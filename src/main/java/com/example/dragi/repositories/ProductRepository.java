package com.example.dragi.repositories;

import com.example.dragi.models.Product;
import com.example.dragi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);

    List<Product> findByTitleOrderByPrice(String title);

    List<Product> findByTitleOrderByPriceDesc(String title);

    List<Product> findByTitleOrderByDateOfCreateDesc(String title);

    List<Product> findAllByOrderByPrice();

    List<Product> findAllByOrderByPriceDesc();

    List<Product> findAllByOrderByDateOfCreateDesc();

    List<Product> findAllByCategory(String category);

    List<Product> findAllByUser(User user);

    List<Product> findAllByInBasketContaining(User user);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO user_basket (user_id, product_id) VALUES (:userId,:productId)", nativeQuery = true)
    void saveProductToUserBasket(Long userId, Long productId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM user_basket WHERE user_id=:userId", nativeQuery = true)
    void deleteAllInBasketOfUser(Long userId);

}

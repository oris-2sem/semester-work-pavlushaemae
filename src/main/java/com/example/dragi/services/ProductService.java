package com.example.dragi.services;

import com.example.dragi.models.Product;
import com.example.dragi.models.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.security.Principal;
import java.util.List;

public interface ProductService {
    List<Product> listProducts();
    void saveProduct(Principal principal, Product product, Part file1, Part file2, Part file3);
    void deleteProduct(long id);
    Product getProductById(long id);
    List<Product> getProductsByTitle(String title);

    List<Product> getProductsByTitle(String title, String sort);

    List<Product> getProductsWithCategory(String category);

    User getUserByPrincipal(Principal principal);

    List<Product> getProductsByUser(User user);

    void updateProduct(Product product);

    List<Product> getBasketOfUser(User user);

    void addProductToBasketOfUser(User user, Long id);

    void deleteBasketOfUser(User user);
}

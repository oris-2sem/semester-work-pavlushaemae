package com.example.dragi.services.impl;

import com.example.dragi.models.Image;
import com.example.dragi.models.Product;
import com.example.dragi.models.User;
import com.example.dragi.repositories.ProductRepository;
import com.example.dragi.repositories.UserRepository;
import com.example.dragi.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public List<Product> listProducts() {
        return productRepository.findAll();
    }

    @Override
    public void saveProduct(Principal principal, Product product, Part file1, Part file2, Part file3) {
        try {
            product.setUser(getUserByPrincipal(principal));
            Image image1;
            Image image2;
            Image image3;
            if (file1 != null && file1.getSize() > 0) {
                image1 = toImageEntity(file1);
                image1.setPreviewImage(true);
                product.addImageToProduct(image1);
            }
            if (file2 != null && file2.getSize() > 0) {
                image2 = toImageEntity(file2);
                product.addImageToProduct(image2);
            }
            if (file3 != null && file3.getSize() > 0) {
                image3 = toImageEntity(file3);
                product.addImageToProduct(image3);
            }

            log.info("Saving new Product. Title: {}; Author email: {}", product.getTitle(), product.getUser().getEmail());
            Product productFromDb = productRepository.save(product);
            productFromDb.setPreviewImageId(productFromDb.getImages().get(0).getId());
            productRepository.save(productFromDb);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    @Override
    public List<Product> getProductsByUser(User user) {
        return productRepository.findAllByUser(user);
    }

    @Override
    public void updateProduct(Product product) {
        Product productFromDb = productRepository.findById(product.getId()).orElse(null);
        if (productFromDb != null) {
            if (product.getPrice() != null) {
                productFromDb.setPrice(product.getPrice());
            }
            if (product.getDescription() != null) {
                productFromDb.setDescription(product.getDescription());
            }
            if (product.getTitle() != null) {
                productFromDb.setTitle(product.getTitle());
            }
            if (product.getCategory() != null) {
                productFromDb.setCategory(product.getCategory());
            }
            if (product.getCity() != null) {
                productFromDb.setCity(product.getCity());
            }
            productRepository.save(productFromDb);
        }
    }

    @Override
    public List<Product> getBasketOfUser(User user) {
        return productRepository.findAllByInBasketContaining(user);
    }

    @Override
    public void addProductToBasketOfUser(User user, Long id) {
        productRepository.saveProductToUserBasket(user.getId(), id);
    }

    @Override
    public void deleteBasketOfUser(User user) {
        productRepository.deleteAllInBasketOfUser(user.getId());
    }

    private Image toImageEntity(Part file) throws IOException {
        String fileName = Paths.get(file.getSubmittedFileName()).getFileName().toString();
        InputStream inputStream = file.getInputStream();
        System.out.println("Single Filename: " + fileName);
        writeFile("C:\\Tomcat 10.0\\fileForImages\\Image\\" + fileName, inputStream);
        Image image = new Image();
        image.setName(fileName);
        image.setContentType(file.getContentType());
        return image;
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getProductsByTitle(String title) {
        if (title != null) {
            return productRepository.findByTitle(title);
        } else {
            return productRepository.findAll();
        }
    }

    @Override
    public List<Product> getProductsByTitle(String title, String sort) {
        List<Product> list;
        if (title != null && !title.equals("")) {
            switch (sort) {
                case "cheap" -> list = productRepository.findByTitleOrderByPrice(title);
                case "expensive" -> list = productRepository.findByTitleOrderByPriceDesc(title);
                case "date" -> list = productRepository.findByTitleOrderByDateOfCreateDesc(title);
                default -> list = productRepository.findByTitle(title);
            }
        } else {
            switch (sort) {
                case "cheap" -> list = productRepository.findAllByOrderByPrice();
                case "expensive" -> list = productRepository.findAllByOrderByPriceDesc();
                case "date" -> list = productRepository.findAllByOrderByDateOfCreateDesc();
                default -> list = productRepository.findAll();
            }
        }
        return list;
    }

    @Override
    public List<Product> getProductsWithCategory(String category) {
        return productRepository.findAllByCategory(category);
    }

    private void writeFile(String path, InputStream input) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path)) {
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = input.read(bytes)) != -1) fileOutputStream.write(bytes, 0, read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.example.dragi.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String title;
    @Column(columnDefinition = "text")
    private String description;
    private Double price;
    private String city;
    private String category;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Image> images;
    @Column(name = "preview_image_id")
    private Long previewImageId;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany
    @JoinTable(
            name = "user_basket",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> inBasket;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private Set<Review> reviews = new HashSet<>();
    @Column(name = "date_of_create")
    private LocalDateTime dateOfCreate;

    public Product(Long product) {
        this.id = product;
    }

    @PrePersist
    private void init() {
        dateOfCreate = LocalDateTime.now();
    }

    public void addImageToProduct(Image image) {
        if (images == null) {
            images = new ArrayList<>();
        }
        images.add(image);
    }
}

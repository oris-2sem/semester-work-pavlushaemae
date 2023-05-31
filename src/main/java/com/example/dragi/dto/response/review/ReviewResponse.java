package com.example.dragi.dto.response.review;

import com.example.dragi.models.Product;
import com.example.dragi.models.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Отзыв")
public class ReviewResponse {
    @Schema(description = "Идентификатор отзыва", example = "1")
    private Long id;
    @Schema(description = "Автор отзыва", example = "Android-developer")
    private String userName;
    @Schema(description = "id продукта отзыва", example = "1")
    private Long productId;
    @Schema(description = "Текст отзыва", example = "Лучший товар! Рекомендую!")
    private String text;
    @Schema(description = "Дата создания отзыва")
    private String dateOfCreated;
}

package com.example.dragi.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Schema(description = "Сведения об ошибке")
public class ExceptionDto {
    @Schema(description = "Текст ошибки", example = "Отзыв не найден")
    private String message;
    @Schema(description = "HTTP-код ошибки", example = "404")
    private int status;
}

package com.example.dragi.controllers.rest;

import com.example.dragi.dto.EntityId;
import com.example.dragi.dto.request.ExceptionDto;
import com.example.dragi.dto.request.review.ReviewRequest;
import com.example.dragi.dto.request.review.ReviewUpdateRequest;
import com.example.dragi.dto.response.review.ReviewResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tags(value = {
        @Tag(name = "Reviews")
})
@RequestMapping("/reviews")
public interface ReviewRestController {

    @Operation(summary = "Получение списка отзывов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Лист с отзывами", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ReviewResponse.class))
            })
    })
    @GetMapping
    ResponseEntity<List<ReviewResponse>> getAll();

    @Operation(summary = "Получение списка отзывов продукта")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Лист с отзывами", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ReviewResponse.class))
            })
    })
    @GetMapping("/{productId}")
    ResponseEntity<List<ReviewResponse>> getAllOfProduct(@PathVariable("productId") Long id);

    @Operation(summary = "Добавление отзыва продукту")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Добавленный отзыв", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ReviewResponse.class))
            })
    })
    @PostMapping
    ResponseEntity<ReviewResponse> create(@RequestBody ReviewRequest reviewRequest);

    @Operation(summary = "Редактирование отзыва к продукту")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Измененный отзыв", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ReviewResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "Сведения об ошибке", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))
            })
    })
    @PutMapping
    ResponseEntity<ReviewResponse> update(@RequestBody ReviewUpdateRequest newRequest);

    @Operation(summary = "Удаление отзыва по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Отзыв удалён")
    })
    @DeleteMapping
    void deleteById(@RequestBody EntityId entityId);

    @Operation(summary = "Получение отзыва по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Отзыв", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ReviewResponse.class))
            }),
            @ApiResponse(responseCode = "404", description = "Сведения об ошибке", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))
            })
    })
    @GetMapping("/byId")
    ResponseEntity<ReviewResponse> findById(@Parameter(description = "Идентификатор отзыва", example = "1") @RequestParam Long reviewId);
}

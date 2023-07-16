package com.luan.vocemaistech.model.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luan.vocemaistech.model.PostBlog;
import com.luan.vocemaistech.model.User;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PostBlogDTO(
        Long id,
        @NotNull(message = "Campo obrigatório") String title,
        @JsonFormat(pattern = "dd/MM/yyyy") LocalDate date,
        @NotNull(message = "Campo obrigatório") String text,
        String categoryPost,
        String subCategory,
        @NotNull(message = "Campo obrigatório") String nameAuthor,
        User author,
        String imagePost) {

    public PostBlogDTO(PostBlog obj) {
        this(obj.getId(),
                obj.getTitle(),
                obj.getDate(),
                obj.getText(),
                obj.getCategoryPost().getDescription(),
                obj.getSubCategory(),
                obj.getNameAuthor(),
                obj.getAuthor(),
                obj.getImagePost());
    }
}

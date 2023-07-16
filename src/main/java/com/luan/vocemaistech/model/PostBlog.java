package com.luan.vocemaistech.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luan.vocemaistech.model.dtos.PostBlogDTO;
import com.luan.vocemaistech.model.enums.CategoryPost;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@EqualsAndHashCode
public class PostBlog implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String title;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date = LocalDate.now();

    @Lob
    private String text;

    private CategoryPost categoryPost;

    private String subCategory;

    @NotNull(message = "Campo Autor é obrigatório!")
    private String nameAuthor;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    private String imagePost;

    public PostBlog() {
        super();
    }

    public PostBlog(Long id, @NotBlank String title, LocalDate date, @NotBlank String text, CategoryPost categoryPost,
                    String subCategory, String nameAuthor, User author, String imagePost) {
        super();
        this.id = id;
        this.title = title;
        this.text = text;
        this.categoryPost = categoryPost;
        this.subCategory = subCategory;
        this.nameAuthor = nameAuthor;
        this.author = author;
        this.imagePost = imagePost;
    }

    public PostBlog(PostBlogDTO obj) {
        this(obj.id(),
                obj.title(),
                obj.date(),
                obj.text(),
                CategoryPost.valueOf(obj.categoryPost()),
                obj.subCategory(),
                obj.nameAuthor(),
                obj.author(),
                obj.imagePost());
    }

}

package com.luan.vocemaistech.model.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luan.vocemaistech.model.PostBlog;

import jakarta.validation.constraints.NotNull;

public class PostBlogDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotNull(message = "Campo obrigatório")
	private String title;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate date = LocalDate.now();

	@NotNull(message = "Campo obrigatório")
	private String text;	

	private String categoryPost;

	private String subCategory;

	@NotNull(message = "Campo Autor é obrigatório!")
	private String nameAuthor;

	private Long author;

	private String imagePost;

	public PostBlogDTO() {
		super();
	}

	public PostBlogDTO(PostBlog obj) {
		super();
		this.id = obj.getId();
		this.title = obj.getTitle();
		this.date = obj.getDate();
		this.text = obj.getText();
		this.categoryPost = obj.getCategoryPost().getDescription();
		this.subCategory = obj.getSubCategory();
		this.nameAuthor = obj.getNameAuthor();
		this.author = obj.getAuthor().getId();
		this.imagePost = obj.getImagePost();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCategoryPost() {
		return categoryPost;
	}

	public void setCategoryPost(String categoryPost) {
		this.categoryPost = categoryPost;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getNameAuthor() {
		return nameAuthor;
	}

	public void setNameAuthor(String nameAuthor) {
		this.nameAuthor = nameAuthor;
	}

	public Long getAuthor() {
		return author;
	}

	public void setAuthor(Long author) {
		this.author = author;
	}

	public String getImagePost() {
		return imagePost;
	}

	public void setImagePost(String imagePost) {
		this.imagePost = imagePost;
	}

}

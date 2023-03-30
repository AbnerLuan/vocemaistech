package com.luan.vocemaistech.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.luan.vocemaistech.model.enums.CategoryPost;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
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

	public PostBlog(Long id, @NotBlank String title, @NotBlank String text, CategoryPost categoryPost,
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
	
	

	public String getImagePost() {
		return imagePost;
	}

	public void setImagePost(String imagePost) {
		this.imagePost = imagePost;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
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

	public CategoryPost getCategoryPost() {
		return categoryPost;
	}

	public void setCategoryPost(CategoryPost categoryPost) {
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

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PostBlog other = (PostBlog) obj;
		return Objects.equals(id, other.id);
	}

}

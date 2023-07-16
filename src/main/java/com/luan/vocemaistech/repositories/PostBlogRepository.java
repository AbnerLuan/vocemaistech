package com.luan.vocemaistech.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.luan.vocemaistech.model.PostBlog;
import com.luan.vocemaistech.model.enums.CategoryPost;

public interface PostBlogRepository extends JpaRepository<PostBlog, Long> {
	 	@Query(value = "SELECT p FROM PostBlog p WHERE p.categoryPost = ?1")
	    List<PostBlog> findByCategoryPost(CategoryPost cod, Sort sort);

}

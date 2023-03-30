package com.luan.vocemaistech.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.luan.vocemaistech.model.PostBlog;
import com.luan.vocemaistech.model.enums.CategoryPost;

public interface PostBlogRepository extends JpaRepository<PostBlog, Long> {

//	Page<PostBlog> findAll(Pageable pageable);
	
	
//	@Query(value = "select u from PostBlog u where (u.CATEGORY_POST) like %?1%")
//	List<PostBlog> findByCategoryPost(Integer categoryPost);
	
//	@Query("SELECT obj FROM PostBlog obj WHERE (obj.categoryPost) = %?1% ORDER BY obj.id")
//	List<PostBlog> findByCategoryPost(Integer categoryPost);
	
	 	@Query(value = "SELECT p FROM PostBlog p WHERE p.categoryPost = ?1")
	    List<PostBlog> findByCategoryPost(CategoryPost cod, Sort sort);

}

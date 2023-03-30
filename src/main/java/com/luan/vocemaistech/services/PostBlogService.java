package com.luan.vocemaistech.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.luan.vocemaistech.model.PostBlog;
import com.luan.vocemaistech.model.User;
import com.luan.vocemaistech.model.dtos.PostBlogDTO;
import com.luan.vocemaistech.model.enums.CategoryPost;
import com.luan.vocemaistech.repositories.PostBlogRepository;
import com.luan.vocemaistech.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class PostBlogService {

	@Autowired
	private PostBlogRepository repository;

	@Autowired
	private UserService userService;

	public PostBlog findById(Long id) {

		Optional<PostBlog> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not Found. ID: " + id));
	}

	public List<PostBlog> findAll() {
		Sort sort = Sort.by("id").descending();
		return repository.findAll(sort);
	}

	public PostBlog create(@Valid PostBlogDTO objDTO) {
		return repository.save(newPostBlog(objDTO));
	}

	private PostBlog newPostBlog(PostBlogDTO obj) {
		User author = userService.findById(obj.getAuthor());  //VERIFICAR ESSA LINHA POIS JA VEM AUTOR DO FRONT

		PostBlog postblog = new PostBlog();
		if (obj.getId() != null) {
			postblog.setId(obj.getId());
		}
		postblog.setAuthor(author); //VERIFICAR
		postblog.setNameAuthor(obj.getNameAuthor());
		postblog.setCategoryPost(CategoryPost.toEnum(obj.getCategoryPost()));
		postblog.setDate(obj.getDate());
		postblog.setSubCategory(obj.getSubCategory());
		postblog.setText(obj.getText());
		postblog.setTitle(obj.getTitle());
		postblog.setImagePost(obj.getImagePost());
		return postblog;
	}

	public PostBlog update(@Valid Long id, PostBlogDTO objDTO) {
		objDTO.setId(id);
		PostBlog oldObj = findById(id);
		oldObj = newPostBlog(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public List<PostBlog> findByCategoryPost(CategoryPost cod, Sort sort) {			
		List<PostBlog> list = repository.findByCategoryPost(cod, sort);		
		return list;
	}
	
	

//	public Object findAllPaginator(Pageable pageable) {
//		return repository.findAll(pageable);
//	}

}

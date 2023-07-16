package com.luan.vocemaistech.services;

import com.luan.vocemaistech.model.PostBlog;
import com.luan.vocemaistech.model.dtos.PostBlogDTO;
import com.luan.vocemaistech.model.enums.CategoryPost;
import com.luan.vocemaistech.repositories.PostBlogRepository;
import com.luan.vocemaistech.services.exceptions.ObjectNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostBlogService {

    @Autowired
    private PostBlogRepository repository;

    public Page<PostBlogDTO> findAllPageable(Pageable pageable) {
        Page<PostBlog> postBlogPage = repository.findAll(pageable);
        List<PostBlogDTO> postBlogRecords = postBlogPage.stream()
                .map(PostBlogDTO::new)
                .collect(Collectors.toList());
        return new PageImpl<>(postBlogRecords, pageable, postBlogPage.getTotalElements());
    }

    public PostBlogDTO findById(Long id) {
        Optional<PostBlog> obj = repository.findById(id);
        return new PostBlogDTO(obj.orElseThrow(() -> new ObjectNotFoundException("Object not Found. ID: " + id)));
    }

    public List<PostBlog> findByCategoryPost(CategoryPost cod, Sort sort) {
        List<PostBlog> list = repository.findByCategoryPost(cod, sort);
        return list;
    }

    public PostBlogDTO create(@Valid PostBlogDTO objDTO) {
        PostBlog obj = new PostBlog(objDTO);
        obj.setId(null);
        repository.save(obj);
        return new PostBlogDTO(obj);
    }

    public PostBlogDTO update(@Valid Long id, PostBlogDTO objDTO) {
        PostBlog newObj = new PostBlog(objDTO);
        newObj.setId(id);
        repository.save(newObj);
        return objDTO;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}

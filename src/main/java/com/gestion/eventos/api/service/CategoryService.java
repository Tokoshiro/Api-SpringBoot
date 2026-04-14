package com.gestion.eventos.api.service;

import com.gestion.eventos.api.domain.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findAll();
    Category save(Category category);
    Category update(Long id, Category category);
    Category findById(Long id);
    void deleteById(Long id);

}

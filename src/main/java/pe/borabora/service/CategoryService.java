package pe.borabora.service;

import pe.borabora.dto.CategoryDTO;
import pe.borabora.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryDTO findCategoryById(Integer categoryId);
    List<Category> getAllCategories();
}

package pe.borabora.service;

import pe.borabora.dto.CategoryDTO;
import pe.borabora.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryDTO findCategoryById(Integer categoryId);
    List<Category> getAllCategories();

    //solo ADMIN- crear, actualizar y borrar categoria:
    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(Integer id, CategoryDTO categoryDTO);

    boolean deleteCategory(Integer id);
}

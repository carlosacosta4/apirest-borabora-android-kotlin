package pe.borabora.service;

import pe.borabora.dto.CategoryDTO;

public interface CategoryService {
    CategoryDTO findCategoryById(Integer categoryId);
}

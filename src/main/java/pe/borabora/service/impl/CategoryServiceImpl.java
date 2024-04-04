package pe.borabora.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.borabora.dto.CategoryDTO;
import pe.borabora.entity.Category;
import pe.borabora.repository.CategoryRepository;
import pe.borabora.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public CategoryDTO findCategoryById(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            return new CategoryDTO(category.getId_category(), category.getName(), category.getImage());
        }
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setImage(categoryDTO.getImage());

        // Guardar la categoría en la base de datos
        Category savedCategory = categoryRepository.save(category);

        // Devolver el DTO de la categoría creada
        CategoryDTO savedCategoryDTO = new CategoryDTO();
        savedCategoryDTO.setId_category(savedCategory.getId_category());
        savedCategoryDTO.setName(savedCategory.getName());
        savedCategoryDTO.setImage(savedCategory.getImage());

        return savedCategoryDTO;
    }
}

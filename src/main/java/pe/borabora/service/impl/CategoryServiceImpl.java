package pe.borabora.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.borabora.dto.CategoryDTO;
import pe.borabora.entity.Category;
import pe.borabora.entity.Product;
import pe.borabora.repository.CategoryRepository;
import pe.borabora.repository.ProductRepository;
import pe.borabora.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;
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

    @Override
    public CategoryDTO updateCategory(Integer id, CategoryDTO categoryDTO) {
        // Verificar si la categoría existe
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + id));

        // Actualizar los datos de la categoría existente con los nuevos datos
        existingCategory.setName(categoryDTO.getName());
        existingCategory.setImage(categoryDTO.getImage());

        Category updatedCategory = categoryRepository.save(existingCategory);
        return convertToDTO(updatedCategory);
    }

    @Override
    public boolean deleteCategory(Integer id) {
        Category existingCategory = categoryRepository.findById(id)
                .orElse(null);

        if (existingCategory != null) {
            // Eliminar todos los productos asociados a la categoría
            List<Product> productsToDelete = productRepository.findByCategoryId(id);
            productRepository.deleteAll(productsToDelete);

            // Eliminar la categoría
            categoryRepository.delete(existingCategory);
            return true; // La categoría y productos asociados eliminados
        } else {
            return false; // La categoría no existe
        }
    }

    private CategoryDTO convertToDTO(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId_category(category.getId_category());
        categoryDTO.setName(category.getName());
        categoryDTO.setImage(category.getImage());
        return categoryDTO;
    }
}

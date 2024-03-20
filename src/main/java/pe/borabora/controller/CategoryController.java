package pe.borabora.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.borabora.dto.CategoryDTO;
import pe.borabora.entity.Category;
import pe.borabora.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/byId/{categoryId}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Integer categoryId) {
        CategoryDTO category = categoryService.findCategoryById(categoryId);
        if (category != null) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
<<<<<<< HEAD
    public ResponseEntity<List<CategoryDTO>> getAllCategories() {
=======
    //@PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<Category>> getAllCategories() {
>>>>>>> a83c8572c4f2e241baccebc9397e6bb2e33feb73
        List<Category> categories = categoryService.getAllCategories();
        List<CategoryDTO> categoryDTOs = new ArrayList<>();
        for (Category category : categories) {
            CategoryDTO categoryDTO = new CategoryDTO(
                category.getId_category(),
                category.getName(),
                category.getImage()
            );
            categoryDTOs.add(categoryDTO);
        }
        return new ResponseEntity<>(categoryDTOs, HttpStatus.OK);
    }
}

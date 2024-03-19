package pe.borabora.service;

import pe.borabora.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    List<ProductDTO> getProductsByCategoryId(Integer categoryId);
}

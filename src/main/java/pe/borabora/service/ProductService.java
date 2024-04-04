package pe.borabora.service;

import pe.borabora.dto.ProductDTO;
import pe.borabora.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProducts();
    List<ProductDTO> getProductsByCategoryId(Integer categoryId);
    List<ProductDTO> getTopSellingProducts(int limit);

    Product getProductById(Integer productId);

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(Integer id, ProductDTO productDTO);

    boolean deleteProduct(Integer id);
}

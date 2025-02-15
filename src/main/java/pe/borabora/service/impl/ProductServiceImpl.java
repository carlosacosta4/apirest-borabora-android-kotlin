package pe.borabora.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pe.borabora.dto.ProductDTO;
import pe.borabora.dto.response.ProductResponse;
import pe.borabora.entity.BrandProduct;
import pe.borabora.entity.Category;
import pe.borabora.entity.Product;
import pe.borabora.repository.BrandProductRepository;
import pe.borabora.repository.CategoryRepository;
import pe.borabora.repository.ProductRepository;
import pe.borabora.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandProductRepository brandProductRepository;
    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAllByDeletedFalse();
        return productList.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

    public List<ProductResponse> getProductsByCategoryId(Integer categoryId) {
        List<Product> productList = productRepository.findByCategoryId(categoryId);
        return productList.stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private ProductResponse mapToResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId_product(product.getId_product());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        response.setExpirationDate(product.getExpirationDate());
        response.setImage(product.getImage());
        response.setCategoryId(product.getCategory().getId_category());
        response.setCategoryName(product.getCategory().getName());
        response.setBrandProductName(product.getBrandproduct().getBrand_product());
        return response;
    }
    @Override
    public List<ProductDTO> getTopSellingProducts(int limit) {
        Pageable pageable = PageRequest.of(0, 10);
        List<Object[]> results = productRepository.findTopSellingProducts(pageable);
        List<ProductDTO> topSellingProducts = new ArrayList<>();

        for (Object[] result : results) {
            Product product = (Product) result[0];
            topSellingProducts.add(new ProductDTO(product));
        }

        return topSellingProducts;
    }

    @Override
    public ProductDTO getProductById(Integer productId) {
        Product product = productRepository.findByIdAndDeletedFalse(productId).orElse(null);
        return new ProductDTO(product);
    }
    
    
    @Override
    public ProductResponse getProductResponseById(Integer productId) {
        Product product = productRepository.findByIdAndDeletedFalse(productId).orElse(null);
        if (product == null) {
            return null;
        }
        ProductResponse response = new ProductResponse();
        response.setId_product(product.getId_product());
        response.setName(product.getName());
        response.setDescription(product.getDescription());
        response.setPrice(product.getPrice());
        response.setStock(product.getStock());
        response.setExpirationDate(product.getExpirationDate());
        response.setImage(product.getImage());
        response.setCategoryName(product.getCategory().getName()); // Cambiado de setCategoryId a setCategoryName
        response.setBrandProductName(product.getBrandproduct().getBrand_product()); // Cambiado de setBrandProductId a setBrandProductName
        return response;
    }

    // Método para mapear un DTO de producto a una entidad Product
    private void mapDtoToProduct(Product product, ProductDTO productDTO) {
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setExpirationDate(productDTO.getExpirationDate());
        product.setImage(productDTO.getImage());
        product.setDeleted(productDTO.getDeleted());
        // Obtener la categoría del DTO y actualizarla en el producto
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: "));
        product.setCategory(category);

        BrandProduct brand = brandProductRepository.findById(productDTO.getBrandProductId())
                .orElseThrow(() -> new RuntimeException("Marca no encontrada con ID: "));
        product.setBrandproduct(brand);
    }
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        // Si el DTO no proporciona un valor para 'deleted', establecerlo a false
        if (productDTO.getDeleted() == null) {
            productDTO.setDeleted(false);
        }
        // Mapear los datos del DTO a la entidad Product
        mapDtoToProduct(product, productDTO);
        Product savedProduct = productRepository.save(product);
        return new ProductDTO(savedProduct);
    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

        // Actualizar los datos del producto con los nuevos datos del DTO
        mapDtoToProduct(existingProduct, productDTO);
        // Guardar el producto actualizado en la base de datos
        Product updatedProduct = productRepository.save(existingProduct);
        return new ProductDTO(updatedProduct);
    }

    @Override
    public void deleteProduct(Integer id) {
        // Verificar si el producto existe
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            // No eliminar realmente el producto, solo marcarlo como eliminado
            existingProduct.setDeleted(true);
            productRepository.save(existingProduct);
        }
    }

}

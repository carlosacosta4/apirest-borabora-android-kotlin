package pe.borabora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.borabora.dto.ProductDTO;
import pe.borabora.dto.response.ApiResponse;
import pe.borabora.entity.BrandProduct;
import pe.borabora.entity.Category;
import pe.borabora.entity.Product;
import pe.borabora.repository.BrandProductRepository;
import pe.borabora.repository.CategoryRepository;
import pe.borabora.repository.ProductRepository;
import pe.borabora.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandProductRepository brandProductRepository;

    //lista todos los productos
    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //lista los productos segun la categoria
    @GetMapping("/byCategory/{categoryId}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategoryId(@PathVariable Integer categoryId) {
        if (categoryId != null) {
            List<ProductDTO> products = productService.getProductsByCategoryId(categoryId);
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //lista los 10 productos màs vendidos (RANKING)
    @GetMapping("/topSelling")
    public ResponseEntity<List<ProductDTO>> getTopSellingProducts(@RequestParam(defaultValue = "10") int limit) {
        List<ProductDTO> topSellingProducts = productService.getTopSellingProducts(limit);
        return new ResponseEntity<>(topSellingProducts, HttpStatus.OK);
    }
    //Crear Producto
    @PostMapping("/createProduct")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.createProduct(productDTO);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Producto creado correctamente");
        apiResponse.setStatus(HttpStatus.CREATED.value());

        return new ResponseEntity<>(apiResponse, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable Integer id, @RequestBody ProductDTO productDTO) {
        Product product = repository.findById(id).orElse(null);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setExpirationDate(productDTO.getExpirationDate());
        product.setImage(productDTO.getImage());

        // Aquí necesitarás buscar la categoría y la marca del producto por sus IDs
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElse(null);
        BrandProduct brandProduct = brandProductRepository.findById(productDTO.getBrandProductId()).orElse(null);

        product.setCategory(category);
        product.setBrandproduct(brandProduct);

        repository.save(product);

        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Producto actualizado correctamente");
        apiResponse.setStatus(HttpStatus.OK.value());

        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer productId) {
        ProductDTO product = productService.getProductById(productId);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
}

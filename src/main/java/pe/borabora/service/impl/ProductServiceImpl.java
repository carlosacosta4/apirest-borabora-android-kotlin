package pe.borabora.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.borabora.dto.ProductDTO;
import pe.borabora.entity.Product;
import pe.borabora.repository.ProductRepository;
import pe.borabora.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getProductsByCategoryId(Integer categoryId) {
        List<Product> productList = productRepository.findByCategoryId(categoryId);
        return productList.stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> getTopSellingProducts(int limit) {
        List<Object[]> results = productRepository.findTopSellingProducts();
        List<ProductDTO> topSellingProducts = new ArrayList<>();

        for (Object[] result : results) {
            Product product = (Product) result[0];
            topSellingProducts.add(new ProductDTO(product));
            if (topSellingProducts.size() >= limit) {
                break;
            }
        }

        return topSellingProducts;

    }
}

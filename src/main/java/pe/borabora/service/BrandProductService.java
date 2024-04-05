package pe.borabora.service;

import org.springframework.stereotype.Service;
import pe.borabora.entity.BrandProduct;

import java.util.List;

public interface BrandProductService {
    List<BrandProduct> getAllBrandProducts();
}

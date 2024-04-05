package pe.borabora.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.borabora.entity.BrandProduct;
import pe.borabora.repository.BrandProductRepository;
import pe.borabora.service.BrandProductService;

import java.util.List;
@Service
public class BrandProductServiceImpl implements BrandProductService {
    @Autowired
    private BrandProductRepository brandProductRepository;
    @Override
    public List<BrandProduct> getAllBrandProducts() {
        return brandProductRepository.findAll();
    }
}

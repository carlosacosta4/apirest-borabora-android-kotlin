package pe.borabora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.borabora.dto.BrandProductDTO;
import pe.borabora.dto.CategoryDTO;
import pe.borabora.entity.BrandProduct;
import pe.borabora.entity.Category;
import pe.borabora.service.BrandProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandProductController {

    @Autowired
    private BrandProductService brandProductService;
    @GetMapping("/all")
    public ResponseEntity<List<BrandProductDTO>> getAllBrandProducts() {
        List<BrandProduct> brand = brandProductService.getAllBrandProducts();
        List<BrandProductDTO> brandProductDTOs = new ArrayList<>();
        for (BrandProduct brandProduct : brand) {
            BrandProductDTO brandProductDTO = new BrandProductDTO(
                    brandProduct.getCod_brand_product(),
                    brandProduct.getBrand_product()
            );
            brandProductDTOs.add(brandProductDTO);
        }
        return new ResponseEntity<>(brandProductDTOs, HttpStatus.OK);
    }
}

package com.vaquita.ternerashop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vaquita.ternerashop.entity.Product;
import com.vaquita.ternerashop.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepo;

     public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public Product getProductById(Integer id){
        Optional<Product> optionalProduct = productRepo.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }
        log.info("Product with id: {} doesn't exist", id);
        return null;
    }

    public Product saveProduct (Product product){
         
        Product savedProduct = productRepo.save(product);
        /*Product.setCreatedAt(LocalDateTime.now());
        Product.setUpdatedAt(LocalDateTime.now());*/

        log.info("Product with id: {} saved successfully", product.getId());
        return savedProduct;
    }

    public Product updateProduct (Product product) {
        /*
        Optional<Product> existingProduct = productRepo.findById(product.getId());
        product.setCreatedAt(existingProduct.get().getCreatedAt());
        product.setUpdatedAt(LocalDateTime.now());
        */
        Product updatedProduct = productRepo.save(product);

        log.info("Product with id: {} updated successfully", product.getId());
        return updatedProduct;
    }

    public void deleteProductById (Integer id) {
        productRepo.deleteById(id);
    }
}

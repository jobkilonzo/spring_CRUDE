package com.example.accessdatamysql.controller;

import com.example.accessdatamysql.model.Products;
import com.example.accessdatamysql.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductsRepository productRepository;

    @GetMapping("/all")
    public List<Products> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{name}")
    public List<Products>getProduct(@PathVariable("name") final String name){
        return productRepository.findByName(name);
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public String addProduct (String name
            , Integer price) {

        Products n = new Products();
        n.setName(name);
        n.setPrice(price);
        productRepository.save(n);
        return "Saved";
    }


    @PutMapping("/update/{id}")
    public Products update(@PathVariable Integer id, @RequestBody Products updatedProducts){



        return productRepository.findById(id)
                .map(product -> {
                    product.setName(updatedProducts.getName());
                    product.setPrice(updatedProducts.getPrice());
                    return productRepository.save(product);
                })
                .orElseGet(() -> {
                    updatedProducts.setId(id);
                    return productRepository.save(updatedProducts);
                });

    }

    @DeleteMapping("/delete/{id}")
    void deleteProduct(@PathVariable Integer id){
        productRepository.deleteById(id);
    }
}

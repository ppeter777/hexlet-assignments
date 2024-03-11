package exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.Comparator;
import java.util.List;

import exercise.model.Product;
import exercise.repository.ProductRepository;
import exercise.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> index(@RequestParam(required = false) Long min, @RequestParam(required = false) Long max) {
        if (min == null && max == null) {
            return productRepository.findAll();
        } else if (min == null) {
            return productRepository.findAllByPriceLessThanOrderByPriceAsc(max);
        } else if (max == null) {
            return productRepository.findAllByPriceGreaterThanOrderByPriceAsc(min);
        }
        return productRepository.findAllByPriceBetweenOrderByPriceAsc(min, max);
    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product =  productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}

package com.example.demo.myproducts;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductsRepository;
import com.example.demo.exeption.ResourceNotFoundException;
import com.example.demo.model.Products;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController

@RequestMapping("/products")
public class productsController {
	
	@Autowired
	ProductsRepository productsRepository;

	// Get All Products
	@GetMapping("")
	public List<Products> getAllProducts() {
	    return productsRepository.findAll();
	}
	// Get a Single Products
	@GetMapping("/{id}")
	public Products getProductById(@PathVariable(value = "id") Long referance) {
	    return productsRepository.findById(referance).orElseThrow(() -> new ResourceNotFoundException("Products", "id", referance));
	}
	
	// Update a Note
	@PutMapping("/{id}")
	public Products updateProduct(@PathVariable(value = "id") Long referance,
	                                        @Valid @RequestBody Products prod) {

		Products product = productsRepository.findById(referance)
	            .orElseThrow(() -> new ResourceNotFoundException("Products", "id", referance));

		product.setDesigniation(prod.getDesigniation());
		product.setPrix(prod.getPrix());
		product.setQuantite(prod.getQuantite());
		product.setPromo(prod.isPromo());
		

	    Products updatedproduct = productsRepository.save(product);
	    return updatedproduct;
	}
	
	// Delete a Note
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long referance) {
	    Products products = productsRepository.findById(referance)
	            .orElseThrow(() -> new ResourceNotFoundException("Note", "id", referance));

	    productsRepository.delete(products);

	    return ResponseEntity.ok().build();
	}
	
	@PostMapping("/")
	public Products addProduct(@Valid @RequestBody Products prod) {

		Products p=new Products();
		p.setDesigniation(prod.getDesigniation());
		p.setPrix(prod.getPrix());
		p.setQuantite(prod.getQuantite());
		p.setPromo(prod.isPromo());
		

	    Products updatedproduct = productsRepository.save(p);
	    return updatedproduct;
	}
}

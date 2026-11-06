package org.example

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
class ProductController(private val productRepository: ProductRepository) {

    @GetMapping
    fun getAllProducts(): List<Product> {
        return productRepository.findAll()
    }

    @PostMapping
    fun createProduct(@RequestBody newProduct: Product): Product {
        return productRepository.save(newProduct)
    }

    @DeleteMapping("/{id}")
    fun deleteProduct(@PathVariable id: Long) {
        productRepository.deleteById(id)
    }
}
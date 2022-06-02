package placeti.atividadespring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import placeti.atividadespring.domain.Product;
import placeti.atividadespring.requests.ProductPostRequestBody;
import placeti.atividadespring.requests.ProductPutRequestBody;
import placeti.atividadespring.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("shop")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> list() {
        return ResponseEntity.ok(productService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody ProductPostRequestBody productPostRequestBody) {
        return new ResponseEntity<>(productService.save(productPostRequestBody), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody ProductPutRequestBody productPutRequestBody) {
        productService.replace(productPutRequestBody);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

package placeti.atividadespring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import placeti.atividadespring.domain.Product;
import placeti.atividadespring.repository.ProductRepository;
import placeti.atividadespring.requests.ProductPostRequestBody;
import placeti.atividadespring.requests.ProductPutRequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product findById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Produto não encontrado"));
    }

    public Product save(ProductPostRequestBody productPostRequestBody) {
        return productRepository.save(
                Product.builder()
                        .name(productPostRequestBody.getName())
                        .price(productPostRequestBody.getPrice())
                        .quantity(productPostRequestBody.getQuantity())
                        .build()
        );
    }

    public void replace(ProductPutRequestBody productPutRequestBody) {
        Product savedProduct = findById(productPutRequestBody.getId());
        Product product =
                Product.builder()
                    .id(savedProduct.getId())
                    .name(productPutRequestBody.getName())
                    .price(productPutRequestBody.getPrice())
                    .quantity(productPutRequestBody.getQuantity())
                    .build();
        productRepository.save(product);
    }

    public void delete(long id) {
        productRepository.delete(findById(id));
    }
}

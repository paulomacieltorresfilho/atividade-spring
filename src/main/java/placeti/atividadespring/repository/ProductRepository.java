package placeti.atividadespring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import placeti.atividadespring.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}

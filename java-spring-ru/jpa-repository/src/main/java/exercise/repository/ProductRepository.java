package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import exercise.model.Product;

import org.springframework.data.domain.Sort;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // BEGIN
    List<Product> findAllByPriceBetweenOrderByPriceAsc(long min, long max);
    List<Product> findAllByPriceGreaterThanOrderByPriceAsc(long min);
    List<Product> findAllByPriceLessThanOrderByPriceAsc(long max);
    // END
}

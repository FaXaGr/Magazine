package Magazine.repository;

import Magazine.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT p from Product p where p.productType.id = :id")
    List<Product> findAllByProductType_Id(Integer id);
    Page<Product> findAllByNameContainingIgnoreCase(String name, Pageable pageable);
    Stream<Product> findAllByIdLessThan(Integer id);
}

package Magazine.repository;

import Magazine.entity.OrdersProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersProductRepository extends JpaRepository<OrdersProduct,Integer> {
}

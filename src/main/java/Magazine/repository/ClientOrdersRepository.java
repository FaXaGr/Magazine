package Magazine.repository;

import Magazine.entity.ClientOrders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientOrdersRepository extends JpaRepository<ClientOrders,Integer> {
}

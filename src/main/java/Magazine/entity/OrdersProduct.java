package Magazine.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdersProduct {
    @Id
    @GeneratedValue(generator = "orders_product_seq_id",strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Product product;

    @ManyToOne
    private ClientOrders clientOrders;
}

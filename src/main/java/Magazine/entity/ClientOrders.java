package Magazine.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClientOrders {
    @Id
    @GeneratedValue(generator = "orders_seq_id",strategy = GenerationType.AUTO)
    private Integer id;

    private Double total;

    @Column(name = "created_at")
    private Date createdAt;

    @ManyToOne
    private Users user;

    @OneToMany(mappedBy = "clientOrders")
    @Fetch(FetchMode.SUBSELECT)
    private List<OrdersProduct> ordersProducts;
}

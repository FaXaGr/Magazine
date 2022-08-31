package Magazine.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(generator = "product_seq_id",strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Double price;
    private Integer amount;

    @ManyToOne
    private ProductType productType;

//    @ManyToOne
//    @JoinColumn(name = "type_id", referencedColumnName = "id")
//    private ProductTypes type;
}

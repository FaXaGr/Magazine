package Magazine.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductType {
    @Id
    @GeneratedValue(generator = "product_type_seq_id",strategy = GenerationType.AUTO)
    private Integer id;
    private String barcode;
    private String name;
    @ManyToOne
    private Units unit;
    @OneToMany(mappedBy = "productType")
    private List<Product> products;


//    @ManyToOne
//    @JoinColumn(name = "type_id", referencedColumnName = "id")
//    private ProductTypes type;
}

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
public class Units {
    @Id
    @GeneratedValue(generator = "units_seq_id",strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @Column(name = "short_name")
    private String shortName;
    @OneToMany(mappedBy = "unit")
    private List<ProductType> productTypes;
}

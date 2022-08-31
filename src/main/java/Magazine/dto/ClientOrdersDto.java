package Magazine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClientOrdersDto {
    private Integer id;
    private Integer userId;
    private Double total;
    private String created_at;
}

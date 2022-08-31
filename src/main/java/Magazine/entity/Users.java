package Magazine.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @Column(name = "id_user")
    @GeneratedValue(generator = "user_id_seq",strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;
    private String login;
    private String password;
    private Double account;
    @Column(name = "created_at")
    private Date createdAt;
    private Integer age;
    private String email;

    @OneToMany(mappedBy = "user")
    private List<ClientOrders> clientOrders;
}

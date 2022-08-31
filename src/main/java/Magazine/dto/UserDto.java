package Magazine.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String login;
    private String password;
    private Double account;
    private Time created_at;
    private Integer age;
    private String email;
}

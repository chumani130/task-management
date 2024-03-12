package com.backend.taskmanagement.entity;

import com.backend.taskmanagement.dto.UserDto;
import com.backend.taskmanagement.model.BaseEntity;
import com.backend.taskmanagement.enums.UserRole;
import com.backend.taskmanagement.model.Token;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{username.name.not.empty}")
    private String username;

    @Email(message = "{user.email.not.valid}")
    @NotEmpty(message = "{user.email.not.empty}")
    @Column(unique = true)
    private String email;

    @NotEmpty(message = "{user.password.not.empty}")
    @Length(min = 5, message = "{user.password.length}")
    private String password;

    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'images/user.png'")
    private String photo;

    @Enumerated(EnumType.STRING)
    private UserRole role;

//    @OneToMany(mappedBy = "user")
//    private List<Token> tokens;
    public UserDto getDto() {
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setEmail(email);
        userDto.setUsername(username);
        userDto.setUserRole(role);

        return userDto;


}

}

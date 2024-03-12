package com.backend.taskmanagement.entity;

import com.backend.taskmanagement.dto.UserDto;
import com.backend.taskmanagement.model.BaseEntity;
import com.backend.taskmanagement.model.Role;
import com.backend.taskmanagement.model.Token;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class UserEntity extends BaseEntity {

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
    private Role role;

//    @OneToMany(mappedBy = "user")
//    private List<Token> tokens;
    public UserDto getDto() {
        UserDto userDto = new UserDto();
        userDto.setId(id);
        userDto.setEmail(email);
        userDto.setName(name);
        userDto.setRole(role);

        return userDto;


}

}

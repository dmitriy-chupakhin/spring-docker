package me.chdm.springbootwithdockerdemo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.chdm.springbootwithdockerdemo.model.User;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String name;
    private Integer age;

    public UserDto(User user) {
        this.name = user.getName();
        this.age = user.getAge();
    }

    public User toUser() {
        return User.builder().name(this.name).age(this.age).build();
    }
}

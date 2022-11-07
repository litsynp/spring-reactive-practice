package com.litsynp.reactive.api.response;

import com.litsynp.reactive.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserView {

    private String id;
    private String email;
    private String name;

    public static UserView from(User user) {
        return new UserView(user.getId(), user.getEmail(), user.getName());
    }
}

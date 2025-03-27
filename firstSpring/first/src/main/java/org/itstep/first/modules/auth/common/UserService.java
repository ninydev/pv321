package org.itstep.first.modules.auth.common;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    private final Map<String, UserModel> users = new HashMap<>();

    public UserService() {
        users.put("test@mail.com", new UserModel("test@mail.com", "12345"));
    }

    public UserModel findByEmail(String email) {
        return users.get(email);
    }
}

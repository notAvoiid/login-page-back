package com.login.page.model.dto.users;

import com.login.page.model.enums.Role;

public record RegisterDTO(String name, String username, String password, Role role) {
}

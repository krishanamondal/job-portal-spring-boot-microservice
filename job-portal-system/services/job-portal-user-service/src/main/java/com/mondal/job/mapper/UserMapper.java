package com.mondal.job.mapper;

import com.mondal.job.dto.response.UserResponse;
import com.mondal.job.model.User;

public class UserMapper {
    public static UserResponse toDTO(User user) {
        UserResponse dto = new UserResponse();
        dto.setId(user.getId());
        dto.setEmail(user.getEmail());
        dto.setFullName(user.getFullName());
        dto.setPhone(user.getPhone());
        dto.setProfileImage(user.getProfileImage());
        dto.setRole(user.getRoles());
        dto.setStatus(user.getStatus());
        dto.setLastLogin(user.getLastLogin());
        dto.setCreatedAt(user.getLocalDateTime());

        return dto;
    }
}

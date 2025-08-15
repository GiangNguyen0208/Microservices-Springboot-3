package com.devteria.identity.mapper;

import org.mapstruct.Mapper;

import com.devteria.identity.dto.request.UserProfileCreationRequest;

@Mapper(componentModel = "spring")
public class ProfileMapper {
    UserProfileCreationRequest toProfileCreationRequest(UserProfileCreationRequest request) {
        return UserProfileCreationRequest.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .dob(request.getDob())
                .city(request.getCity())
                .build();
    }
}

package com.devteria.profile.mapper;

import org.mapstruct.Mapper;

import com.devteria.profile.dto.request.UserProfileCreationRequest;
import com.devteria.profile.dto.response.UserProfileCreationResponse;
import com.devteria.profile.entity.UserProfile;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfile toUserProfile(UserProfileCreationRequest request);

    UserProfileCreationResponse toUserProfileResponse(UserProfile entity);
}

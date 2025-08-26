package com.devteria.profile.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devteria.profile.dto.ApiResponse;
import com.devteria.profile.dto.request.UserProfileCreationRequest;
import com.devteria.profile.dto.response.UserProfileCreationResponse;
import com.devteria.profile.service.UserProfileService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InternalUserProfileController {
    UserProfileService userProfileService;

    @PostMapping("/internal/users/create")
    public ApiResponse<UserProfileCreationResponse> createProfile(@RequestBody UserProfileCreationRequest request) {
        return ApiResponse.<UserProfileCreationResponse>builder()
                .result(userProfileService.createProfile(request))
                .build();
    }
}

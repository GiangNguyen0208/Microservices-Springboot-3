package com.devteria.profile.controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.devteria.profile.dto.ApiResponse;
import com.devteria.profile.dto.response.UserProfileCreationResponse;
import com.devteria.profile.service.UserProfileService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserProfileController {
    UserProfileService userProfileService;

    @GetMapping("/users/{profileId}")
    public ApiResponse<UserProfileCreationResponse> getProfile(@PathVariable String profileId) {
        return ApiResponse.<UserProfileCreationResponse>builder()
                .result(userProfileService.getProfile(profileId))
                .build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/users")
    public ApiResponse<List<UserProfileCreationResponse>> getAllProfiles() {
        return ApiResponse.<List<UserProfileCreationResponse>>builder()
                .result(userProfileService.getAllProfiles())
                .build();
    }
}

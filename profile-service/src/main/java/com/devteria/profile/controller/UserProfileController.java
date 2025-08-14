package com.devteria.profile.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.devteria.profile.dto.request.UserProfileCreationRequest;
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

    @PostMapping("/user/create")
    public ResponseEntity<UserProfileCreationResponse> createProfile(@RequestBody UserProfileCreationRequest request) {
        UserProfileCreationResponse response = userProfileService.createProfile(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/user/{profileId}")
    public ResponseEntity<UserProfileCreationResponse> getProfile(@PathVariable String profileId) {
        UserProfileCreationResponse response = userProfileService.getProfile(profileId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserProfileCreationResponse>> getAllProfiles() {
        List<UserProfileCreationResponse> responses = userProfileService.getAllProfiles();
        return ResponseEntity.ok(responses);
    }
}

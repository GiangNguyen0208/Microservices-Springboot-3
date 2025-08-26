package com.devteria.identity.repository.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devteria.identity.configuration.AuthenticationRequestInterceptor;
import com.devteria.identity.dto.request.ApiResponse;
import com.devteria.identity.dto.request.UserProfileCreationRequest;
import com.devteria.identity.dto.response.UserProfileCreationResponse;

@FeignClient(
        name = "profile-service",
        url = "${app.service.profile.url}",
        configuration = {AuthenticationRequestInterceptor.class})
public interface ProfileClient {
    @PostMapping(value = "/internal/users/create", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiResponse<UserProfileCreationResponse> createProfile(@RequestBody UserProfileCreationRequest request);
}

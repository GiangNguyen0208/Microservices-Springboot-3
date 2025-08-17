package com.devteria.identity.repository.httpClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devteria.identity.dto.request.UserProfileCreationRequest;
import com.devteria.identity.dto.response.UserProfileCreationResponse;

@FeignClient(name = "profile-service", url = "${app.service.profile.url}")
public interface ProfileClient {
    @PostMapping(value = "/internal/user/create", produces = MediaType.APPLICATION_JSON_VALUE)
    UserProfileCreationResponse createProfile(@RequestBody UserProfileCreationRequest request);
}

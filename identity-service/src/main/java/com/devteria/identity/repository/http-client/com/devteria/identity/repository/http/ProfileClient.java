package com.devteria.identity.repository.http-client.com.devteria.identity.repository.http;
import javax.print.attribute.standard.Media;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.devteria.identity.dto.request.UserProfileCreationRequest;

@FeignClient(name = "profile-service", url = "http://localhost:8081/profile")
public interface ProfileClient {
    @PostMapping(value = "/user/create", produces = MediaType.APPLICATION_JSON_VALUE)
    Object createProfile(@RequestBody UserProfileCreationRequest request); 
}

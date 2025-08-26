package com.devteria.identity.configuration;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import feign.RequestInterceptor;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AuthenticationRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(feign.RequestTemplate template) {
        ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        var authHeader = attrs.getRequest().getHeader("Authorization");
        log.info("Auth header: {}", authHeader);

        if (StringUtils.isNotBlank(authHeader)) {
            log.info("Auth header found, request will be sent with authentication");
            template.header("Authorization", authHeader);
        } else {
            log.warn("No auth header or predefined token found, request will be sent without authentication");
        }
    }
}

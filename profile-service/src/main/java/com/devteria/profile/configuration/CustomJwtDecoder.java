package com.devteria.profile.configuration;

import java.text.ParseException;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtException;
import org.springframework.stereotype.Component;

import com.nimbusds.jwt.SignedJWT;

@Component
public class CustomJwtDecoder implements JwtDecoder {

    @Override
    public Jwt decode(String token) throws JwtException {
        try {
            SignedJWT signnedJWT = SignedJWT.parse(token);
            return new Jwt(
                    token,
                    signnedJWT.getJWTClaimsSet().getIssueTime().toInstant(),
                    signnedJWT.getJWTClaimsSet().getExpirationTime().toInstant(),
                    signnedJWT.getHeader().toJSONObject(),
                    signnedJWT.getJWTClaimsSet().toJSONObject());
        } catch (ParseException e) {
            throw new JwtException("Invalid JWT token", e);
        }
    }
}

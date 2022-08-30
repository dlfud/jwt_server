package com.example.jwtserver_forlecture.config.jwt;

public interface JwtProperties {
    String SECRET = "MySecretKey";
    //int EXPIRATION_TIME = 1000 * 60 * 60 * 24 * 14;
    int EXPIRATION_TIME = 1000 * 10;
    String TOKEN_PREFIX = "Bearer ";
}

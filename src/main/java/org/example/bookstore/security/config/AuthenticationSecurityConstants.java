package org.example.bookstore.security.config;

public class AuthenticationSecurityConstants {
    public static String SECRET = "java_secret";
    public static final long EXP_TIME = 600000;
    public static String TOKEN_PREFIX = "Bearer ";
    public static String HEADER = "Authorization";
    public static String SIGN_UP_URL = "/user";
}
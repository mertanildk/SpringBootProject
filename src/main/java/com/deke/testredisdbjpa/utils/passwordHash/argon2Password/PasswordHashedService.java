package com.deke.testredisdbjpa.utils.passwordHash.argon2Password;

public interface PasswordHashedService {

    String  hashPassword(String password);
    boolean isPasswordMatch(String password, String hashedPassword);
}

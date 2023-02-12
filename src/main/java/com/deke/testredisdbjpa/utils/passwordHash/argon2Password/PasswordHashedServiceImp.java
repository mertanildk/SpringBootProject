package com.deke.testredisdbjpa.utils.passwordHash.argon2Password;


import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PasswordHashedServiceImp implements PasswordHashedService {

    private final Argon2PasswordEncoder argon2PasswordEncoder = new Argon2PasswordEncoder(32, 64, 1, 15 * 1024, 2);
    @Override
    public String hashPassword(String password) {
        return argon2PasswordEncoder.encode(password);

    }
    @Override
    public boolean isPasswordMatch(String password, String hashedPassword) {
        return  argon2PasswordEncoder.matches(password, hashedPassword);
    }
}

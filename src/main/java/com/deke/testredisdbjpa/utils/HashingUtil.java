package com.deke.testredisdbjpa.utils;

import lombok.experimental.UtilityClass;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@UtilityClass
@Deprecated
public class HashingUtil {

    @Deprecated
    public static String hashSHA2(String original) {
        MessageDigest sha256;
        try {
            sha256 = MessageDigest.getInstance("SHA-256");
            byte[] originalBytes = original.getBytes(StandardCharsets.UTF_8);
            byte[] hashed = sha256.digest(originalBytes);
            StringBuilder sb = new StringBuilder();
            for (byte b : hashed) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}

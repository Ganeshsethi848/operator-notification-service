package com.telecom.operator.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtil {

	private static final String ALGORITHM = "AES";

	private static final String SECRET_KEY = "TechTezAESKey161";

	public static String encrypt(String plainText) {

		try {

			SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);

			Cipher cipher = Cipher.getInstance(ALGORITHM);

			cipher.init(Cipher.ENCRYPT_MODE, secretKey);

			byte[] encryptedBytes = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));

			return Base64.getEncoder().encodeToString(encryptedBytes);

		} catch (Exception ex) {

			throw new RuntimeException("Password encryption failed.", ex);
		}
	}

	public static String decrypt(String encryptedText) {

		try {

			SecretKeySpec secretKey = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), ALGORITHM);

			Cipher cipher = Cipher.getInstance(ALGORITHM);

			cipher.init(Cipher.DECRYPT_MODE, secretKey);

			byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));

			return new String(decryptedBytes, StandardCharsets.UTF_8);

		} catch (Exception ex) {

			throw new RuntimeException("Password decryption failed.", ex);
		}
	}

}
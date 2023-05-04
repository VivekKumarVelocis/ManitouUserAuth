package com.userauth.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * added by kishan pandey. this class is used for password encryption using BcryptPasswordEncoder
 */
@Service
public class PasswordEncoderUtility {

    private static final BCryptPasswordEncoder INSTANCE = new BCryptPasswordEncoder();

	/*
	 * encrypt password form this function
	 */
    public static String passwordEncoder(String l_rawPassword) {
        return getPasswordEncoderInstance().encode(l_rawPassword);
    }

	/*
	 * check password form this function
	 */
    public static boolean checkPassword(String l_rawPassword, String l_encodedPassword) {
        return getPasswordEncoderInstance().matches(l_rawPassword,l_encodedPassword);
    }

    private static BCryptPasswordEncoder getPasswordEncoderInstance() {
        return INSTANCE;
    }

}

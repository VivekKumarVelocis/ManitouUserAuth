package com.userauth.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * This is custom exception class which is call when user is inactive.
 */
public class UserLockedException extends AuthenticationException {
	
	private static final long serialVersionUID = 6386894326605147953L;

	public UserLockedException(String l_message) {
        super(l_message);
    }
}

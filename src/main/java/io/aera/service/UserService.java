package io.aera.service;

import io.aera.entity.User;

/**
 * Used for user functionality (register, profile, etc)
 */
public interface UserService {
    /**
     * Register new user
     * @param user - new User
     * @return registered user if success, null otherwise
     */
    User register(User user);

}

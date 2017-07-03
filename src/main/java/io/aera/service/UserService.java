package io.aera.service;

import io.aera.entity.User;

/**
 * Used for user functionality (register, profile, etc)
 */
public interface UserService {
    /**
     * Register new user
     * @param user - new User
     * @return boolean, true if register complete successfully, false if register failed
     */
    boolean register(User user);
}

package io.aera.service;

import io.aera.entity.User;

import java.util.List;

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

    /**
     * Returns user by id
     * @param id
     * @return id
     */
    User getById(long id);

    /**
     * Finds user by its login
     *
     * @param login
     * @return user
     */
    User findByLogin(String login);

    /**
     * Updates current user
     *
     * @param user
     * @return updated user
     */
    User update(User user);

    /**
     * Returns list of users
     *
     * @return list of users
     */
    List<User> getListofUsers();

    /**
     * Deletes story by id
     *
     * @param id
     */
    User deleteStory(long id);
}

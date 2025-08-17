package com.jee.tutorial.jsfcdiexample.initializebeanstate;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.Map;
import java.util.Optional;

/**
 * A fake service to simulate fetching users from a database.
 * @ApplicationScoped because it's a stateless utility shared by all users.
 */
@ApplicationScoped
public class UserService {

    // A fake in-memory "database" table of users.
    private static final Map<Long, User> USERS = Map.of(
            1L, new User(1L, "John Doe", "john.doe@example.com"),
            2L, new User(2L, "Jane Smith", "jane.smith@example.com")
    );

    /**
     * Finds a user by their ID.
     * @param id The ID of the user to find.
     * @return An Optional containing the User if found, otherwise an empty Optional.
     */
    public Optional<User> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(USERS.get(id));
    }
}


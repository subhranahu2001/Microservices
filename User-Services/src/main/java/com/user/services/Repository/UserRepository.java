package com.user.services.Repository;

import com.user.services.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    // Additional custom methods can be added here if needed.
}

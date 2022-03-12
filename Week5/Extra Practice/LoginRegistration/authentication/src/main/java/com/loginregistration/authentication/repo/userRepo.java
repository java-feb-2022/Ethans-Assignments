package com.loginregistration.authentication.repo;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.loginregistration.authentication.models.User;

@Repository
public interface userRepo extends CrudRepository<User, Long> {
    
    public User findByEmail(String email);
    
}

package com.devfapesc.api.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.devfapesc.api.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}

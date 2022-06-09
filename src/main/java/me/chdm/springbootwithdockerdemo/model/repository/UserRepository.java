package me.chdm.springbootwithdockerdemo.model.repository;

import me.chdm.springbootwithdockerdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

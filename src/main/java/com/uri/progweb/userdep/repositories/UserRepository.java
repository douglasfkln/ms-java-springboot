package com.uri.progweb.userdep.repositories;

import com.uri.progweb.userdep.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

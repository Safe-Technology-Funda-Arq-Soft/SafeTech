package com.api.safetech.user.domain.persistence;

import com.api.safetech.user.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {

    User findByEmail(String email);
//    User findAllByFirstNameAndLastName(String firstName, String lastName);

}

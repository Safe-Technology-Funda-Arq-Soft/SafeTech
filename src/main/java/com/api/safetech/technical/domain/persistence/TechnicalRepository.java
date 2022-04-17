package com.api.safetech.technical.domain.persistence;

import com.api.safetech.technical.domain.model.entity.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnicalRepository extends JpaRepository<Technical, Long> {
    Technical findByEmail(String email);
    List<Technical> findByFirstName(String firsName);
    List<Technical> findByLastName(String lastName);
}

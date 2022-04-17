package com.api.safetech.technical.domain.persistence;

import com.api.safetech.technical.domain.model.entity.Technical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicalRepository extends JpaRepository<Technical, Long> {
    Technical findByEmail(String email);
    Technical findByFirstName(String firsName);
}

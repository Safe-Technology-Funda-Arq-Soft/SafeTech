package com.api.safetech.appliance.domain.persistence;


import com.api.safetech.appliance.domain.model.entity.Appliance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplianceRepository extends JpaRepository<Appliance, Long> {

    List<Appliance>findByName(String name);
}

package com.api.safetech.appliance.domain.service;

import com.api.safetech.appliance.domain.model.entity.Appliance;

import java.util.List;

public interface ApplianceService {
    List<Appliance>getAll();
    Appliance getById(Long ApplianceId);
    Appliance create(Appliance appliance);
    Appliance update(Appliance applianceId, Appliance appliance);
    Appliance delete(Long applianceId);
    List<Appliance> getByName(String name);

}

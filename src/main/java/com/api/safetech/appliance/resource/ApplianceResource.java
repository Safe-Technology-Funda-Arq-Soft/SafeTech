package com.api.safetech.appliance.resource;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplianceResource {
    private Long id;
    private String appliance;
    private Float unitReparationCost;
}

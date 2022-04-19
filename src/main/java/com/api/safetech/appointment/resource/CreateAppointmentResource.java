package com.api.safetech.appointment.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateAppointmentResource {
    @NotNull
    @NotBlank
    private String problemDescription;

    @NotNull
    @NotBlank
    private String scheduledAt;

    @NotNull
    @NotBlank
    private String address;

    @NotNull
    private Boolean isCancelled;
}

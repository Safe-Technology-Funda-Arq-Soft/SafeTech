package com.api.safetech.publication.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateCommentResource {

    @NotNull
    @NotBlank
    @Size(max = 250)
    private String comment;

}

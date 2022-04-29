package com.api.safetech.publication.resource;
import com.api.safetech.user.resource.UserResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentaryResource {
    private Long id;
    private String commentary;
    private PublicationResource publication;
    private UserResource user;
}

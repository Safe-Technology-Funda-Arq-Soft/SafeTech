package com.api.safetech.publication.mapping;

import com.api.safetech.publication.domain.model.entity.Commentary;
import com.api.safetech.publication.resource.CreateCommentaryResource;
import com.api.safetech.publication.resource.CommentaryResource;
import com.api.safetech.publication.resource.UpdateCommentaryResource;
import com.api.safetech.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentaryMapper {

    @Autowired
    private EnhancedModelMapper mapper;

    // Object Mapping
    public CommentaryResource toResource(Commentary model)
    {
        return mapper.map(model, CommentaryResource.class);
    }

    public List<CommentaryResource> toResource(List<Commentary> model)
    {
        return mapper.mapList(model, CommentaryResource.class);
    }

    public Commentary toModel(CreateCommentaryResource resource)
    {
        return mapper.map(resource, Commentary.class);
    }

    public Commentary toModel(UpdateCommentaryResource resource)
    {
        return mapper.map(resource, Commentary.class);
    }

}

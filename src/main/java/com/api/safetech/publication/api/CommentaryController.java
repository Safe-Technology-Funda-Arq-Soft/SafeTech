package com.api.safetech.publication.api;
import com.api.safetech.publication.domain.service.CommentaryService;
import com.api.safetech.publication.mapping.CommentaryMapper;
import com.api.safetech.publication.resource.CreateCommentaryResource;
import com.api.safetech.publication.resource.CommentaryResource;
import com.api.safetech.publication.resource.UpdateCommentaryResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Commentary")
@RestController
@RequestMapping("/api/v1/commentary")
@CrossOrigin
public class CommentaryController {
    @Autowired
    private CommentaryService commentaryService;

    @Autowired
    private CommentaryMapper mapper;

    @Operation(summary = "Get Commentarys", description = "Get All Commentarys")
    @GetMapping
    public List<CommentaryResource> getAllCommentary()
    {
        return mapper.toResource(commentaryService.getAll());
    }

    @Operation(summary = "Get Commentary by Id", description = "Get Commentary by Id")
    @GetMapping("{commentaryId}")
    public CommentaryResource getCommentaryById(@PathVariable Long commentaryId)
    {
        return mapper.toResource(commentaryService.getById(commentaryId));
    }

    @Operation(summary = "Create Commentary", description = "Create Commentary")
    @PostMapping("publications/{publicationId}")
    public CommentaryResource createCommentary(@PathVariable Long publicationId, @Valid @RequestBody CreateCommentaryResource request)
    {
        return mapper.toResource(commentaryService.create(mapper.toModel(request), publicationId));
    }

    @Operation(summary = "Update Commentary", description = "Update Commentary by Id ")
    @PutMapping("{commentaryId}")
    public CommentaryResource updateCommentary(@PathVariable Long commentaryId, @Valid @RequestBody UpdateCommentaryResource request)
    {
        return mapper.toResource(commentaryService.update(commentaryId, mapper.toModel(request)));
    }

    @Operation(summary = "Delete Commentary", description = "Delete Commentary by Id")
    @DeleteMapping("{commentaryId}")
    public ResponseEntity<?> deleteCommentary(@PathVariable Long commentaryId)
    {
        return commentaryService.delete(commentaryId);
    }

    @Operation(summary = "Get Commentary by publication Id", description = "Get Commentary by publication Id")
    @GetMapping("publication/{publicationId}")
    public List<CommentaryResource> getCommentaryByPublication(@PathVariable Long publicationId)
    {
        return mapper.toResource(commentaryService.getByPublicationId(publicationId));
    }

    @Operation(summary = "Get Commentary by user Id", description = "Get Commentary by user Id")
    @GetMapping("user/{userId}")
    public List<CommentaryResource> getCommentaryByUser(@PathVariable Long userId)
    {
        return mapper.toResource(commentaryService.getByUserId(userId));
    }

}


package com.api.safetech.publication.domain.service;

import com.api.safetech.publication.domain.model.entity.Commentary;
import org.springframework.http.ResponseEntity;

import java.util.List;
public interface CommentaryService {
    List<Commentary> getAll();
    Commentary getById(Long commentaryId);
    Commentary create(Commentary commentary, Long publicationId);
    Commentary update(Long commentaryId, Commentary request);
    ResponseEntity<?> delete(Long commentaryId);
    List<Commentary> getByPublicationId(Long publicationId);
    List<Commentary> getByUserId(Long userId);
}

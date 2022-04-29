package com.api.safetech.publication.service;

import com.api.safetech.publication.domain.model.entity.Commentary;
import com.api.safetech.publication.domain.persistence.CommentaryRepository;
import com.api.safetech.publication.domain.service.CommentaryService;
import com.api.safetech.shared.exception.ResourceNotFoundException;
import com.api.safetech.publication.domain.model.entity.Publication;
import com.api.safetech.publication.domain.persistence.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentaryServiceImpl implements CommentaryService {
    private final static String ENTITY = "Commentary";

    @Autowired
    private CommentaryRepository commentaryRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public List<Commentary> getAll() {
        return commentaryRepository.findAll();
    }

    @Override
    public Commentary getById(Long commentaryId) {
        return commentaryRepository.findById(commentaryId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, commentaryId));
    }

    @Override
    public Commentary create(Commentary commentary, Long publicationId) {
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with Id" + publicationId));
        commentary.setPublication(publication);
        return commentaryRepository.save(commentary);
    }

    @Override
    public Commentary update(Long commentaryId, Commentary request) {
        return commentaryRepository.findById(commentaryId).map(commentary ->
                        commentaryRepository.save(commentary
                                .withCommentary(request.getCommentary())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY,commentaryId));
    }

    @Override
    public ResponseEntity<?> delete(Long commentaryId) {
        return commentaryRepository.findById(commentaryId).map(commentary -> {
            commentaryRepository.delete(commentary);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentaryId));
    }
    @Override
    public List<Commentary> getByPublicationId(Long publicationId) {
        return commentaryRepository.findByPublicationId(publicationId);
    }
    @Override
    public List<Commentary> getByUserId(Long userId) {
        return commentaryRepository.findByUserId(userId);
    }
}

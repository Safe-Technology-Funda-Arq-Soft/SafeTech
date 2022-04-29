package com.api.safetech.publication.service;

import com.api.safetech.publication.domain.model.entity.Comment;
import com.api.safetech.publication.domain.persistence.CommentRepository;
import com.api.safetech.publication.domain.service.CommentService;
import com.api.safetech.shared.exception.ResourceNotFoundException;
import com.api.safetech.publication.domain.model.entity.Publication;
import com.api.safetech.publication.domain.persistence.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final static String ENTITY = "Comment";

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PublicationRepository publicationRepository;

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment getById(Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, commentId));
    }

    @Override
    public Comment create(Comment comment, Long publicationId) {
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with Id" + publicationId));
        comment.setPublication(publication);
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Long commentId, Comment request) {
        return commentRepository.findById(commentId).map(comment ->
                        commentRepository.save(comment
                                .withComment(request.getComment())))
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY,commentId));
    }

    @Override
    public ResponseEntity<?> delete(Long commentId) {
        return commentRepository.findById(commentId).map(comment -> {
            commentRepository.delete(comment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, commentId));
    }
    @Override
    public List<Comment> getByPublicationId(Long publicationId) {
        return commentRepository.findByPublicationId(publicationId);
    }
    @Override
    public List<Comment> getByUserId(Long userId) {
        return commentRepository.findByUserId(userId);
    }
}

package com.api.doc.easy.service;

import com.api.doc.easy.model.ApplicationItem;
import com.api.doc.easy.repository.ApplicationRepository;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ApplicationService {
    private final ApplicationRepository applicationRepository;

    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public ApplicationItem save(@NotNull ApplicationItem item) {
        return applicationRepository.save(item);
    }

    public List<ApplicationItem> getAll() {
        return applicationRepository.findAllByDeletedFalseOrderByNameAsc();
    }

    public ApplicationItem getById(Long applicationId) {
        if (applicationId == null) return null;
        return applicationRepository.getById(applicationId);
    }

    @Transactional
    public void delete(Long id) {
        applicationRepository.findById(id).ifPresent(applicationItem -> {
            applicationItem.setDeleted(true);
            applicationRepository.save(applicationItem);
        });
    }
}
package com.api.doc.easy.service;

import com.api.doc.easy.model.ApplicationItem;
import com.api.doc.easy.repository.ApplicationRepository;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;

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
        return applicationRepository.findAllByOrderByIdAsc();
    }

    public ApplicationItem getById(Long applicationId) {
        if (applicationId == null) return null;
        return applicationRepository.getById(applicationId);
    }
}
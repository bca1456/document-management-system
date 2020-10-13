package com.documents.demo.service.impl;

import com.documents.demo.domain.Document;
import com.documents.demo.repos.DocumentRepository;
import com.documents.demo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public List<Document> findAll() {
        return (List<Document>) documentRepository.findAll();
    }
}

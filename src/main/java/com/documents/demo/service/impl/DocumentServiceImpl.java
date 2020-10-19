package com.documents.demo.service.impl;

import com.documents.demo.domain.Document;
import com.documents.demo.repos.DocumentRepository;
import com.documents.demo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    @Override
    public Optional<Document> findById(int id) {
        return documentRepository.findById(id);
    }

    @Override
    public void addNew(Document document) {
        documentRepository.save(document);
    }

    @Override
    public void deleteById(int id) {
        documentRepository.deleteById(id);
    }

    @Override
    public boolean update(Document document) {
        if (documentRepository.findById(document.getId()).isPresent()) {
            documentRepository.deleteById(document.getId());
            Document newDocument = new Document(document.getId(), document.getCreationDate(), document.getStatus(), document.getAuthor(), document.getFile());
            documentRepository.save(newDocument);
            return true;
        }
        return false;
    }
}

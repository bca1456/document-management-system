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
            Document documentToUpdate = documentRepository.getOne(document.getId());
            documentToUpdate.setCreationDate(document.getCreationDate());
            documentToUpdate.setStatus(document.getStatus());
            documentToUpdate.setFile(document.getFile());
            documentToUpdate.setAuthor(document.getAuthor());
            documentRepository.save(documentToUpdate);
            return true;
        }
        return false;
    }
}

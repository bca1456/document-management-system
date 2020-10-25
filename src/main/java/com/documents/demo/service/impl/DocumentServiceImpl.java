package com.documents.demo.service.impl;

import com.documents.demo.domain.Document;
import com.documents.demo.repos.DocumentRepository;
import com.documents.demo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    @Override
    public Document findById(int id) {
        return documentRepository.findById(id).orElse(new Document());
    }

    @Override
    public boolean addNew(Document document) {
        if (document != null) {
            documentRepository.save(document);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteById(int id) {
        if (documentRepository.findById(id).isPresent()) {
            documentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Document document) {
        if (documentRepository.findById(document.getId()).isPresent()) {
            Document documentToUpdate = documentRepository.getOne(document.getId());
            documentToUpdate.setCreationDate(document.getCreationDate());
            documentToUpdate.setStatus(document.getStatus());
            documentToUpdate.setFile(document.getFile());
            documentToUpdate.setAuthor(document.getAuthor());
            documentToUpdate.setPaperFormat(document.getPaperFormat());
            documentRepository.save(documentToUpdate);
            return true;
        }
        return false;
    }

    @Override
    public Page<Document> findPaginated(int page, int size) {
        return documentRepository.findAll(PageRequest.of(page, size));
    }
}

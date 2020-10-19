package com.documents.demo.service;

import com.documents.demo.domain.Document;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

public interface DocumentService {
    List<Document> findAll();
    Optional<Document> findById(int id);
    void addNew(Document document);
    void deleteById(int id);
    boolean update(Document document);
}

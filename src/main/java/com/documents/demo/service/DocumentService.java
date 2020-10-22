package com.documents.demo.service;

import com.documents.demo.domain.Document;

import java.util.List;

public interface DocumentService {
    List<Document> findAll();
    Document findById(int id);
    boolean addNew(Document document);
    boolean deleteById(int id);
    boolean update(Document document);
}

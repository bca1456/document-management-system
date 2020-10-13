package com.documents.demo.controller;

import com.documents.demo.domain.Document;
import com.documents.demo.repos.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/document")
public class DocumentController {

    @Autowired
    private DocumentRepository documentRepository;

    @RequestMapping("/okay")
    public String getOkay(){
        return "okay";
    }

    @RequestMapping("/all")
    public List<Document> findAll(){
        documentRepository.findAll().forEach(System.out::println);
        return (List<Document>) this.documentRepository.findAll();
    }
}

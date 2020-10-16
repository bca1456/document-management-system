package com.documents.demo.controller;

import com.documents.demo.domain.Document;
import com.documents.demo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping("/okay")
    public String getOkay(){
        return "okay";
    }

    @RequestMapping("/all")
    public List<Document> findAll(){
        return this.documentService.findAll();
    }

    @RequestMapping("/{document_id}")
    public Optional<Document> findById(@PathVariable("document_id") int document_id){
        return documentService.findById(document_id);
    }

    @PostMapping("/add")
    public void addDocument(@RequestBody Document document){
//        System.out.println(document.getCreationDate());
        documentService.addNew(document);
    }

    @DeleteMapping("/{document_id}")
    public void deleteDocument(@PathVariable("document_id") int document_id){
        documentService.deleteById(document_id);
    }

}

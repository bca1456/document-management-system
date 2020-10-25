package com.documents.demo.controller;

import com.documents.demo.domain.Document;
import com.documents.demo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/api/v1/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @RequestMapping("/okay")
    public String getOkay(){
        return "okay";
    }

    @RequestMapping(value = "/all")
    public List<Document> findAll(){
       return this.documentService.findAll();
    }

    @RequestMapping(value = "/all", params = { "page", "size" })
    public Page<Document> findAll(@RequestParam("page") int page, @RequestParam("size") int size){
        return documentService.findPaginated(page, size);
    }

    @RequestMapping("/{document_id}")
    public Document findById(@PathVariable("document_id") int document_id){
        return documentService.findById(document_id);
    }

    @PostMapping("/add")
    public Serializable addDocument(@RequestBody Document document){
//        System.out.println(document.getCreationDate());
        if (documentService.addNew(document)){
            return document;
        }
        return "gg";
    }

    @DeleteMapping("/{document_id}")
    public Serializable deleteDocument(@PathVariable("document_id") int document_id){
        if (documentService.deleteById(document_id)){
            return "ok";
        }
        return "gg";
    }

    @PutMapping("/update")
    public Serializable updateDocument(@RequestBody Document document){
        if(documentService.update(document)){
            return document;
        }
        return "gg";
    }

}

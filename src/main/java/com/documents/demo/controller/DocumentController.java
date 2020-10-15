package com.documents.demo.controller;

import com.documents.demo.domain.Document;
import com.documents.demo.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.Doc;
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

    @RequestMapping("/all")
    public List<Document> findAll(){
        return this.documentService.findAll();
    }


}

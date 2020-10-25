package com.documents.demo.controller;

import com.documents.demo.domain.Document;
import com.documents.demo.service.DocumentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/api/v1/document")
@Api
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @ApiOperation(value = "get okay string idk for what =)")
    @RequestMapping("/okay")
    public String getOkay(){
        return "okay";
    }

    @ApiOperation(value = "get all documents")
    @RequestMapping(value = "/all")
    public List<Document> findAll(){
       return this.documentService.findAll();
    }

    @ApiOperation(value = "get all documents with pagination")
    @RequestMapping(value = "/all", params = { "page", "size" })
    public Page<Document> findAll(@RequestParam("page") int page, @RequestParam("size") int size){
        return documentService.findPaginated(page, size);
    }

    @ApiOperation(value = "get document by id")
    @RequestMapping("/{document_id}")
    public Document findById(@PathVariable("document_id") int document_id){
        return documentService.findById(document_id);
    }

    @ApiOperation(value = "add document via post")
    @PostMapping("/add")
    public Serializable addDocument(@RequestBody Document document){
//        System.out.println(document.getCreationDate());
        if (documentService.addNew(document)){
            return document;
        }
        return "gg";
    }

    @ApiOperation(value = "delete document by id")
    @DeleteMapping("/{document_id}")
    public Serializable deleteDocument(@PathVariable("document_id") int document_id){
        if (documentService.deleteById(document_id)){
            return "ok";
        }
        return "gg";
    }

    @ApiOperation(value = "update document via put")
    @PutMapping("/update")
    public Serializable updateDocument(@RequestBody Document document){
        if(documentService.update(document)){
            return document;
        }
        return "gg";
    }

}

package com.documents.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/document")
public class DocumentController {

    @RequestMapping("/okay")
    public String getOkay(){
        return "okay";
    }
}

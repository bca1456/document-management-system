package com.documents.demo.domain;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate creationDate;
    private String status;
    private String author;
    private String file;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}

package com.documents.demo.domain;


import javax.persistence.*;
import java.io.File;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue
    private int id;

  //  @todo need to fix
    @Column(name = "creation_date")
//    @Temporal(TemporalType.DATE)
    private LocalDate creationDate;

    @Column(name = "status")
    private String status;

    @Column(name = "author")
    private String author;

    @Column(name = "file")
    private File file;

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

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}

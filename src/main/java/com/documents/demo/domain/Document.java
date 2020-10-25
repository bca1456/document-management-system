package com.documents.demo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "documents")
public class Document extends PaperList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "creation_date", nullable = false)
    private LocalDate creationDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "file")
    private String file;

    public Document() {
        super();
    }

    public Document(int id, LocalDate creationDate, String status, String author, String file) {
        super();
        this.id = id;
        this.creationDate = creationDate;
        this.status = status;
        this.author = author;
        this.file = file;
    }

    public Document(Format paperFormat, int id, LocalDate creationDate, String status, String author, String file) {
        super(paperFormat);
        this.id = id;
        this.creationDate = creationDate;
        this.status = status;
        this.author = author;
        this.file = file;
    }

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

    @Override
    public Format getPaperFormat() {
        return super.getPaperFormat();
    }

    @Override
    public void setPaperFormat(Format paperFormat) {
        super.setPaperFormat(paperFormat);
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", status='" + status + '\'' +
                ", author='" + author + '\'' +
                ", file='" + file + '\'' +
                ", paperFormat=" + paperFormat +
                '}';
    }
}

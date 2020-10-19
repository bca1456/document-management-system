package com.documents.demo.domain;

public class PaperList {
    protected Format paperFormat;

    public PaperList() {
        this.paperFormat = Format.A4;
    }

    public PaperList(Format paperFormat) {
        this.paperFormat = paperFormat;
    }

    public Format getPaperFormat() {
        return paperFormat;
    }

    public void setPaperFormat(Format paperFormat) {
        this.paperFormat = paperFormat;
    }
}

enum Format{
    A1,
    A2,
    A3,
    A4,
    A5
}
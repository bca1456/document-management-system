package com.documents.demo.repos;

import com.documents.demo.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface  DocumentRepository extends CrudRepository<Document, Integer>{}

package com.bankApp.authentication.repository;

import com.bankApp.authentication.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Long> {
}

package com.bankApp.authentication.documentMgt.repo;

import com.bankApp.authentication.documentMgt.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,Long> {
}

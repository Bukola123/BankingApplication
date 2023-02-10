package com.bankApp.authentication.documentMgt.repo;

import com.bankApp.authentication.documentMgt.model.IdDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdDetailsRepo extends JpaRepository<IdDetails , Long> {
}

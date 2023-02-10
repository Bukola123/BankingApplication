package com.bankApp.authentication.documentMgt.repo;

import com.bankApp.authentication.documentMgt.model.Utility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilityRepo extends JpaRepository <Utility, Long> {
}

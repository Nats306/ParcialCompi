package com.example.parcialcompiladores.repositories;

import com.example.parcialcompiladores.modelos.SecurityReport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ISecurityReportRepository extends JpaRepository<SecurityReport, String> {

    public List<SecurityReport> findByIs_resolved(boolean isResolved);
}

package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.DTO.SecurityReportDTO;
import com.example.parcialcompiladores.modelos.SecurityReport;

import java.util.List;

public interface IServiceSecurityReport {
    public void addSecurityReport(SecurityReportDTO securityReportDTO);
    public List<SecurityReportDTO> getReportByUnresolved();
    public void changeStatusReport(String id);
}

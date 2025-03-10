package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.modelos.SecurityReport;

import java.util.List;

public interface IServiceSecurityReport {
    public void addSecurityReport(SecurityReport securityReport);
    public List<SecurityReport> getReportByUnresolved();
    public void changeStatusReport(String id);
}

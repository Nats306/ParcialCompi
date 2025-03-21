package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.modelos.PrivateJet;
import com.example.parcialcompiladores.modelos.SecurityReport;
import com.example.parcialcompiladores.repositories.ISecurityReportRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class SecurityReportService implements IServiceSecurityReport{
    private ISecurityReportRepository securityReportRepository;

    @Override
    public void addSecurityReport(SecurityReport securityReport) {

        this.securityReportRepository.save(securityReport);
    }

    @Override
    public List<SecurityReport> getReportByUnresolved() {
        return this.securityReportRepository.findByIs_resolved(false);
    }

    @Override
    public void changeStatusReport(String id) {
        SecurityReport previousReport = this.securityReportRepository.findById(id).orElse(null);
        if(previousReport != null){
            previousReport.set_resolved(true);
            //this.privateJetRepository.save(previousReport);donde tengo que poner para que savee
        }
    }
}

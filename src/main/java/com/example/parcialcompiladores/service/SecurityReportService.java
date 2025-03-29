package com.example.parcialcompiladores.service;

import com.example.parcialcompiladores.DTO.SecurityReportDTO;
import com.example.parcialcompiladores.modelos.Flight;
import com.example.parcialcompiladores.modelos.SecurityReport;
import com.example.parcialcompiladores.repositories.IFlightRepository;
import com.example.parcialcompiladores.repositories.ISecurityReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class SecurityReportService implements IServiceSecurityReport{
    @Autowired
    private ISecurityReportRepository securityReportRepository;
    @Autowired
    private IFlightRepository flightRepository;

    private SecurityReportDTO convertToDTO(SecurityReport securityReport) {
        return new SecurityReportDTO(
                securityReport.getId(),
                securityReport.getReported_by(),
                securityReport.getDescription(),
                securityReport.isResolved(),
                securityReport.getFlight().getId()
        );
    }

    @Override
    public void addSecurityReport(SecurityReportDTO securityReportDTO) {
        Flight flight= flightRepository.findById(securityReportDTO.getFlight_id()).get();
        SecurityReport securityReport= new SecurityReport();

        securityReport.setReported_by(securityReportDTO.getReported_by());
        securityReport.setDescription(securityReportDTO.getDescription());
        securityReport.setResolved(securityReportDTO.isResolved());
        securityReport.setFlight(flight);

        securityReportRepository.save(securityReport);

    }

    @Override
    public List<SecurityReportDTO> getReportByUnresolved() {
        return securityReportRepository.findByResolved(false).
                stream().map(this::convertToDTO).toList();

    }

    @Override
    public void changeStatusReport(String id) {
        SecurityReport previousReport = this.securityReportRepository.findById(id).orElse(null);
        if(previousReport != null){
            previousReport.setResolved(true);
        }
    }
}

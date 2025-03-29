package com.example.parcialcompiladores.controllers;

import com.example.parcialcompiladores.DTO.SecurityReportDTO;
import com.example.parcialcompiladores.modelos.SecurityReport;
import com.example.parcialcompiladores.service.IServiceSecurityReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/security-reports")
public class ControladorSecurityReport {
    @Autowired
    private IServiceSecurityReport serviceSecurityReport;

    @GetMapping("/unresolved")
    public List<SecurityReportDTO> buscar() {
        return this.serviceSecurityReport.getReportByUnresolved();
    }

    @PostMapping("/")
    public void add(@RequestBody SecurityReportDTO securityReport) {
        this.serviceSecurityReport.addSecurityReport(securityReport);
    }

    @PatchMapping("/{id}/resolve")
    public void update(@PathVariable String id) {
        this.serviceSecurityReport.changeStatusReport(id);
    }

}

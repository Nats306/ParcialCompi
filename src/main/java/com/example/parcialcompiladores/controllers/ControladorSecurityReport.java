package com.example.parcialcompiladores.controllers;

import com.example.parcialcompiladores.modelos.PrivateJet;
import com.example.parcialcompiladores.modelos.SecurityReport;
import com.example.parcialcompiladores.service.IServicePrivateJet;
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
    public List<SecurityReport> buscar() {
        return this.serviceSecurityReport.getReportByUnresolved();
    }

    @PostMapping("/")
    public void add(@RequestBody SecurityReport securityReport) {
        this.serviceSecurityReport.addSecurityReport(securityReport);
    }

    @PatchMapping("/{id}/resolve")
    public void update(@PathVariable String id) {
        this.serviceSecurityReport.changeStatusReport(id);
    }

}

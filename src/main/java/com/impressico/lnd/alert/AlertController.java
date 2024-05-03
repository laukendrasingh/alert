package com.impressico.lnd.alert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertController {
    @Autowired
    private AlertRepository alertRepository;

    @Value("${value.from.configmap}")
    private String configMap;

    @GetMapping("/")
    public ResponseEntity<List<Alert>> getAll() {
        return new ResponseEntity<>(alertRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alert> getAll(@PathVariable("id") Long id) {
        return new ResponseEntity<>(alertRepository.findById(id).orElse(null), HttpStatus.OK);
    }

    @GetMapping("employeeId/{employeeId}")
    public ResponseEntity<List<Alert>> getAllByEmployeeId(@PathVariable("employeeId") Integer employeeId) {
        return new ResponseEntity<>(alertRepository.findAllByEmployeeId(employeeId), HttpStatus.OK);
    }

    @GetMapping("/configmap")
    public String getValuesFromConfgimap() {
        return "configMap: " + configMap;
    }
}

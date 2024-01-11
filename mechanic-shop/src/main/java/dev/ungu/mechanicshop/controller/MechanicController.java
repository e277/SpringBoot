package dev.ungu.mechanicshop.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ungu.mechanicshop.model.Mechanic;
import dev.ungu.mechanicshop.service.MechanicService;

@RestController
@RequestMapping("/api/v1/mechanic")
public class MechanicController {
    
    private MechanicService mechanicService;

    public MechanicController(MechanicService mechanicService) {
        this.mechanicService = mechanicService;
    }

    @GetMapping("/")
    public List<Mechanic> getAllmechanics() {
        return this.mechanicService.getAllMechanics();
    }

    @GetMapping("/{id}")
    public Mechanic getMechanicById(@PathVariable Long id) {
        return this.mechanicService.getMechanicById(id);
    }

    @PostMapping("/")
    public Mechanic createMechanic(@RequestBody Mechanic mechanic) {
        return this.mechanicService.createMechanic(mechanic);
    }

    @PutMapping("/{id}")
    public Mechanic updateMechanic(@PathVariable Long id, @RequestBody Mechanic mechanic) {
        return this.mechanicService.updateMechanic(id, mechanic);
    }

    @DeleteMapping("/{id}")
    public void deleteMechanic(@PathVariable Long id) {
        Mechanic mechanic = this.mechanicService.getMechanicById(id);
        this.mechanicService.deleteMechanic(mechanic);
    }
    
}

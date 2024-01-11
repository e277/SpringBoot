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

import dev.ungu.mechanicshop.model.Vehicle;
import dev.ungu.mechanicshop.service.VehicleService;

@RestController
@RequestMapping("/api/v1/vehicle")
public class VehicleController {
    
    private VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/")
    public List<Vehicle> getAllVehicles() {
        return this.vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return this.vehicleService.getVehicleById(id);
    }

    @PostMapping("/")
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return this.vehicleService.createVehicle(vehicle);
    }

    @PutMapping("/{id}")
    public Vehicle updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        return this.vehicleService.updateVehicle(id, vehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        Vehicle vehicle = this.vehicleService.getVehicleById(id);
        this.vehicleService.deleteVehicle(vehicle);
    }
    
}

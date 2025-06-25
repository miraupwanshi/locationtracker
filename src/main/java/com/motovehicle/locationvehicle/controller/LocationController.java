package com.motovehicle.locationvehicle.controller;

import com.motovehicle.locationvehicle.model.Location;
import com.motovehicle.locationvehicle.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
@CrossOrigin(origins = "*")
public class LocationController {

    @Autowired
    private LocationService service;

    @PostMapping
    public Location updateLocation(@RequestBody Location location) {
        return service.save(location);
    }

    @GetMapping("/{vehicleId}")
    public Location getLatest(@PathVariable String vehicleId) {
        return service.getLatestLocation(vehicleId);
    }

    @GetMapping("/history/{vehicleId}")
    public List<Location> getHistory(@PathVariable String vehicleId) {
        return service.getLocationHistory(vehicleId);
    }
}



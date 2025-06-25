package com.motovehicle.locationvehicle.service;

import com.motovehicle.locationvehicle.model.Location;
import com.motovehicle.locationvehicle.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationRepository repository;

    public Location save(Location location) {
        if (location.getTimestamp() == null) {
            location.setTimestamp(LocalDateTime.now());
        }
        return repository.save(location);
    }

    public Location getLatestLocation(String vehicleId) {
        return repository.findTopByVehicleIdOrderByTimestampDesc(vehicleId);
    }

    public List<Location> getLocationHistory(String vehicleId) {
        return repository.findAllByVehicleIdOrderByTimestampDesc(vehicleId);
    }
}


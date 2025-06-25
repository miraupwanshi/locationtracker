package com.motovehicle.locationvehicle.repository;


import com.motovehicle.locationvehicle.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findTopByVehicleIdOrderByTimestampDesc(String vehicleId);

    List<Location> findAllByVehicleIdOrderByTimestampDesc(String vehicleId);
}


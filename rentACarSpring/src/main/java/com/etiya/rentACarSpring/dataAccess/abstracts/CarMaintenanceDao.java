package com.etiya.rentACarSpring.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.etiya.rentACarSpring.entities.CarMaintenance;

public interface CarMaintenanceDao extends JpaRepository<CarMaintenance, Integer>{

}

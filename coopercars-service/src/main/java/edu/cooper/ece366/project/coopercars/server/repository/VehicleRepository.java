package edu.cooper.ece366.project.coopercars.server.repository;

import edu.cooper.ece366.project.coopercars.server.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;


@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, String> {
    Vehicle findByVIN(String VIN);
    void deleteById(String VIN);
    void deleteByStatus(String myStatus);
    List<Vehicle> findByBackupCam(String backupCam);
    List<Vehicle> findByParkingAssist(String parkingAssist);
    List<Vehicle> findByAdaptiveCruiseControl(String adaptiveCruiseControl);
    List<Vehicle> findByAdaptDrivingBeam(String adaptDrivingBeam);
    List<Vehicle> findByRearAutoEmergBraking(String rearAutoEmergBraking);
}


package com.example.Iot_Smart_Park.dao;

import com.example.Iot_Smart_Park.model.ParkSpace;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("spacePostgres")
public class ParkSpaceDataAccess implements ParkSpaceDao{
    @Override
    public int insertParkSpace(UUID id, ParkSpace parkSpace) {
        return 0;
    }

    @Override
    public Optional<ParkSpace> selectParkSpaceById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<ParkSpace> selectAllParkSpaces() {
        return null;
    }

    @Override
    public int deleteParkSpaceById(UUID id) {
        return 0;
    }

    @Override
    public int updateParkSpaceById(UUID id, ParkSpace parkSpace) {
        return 0;
    }

    @Override
    public Optional<ParkSpace> getParkSpaceByName(String name) {
        return Optional.empty();
    }
}

package com.example.Iot_Smart_Park.dao;

import com.example.Iot_Smart_Park.model.ParkSpace;

import java.util.List;
import java.util.Optional;

import java.util.UUID;

public interface ParkSpaceDao {
    int  insertParkSpace(UUID id, ParkSpace parkSpace);

    default int insertParkSpace(ParkSpace parkSpace){
        UUID id = UUID.randomUUID();
        return insertParkSpace(id,parkSpace);
    }

    Optional<ParkSpace> selectParkSpaceById(UUID id);
    List<ParkSpace> selectAllParkSpaces();
    int deleteParkSpaceById(UUID id);
    int updateParkSpaceById(UUID id, ParkSpace parkSpace);

}

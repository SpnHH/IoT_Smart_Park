package com.example.Iot_Smart_Park.service;

import com.example.Iot_Smart_Park.dao.ParkSpaceDao;
import com.example.Iot_Smart_Park.model.ParkSpace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkSpaceService {
    private final ParkSpaceDao parkSpaceDao;

    @Autowired
    public ParkSpaceService(@Qualifier("spacePostgres")ParkSpaceDao parkSpaceDao) {
        this.parkSpaceDao = parkSpaceDao;
    }

    public int addParkSpace(ParkSpace parkSpace){
        return parkSpaceDao.insertParkSpace(parkSpace);
    }
    public List<ParkSpace> getAllParkSpaces(){
        return parkSpaceDao.selectAllParkSpaces();
    }

    public Optional<ParkSpace> getParkSpaceById(UUID id){
        return parkSpaceDao.selectParkSpaceById(id);
    }

    public int deleteParkSpace(UUID id){
        return parkSpaceDao.deleteParkSpaceById(id);
    }
    public int updateParkSpace(UUID id, ParkSpace newParkSpace){
        return parkSpaceDao.updateParkSpaceById(id, newParkSpace);
    }

}

package com.example.Iot_Smart_Park.api;

import com.example.Iot_Smart_Park.model.ParkSpace;
import com.example.Iot_Smart_Park.model.Person;
import com.example.Iot_Smart_Park.service.ParkSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("api/v1/parkspace")
@RestController
public class ParkSpaceController {

    private final ParkSpaceService parkSpaceService;

    @Autowired
    public ParkSpaceController(ParkSpaceService parkSpaceService){
        this.parkSpaceService = parkSpaceService;
    }

    @GetMapping
    public List<ParkSpace> getAllParkSpaces() {
        return parkSpaceService.getAllParkSpaces();
    }
}

package com.example.Iot_Smart_Park.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class ParkSpace {

    private final UUID id;
    private final boolean status;
    private final double LocationLat;
    private final double LocationLng;

    public ParkSpace(@JsonProperty("id")UUID id,
                     @JsonProperty("status") boolean status,
                     @JsonProperty("LocationLat")double locationLat,
                     @JsonProperty("LocationLng")double locationLng) {
        this.id = id;
        this.status = status;
        LocationLat = locationLat;
        LocationLng = locationLng;
    }

    public UUID getId() {
        return id;
    }

    public boolean isStatus() {
        return status;
    }

    public double getLocationLat() {
        return LocationLat;
    }

    public double getLocationLng() {
        return LocationLng;
    }
}

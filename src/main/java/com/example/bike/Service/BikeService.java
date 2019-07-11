package com.example.bike.Service;

import com.example.bike.Entity.Bike;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.GeoResults;

import java.util.List;

public interface BikeService {
    void save(Bike bike);


    List<GeoResult<Bike>> findNear(double longitude, double latitude);
}

package com.esde.warehouse;

import com.esde.entity.Cone;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private static final Warehouse INSTANCE = new Warehouse();
    private final Map<String, Double> volumeMap = new HashMap<>();
    private final Map<String, Double> surfaceMap = new HashMap<>();

    private Warehouse() {
    }

    public static Warehouse getInstance() {
        return INSTANCE;
    }

    public void update(Cone cone, double volume, double surfaceArea) {
        volumeMap.put(cone.getId(), volume);
        surfaceMap.put(cone.getId(), surfaceArea);
    }

    public Double getVolume(String id) {
        return volumeMap.get(id);
    }

    public Double getSurfaceArea(String id) {
        return surfaceMap.get(id);
    }
}
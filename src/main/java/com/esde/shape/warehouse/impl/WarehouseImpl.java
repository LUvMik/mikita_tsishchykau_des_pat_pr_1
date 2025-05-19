package com.esde.shape.warehouse.impl;

import com.esde.shape.entity.Cone;
import com.esde.shape.warehouse.Warehouse;

import java.util.HashMap;
import java.util.Map;

public class WarehouseImpl implements Warehouse {
    private static final Warehouse instance = new WarehouseImpl();
    private final Map<String, Double> volumeMap = new HashMap<>();
    private final Map<String, Double> surfaceMap = new HashMap<>();

    private WarehouseImpl() {
    }

    public static Warehouse getInstance() {
        return instance;
    }

    public void update(Cone cone, double volume, double surfaceArea) {
        volumeMap.put(cone.getId(), volume);
        surfaceMap.put(cone.getId(), surfaceArea);
    }

    @Override
    public Double getVolume(String id) {
        return volumeMap.get(id);
    }

    @Override
    public Double getSurfaceArea(String id) {
        return surfaceMap.get(id);
    }
}
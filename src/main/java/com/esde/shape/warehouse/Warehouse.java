package com.esde.shape.warehouse;

import com.esde.shape.entity.Cone;
import com.esde.shape.warehouse.impl.WarehouseImpl;

public interface Warehouse {
    void update(Cone cone, double volume, double surfaceArea);

    Double getVolume(String id);

    Double getSurfaceArea(String id);
}

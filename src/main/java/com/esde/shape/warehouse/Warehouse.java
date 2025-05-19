package com.esde.shape.warehouse;

import com.esde.shape.entity.Cone;

public interface Warehouse {
    void update(Cone cone, double volume, double surfaceArea);

    Double getVolume(String id);

    Double getSurfaceArea(String id);
}

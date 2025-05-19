package com.esde.shape.service;

import com.esde.shape.entity.Cone;

public interface ConeService {
    double calculateHeight(Cone cone);

    double calculateSurfaceArea(Cone cone);

    double calculateVolume(Cone cone);

    boolean isValid(Cone cone);
}

package com.esde.shape.specification.impl;

import com.esde.shape.entity.Cone;
import com.esde.shape.specification.ConeSpecification;

public class RadiusGreaterThanSpecification implements ConeSpecification {
    private final double minRadius;

    public RadiusGreaterThanSpecification(double minRadius) {
        this.minRadius = minRadius;
    }

    @Override
    public boolean specified(Cone cone) {
        return cone.getRadius() > minRadius;
    }
}
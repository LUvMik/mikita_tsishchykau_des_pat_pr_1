package com.esde.specification;

import com.esde.entity.Cone;

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
package com.esde.service;

import com.esde.entity.Cone;
import com.esde.entity.Point;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;

public class ConeService {
    public double calculateHeight(Cone cone) {
        double dx = cone.getApex().getX() - cone.getBaseCenter().getX();
        double dy = cone.getApex().getY() - cone.getBaseCenter().getY();
        double dz = cone.getApex().getZ() - cone.getBaseCenter().getZ();
        return sqrt(dx * dx + dy * dy + dz * dz);
    }

    public double calculateSurfaceArea(Cone cone) {
        double h = calculateHeight(cone);
        double r = cone.getRadius();
        double l = sqrt(h * h + r * r);
        return PI * r * (r + l);
    }

    public double calculateVolume(Cone cone) {
        double h = calculateHeight(cone);
        double r = cone.getRadius();
        return (PI * r * r * h) / 3;
    }

    public boolean isValid(Cone cone) {
        Point baseCenter = cone.getBaseCenter();
        Point apex = cone.getApex();
        return cone.getRadius() > 0 && (baseCenter.getX() != apex.getX() &&
                apex.getY() == baseCenter.getY() && apex.getZ() == baseCenter.getZ());
    }
}
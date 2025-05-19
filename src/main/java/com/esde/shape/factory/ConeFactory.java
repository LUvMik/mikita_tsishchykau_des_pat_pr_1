package com.esde.shape.factory;

import com.esde.shape.entity.Cone;
import com.esde.shape.entity.Point;

public class ConeFactory {
    public static Cone create(String id, Point base, Point apex, double radius) {
        return new Cone(id, base, apex, radius);
    }
}
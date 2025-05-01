package com.esde.factory;

import com.esde.entity.Cone;
import com.esde.entity.Point;

public class ConeFactory {
    public static Cone create(String id, Point base, Point apex, double radius) {
        return new Cone(id, base, apex, radius);
    }
}
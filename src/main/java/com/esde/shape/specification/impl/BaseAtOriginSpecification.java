package com.esde.shape.specification.impl;

import com.esde.shape.entity.Cone;
import com.esde.shape.entity.Point;
import com.esde.shape.specification.ConeSpecification;

public class BaseAtOriginSpecification implements ConeSpecification {

    @Override
    public boolean specified(Cone cone) {
        Point base = cone.getBaseCenter();
        return base.getX() == 0.0 && base.getY() == 0.0 && base.getZ() == 0.0;
    }
}

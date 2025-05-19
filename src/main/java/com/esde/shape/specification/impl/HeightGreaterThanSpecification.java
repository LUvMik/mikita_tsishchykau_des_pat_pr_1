package com.esde.shape.specification.impl;

import com.esde.shape.entity.Cone;
import com.esde.shape.service.ConeService;
import com.esde.shape.service.impl.ConeServiceImpl;
import com.esde.shape.specification.ConeSpecification;

public class HeightGreaterThanSpecification implements ConeSpecification {
    private final double minHeight;
    private final ConeService service = new ConeServiceImpl();

    public HeightGreaterThanSpecification(double minHeight) {
        this.minHeight = minHeight;
    }

    @Override
    public boolean specified(Cone cone) {
        return service.calculateHeight(cone) > minHeight;
    }
}

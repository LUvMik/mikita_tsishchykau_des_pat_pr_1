package com.esde.shape.specification.impl;

import com.esde.shape.entity.Cone;
import com.esde.shape.service.ConeService;
import com.esde.shape.service.impl.ConeServiceImpl;
import com.esde.shape.specification.ConeSpecification;

public class VolumeInRangeSpecification implements ConeSpecification {
    private final double minVolume;
    private final double maxVolume;
    private final ConeService service = new ConeServiceImpl();

    public VolumeInRangeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specified(Cone cone) {
        double volume = service.calculateVolume(cone);
        return volume >= minVolume && volume <= maxVolume;
    }
}

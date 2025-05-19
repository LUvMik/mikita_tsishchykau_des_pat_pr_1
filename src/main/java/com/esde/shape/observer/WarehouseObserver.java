package com.esde.shape.observer;

import com.esde.shape.entity.Cone;
import com.esde.shape.observer.api.Observer;
import com.esde.shape.service.impl.ConeServiceImpl;
import com.esde.shape.warehouse.Warehouse;
import com.esde.shape.warehouse.impl.WarehouseImpl;

public class WarehouseObserver implements Observer {

    private final ConeServiceImpl service = new ConeServiceImpl();
    private final Warehouse warehouse = WarehouseImpl.getInstance();

    @Override
    public void update(Cone cone) {
        double volume = service.calculateVolume(cone);
        double surface = service.calculateSurfaceArea(cone);
        warehouse.update(cone, volume, surface);
    }
}

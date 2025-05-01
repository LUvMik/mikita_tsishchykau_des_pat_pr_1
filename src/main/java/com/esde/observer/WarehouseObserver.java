package com.esde.observer;

import com.esde.entity.Cone;
import com.esde.observer.api.Observer;
import com.esde.service.ConeService;
import com.esde.warehouse.Warehouse;

public class WarehouseObserver implements Observer {

    private final ConeService service = new ConeService();
    private final Warehouse warehouse = Warehouse.getInstance();

    @Override
    public void update(Cone cone) {
        double volume = service.calculateVolume(cone);
        double surface = service.calculateSurfaceArea(cone);
        warehouse.update(cone, volume, surface);
    }
}

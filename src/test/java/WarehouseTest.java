import com.esde.shape.entity.Cone;
import com.esde.shape.entity.Point;
import com.esde.shape.observer.WarehouseObserver;
import com.esde.shape.service.impl.ConeServiceImpl;
import com.esde.shape.warehouse.Warehouse;
import com.esde.shape.warehouse.impl.WarehouseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WarehouseTest {
    private WarehouseObserver observer;
    private ConeServiceImpl service;
    private Warehouse warehouse;

    @BeforeEach
    void setup() {
        observer = new WarehouseObserver();
        service = new ConeServiceImpl();
        warehouse = WarehouseImpl.getInstance();
    }

    @Test
    void shouldUpdateWarehouseWithCorrectValues() {
        Cone cone = new Cone("w1", new Point(0, 0, 0), new Point(0, 0, 3), 2.0);
        observer.update(cone);
        double expectedVolume = service.calculateVolume(cone);
        double expectedSurface = service.calculateSurfaceArea(cone);
        assertEquals(expectedVolume, warehouse.getVolume("w1"), 0.0001);
        assertEquals(expectedSurface, warehouse.getSurfaceArea("w1"), 0.0001);
    }

    @Test
    void shouldUpdateWarehouseWhenValuesChange() {
        Cone cone = new Cone("w2", new Point(0, 0, 0), new Point(0, 0, 3), 2.0);
        observer.update(cone);
        cone.setRadius(4.0);
        observer.update(cone);
        double newExpectedVolume = service.calculateVolume(cone);
        double newExpectedSurface = service.calculateSurfaceArea(cone);
        assertEquals(newExpectedVolume, warehouse.getVolume("w2"), 0.0001);
        assertEquals(newExpectedSurface, warehouse.getSurfaceArea("w2"), 0.0001);
    }

    @Test
    public void shouldStoreVolumeAndSurfaceArea() {
        Cone cone = new Cone("c1", new Point(0, 0, 0), new Point(0, 0, 3), 2);
        Warehouse warehouse = WarehouseImpl.getInstance();
        warehouse.update(cone, 12.0, 24.0);
        assertEquals(warehouse.getVolume("c1"), 12.0);
        assertEquals(warehouse.getSurfaceArea("c1"), 24.0);
    }
}
import com.esde.shape.entity.Point;
import com.esde.shape.observer.ObservableCone;
import com.esde.shape.observer.WarehouseObserver;
import com.esde.shape.observer.api.Observer;
import com.esde.shape.service.impl.ConeServiceImpl;
import com.esde.shape.warehouse.Warehouse;
import com.esde.shape.warehouse.impl.WarehouseImpl;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;

public class ObservableConeTest {

    @Test
    void shouldCallObserverOnSetBaseCenter() {
        ObservableCone cone = new ObservableCone("c1", new Point(0, 0, 0), new Point(0, 0, 1), 1);
        AtomicBoolean wasCalled = new AtomicBoolean(false);
        cone.attach(updatedCone -> wasCalled.set(true));

        cone.setBaseCenter(new Point(1, 0, 0));

        assertTrue(wasCalled.get(), "Observer should be called on base change");
    }

    @Test
    void shouldCallObserverOnSetApex() {
        ObservableCone cone = new ObservableCone("c2", new Point(0, 0, 0), new Point(0, 0, 1), 1);
        AtomicBoolean wasCalled = new AtomicBoolean(false);
        cone.attach(updatedCone -> wasCalled.set(true));

        cone.setApex(new Point(0, 1, 1));

        assertTrue(wasCalled.get(), "Observer should be called on apex change");
    }

    @Test
    void shouldCallObserverOnSetRadius() {
        ObservableCone cone = new ObservableCone("c3", new Point(0, 0, 0), new Point(0, 0, 1), 1);
        AtomicBoolean wasCalled = new AtomicBoolean(false);
        cone.attach(updatedCone -> wasCalled.set(true));

        cone.setRadius(5.0);

        assertTrue(wasCalled.get(), "Observer should be called on radius change");
    }

    @Test
    void shouldNotCallDetachedObserver() {
        ObservableCone cone = new ObservableCone("c4", new Point(0, 0, 0), new Point(0, 0, 1), 1);
        AtomicBoolean wasCalled = new AtomicBoolean(false);
        Observer observer = updatedCone -> wasCalled.set(true);
        cone.attach(observer);
        cone.detach(observer);

        cone.setRadius(3.0);

        assertFalse(wasCalled.get(), "Detached observer should not be called");
    }

    @Test
    void shouldStoreMultipleObservers() {
        ObservableCone cone = new ObservableCone("c5", new Point(0, 0, 0), new Point(0, 0, 1), 1);
        AtomicBoolean observer1Called = new AtomicBoolean(false);
        AtomicBoolean observer2Called = new AtomicBoolean(false);

        Observer obs1 = c -> observer1Called.set(true);
        Observer obs2 = c -> observer2Called.set(true);

        cone.attach(obs1);
        cone.attach(obs2);

        cone.setApex(new Point(0, 1, 1));

        assertTrue(observer1Called.get());
        assertTrue(observer2Called.get());
    }

    @Test
    void shouldUpdateWarehouseOnChange() {
        ObservableCone cone = new ObservableCone("c6", new Point(0, 0, 0), new Point(0, 0, 3), 2.0);
        cone.attach(new WarehouseObserver());

        cone.setRadius(3.0); // должно обновить warehouse

        Warehouse warehouseImpl = WarehouseImpl.getInstance();
        double expectedVolume = new ConeServiceImpl().calculateVolume(cone);
        assertEquals(expectedVolume, warehouseImpl.getVolume("c6"), 0.0001);
    }
}

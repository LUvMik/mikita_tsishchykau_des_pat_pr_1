import com.esde.shape.entity.Cone;
import com.esde.shape.entity.Point;
import com.esde.shape.service.impl.ConeServiceImpl;
import com.esde.shape.specification.impl.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConeSpecificationTests {

    @Test
    void shouldReturnTrueIfHeightGreaterThanThreshold() {
        Cone cone = new Cone("h1", new Point(0, 0, 0), new Point(0, 0, 10), 2.0);
        HeightGreaterThanSpecification spec = new HeightGreaterThanSpecification(5.0);

        assertTrue(spec.specified(cone));
    }

    @Test
    void shouldReturnFalseIfHeightEqualOrLessThanThreshold() {
        Cone cone = new Cone("h2", new Point(0, 0, 0), new Point(0, 0, 4), 2.0);
        HeightGreaterThanSpecification spec = new HeightGreaterThanSpecification(5.0);

        assertFalse(spec.specified(cone));
    }

    @Test
    void shouldReturnTrueIfVolumeWithinRange() {
        Cone cone = new Cone("v1", new Point(0, 0, 0), new Point(0, 0, 3), 2.0);
        double volume = new ConeServiceImpl().calculateVolume(cone);
        VolumeInRangeSpecification spec = new VolumeInRangeSpecification(volume - 1, volume + 1);

        assertTrue(spec.specified(cone));
    }

    @Test
    void shouldReturnFalseIfVolumeBelowRange() {
        Cone cone = new Cone("v2", new Point(0, 0, 0), new Point(0, 0, 2), 1.0);
        VolumeInRangeSpecification spec = new VolumeInRangeSpecification(10.0, 20.0);

        assertFalse(spec.specified(cone));
    }

    @Test
    void shouldReturnTrueIfBaseAtOrigin() {
        Cone cone = new Cone("b1", new Point(0, 0, 0), new Point(1, 1, 1), 1.0);
        BaseAtOriginSpecification spec = new BaseAtOriginSpecification();

        assertTrue(spec.specified(cone));
    }

    @Test
    void shouldReturnFalseIfBaseNotAtOrigin() {
        Cone cone = new Cone("b2", new Point(1, 0, 0), new Point(2, 2, 2), 1.0);
        BaseAtOriginSpecification spec = new BaseAtOriginSpecification();

        assertFalse(spec.specified(cone));
    }

    @Test
    void shouldReturnTrueIfIdStartsWithPrefix() {
        Cone cone = new Cone("cone123", new Point(0, 0, 0), new Point(0, 0, 3), 2.0);
        IdStartsWithSpecification spec = new IdStartsWithSpecification("cone");

        assertTrue(spec.specified(cone));
    }

    @Test
    void shouldReturnFalseIfIdDoesNotStartWithPrefix() {
        Cone cone = new Cone("shape456", new Point(0, 0, 0), new Point(0, 0, 3), 2.0);
        IdStartsWithSpecification spec = new IdStartsWithSpecification("cone");

        assertFalse(spec.specified(cone));
    }

    @Test
    void shouldReturnTrueForEmptyPrefix() {
        Cone cone = new Cone("anything", new Point(0, 0, 0), new Point(0, 0, 3), 2.0);
        IdStartsWithSpecification spec = new IdStartsWithSpecification("");

        assertTrue(spec.specified(cone));
    }

    @Test
    void shouldReturnTrueIfRadiusGreaterThanThreshold() {
        Cone cone = new Cone("cone1", new Point(0, 0, 0), new Point(0, 0, 3), 5.0);
        RadiusGreaterThanSpecification spec = new RadiusGreaterThanSpecification(3.0);

        assertTrue(spec.specified(cone));
    }

    @Test
    void shouldReturnFalseIfRadiusEqualToThreshold() {
        Cone cone = new Cone("cone1", new Point(0, 0, 0), new Point(0, 0, 3), 3.0);
        RadiusGreaterThanSpecification spec = new RadiusGreaterThanSpecification(3.0);

        assertFalse(spec.specified(cone));
    }

    @Test
    void shouldReturnFalseIfRadiusLessThanThreshold() {
        Cone cone = new Cone("cone1", new Point(0, 0, 0), new Point(0, 0, 3), 1.0);
        RadiusGreaterThanSpecification spec = new RadiusGreaterThanSpecification(3.0);

        assertFalse(spec.specified(cone));
    }
}
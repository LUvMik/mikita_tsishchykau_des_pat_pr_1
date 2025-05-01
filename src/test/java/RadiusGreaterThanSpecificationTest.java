import com.esde.entity.Cone;
import com.esde.entity.Point;
import com.esde.specification.RadiusGreaterThanSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RadiusGreaterThanSpecificationTest {

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

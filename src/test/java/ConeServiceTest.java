import com.esde.entity.Cone;
import com.esde.entity.Point;
import com.esde.service.ConeService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConeServiceTest {
    ConeService service = new ConeService();

    @Test
    public void volumeCalculationShouldBeCorrect() {
        Cone cone = new Cone("v1", new Point(0, 0, 0), new Point(0, 0, 3), 2);
        double expected = Math.PI * 4 * 3 / 3;
        assertEquals(service.calculateVolume(cone), expected, 0.0001);
    }

    @Test
    public void surfaceAreaShouldBeCorrect() {
        Cone cone = new Cone("s1", new Point(0, 0, 0), new Point(0, 0, 4), 3);
        double l = Math.sqrt(4 * 4 + 9);
        double expected = Math.PI * 3 * (3 + l);
        assertEquals(service.calculateSurfaceArea(cone), expected, 0.0001);
    }

    @Test
    public void isValidShouldReturnTrueForCorrectCone() {
        Cone cone = new Cone("v2", new Point(0, 0, 0), new Point(0, 1, 1), 1);
        assertFalse(service.isValid(cone));
    }
}
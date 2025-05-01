import com.esde.entity.Point;
import com.esde.validator.ConeValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConeValidatorTest {

    @Test
    void shouldReturnFalseIfLineHasLessThan8Tokens() {
        String line = "cone1;1.0;2.0";
        assertFalse(ConeValidator.isValidLine(line));
    }

    @Test
    void shouldReturnFalseIfLineContainsNonNumericValue() {
        String line = "cone1;1.0;2.0;3.0;a;5.0;6.0;7.0";
        assertFalse(ConeValidator.isValidLine(line));
    }

    @Test
    void shouldReturnFalseIfRadiusIsNegative() {
        String line = "cone1;1.0;2.0;3.0;4.0;5.0;6.0;-1.0";
        assertFalse(ConeValidator.isValidLine(line));
    }

    @Test
    void shouldReturnFalseIfBaseEqualsApex() {
        String line = "cone1;1.0;2.0;3.0;1.0;2.0;3.0;2.0";
        assertFalse(ConeValidator.isValidLine(line));
    }

    @Test
    void shouldReturnTrueForValidLine() {
        String line = "cone1;0.0;0.0;0.0;0.0;0.0;5.0;2.0";
        assertTrue(ConeValidator.isValidLine(line));
    }

    @Test
    void shouldReturnTrueForValidRadius() {
        assertTrue(ConeValidator.isRadiusValid(1.0));
    }

    @Test
    void shouldReturnFalseForInvalidRadius() {
        assertFalse(ConeValidator.isRadiusValid(0.0));
        assertFalse(ConeValidator.isRadiusValid(-2.0));
    }

    @Test
    void shouldReturnTrueIfPointXNotEqualAndYAndZEqual() {
        Point p1 = new Point(1.0, 2.0, 3.0);
        Point p2 = new Point(2.0, 2.0, 3.0);
        assertTrue(ConeValidator.isPointValid(p1, p2));
    }

    @Test
    void shouldReturnFalseIfAllCoordinatesEqual() {
        Point p1 = new Point(1.0, 2.0, 3.0);
        Point p2 = new Point(1.0, 2.0, 3.0);
        assertFalse(ConeValidator.isPointValid(p1, p2));
    }

    @Test
    void shouldReturnFalseIfYCoordinatesDiffer() {
        Point p1 = new Point(1.0, 2.0, 3.0);
        Point p2 = new Point(2.0, 5.0, 3.0);
        assertFalse(ConeValidator.isPointValid(p1, p2));
    }

    @Test
    void shouldReturnFalseIfZCoordinatesDiffer() {
        Point p1 = new Point(1.0, 2.0, 3.0);
        Point p2 = new Point(2.0, 2.0, 7.0);
        assertFalse(ConeValidator.isPointValid(p1, p2));
    }
}

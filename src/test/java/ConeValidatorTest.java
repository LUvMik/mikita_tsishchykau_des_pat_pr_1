import com.esde.shape.entity.Point;
import com.esde.shape.validator.ConeValidator;
import com.esde.shape.validator.impl.ConeValidatorImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConeValidatorTest {

    @Test
    void shouldReturnFalseIfLineHasLessThan8Tokens() {
        ConeValidator validator = new ConeValidatorImpl();
        String line = "cone1;1.0;2.0";
        assertFalse(validator.isValidLine(line));
    }

    @Test
    void shouldReturnFalseIfLineContainsNonNumericValue() {
        ConeValidator validator = new ConeValidatorImpl();
        String line = "cone1;1.0;2.0;3.0;a;5.0;6.0;7.0";
        assertFalse(validator.isValidLine(line));
    }

    @Test
    void shouldReturnFalseIfRadiusIsNegative() {
        ConeValidator validator = new ConeValidatorImpl();
        String line = "cone1;1.0;2.0;3.0;4.0;5.0;6.0;-1.0";
        assertFalse(validator.isValidLine(line));
    }

    @Test
    void shouldReturnFalseIfBaseEqualsApex() {
        ConeValidator validator = new ConeValidatorImpl();
        String line = "cone1;1.0;2.0;3.0;1.0;2.0;3.0;2.0";
        assertFalse(validator.isValidLine(line));
    }

    @Test
    void shouldReturnTrueForValidLine() {
        ConeValidator validator = new ConeValidatorImpl();
        String line = "cone1;0.0;0.0;0.0;0.0;0.0;5.0;2.0";
        assertTrue(validator.isValidLine(line));
    }

    @Test
    void shouldReturnTrueForValidRadius() {
        ConeValidator validator = new ConeValidatorImpl();
        assertTrue(validator.isRadiusValid(1.0));
    }

    @Test
    void shouldReturnFalseForInvalidRadius() {
        ConeValidator validator = new ConeValidatorImpl();
        assertFalse(validator.isRadiusValid(0.0));
        assertFalse(validator.isRadiusValid(-2.0));
    }

    @Test
    void shouldReturnTrueIfPointXNotEqualAndYAndZEqual() {
        ConeValidator validator = new ConeValidatorImpl();
        Point p1 = new Point(1.0, 2.0, 3.0);
        Point p2 = new Point(2.0, 2.0, 3.0);
        assertTrue(validator.isPointValid(p1, p2));
    }

    @Test
    void shouldReturnFalseIfAllCoordinatesEqual() {
        ConeValidator validator = new ConeValidatorImpl();
        Point p1 = new Point(1.0, 2.0, 3.0);
        Point p2 = new Point(1.0, 2.0, 3.0);
        assertFalse(validator.isPointValid(p1, p2));
    }

    @Test
    void shouldReturnFalseIfYCoordinatesDiffer() {
        ConeValidator validator = new ConeValidatorImpl();
        Point p1 = new Point(1.0, 2.0, 3.0);
        Point p2 = new Point(2.0, 5.0, 3.0);
        assertFalse(validator.isPointValid(p1, p2));
    }

    @Test
    void shouldReturnFalseIfZCoordinatesDiffer() {
        ConeValidator validator = new ConeValidatorImpl();
        Point p1 = new Point(1.0, 2.0, 3.0);
        Point p2 = new Point(2.0, 2.0, 7.0);
        assertFalse(validator.isPointValid(p1, p2));
    }
}

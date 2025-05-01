import com.esde.entity.Cone;
import com.esde.entity.Point;
import com.esde.specification.IdStartsWithSpecification;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IdStartsWithSpecificationTest {

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
}

import com.esde.shape.entity.Cone;
import com.esde.shape.entity.Point;
import com.esde.shape.repository.ConeRepository;
import com.esde.shape.repository.impl.ConeRepositoryImpl;
import com.esde.shape.specification.ConeSpecification;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConeRepositoryTest {

    @Test
    void shouldAddConeToRepository() {
        ConeRepository repo = new ConeRepositoryImpl();
        Cone cone = new Cone("c1", new Point(0, 0, 0), new Point(0, 0, 1), 1);
        repo.add(cone);

        List<Cone> all = repo.getAll();
        assertEquals(1, all.size());
        assertEquals(cone, all.getFirst());
    }

    @Test
    void shouldReturnCopyFromGetAll() {
        ConeRepository repo = new ConeRepositoryImpl();
        Cone cone = new Cone("c1", new Point(0, 0, 0), new Point(0, 0, 1), 1);
        repo.add(cone);

        List<Cone> first = repo.getAll();
        List<Cone> second = repo.getAll();

        first.clear(); // не должно повлиять на внутреннее состояние
        assertEquals(1, second.size());
    }

    @Test
    void shouldQueryBySpecification() {
        ConeRepository repo = new ConeRepositoryImpl();
        Cone small = new Cone("small", new Point(0, 0, 0), new Point(0, 0, 1), 1);
        Cone large = new Cone("large", new Point(0, 0, 0), new Point(0, 0, 1), 5);

        repo.add(small);
        repo.add(large);

        // Спецификация: радиус больше 2
        ConeSpecification radiusGreaterThan2 = cone -> cone.getRadius() > 2;

        List<Cone> result = repo.query(radiusGreaterThan2);
        assertEquals(1, result.size());
        assertEquals("large", result.getFirst().getId());
    }

    @Test
    void shouldSortByRadius() {
        ConeRepository repo = new ConeRepositoryImpl();
        Cone cone1 = new Cone("c1", new Point(0, 0, 0), new Point(0, 0, 1), 3);
        Cone cone2 = new Cone("c2", new Point(0, 0, 0), new Point(0, 0, 1), 1);
        Cone cone3 = new Cone("c3", new Point(0, 0, 0), new Point(0, 0, 1), 2);

        repo.add(cone1);
        repo.add(cone2);
        repo.add(cone3);

        List<Cone> sorted = repo.sortBy(Comparator.comparingDouble(Cone::getRadius));
        assertEquals(List.of(cone2, cone3, cone1), sorted);
    }
}
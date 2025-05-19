import com.esde.shape.coneReader.ConeReader;
import com.esde.shape.entity.Cone;
import com.esde.shape.parser.impl.ConeParserImpl;
import com.esde.shape.repository.ConeRepository;
import com.esde.shape.repository.impl.ConeRepositoryImpl;
import com.esde.shape.service.ConeService;
import com.esde.shape.service.impl.ConeServiceImpl;
import com.esde.shape.validator.impl.ConeValidatorImpl;
import com.esde.shape.warehouse.Warehouse;
import com.esde.shape.warehouse.impl.WarehouseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MyFileReaderTest {

    private ConeRepository repository;
    private Warehouse warehouse;
    private ConeService service;
    private ConeReader coneReader;

    @BeforeEach
    void setup() {
        repository = new ConeRepositoryImpl();
        warehouse = WarehouseImpl.getInstance();
        service = new ConeServiceImpl();
        coneReader = new ConeReader();
    }

    @Test
    void shouldReadAndParseValidConesFromFile() throws IOException {
        ConeValidatorImpl coneValidator = new ConeValidatorImpl();
        ConeParserImpl coneParser = new ConeParserImpl();
        List<Cone> list = coneReader.readValidCones("test.txt", coneValidator, coneParser);
        list.forEach(cone -> {
            repository.add(cone);
            double volume = service.calculateVolume(cone);
            double surface = service.calculateSurfaceArea(cone);
            warehouse.update(cone, volume, surface);
        });

        List<Cone> cones = repository.getAll();
        assertEquals(2, cones.size(), "Должно быть создано 2 валидных конуса");

        Cone first = cones.getFirst();
        assertEquals("cone1", first.getId());
        assertEquals(2.0, first.getRadius(), 0.001);

        Cone second = cones.get(1);
        assertEquals("cone2", second.getId());
        assertEquals(3.5, second.getRadius(), 0.001);

        assertNotNull(warehouse.getVolume("cone1"));
        assertNotNull(warehouse.getSurfaceArea("cone2"));
    }
}

import com.esde.shape.coneReader.ConeReader;
import com.esde.shape.entity.Cone;
import com.esde.shape.parser.ConeParser;
import com.esde.shape.parser.impl.ConeParserImpl;
import com.esde.shape.repository.ConeRepository;
import com.esde.shape.repository.impl.ConeRepositoryImpl;
import com.esde.shape.service.ConeService;
import com.esde.shape.service.impl.ConeServiceImpl;
import com.esde.shape.validator.ConeValidator;
import com.esde.shape.validator.impl.ConeValidatorImpl;
import com.esde.shape.warehouse.Warehouse;
import com.esde.shape.warehouse.impl.WarehouseImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectIntegrationTest {

    private ConeRepository repository;
    private Warehouse warehouse;
    private ConeService service;
    private ConeValidator coneValidator;
    private ConeParser parser;
    private ConeReader reader;

    @BeforeEach
    void setup() {
        repository = new ConeRepositoryImpl();
        warehouse = WarehouseImpl.getInstance();
        service = new ConeServiceImpl();
        coneValidator = new ConeValidatorImpl();
        parser = new ConeParserImpl();
        reader = new ConeReader();
    }

    @Test
    void shouldIntegrateAllLayersAndValidateProjectFlow() throws IOException {
        List<Cone> list = reader.readValidCones("test.txt", coneValidator, parser);
        list.forEach(cone -> {
            repository.add(cone);
            double volume = service.calculateVolume(cone);
            double surface = service.calculateSurfaceArea(cone);
            warehouse.update(cone, volume, surface);
        });

        List<Cone> cones = repository.getAll();
        assertEquals(2, cones.size(), "Ожидалось 2 валидных объекта конуса");

        Cone cone1 = cones.get(0);
        Cone cone2 = cones.get(1);

        assertEquals("cone1", cone1.getId());
        assertEquals("cone2", cone2.getId());

        assertNotNull(warehouse.getVolume("cone1"));
        assertNotNull(warehouse.getSurfaceArea("cone2"));
        assertTrue(warehouse.getVolume("cone1") > 0);
        assertTrue(warehouse.getSurfaceArea("cone2") > 0);
    }
}

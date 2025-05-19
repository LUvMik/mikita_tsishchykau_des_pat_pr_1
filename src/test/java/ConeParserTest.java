import com.esde.shape.entity.Cone;
import com.esde.shape.entity.Point;
import com.esde.shape.parser.ConeParser;
import com.esde.shape.parser.impl.ConeParserImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConeParserTest {

    @Test
    public void shouldParseCorrectLine() {
        String line = "cone1;0;0;0;0;0;5;2";
        ConeParser parser = new ConeParserImpl();
        Cone cone = parser.parse(line);
        assertEquals(cone.getId(), "cone1");
        assertEquals(cone.getRadius(), 2.0);
        assertEquals(cone.getApex(), new Point(0, 0, 5));
    }
}
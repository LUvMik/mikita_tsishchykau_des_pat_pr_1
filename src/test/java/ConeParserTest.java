import com.esde.entity.Cone;
import com.esde.entity.Point;
import com.esde.parser.ConeParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConeParserTest {

    @Test
    public void shouldParseCorrectLine() {
        String line = "cone1;0;0;0;0;0;5;2";
        Cone cone = ConeParser.parse(line);
        assertEquals(cone.getId(), "cone1");
        assertEquals(cone.getRadius(), 2.0);
        assertEquals(cone.getApex(), new Point(0, 0, 5));
    }
}
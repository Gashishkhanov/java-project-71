package hexlet.code;

import org.junit.jupiter.api.Test;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParserTest {

    private static final String FIXTURES_PATH = "src/test/resources/fixtures/";

    @Test
    void testParseJson() throws Exception {
        String filePath = FIXTURES_PATH + "file1.json";
        Map<String, Object> expected = Map.of(
                "host", "hexlet.io",
                "timeout", 50,
                "proxy", "123.234.53.22",
                "follow", false
        );

        Map<String, Object> actual = Parser.parse(filePath);
        assertEquals(expected, actual);
    }

    @Test
    void testParseYaml() throws Exception {
        String filePath = FIXTURES_PATH + "file1.yml";
        Map<String, Object> expected = Map.of(
                "host", "hexlet.io",
                "timeout", 50,
                "proxy", "123.234.53.22",
                "follow", false
        );

        Map<String, Object> actual = Parser.parse(filePath);
        assertEquals(expected, actual);
    }

    @Test
    void testParseInvalidFile() {
        String invalidFilePath = FIXTURES_PATH + "invalid.txt";
        Exception exception = assertThrows(Exception.class, () -> Parser.parse(invalidFilePath));
        String expectedMessage = "Ошибка";
        assertEquals(true, exception.getMessage().contains(expectedMessage));
    }
}
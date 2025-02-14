package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.nio.file.Files;
import java.nio.file.Paths;

class DifferTest {

    private static final String FIXTURES_PATH = "src/test/resources/fixtures/";

    @Test
    void testGenerateStylish() throws Exception {
        String file1 = FIXTURES_PATH + "file1.json";
        String file2 = FIXTURES_PATH + "file2.json";
        String expected = Files.readString(Paths.get(FIXTURES_PATH + "expected_stylish.txt"));

        assertEquals(expected.trim(), Differ.generate(file1, file2, "stylish").trim());
    }

    @Test
    void testGeneratePlain() throws Exception {
        String file1 = FIXTURES_PATH + "file1.json";
        String file2 = FIXTURES_PATH + "file2.json";
        String expected = Files.readString(Paths.get(FIXTURES_PATH + "expected_plain.txt"));

        assertEquals(expected.trim(), Differ.generate(file1, file2, "plain").trim());
    }

    @Test
    void testGenerateJson() throws Exception {
        String file1 = FIXTURES_PATH + "file1.json";
        String file2 = FIXTURES_PATH + "file2.json";
        String expected = Files.readString(Paths.get(FIXTURES_PATH + "expected_json.txt"));

        assertEquals(expected.trim(), Differ.generate(file1, file2, "json").trim());
    }

    @Test
    void testGenerateWithUnknownFormat() throws Exception {
        String file1 = FIXTURES_PATH + "file1.json";
        String file2 = FIXTURES_PATH + "file2.json";
        String expected = Files.readString(Paths.get(FIXTURES_PATH + "expected_stylish.txt")); // Должен применяться формат stylish

        assertEquals(expected.trim(), Differ.generate(file1, file2, "unknown").trim());
    }

    @Test
    void testGenerateWithNonExistingFile() {
        Exception exception = assertThrows(Exception.class, () -> Differ.generate("wrong1.json", "wrong2.json", "stylish"));
        String expectedMessage = "No such file";
        assertEquals(true, exception.getMessage().contains(expectedMessage));
    }
}
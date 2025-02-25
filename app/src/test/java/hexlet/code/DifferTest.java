package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.nio.file.Files;
import java.nio.file.Paths;

class DifferTest {
    private static final String FIXTURES_PATH = "src/test/resources/fixtures/";

    @Test
    void testGenerateStylishJson() throws Exception {
        String file1 = FIXTURES_PATH + "file1.json";
        String file2 = FIXTURES_PATH + "file2.json";
        String expected = Files.readString(Paths.get(FIXTURES_PATH + "expected_stylish.txt"));

        assertEquals(expected.trim(), Differ.generate(file1, file2, "stylish").trim());
    }

    @Test
    void testGenerateStylishYaml() throws Exception {
        String file1 = FIXTURES_PATH + "file1.yaml";
        String file2 = FIXTURES_PATH + "file2.yaml";
        String expected = Files.readString(Paths.get(FIXTURES_PATH + "expected_stylish.txt"));

        assertEquals(expected.trim(), Differ.generate(file1, file2, "stylish").trim());
    }

    @Test
    void testGeneratePlainJson() throws Exception {
        String file1 = FIXTURES_PATH + "file1.json";
        String file2 = FIXTURES_PATH + "file2.json";
        String expected = Files.readString(Paths.get(FIXTURES_PATH + "expected_plain.txt"));

        assertEquals(expected.trim(), Differ.generate(file1, file2, "plain").trim());
    }

    @Test
    void testGeneratePlainYaml() throws Exception {
        String file1 = FIXTURES_PATH + "file1.yaml";
        String file2 = FIXTURES_PATH + "file2.yaml";
        String expected = Files.readString(Paths.get(FIXTURES_PATH + "expected_plain.txt"));

        assertEquals(expected.trim(), Differ.generate(file1, file2, "plain").trim());
    }

    @Test
    void testGenerateJsonFormatJson() throws Exception {
        String file1 = FIXTURES_PATH + "file1.json";
        String file2 = FIXTURES_PATH + "file2.json";
        String expected = Files.readString(Paths.get(FIXTURES_PATH + "expected_json.txt"));

        assertEquals(expected.trim(), Differ.generate(file1, file2, "json").trim());
    }

    @Test
    void testGenerateJsonFormatYaml() throws Exception {
        String file1 = FIXTURES_PATH + "file1.yaml";
        String file2 = FIXTURES_PATH + "file2.yaml";
        String expected = Files.readString(Paths.get(FIXTURES_PATH + "expected_json.txt"));

        assertEquals(expected.trim(), Differ.generate(file1, file2, "json").trim());
    }

    @Test
    void testGenerateDefaultFormatJson() throws Exception {
        String file1 = FIXTURES_PATH + "file1.json";
        String file2 = FIXTURES_PATH + "file2.json";
        String expected = Files.readString(Paths.get(FIXTURES_PATH + "expected_stylish.txt"));

        assertEquals(expected.trim(), Differ.generate(file1, file2).trim());
    }

    @Test
    void testGenerateDefaultFormatYaml() throws Exception {
        String file1 = FIXTURES_PATH + "file1.yaml";
        String file2 = FIXTURES_PATH + "file2.yaml";
        String expected = Files.readString(Paths.get(FIXTURES_PATH + "expected_stylish.txt"));

        assertEquals(expected.trim(), Differ.generate(file1, file2).trim());
    }
}
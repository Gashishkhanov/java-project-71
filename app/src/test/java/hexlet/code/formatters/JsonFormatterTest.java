package hexlet.code.formatters;

import hexlet.code.DifferEntry;
import org.junit.jupiter.api.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import static hexlet.code.DifferEntry.Status.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class JsonFormatterTest {

    @Test
    void testFormat() throws Exception {
        List<DifferEntry> diff = List.of(
                new DifferEntry("host", "hexlet.io", "hexlet.com", CHANGED),
                new DifferEntry("timeout", null, 50, REMOVED),
                new DifferEntry("proxy", "123.234.53.22", null, ADDED),
                new DifferEntry("follow", false, false, UNCHANGED)
        );

        String expected = """
                [{"key":"host","newValue":"hexlet.io","oldValue":"hexlet.com","status":"CHANGED"},
                 {"key":"timeout","newValue":null,"oldValue":50,"status":"REMOVED"},
                 {"key":"proxy","newValue":"123.234.53.22","oldValue":null,"status":"ADDED"},
                 {"key":"follow","newValue":false,"oldValue":false,"status":"UNCHANGED"}]""".replaceAll("\\s", "");

        String actual = new JsonFormatter().format(diff).replaceAll("\\s", "");

        assertEquals(expected, actual);
    }
}
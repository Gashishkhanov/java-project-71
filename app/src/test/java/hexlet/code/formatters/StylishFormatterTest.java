package hexlet.code.formatters;

import hexlet.code.DifferEntry;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hexlet.code.DifferEntry.Status.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StylishFormatterTest {

    @Test
    void testFormat() {
        List<DifferEntry> diff = List.of(
                new DifferEntry("host", "hexlet.io", "hexlet.com", CHANGED),
                new DifferEntry("timeout", 50, null, REMOVED),
                new DifferEntry("proxy", "123.234.53.22", null, ADDED),
                new DifferEntry("follow", false, false, UNCHANGED)
        );

        String expected = """
                {
                  - host: hexlet.com
                  + host: hexlet.io
                  - timeout: 50
                  + proxy: 123.234.53.22
                    follow: false
                }""";

        String actual = new StylishFormatter().format(diff);
        assertEquals(expected, actual);
    }
}
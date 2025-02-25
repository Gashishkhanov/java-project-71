package hexlet.code.formatters;

import hexlet.code.DifferEntry;
import org.junit.jupiter.api.Test;

import java.util.List;

import static hexlet.code.DifferEntry.Status.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PlainFormatterTest {

    @Test
    void testFormat() {
        List<DifferEntry> diff = List.of(
                new DifferEntry("host", "hexlet.io", "hexlet.com", CHANGED),
                new DifferEntry("timeout", null, 50, REMOVED),
                new DifferEntry("proxy", "123.234.53.22", null, ADDED),
                new DifferEntry("follow", false, false, UNCHANGED)
        );

        String expected = """
                Property 'host' was updated. From 'hexlet.com' to 'hexlet.io'
                Property 'timeout' was removed
                Property 'proxy' was added with value: '123.234.53.22'""";

        String actual = new PlainFormatter().format(diff);
        assertEquals(expected, actual);
    }
}
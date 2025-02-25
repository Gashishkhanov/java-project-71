package hexlet.code.formatters;

import java.util.List;
import hexlet.code.DifferEntry;

public interface Formatter {
    String format(List<DifferEntry> diff);
}
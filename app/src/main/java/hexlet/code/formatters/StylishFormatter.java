package hexlet.code.formatters;

import hexlet.code.DifferEntry;
import java.util.List;

public class StylishFormatter {
    public static String format(List<DifferEntry> diff) {
        StringBuilder result = new StringBuilder("{\n");

        for (DifferEntry entry : diff) {
            switch (entry.status()) {
                case REMOVED -> result.append("  - ").append(entry.key()).append(": ")
                        .append(entry.oldValue()).append("\n");
                case ADDED -> result.append("  + ").append(entry.key()).append(": ")
                        .append(entry.newValue()).append("\n");
                case CHANGED -> {
                    result.append("  - ").append(entry.key()).append(": ")
                            .append(entry.oldValue()).append("\n");
                    result.append("  + ").append(entry.key()).append(": ")
                            .append(entry.newValue()).append("\n");
                }
                case UNCHANGED -> result.append("    ").append(entry.key()).append(": ")
                        .append(entry.oldValue()).append("\n");
            }
        }

        result.append("}");
        return result.toString();
    }
}

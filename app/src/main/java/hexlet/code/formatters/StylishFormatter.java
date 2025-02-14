package hexlet.code.formatters;

import hexlet.code.DifferEntry;
import java.util.List;

public class StylishFormatter implements Formatter {

    @Override
    public String format(List<DifferEntry> diff) {
        StringBuilder result = new StringBuilder("{\n");

        for (DifferEntry entry : diff) {
            String key = entry.key();
            Object newValue = entry.newValue();
            Object oldValue = entry.oldValue();

            switch (entry.status()) {
                case ADDED -> result.append("  + ").append(key).append(": ").append(newValue).append("\n");
                case REMOVED -> result.append("  - ").append(key).append(": ").append(oldValue).append("\n");
                case CHANGED -> {
                    result.append("  - ").append(key).append(": ").append(oldValue).append("\n");
                    result.append("  + ").append(key).append(": ").append(newValue).append("\n");
                }
                case UNCHANGED -> result.append("    ").append(key).append(": ").append(newValue).append("\n");
            }
        }

        result.append("}");
        return result.toString();
    }
}

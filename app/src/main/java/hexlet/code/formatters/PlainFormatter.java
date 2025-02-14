package hexlet.code.formatters;

import hexlet.code.DifferEntry;
import java.util.List;

public class PlainFormatter implements Formatter {

    @Override
    public String format(List<DifferEntry> diff) {
        StringBuilder result = new StringBuilder();

        for (DifferEntry entry : diff) {
            String key = entry.key();
            Object newValue = formatValue(entry.newValue());
            Object oldValue = formatValue(entry.oldValue());

            switch (entry.status()) {
                case ADDED -> result.append("Property '").append(key)
                        .append("' was added with value: ").append(newValue).append("\n");
                case REMOVED -> result.append("Property '").append(key)
                        .append("' was removed\n");
                case CHANGED -> result.append("Property '").append(key)
                        .append("' was updated. From ").append(oldValue)
                        .append(" to ").append(newValue).append("\n");
                default -> { }
            }
        }

        return result.toString().trim();
    }

    private String formatValue(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        } else if (value instanceof List || value instanceof java.util.Map) {
            return "[complex value]";
        }
        return String.valueOf(value);
    }
}
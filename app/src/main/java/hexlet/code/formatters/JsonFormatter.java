package hexlet.code.formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.DifferEntry;
import java.util.List;

public class JsonFormatter implements Formatter {

    @Override
    public String format(List<DifferEntry> diff) {
        try {
            return new ObjectMapper().writeValueAsString(diff);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при форматировании в JSON", e);
        }
    }
}
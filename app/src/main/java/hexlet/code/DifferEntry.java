package hexlet.code;

import lombok.Getter;

@Getter
public record DifferEntry(String key, Object oldValue, Object newValue, hexlet.code.DifferEntry.Status status) {
    public enum Status {
        ADDED, REMOVED, CHANGED, UNCHANGED
    }
}
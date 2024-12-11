package oncall.model;

import java.util.Objects;

public class WorkerName {
    private static final int MAX_NAME_LENGTH = 5;
    String name;

    public static WorkerName valueOf(String name) {
        validate(name);
        return new WorkerName(name);
    }

    private static void validate(String name) {
        if(!(!name.isEmpty() && name.length() <= MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException();
        }
    }

    private WorkerName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerName p = (WorkerName) o;
        return Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

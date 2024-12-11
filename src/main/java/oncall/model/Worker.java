package oncall.model;

import java.util.Objects;

public class Worker {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public static Worker valueOf(String name) {
        validate(name);
        return new Worker(name);
    }

    private static void validate(String name) {
        if(!(!name.isEmpty() && name.length() <= MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException();
        }
    }

    private Worker(String name) {
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
        Worker p = (Worker) o;
        return Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

package oncall.domain;

public class WorkerName {
    private static final int MAX_NAME_LENGTH = 6;
    String name;

    public static WorkerName valueOf(String name) {
        validate(name);
        return new WorkerName(name);
    }

    private static void validate(String name) {
        if(!(!name.isEmpty() && name.length() < MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException();
        }
    }

    private WorkerName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

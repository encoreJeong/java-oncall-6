package oncall.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkerSequence {

    private static final int MIN_WORKER_SIZE = 5;
    private static final int MAX_WORKER_SIZE = 35;

    private List<WorkerName> sequence;

    public static WorkerSequence from(ArrayList<String> names) {
        validate(names);
        ArrayList<WorkerName> sequence = new ArrayList<>(names.stream().map(WorkerName::valueOf).toList());
        return new WorkerSequence(sequence);
    }

    private WorkerSequence(ArrayList<WorkerName> sequence) {
        this.sequence = sequence;
    }

    public static void validate(ArrayList<String> sequence) {
        if(isSizeImpossible(sequence) || isDuplicated(sequence)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isSizeImpossible(ArrayList<String> sequence) {
        return !(sequence.size() >= MIN_WORKER_SIZE && sequence.size() <= MAX_WORKER_SIZE);
    }

    private static boolean isDuplicated(ArrayList<String> sequence) {
        Set<String> validateSet = new HashSet<>(sequence);
        return !(validateSet.size() == sequence.size());
    }

    public void changeSequence(WorkerName worker) {
        WorkerName nextWorker = sequence.get((sequence.indexOf(worker) + 1) % sequence.size());
        sequence.set(sequence.indexOf(worker) + 1, worker);
        sequence.set(sequence.indexOf(worker), nextWorker);
    }

    @Override
    public String toString() {
        List<String> workerNames = sequence.stream().map(WorkerName::getName).toList();
        return workerNames.toString();
    }
}

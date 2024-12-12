package oncall.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkerSequence {

    private static final int MIN_WORKER_SIZE = 5;
    private static final int MAX_WORKER_SIZE = 35;

    private List<Worker> sequence;

    public static WorkerSequence fromParams(String[] params) {
        ArrayList<String> names = new ArrayList<>(List.of(params));
        validate(names);
        ArrayList<Worker> sequence = new ArrayList<>(names.stream().map(Worker::valueOf).toList());
        return new WorkerSequence(sequence);
    }

    private WorkerSequence(ArrayList<Worker> sequence) {
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

    public Worker getNextWorker(Worker prevWorker, int currenSeqIdx) {
        Worker nextWorker = sequence.get((currenSeqIdx + 1) % sequence.size());

        if(prevWorker.equals(nextWorker)) {
            changeSequence(nextWorker);
            nextWorker = sequence.get((currenSeqIdx + 1) % sequence.size());
        }
        return nextWorker;
    }

    private void changeSequence(Worker worker) {
        Worker nextWorker = sequence.get((sequence.indexOf(worker) + 1) % sequence.size());
        sequence.set(sequence.indexOf(worker) + 1, worker);
        sequence.set(sequence.indexOf(worker), nextWorker);
    }

    @Override
    public String toString() {
        List<String> workerNames = sequence.stream().map(Worker::toString).toList();
        return workerNames.toString();
    }
}

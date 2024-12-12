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
        isSizeImpossible(sequence);
        isDuplicated(sequence);
    }

    private static void isSizeImpossible(ArrayList<String> sequence) {
        if (!(sequence.size() >= MIN_WORKER_SIZE && sequence.size() <= MAX_WORKER_SIZE)) {
            throw new IllegalArgumentException("비상 근무자는 5명 이상, 35명 이하여야 합니다.");
        }
    }

    private static void isDuplicated(ArrayList<String> sequence) {
        Set<String> validateSet = new HashSet<>(sequence);
        if(!(validateSet.size() == sequence.size())) {
            throw new IllegalArgumentException("비상 근무자는 평일 순번, 휴일 순번에 각각 1회 편성되어야 합니다.");
        }
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
        sequence.set((sequence.indexOf(worker) + 1) % sequence.size(), worker);
        sequence.set(sequence.indexOf(worker), nextWorker);
    }

    @Override
    public String toString() {
        List<String> workerNames = sequence.stream().map(Worker::toString).toList();
        return workerNames.toString();
    }
}

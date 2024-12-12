package oncall.controller;

import oncall.global.ExceptionHandler;
import oncall.global.util.InputHandler;
import oncall.model.AssignStartDate;
import oncall.model.Assigner;
import oncall.model.WorkerSequence;

import java.util.List;

public class AssignController {

    private final InputHandler inputHandler;

    public AssignController(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }

    public void process() {

        AssignStartDate startDate = inputHandler.getSingleObject(AssignStartDate.class);

        List<WorkerSequence> totalSequences = inputHandler.getMultipleObjects(WorkerSequence.class);

        ExceptionHandler.debug(() -> assign(totalSequences, startDate));
    }

    private void assign(List<WorkerSequence> totalSequences, AssignStartDate startDate) {
        Assigner assigner = new Assigner(totalSequences.get(0), totalSequences.get(1), startDate);
        assigner.assign();
    }
}

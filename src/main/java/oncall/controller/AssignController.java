package oncall.controller;

import oncall.global.ExceptionHandler;
import oncall.global.util.InputHandler;
import oncall.model.Assigner;
import oncall.model.AssignStartDate;
import oncall.model.WorkerSequence;

import java.util.List;

public class AssignController {

    private static AssignController singleToneAssignController;

    public static AssignController getInstance() {
        if(singleToneAssignController == null) {
            singleToneAssignController = new AssignController();
        }
        return singleToneAssignController;
    }

    public void process() {

        AssignStartDate startDate = InputHandler.getStartDate();

        List<WorkerSequence> totalSequences = InputHandler.getTotalSequence();

        ExceptionHandler.handle(() -> assign(totalSequences, startDate));
    }

    private void assign(List<WorkerSequence> totalSequences, AssignStartDate startDate) {
        Assigner assigner = new Assigner(totalSequences.get(0), totalSequences.get(1), startDate);
        assigner.assign();
    }
}

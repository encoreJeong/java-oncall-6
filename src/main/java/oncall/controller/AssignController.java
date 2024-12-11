package oncall.controller;

import oncall.model.Assigner;
import oncall.model.AssignStartDate;
import oncall.model.WorkerSequence;
import oncall.util.InputUtils;
import oncall.view.InputView;
import oncall.view.OutputView;

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

        AssignStartDate startDate = InputUtils.getWithRetry(this::promptAssignStartdate);

        List<WorkerSequence> totalSequences = InputUtils.getWithRetry(this::promptWeekdaySequence, this::promptHolidaySequence);

        assign(totalSequences, startDate);
    }

    private void assign(List<WorkerSequence> totalSequences, AssignStartDate startDate) {
        Assigner assigner = new Assigner(totalSequences.get(0), totalSequences.get(1), startDate);
        try{
            assigner.assign();
        } catch (Exception e) {
            OutputView.printString(e.getMessage());
        }
    }

    private AssignStartDate promptAssignStartdate() {
        return InputView.promptAssignStartDate();
    }

    private WorkerSequence promptWeekdaySequence() {
        return InputView.promptWeekdaySequence();
    }

    private WorkerSequence promptHolidaySequence() {
        return InputView.promptHolidaySequence();
    }
}

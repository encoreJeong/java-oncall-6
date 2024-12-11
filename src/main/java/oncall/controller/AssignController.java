package oncall.controller;

import oncall.model.Assigner;
import oncall.model.EmergencyDate;
import oncall.model.WorkerSequence;
import oncall.util.InputUtils;
import oncall.view.InputView;
import oncall.view.OutputView;

import java.util.List;

public class AssignController {

    public void process() {

        EmergencyDate startDate = InputUtils.getWithRetry(this::getAssignStartdate);

        List<WorkerSequence> workerSequences = InputUtils.getWithRetry(this::getWeekdaySequence, this::getHolidaySequence);

        assign(workerSequences, startDate);
    }

    private void assign(List<WorkerSequence> workerSequences, EmergencyDate startDate) {
        Assigner assigner = new Assigner(workerSequences.get(0), workerSequences.get(1), startDate);
        try{
            assigner.assign();
        } catch (Exception e) {
            OutputView.printString(e.getMessage());
        }
    }

    private EmergencyDate getAssignStartdate() {
        return InputView.readAssignStartDate();
    }

    private WorkerSequence getWeekdaySequence() {
        return InputView.readWeekdaySequence();
    }

    private WorkerSequence getHolidaySequence() {
        return InputView.readHolidaySequence();
    }
}

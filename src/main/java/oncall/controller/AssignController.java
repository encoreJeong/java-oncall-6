package oncall.controller;

import oncall.model.Assigner;
import oncall.model.EmergencyDate;
import oncall.model.WorkerSequence;
import oncall.util.Message.Error;
import oncall.view.InputView;
import oncall.view.OutputView;

public class AssignController {

    public void assign() {
        //비상 근무 배정 시작일 입력
        EmergencyDate startDate = null;
        while(true) {
            try {
                startDate = getAssignStartdate();
                break;
            } catch (Exception e) {
                OutputView.printMessage(oncall.util.Message.Error.INPUT_ERROR);
            }
        }

        //평일 순번, 휴일 순번 입력
        WorkerSequence weekdaySequence = null;
        WorkerSequence holidaySequence = null;
        while (true) {
            try {
                weekdaySequence = getWeekdaySequence();
                holidaySequence = getHolidaySequence();
                break;
            } catch (Exception e) {
                OutputView.printMessage(Error.INPUT_ERROR);
            }
        }

        Assigner assigner = new Assigner(weekdaySequence, holidaySequence, startDate);
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

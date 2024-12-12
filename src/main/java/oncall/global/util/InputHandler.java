package oncall.global.util;

import oncall.model.AssignStartDate;
import oncall.model.WorkerSequence;
import oncall.view.InputView;

import java.util.List;

public class InputHandler {

    public static AssignStartDate getStartDate() {
        return InputUtils.getWithRetry(InputView::promptAssignStartDate);
    }

    public static List<WorkerSequence> getTotalSequence() {
        return InputUtils.getWithRetry(InputView::promptWeekdaySequence, InputView::promptHolidaySequence);
    }

}

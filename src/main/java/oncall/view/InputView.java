package oncall.view;
import camp.nextstep.edu.missionutils.Console;
import oncall.model.AssignStartDate;
import oncall.model.WorkerSequence;
import oncall.util.InputUtils;

import java.util.ArrayList;
import java.util.Arrays;

import static oncall.Message.InputHint.*;

public class InputView {

    private static final String DELIMETER = ",";

    public static AssignStartDate promptAssignStartDate() {
        OutputView.printMessage(EMERGENCY_WORK_START_DATE);

        String input = readString();
        String[] params = InputUtils.splitByDelimeter(input, DELIMETER);

        return AssignStartDate.of(params);
    }

    public static WorkerSequence promptWeekdaySequence() {
        OutputView.printMessage(EMERGENCY_WORK_WEEKDAY);

        String input = readString();
        String[] params = InputUtils.splitByDelimeter(input, DELIMETER);

        return WorkerSequence.from(params);
    }

    public static WorkerSequence promptHolidaySequence() {
        OutputView.printMessage(EMERGENCY_WORK_HOLIDAY);

        String input = readString();
        String[] params = InputUtils.splitByDelimeter(input, DELIMETER);

        return WorkerSequence.from(params);
    }

    private static String readString() {
        return Console.readLine();
    }

}

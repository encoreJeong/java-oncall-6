package oncall.view;
import camp.nextstep.edu.missionutils.Console;
import oncall.model.AssignStartDate;
import oncall.model.WorkerSequence;

import java.util.ArrayList;
import java.util.Arrays;

import static oncall.Message.InputHint.*;

public class InputView {

    public static AssignStartDate promptAssignStartDate() {
        OutputView.printMessage(EMERGENCY_WORK_START_DATE);

        String input = readString();
        String[] params =input.split(",");
        for(int i = 0; i < params.length; i++) {
            params[i] = params[i].trim();
        }

        return AssignStartDate.of(params);
    }

    public static WorkerSequence promptWeekdaySequence() {
        OutputView.printMessage(EMERGENCY_WORK_WEEKDAY);

        String input = readString();
        String[] params =input.split(",");
        for(int i = 0; i < params.length; i++) {
            params[i] = params[i].trim();
        }

        return WorkerSequence.from(new ArrayList<>(Arrays.asList(params)));
    }

    public static WorkerSequence promptHolidaySequence() {
        OutputView.printMessage(EMERGENCY_WORK_HOLIDAY);

        String input = readString();
        String[] params =input.split(",");
        for(int i = 0; i < params.length; i++) {
            params[i] = params[i].trim();
        }

        return WorkerSequence.from(new ArrayList<>(Arrays.asList(params)));
    }

    private static String readString() {
        return Console.readLine();
    }

}

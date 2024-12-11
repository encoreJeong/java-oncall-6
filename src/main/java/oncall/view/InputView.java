package oncall.view;
import camp.nextstep.edu.missionutils.Console;
import oncall.model.EmergencyDate;
import oncall.model.WorkerSequence;

import java.util.ArrayList;
import java.util.Arrays;

import static oncall.util.Message.InputHint.*;

public class InputView {

    public static EmergencyDate readAssignStartDate() {
        OutputView.printMessage(EMERGENCY_WORK_START_DATE);

        String input = readString();
        String[] params =input.split(",");
        for(int i = 0; i < params.length; i++) {
            params[i] = params[i].trim();
        }

        return EmergencyDate.of(params);
    }

    public static WorkerSequence readWeekdaySequence() {
        OutputView.printMessage(EMERGENCY_WORK_WEEKDAY);

        String input = readString();
        String[] params =input.split(",");
        for(int i = 0; i < params.length; i++) {
            params[i] = params[i].trim();
        }

        return WorkerSequence.from(new ArrayList<>(Arrays.asList(params)));
    }

    public static WorkerSequence readHolidaySequence() {
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

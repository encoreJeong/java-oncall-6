package oncall.util;
import camp.nextstep.edu.missionutils.Console;
import oncall.domain.EmergencyDate;

import static oncall.Message.InputHint.EMERGENCY_WORK_START_DATE;

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


    private static String readString() {
        return Console.readLine();
    }

}

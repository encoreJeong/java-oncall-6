package oncall.view;
import camp.nextstep.edu.missionutils.Console;
import oncall.Message.SystemMessage;
import oncall.global.util.InputUtils;

public class InputView {

    private static final String DELIMETER = ",";

    public static String[] prompt(SystemMessage promptMessage) {
        OutputView.printMessage(promptMessage);

        String input = readString();

        return InputUtils.splitByDelimeter(input, DELIMETER);
    }

    private static String readString() {
        return Console.readLine();
    }

}

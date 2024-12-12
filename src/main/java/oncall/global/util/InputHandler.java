package oncall.global.util;

import oncall.Message.InputHint;
import oncall.Message.SystemMessage;
import oncall.view.InputView;

import java.util.List;

public class InputHandler {

    public <T> T getSingleObject(Class<T> clazz) {
        return InputUtils.getWithRetry(
                () -> InputParser.parse(
                        clazz,
                        promptParams(InputHint.EMERGENCY_WORK_START_DATE)
                )
        );
    }

    public <T> List<T> getMultipleObjects(Class<T> clazz) {
        return InputUtils.getWithRetry(
                () -> InputParser.parse(
                        clazz,
                        promptParams(InputHint.EMERGENCY_WORK_WEEKDAY)
                ),
                () -> InputParser.parse(
                        clazz,
                        promptParams(InputHint.EMERGENCY_WORK_HOLIDAY)
                )
        );
    }

    private String[] promptParams(SystemMessage systemMessage) {
        return InputView.prompt(systemMessage);
    }

}

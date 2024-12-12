package oncall.global.util;

import oncall.Message.InputHint;
import oncall.Message.SystemMessage;
import oncall.view.InputView;

import java.util.List;

public class InputHandler {

    public <T> T getSingleObject(Class<T> clazz) {
        return InputUtils.getWithRetry(
                () -> Parser.parse(
                        clazz,
                        getParams(InputHint.EMERGENCY_WORK_START_DATE)
                )
        );
    }

    public <T> List<T> getMultipleObjects(Class<T> clazz) {
        return InputUtils.getWithRetry(
                () -> Parser.parse(
                        clazz,
                        getParams(InputHint.EMERGENCY_WORK_WEEKDAY)
                ),
                () -> Parser.parse(
                        clazz,
                        getParams(InputHint.EMERGENCY_WORK_HOLIDAY)
                )
        );
    }

    private String[] getParams(SystemMessage systemMessage) {
        return InputView.prompt(systemMessage);
    }

}

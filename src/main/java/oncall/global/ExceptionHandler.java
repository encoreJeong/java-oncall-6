package oncall.global;

import oncall.Message.Error;
import oncall.view.OutputView;

public class ExceptionHandler {
    public static void handle(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            OutputView.printMessage(Error.INPUT_ERROR);
        }
    }
}

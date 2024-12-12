package oncall.global;
import oncall.view.OutputView;

public class ExceptionHandler {
    public static void handle(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            OutputView.printError(e);
        }
    }
}

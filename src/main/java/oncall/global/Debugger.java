package oncall.global;
import oncall.view.OutputView;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Debugger {
    public static void debug(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {
            OutputView.printError(e);

            String stackTrace = Arrays.stream(e.getStackTrace())
                    .map(StackTraceElement::toString)
                    .collect(Collectors.joining("\n"));

            OutputView.printString("\nStack Trace:\n" + stackTrace);
        }
    }
}

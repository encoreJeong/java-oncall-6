package oncall.global.util;

import oncall.global.exception.InputParsingException;
import oncall.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class InputUtils {

    public static <T> T getWithRetry(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (InputParsingException e) {
                OutputView.printError(e);
            }
        }
    }

    public static <T> List<T> getWithRetry(Supplier<T>... inputSuppliers) {
        List<T> result = new ArrayList<>();

        while (true) {
            try {
                for(Supplier<T> inputSupplier : inputSuppliers) {
                    result.add(inputSupplier.get());
                }
                break;
            } catch (InputParsingException e) {
                OutputView.printError(e);
            }
        }

        return result;
    }

    public static String[] splitByDelimeter(String input, String delimeter) {
        String[] params =input.split(delimeter);
        for(int i = 0; i < params.length; i++) {
            params[i] = params[i].trim();
        }
        return params;
    }

}

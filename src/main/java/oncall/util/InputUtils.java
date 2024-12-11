package oncall.util;

import oncall.util.Message.Error;
import oncall.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class InputUtils {

    public static <T> T getWithRetry(Supplier<T> inputSupplier) {
        while (true) {
            try {
                return inputSupplier.get();
            } catch (Exception e) {
                OutputView.printMessage(Error.INPUT_ERROR);
            }
        }
    }

    public static <T> List<T> getWithRetry(Supplier<T>... inputSupppliers) {
        List<T> result = new ArrayList<>();

        while (true) {
            try {
                for(Supplier<T> supplier : inputSupppliers) {
                    result.add(supplier.get());
                }
                break;
            } catch (Exception e) {
                OutputView.printMessage(Error.INPUT_ERROR);
            }
        }

        return result;
    }

}
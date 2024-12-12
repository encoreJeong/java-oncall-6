package oncall.global.util;

import oncall.view.OutputView;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Parser {
    public static <T> T parse(Class<T> clazz, String[] params) throws IllegalArgumentException {

        try{
            Method method = clazz.getMethod("fromParams", String[].class);
            return clazz.cast(method.invoke(null, (Object) params));

        } catch (NoSuchMethodException | IllegalAccessException e) {
            OutputView.printError(e);
            System.exit(1);
        } catch (InvocationTargetException e) {
            throw new IllegalArgumentException(e.getMessage());
        }

        throw new RuntimeException("[ERROR] 알수없는 오류가 발생했습니다.\n");
    }
}

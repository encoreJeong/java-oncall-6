package oncall.global.util;

import oncall.global.exception.InputParsingException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static oncall.Message.InputParsingError.*;

public class InputParser {
    public static <T> T parse(Class<T> clazz, String[] params) throws InputParsingException {

        try{
            Method method = clazz.getMethod("fromParams", String[].class);
            return clazz.cast(method.invoke(null, (Object) params));

        } catch (InvocationTargetException e) {
            throw new InputParsingException(PARSING_FAILED.getMessage() + e.getCause().getMessage());

        } catch (NoSuchMethodException e) {
            throw new InputParsingException(FACTORY_NOT_EXIST.getMessage());

        } catch (IllegalAccessException e) {
            throw new InputParsingException(FACTORY_NOT_PUBLIC.getMessage());

        }

    }
}

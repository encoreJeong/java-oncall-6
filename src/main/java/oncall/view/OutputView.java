package oncall.view;

import oncall.Message.SystemMessage;

public class OutputView {

    public static void printMessage(SystemMessage systemMessage) {
        System.out.print(systemMessage.getMessage());
    }

    public static void printError(Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
    }

    public static void printString(String string) {
        System.out.print(string);
    }
}

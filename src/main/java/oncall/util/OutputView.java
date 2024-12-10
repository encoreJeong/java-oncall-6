package oncall.util;

import oncall.Message.SystemMessage;

public class OutputView {

    public static  void printMessage(SystemMessage systemMessage) {
        System.out.print(systemMessage.getMessage());
    }
}

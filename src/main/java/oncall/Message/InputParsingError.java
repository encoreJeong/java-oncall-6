package oncall.Message;

public enum InputParsingError implements SystemMessage {
    FACTORY_NOT_EXIST("fromParams 메서드가 구현되어있지 않아 파싱이 불가합니다."),
    FACTORY_NOT_PUBLIC("fromParams 메서드는 퍼블릭이어야 합니다."),
    PARSING_FAILED("유효하지 않은 입력입니다. ");

    String message;

    InputParsingError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

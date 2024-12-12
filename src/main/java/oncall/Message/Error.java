package oncall.Message;

public enum Error implements SystemMessage {
    FACTORY_NOT_EXIST("[ERROR] fromParams 메서드가 구현돼있지 않은 클래스가 존재합니다."),
    FACTORY_NOT_PUBLIC("[ERROR] fromParams 메서드는 퍼블릭이어야 합니다."),
    PARSE_FAILED("[ERROR] 주어진 파라미터로 파싱이 불가합니다.");

    String message;

    Error(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

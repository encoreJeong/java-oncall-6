package oncall.Message;

public enum Error implements SystemMessage {
    INPUT_ERROR("[ERROR] 유효하지 않은 입력 값입니다. 다시 입력해 주세요.\n");

    String message;

    Error(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

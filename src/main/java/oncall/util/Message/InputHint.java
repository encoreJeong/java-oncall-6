package oncall.util.Message;

public enum InputHint implements SystemMessage{
    EMERGENCY_WORK_START_DATE("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
    EMERGENCY_WORK_WEEKDAY("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    EMERGENCY_WORK_HOLIDAY("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ");

    public String message;

    InputHint(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

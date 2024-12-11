package oncall.model.type;

public enum KoreanDayOfWeek {
    월(1),
    화(2),
    수(3),
    목(4),
    금(5),
    토(6),
    일(7);

    private int intValue;

    KoreanDayOfWeek(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }
}

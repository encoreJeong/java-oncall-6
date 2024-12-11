package oncall.model;

import java.time.DayOfWeek;
import java.time.Month;

public class EmergencyDate {
    private Month month;
    private DayOfWeek dayOfWeek;

    public static EmergencyDate of(String[] params) {

        Month startMonth = Month.of(Integer.parseInt(params[0]));
        DayOfWeek dayOfWeek = DayOfWeek.of(KoreanDay.valueOf(params[1]).getIntValue());

        return new EmergencyDate(startMonth, dayOfWeek);
    }

    private EmergencyDate(Month month, DayOfWeek dayOfWeek) {
        this.month = month;
        this.dayOfWeek = dayOfWeek;
    }

    public Month getMonth() {
        return month;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public int endDateOfTheMonth() {
        return month.minLength();
    }
}

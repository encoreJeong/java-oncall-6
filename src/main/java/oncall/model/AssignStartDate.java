package oncall.model;

import oncall.model.type.KoreanDayOfWeek;

import java.time.DayOfWeek;
import java.time.Month;

public class AssignStartDate {
    private Month month;
    private DayOfWeek dayOfWeek;

    public static AssignStartDate of(String[] params) {

        Month startMonth = Month.of(Integer.parseInt(params[0]));
        DayOfWeek dayOfWeek = DayOfWeek.of(KoreanDayOfWeek.valueOf(params[1]).getIntValue());

        return new AssignStartDate(startMonth, dayOfWeek);
    }

    private AssignStartDate(Month month, DayOfWeek dayOfWeek) {
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

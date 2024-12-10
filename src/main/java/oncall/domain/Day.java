package oncall.domain;

import java.time.Month;
import java.util.Objects;
import java.util.Set;

public class Day {
    private final Month month;
    private final int date;

    private final static Set<Day> holiday = Set.of(
            Day.of(1,1),
            Day.of(3,1),
            Day.of(5,5),
            Day.of(6,6),
            Day.of(8,15),
            Day.of(10,3),
            Day.of(10,9),
            Day.of(12,25)
    );

    public static Day of(int month, int date) {
        return new Day(Month.of(month), date);
    }

    private Day(Month month, int date) {
        this.month = month;
        this.date = date;
    }

    public static boolean isHoliday(Month month, int date) {
        return holiday.contains(new Day(month, date));
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, date);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day p = (Day) o;
        return Objects.equals(month, p.month) && Objects.equals(date, p.date);
    }
}

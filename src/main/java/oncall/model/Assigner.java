package oncall.model;

import oncall.model.type.KoreanDayOfWeek;
import oncall.view.OutputView;

import java.time.DayOfWeek;
import java.time.Month;

public class Assigner {
    private WorkerSequence weekdaySequence;
    private WorkerSequence holidaySequence;
    private final AssignStartDate startDate;

    private Integer currentWeekdaySeqIdx = -1;
    private Integer currentHolidaySeqIdx = -1;

    public Assigner(WorkerSequence weekdaySequence, WorkerSequence holidaySequence, AssignStartDate startDate) {
        this.weekdaySequence = weekdaySequence;
        this.holidaySequence = holidaySequence;
        this.startDate = startDate;
    }

    //배정후 출력
    public void assign() {
        StringBuilder assignedResult = new StringBuilder();

        int endDateOfMonth = startDate.endDateOfTheMonth();
        DayOfWeek dayOfWeek = startDate.getDayOfWeek();
        Worker prevWorker = Worker.valueOf("NONE");

        for(int date = 1; date <= endDateOfMonth; date++) {
            Worker worker = getNextWorker(startDate.getMonth(), date, dayOfWeek, prevWorker);
            assignedResult
                    .append(startDate.getMonth().getValue()).append("월").append(" ")
                    .append(date).append("일").append(" ")
                    .append(KoreanDayOfWeek.values()[dayOfWeek.getValue() - 1]);

            //평일이면서 휴일인경우
            if (Day.isHoliday(startDate.getMonth(), date) && !isWeekEnd(dayOfWeek)) {
                assignedResult.append("(휴일)");
            }

            assignedResult.append(" ").append(worker.toString()).append("\n");
            dayOfWeek = dayOfWeek.plus(1);
            prevWorker = worker;
        }

        OutputView.printString(assignedResult.toString());
    }

    private Worker getNextWorker(Month month, int date, DayOfWeek dayOfWeek, Worker prevWorker) {

        if(Day.isHoliday(month, date) || isWeekEnd(dayOfWeek)) {
            Worker worker = holidaySequence.getNextWorker(prevWorker, currentHolidaySeqIdx);
            currentHolidaySeqIdx++;
            return worker;
        }

        Worker worker = weekdaySequence.getNextWorker(prevWorker, currentWeekdaySeqIdx);
        currentWeekdaySeqIdx++;
        return worker;
    }

    private boolean isWeekEnd(DayOfWeek dayOfWeek) {
        return (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7);
    }
}

package oncall.model;

import oncall.model.type.KoreanDay;
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
        WorkerName prevWorker = WorkerName.valueOf("NONE");

        for(int date = 1; date <= endDateOfMonth; date++) {
            WorkerName workerName = getNextWorker(startDate.getMonth(), date, dayOfWeek, prevWorker);
            assignedResult
                    .append(startDate.getMonth().getValue()).append("월").append(" ")
                    .append(date).append("일").append(" ")
                    .append(KoreanDay.values()[dayOfWeek.getValue() - 1]);

            //평일이면서 휴일인경우
            if (Day.isHoliday(startDate.getMonth(), date) && !isWeekEnd(dayOfWeek)) {
                assignedResult.append("(휴일)");
            }

            assignedResult.append(" ").append(workerName.toString()).append("\n");
            dayOfWeek = dayOfWeek.plus(1);
            prevWorker = workerName;
        }

        OutputView.printString(assignedResult.toString());
    }

    private WorkerName getNextWorker(Month month, int date, DayOfWeek dayOfWeek, WorkerName prevWorker) {

        if(Day.isHoliday(month, date) || isWeekEnd(dayOfWeek)) {
            WorkerName workerName = holidaySequence.getNextWorker(prevWorker, currentHolidaySeqIdx);
            currentHolidaySeqIdx++;
            return workerName;
        }

        WorkerName workerName = weekdaySequence.getNextWorker(prevWorker, currentWeekdaySeqIdx);
        currentWeekdaySeqIdx++;
        return workerName;
    }

    private boolean isWeekEnd(DayOfWeek dayOfWeek) {
        return (dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7);
    }
}

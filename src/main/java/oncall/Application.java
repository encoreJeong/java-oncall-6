package oncall;

import oncall.Message.Error;
import oncall.domain.EmergencyDate;
import oncall.domain.WorkerSequence;
import oncall.util.OutputView;

import static oncall.util.InputView.*;

public class Application {
    public static void main(String[] args) {

        //비상 근무 배정 시작일 입력
        EmergencyDate startDate = null;
        while(true) {
            try {
                startDate = readAssignStartDate();
                break;
            } catch (Exception e) {
                OutputView.printMessage(Error.INPUT_ERROR);
            }
        }

        //평일 순번, 휴일 순번 입력
        WorkerSequence weekdaySequence = null;
        WorkerSequence holidaySequence = null;
        while (true) {
            try {
                weekdaySequence = readWeekdaySequence();
                holidaySequence = readHolidaySequence();
                break;
            } catch (Exception e) {
                OutputView.printMessage(Error.INPUT_ERROR);
            }
        }

        System.out.println(weekdaySequence);
        System.out.println(holidaySequence);


    }
}

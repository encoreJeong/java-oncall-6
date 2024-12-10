package oncall;

import oncall.Message.Error;
import oncall.domain.EmergencyDate;
import oncall.util.OutputView;

import static oncall.util.InputView.readAssignStartDate;

public class Application {
    public static void main(String[] args) {

        EmergencyDate startDate = null;
        //비상 근무 배정 시작일 입력
        while(true) {
            try {
                startDate = readAssignStartDate();
                break;
            } catch (Exception e) {
                OutputView.printMessage(Error.INPUT_ERROR);
            }
        }


    }
}

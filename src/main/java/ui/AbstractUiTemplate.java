package ui;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

public abstract class AbstractUiTemplate extends AbstractUi{

    @Override
    public void show() {
        //메뉴출력
        showMenu();
        //키보드에서 문자열 읽음
        String inputedString  = getInputedString();
        //읽어온 문자열 유효성검사
        if(isValidNumber(inputedString)){
            //메뉴번호에 해당되는 작업을 실행하기 위한 메소드 호출
            execute(NumberUtils.toInt(inputedString));
        }
    }

    protected abstract void showMenu();

    protected  abstract  int getMaxMenuNumber();

    protected abstract int getMinNumber();

    private boolean isValidNumber(final String str) {
        //문자열이 입력되어 있는가?
        if(StringUtils.isBlank(str)){
            return false;
        }else if(!StringUtils.isNumeric(str)){
            return false;
        }

        //입력받은 메뉴번호는 문자열이므로 이를 int형으로 변환
        int number = NumberUtils.toInt(str);

        //입력된 메뉴번호가 범위내에 존재하는 숫자인지를 판단한다.
        if(getMinNumber() <= number && number <= getMaxMenuNumber()){
            return true;
        }
        return false;
    }

    protected abstract void execute(int number);
}

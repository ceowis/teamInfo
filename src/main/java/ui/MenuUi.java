package ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MenuUi extends AbstractUiTemplate{

    private SelectTeamUi selectTeamUi;
    private InsertPlayerUi insertPlayerUi;

    public void setInsertPlayerUi(InsertPlayerUi insertPlayerUi) {
        this.insertPlayerUi = insertPlayerUi;
    }
    public void setSelectTeamUi(SelectTeamUi selectTeamUi) {
        this.selectTeamUi = selectTeamUi;
    }

    @Override
    protected void showMenu() {
        System.out.println("========================");
        System.out.println(" ");
        System.out.println("1.종료");
        System.out.println("2.팀 전체 리스트");
        System.out.println("3.선수 정보 추가");
        System.out.println(" ");
        System.out.println("번호를 입력하고 Ener를 눌러주십시오");

    }

    @Override
    protected int getMaxMenuNumber() {
        return 3;
    }

    @Override
    protected int getMinNumber() {
        return 1;
    }

    @Override
    protected void execute(int number){
        switch (number) {
            case 1:
                //1.종료
                System.out.println("프로그램이 종료되었습니다.");
                System.exit(0);
            case 2:
                //2. 전체 리스트
                this.selectTeamUi.show();
                break;
            case 3:
                //2. 전체 리스트
                this.insertPlayerUi.show();
                break;
        }
    }

    public static void main(String[] args){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MenuUi menuUi = (MenuUi)context.getBean("menuUi");
        while(true){
            menuUi.show();
        }
    }
}

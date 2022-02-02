package ui;

import java.util.List;
import java.util.Iterator;

import dao.TeamDao;
import model.Team;

public class SelectTeamUi extends AbstractUi{

    public TeamDao getTeamDao() {
        return teamDao;
    }

    public void setTeamDao(final TeamDao teamDao) {
        this.teamDao = teamDao;
    }

    private TeamDao teamDao;

    @Override
    public void show() {
        showTeamList(this.teamDao.getTeamList());
        System.out.println("Enter를 눌러주십시오");
        getInputedString();
    }

    protected void showTeamList(List teamList){
        System.out.println("======================");
        System.out.println("    팀 관리 ");
        System.out.println(" ");
        System.out.println("ID 팀 명");
        for(Iterator iter = teamList.iterator(); iter.hasNext();){
            Team team = (Team)iter.next();
            System.out.println(team.getId() + " "+ team.getName());
        }

    }
}

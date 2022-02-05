package ui;


import model.Team;
import model.Player;

import org.apache.commons.lang.StringUtils;

import dao.PlayerDao;
import dao.TeamDao;

public class InsertPlayerUi extends AbstractUi {

	private TeamDao teamDao;
	private PlayerDao playerDao;

	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public void setPlayerDao(PlayerDao service) {
		this.playerDao = service;
	}


	@Override
	public void show() {
		final String playerName="선수이름";
		//메뉴로 돌아감
		showMenu(playerName);

		//문자열을 입력받음
		String name = getInputedString();

		if(StringUtils.isEmpty(name)){
			return; // 메뉴로 돌아감
		}else if(UiUtils.isSmallLength(name, playerName, 128)){
			Player player = new Player();
			player.setName(name);
			showTeamField(player);
		}else{
			show();
		}

	}

	//문자열을 입력받아서 선수를 세팅
	protected void showTeamField(Player player){
		final String teamId = "팀 ID";
		//메뉴로 돌아감
		showMenu(teamId);
		//문자열 입력
		String id = getInputedString();
		//문자열이 입력되었는지 확인
		if(StringUtils.isEmpty(id)){
			return;
		}else if(UiUtils.isNumeric(id, teamId)){
			//ID로 팀을 검색
			Team team = this.teamDao.getTeam(Integer.valueOf(id));
			if( team == null) {
				//해당 팀은 존재하지 않음
				System.out.println("입력된 팀명"+ id + "의 팀은 존재하지 않는다. \n");
				showTeamField(player);
			}else {
				//팀을 선수에 셋팅한다.
				player.setTeam(team);
				//데이터베이스로 선수를 등록
				playerDao.insertPlayer(player);
				System.out.println("\n 팀 "+ team.getName()+"에 "+ player.getName() + "선수를 추가했다.\n");
			}
		}
	}

	//메뉴 리스트
	//선수를 생성, 팀을 선택한다.
	protected void showMenu(String wanted){
		System.out.println("--------------------");
		System.out.println(wanted +"을 입력하고 Enter를 눌러주십시오" );
		System.out.printf("아무것도 입력하지 않고 Enter를 누르면 메뉴로 돌아갑니다. ");
	}
}

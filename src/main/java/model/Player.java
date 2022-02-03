package model;

public class Player {
    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(final Team team) {
        this.team = team;
    }

    private Integer id;  //선수ID(player_id)를 저장할 변수를 선언한다.
    private String name; // 선수(name)을 저장할 변수를 선언한다.
    private Team team;  //팀 ID(team_id)을 저장할 변수를 선언한다.


}

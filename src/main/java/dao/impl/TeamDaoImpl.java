package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import model.Team;
import dao.TeamDao;

public class TeamDaoImpl extends JdbcDaoSupport implements TeamDao {

    @Override
    public List getTeamList() throws DataAccessException {
        //콜백 인터페이스 생성
        RowMapper rowMapper = new TeamRowMapper();
        return getJdbcTemplate().query("select team_id, name from team", rowMapper);
    }

    //RowMapper 인터페이스의 구현클래스인 TeamRowMapper
    protected class TeamRowMapper implements RowMapper {

        private List teamList = new ArrayList();

        public List getTeamList(){
            return teamList;
        }

        @Override public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            //ResultSet에서 오브젝트로 다시 채워넣음.
            Team team = new Team();
            team.setId(rs.getInt("team_id"));
            team.setName(rs.getString("name"));
            return team;
        }
    }
}

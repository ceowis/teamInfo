package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
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

    @Override
    public Team getTeam(final Integer teamId) throws DataAccessException {
        return (Team)getJdbcTemplate().query(
                new TeamPreparedStatementCreator(teamId), new TeamResultSetExtractor());
    }

    //RowMapper 인터페이스의 구현클래스인 TeamRowMapper
    protected class TeamRowMapper implements RowMapper {

        private List teamList = new ArrayList();

        public List getTeamList(){
            return teamList;
        }

        @Override
        public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            //ResultSet에서 오브젝트로 다시 채워넣음.
            Team team = new Team();
            team.setId(rs.getInt("team_id"));
            team.setName(rs.getString("name"));
            return team;
        }
    }

    protected class TeamPreparedStatementCreator implements PreparedStatementCreator{

        private Integer teamId;

        public TeamPreparedStatementCreator(Integer id){
            this.teamId = id;
        }

        @Override
        public PreparedStatement createPreparedStatement(final Connection con) throws SQLException {
            final String sql = "SELECT team_id, name  FROM team where team_id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, this.teamId);
            return  ps;
        }
    }

    protected class TeamResultSetExtractor implements ResultSetExtractor {

        @Override
        public Object extractData(final ResultSet rs) throws SQLException, DataAccessException {
            //SQL 결과가 적어도 1건이라도 있는지 검사한다.
            if(rs.next()){
                //ResultSet에서 오브젝트에 바꿔 채움
                Team team = new Team();
                team.setId(rs.getInt("team_id"));
                team.setName(rs.getString("name"));
                return team;
            }else{
                return null;
            }
        }
    }
}

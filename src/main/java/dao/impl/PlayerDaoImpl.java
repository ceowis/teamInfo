package dao.impl;

import dao.PlayerDao;
import model.Player;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PlayerDaoImpl extends JdbcDaoSupport implements PlayerDao {

    private InsertPlayer insertPlayer;

    @Override
    protected void initDao() throws Exception  {
        this.insertPlayer = new InsertPlayer(getDataSource());
    }

    @Override
    public void insertPlayer(Player player) throws DataAccessException {
        //선수등록
        System.out.println(">> getname : "+ player.getName());
        System.out.println(">> getId : "+ player.getTeam().getId());
        this.insertPlayer.update(
              new Object[] { player.getName(), player.getTeam().getId() });
    }
}

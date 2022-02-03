package dao.impl;

import dao.PlayerDao;
import model.Player;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PlayerDaoImpl extends JdbcDaoSupport implements PlayerDao {

    private InsertPlayer insertPlayer;

    @Override
    protected void initDao() throws Exception{
        this.insertPlayer = insertPlayer;
    }

    @Override
    public void insertPlayer(final Player player) throws DataAccessException {
        //선수등록
        this.insertPlayer.update(
                new Object[] { player.getName(), player.getTeam().getId() });
    }
}

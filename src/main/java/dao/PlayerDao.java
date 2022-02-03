package dao;

import model.Player;
import org.springframework.dao.DataAccessException;

public interface PlayerDao {
    //선수등록
    void insertPlayer(Player player) throws DataAccessException;
}

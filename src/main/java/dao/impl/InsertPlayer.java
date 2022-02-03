package dao.impl;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class InsertPlayer extends SqlUpdate {
    public InsertPlayer(DataSource ds){
        super(ds,"INSERT INTO player(name, team_id) values(?,?)");
        super.declareParameter(new SqlParameter("name", Types.VARCHAR));
        super.declareParameter(new SqlParameter("team_id", Types.INTEGER));
        compile();
    }
}

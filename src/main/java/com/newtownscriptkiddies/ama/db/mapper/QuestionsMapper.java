package com.newtownscriptkiddies.ama.db.mapper;

import com.newtownscriptkiddies.ama.api.Question;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class QuestionsMapper implements ResultSetMapper<Question> {

    @Override
    public Question map(int i, ResultSet resultSet, StatementContext statementContext)
        throws SQLException {
        return new Question(
            UUID.fromString(resultSet.getString("id")),
            resultSet.getString("text"),
            resultSet.getString("category")
        );
    }
}

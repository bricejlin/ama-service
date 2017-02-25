package com.newtownscriptkiddies.ama.db.dao;

import com.newtownscriptkiddies.ama.api.Question;
import com.newtownscriptkiddies.ama.db.mapper.QuestionsMapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface QuestionDAO {
    @SqlUpdate("insert into questions (id, text, category) values (uuid_generate_v4(), :text, :category)")
    void insert(@BindBean Question question);

    @SqlQuery("select * from questions")
    @Mapper(QuestionsMapper.class)
    List<Question> getAll();
}

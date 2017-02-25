package com.newtownscriptkiddies.ama.resources;

import com.newtownscriptkiddies.ama.api.Question;
import com.newtownscriptkiddies.ama.db.dao.QuestionDAO;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/v1/questions")
public class QuestionsResource {
    private QuestionDAO questionDAO;

    public QuestionsResource(QuestionDAO questionDAO) {
        this.questionDAO = questionDAO;
    }

    @POST
    public Response addQuestion(Question question) {
        questionDAO.insert(question);
        return Response.status(Status.CREATED).build();
    }

    @GET
    public List<Question> getQuestions() {
        return questionDAO.getAll();
    }
}

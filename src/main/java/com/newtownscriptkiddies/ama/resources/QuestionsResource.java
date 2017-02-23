package com.newtownscriptkiddies.ama.resources;

import com.newtownscriptkiddies.ama.api.Question;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.log4j.Logger;

@Consumes(MediaType.APPLICATION_JSON)
@Path("/v1/questions/new")
public class QuestionsResource {
    private static Logger LOG = Logger.getLogger(QuestionsResource.class);

    public QuestionsResource() {}

    @POST
    public Response addQuestion(@Valid @NotNull Question question) {
        // TODO(Brice): Add question to db
        LOG.info(String.format("Something: %s", question.getText()));
        return Response.status(Status.CREATED).build();
    }
}

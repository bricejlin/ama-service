package com.newtownscriptkiddies.ama.resources;

import com.newtownscriptkiddies.ama.api.Subscription;
import com.newtownscriptkiddies.ama.db.dao.SubscriptionDAO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Consumes(MediaType.APPLICATION_JSON)
@Path("/v1/subscriptions")
public class SubscriptionsResource {
    private SubscriptionDAO subscriptionDAO;

    public SubscriptionsResource(SubscriptionDAO subscriptionDAO) {
        this.subscriptionDAO = subscriptionDAO;
    }

    @POST
    public Response addSubscription(Subscription subscription) {
        subscriptionDAO.insert(subscription);
        return Response.status(Status.CREATED).build();
    }
}

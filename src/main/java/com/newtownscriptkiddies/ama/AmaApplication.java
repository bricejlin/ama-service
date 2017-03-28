package com.newtownscriptkiddies.ama;

import com.newtownscriptkiddies.ama.db.dao.QuestionDAO;
import com.newtownscriptkiddies.ama.db.dao.SubscriptionDAO;
import com.newtownscriptkiddies.ama.resources.QuestionsResource;
import com.newtownscriptkiddies.ama.resources.SubscriptionsResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmaApplication extends Application<AmaConfiguration> {

    private static final Logger LOG = LoggerFactory.getLogger(AmaApplication.class);

    public static void main(final String[] args) throws Exception {
        new AmaApplication().run(args);
    }

    @Override
    public String getName() {
        return "Ama";
    }

    @Override
    public void initialize(final Bootstrap<AmaConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final AmaConfiguration config,
                    final Environment env) {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(env, config.getDataSourceFactory(), "postgresql");
        final QuestionDAO questionDAO = jdbi.onDemand(QuestionDAO.class);
        final SubscriptionDAO subscriptionDAO = jdbi.onDemand(SubscriptionDAO.class);

        final FilterRegistration.Dynamic cors = env.servlets().addFilter("CORS", CrossOriginFilter.class);
        cors.setInitParameter("allowedOrigins", "*");
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        env.jersey().register(new QuestionsResource(questionDAO));
        env.jersey().register(new SubscriptionsResource(subscriptionDAO));
    }

}

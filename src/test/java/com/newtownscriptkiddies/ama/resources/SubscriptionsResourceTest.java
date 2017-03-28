package com.newtownscriptkiddies.ama.resources;

import static org.mockito.Mockito.verify;

import com.newtownscriptkiddies.ama.api.Subscription;
import com.newtownscriptkiddies.ama.db.dao.SubscriptionDAO;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SubscriptionsResourceTest extends TestCase {

    private Subscription subscription = new Subscription("testendpoint");

    private SubscriptionsResource subscriptionsResource;

    @Mock
    SubscriptionDAO subscriptionDAO;

    @Before
    public void setUp() {
        subscriptionsResource = new SubscriptionsResource(subscriptionDAO);
    }

    @Test
    public void testAddSubscription_Should_AddSubscriptionToDB() {
        subscriptionsResource.addSubscription(subscription);
        verify(subscriptionDAO).insert(subscription);
    }
}
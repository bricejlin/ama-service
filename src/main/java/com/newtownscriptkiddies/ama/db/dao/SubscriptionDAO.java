package com.newtownscriptkiddies.ama.db.dao;

import com.newtownscriptkiddies.ama.api.Subscription;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface SubscriptionDAO {
    @SqlUpdate("insert into subscriptions (endpoint) values (:endpoint)")
    void insert(@BindBean Subscription subscription);
}

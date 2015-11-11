/*
 * Copyright © 2015, 8Kdata Technology S.L.
 *
 * Permission to use, copy, modify, and distribute this software
 * and its documentation for any purpose, without fee, and without
 * a written agreement is hereby granted, provided that the above
 * copyright notice and this paragraph and the following two
 * paragraphs appear in all copies.
 *
 * In no event shall 8Kdata Technology S.L. be liable to any party
 * for direct, indirect, special, incidental, or consequential
 * damages, including lost profits, arising out of the use of this
 * software and its documentation, even if 8Kdata Technology S.L.
 * has been advised of the possibility of such damage.
 *
 * 8Kdata Technology S.L. specifically disclaims any warranties,
 * including, but not limited to, the implied warranties of
 * merchantability and fitness for a particular purpose. the
 * software provided hereunder is on an “as is” basis, and
 * 8Kdata Technology S.L. has no obligations to provide
 * maintenance, support, updates, enhancements, or modifications.
 */

package com.eightkdata.phoebe.client.rs.rxjava;

import com.eightkdata.phoebe.client.rs.FailedConnectionException;
import com.eightkdata.phoebe.client.rs.PostgresConnection;
import com.eightkdata.phoebe.common.util.Try;
import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * Unit tests for the various authentication methods.
 *
 * You will need to configure your PostgtreSQL instance appropriately in order to run these.
 */
public class AuthenticationTest extends AbstractTest {

    @Test
    public void testMD5Password() throws Throwable {
        String host = props.getProperty("db.host");
        int port = Integer.parseInt(props.getProperty("db.port"));
        RxPostgresClient client = RxPostgresClient.newClient().tcpIp(host, port).create(5, SECONDS);
        client.connections().subscribe(new Subscriber<Try<PostgresConnection, FailedConnectionException>>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(1);
                waiter.resume();
            }
            @Override
            public void onNext(Try<PostgresConnection, FailedConnectionException> next) {
                System.out.println("next " + next);
                waiter.assertTrue(next.isSuccess());
                waiter.resume();
            }
            @Override
            public void onError(Throwable t) {
                waiter.fail(t);
            }
            @Override
            public void onComplete() {
            }
        });
        waiter.await(5, SECONDS, 2 /* resumes */);
    }

}

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

package com.eightkdata.phoebe.client.api;

/**
 * Unit tests for the various authentication methods.
 *
 * You will need to configure your PostgtreSQL instance appropriately in order to run these.
 */
public class AuthenticationTest extends AbstractTest {

    /*
     * TODO: uncomment the tests and fix them. Testing code is ok, but it assumes a certain given environment.
     * This is problematic for builds as by default they are broken. And they depend on external systems.
     * A general framework for testing with a real PostgreSQL server should be developed for these kind of tests.
     * One way of doing that could be using this: https://github.com/airlift/testing-postgresql-server
     *

    @Test
    public void testMD5Password() throws Throwable {
        String username = props.getProperty("db.md5.user");
        String password = props.getProperty("db.md5.pass");
        String database = props.getProperty("db.md5.name");
        session.start(new StartupCommand(username, password, database, UTF8) {
            @Override
            public void onCompleted(ReadyForQuery message) {
                waiter.assertTrue(message.getStatus() == ReadyForQuery.Status.IDLE);
                waiter.resume();
            }
        });
        waiter.await(5, SECONDS);
    }

    */

}

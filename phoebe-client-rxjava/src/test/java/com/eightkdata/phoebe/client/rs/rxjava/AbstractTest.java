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

import net.jodah.concurrentunit.Waiter;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.Properties;

public abstract class AbstractTest {

    /**
     * Add a file named {@code local.properties} to override the defaults for your database connection.
     */
    static Properties props;

    Waiter waiter;


    @BeforeClass
    public static void setUpClass() throws Exception {
        props = new Properties();
        props.load(AbstractTest.class.getResourceAsStream("/default.properties"));
        if (AbstractTest.class.getResource("/local.properties") != null) {
            props.load(AbstractTest.class.getResourceAsStream("/local.properties"));
        }
    }

    @Before
    public void setUp() throws Exception {
        waiter = new Waiter();
    }

}

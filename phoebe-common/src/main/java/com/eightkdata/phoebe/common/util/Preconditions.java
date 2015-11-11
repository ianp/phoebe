/*
 * Copyright (c) 2015, 8Kdata Technology S.L.
 *
 * Permission to use, copy, modify, and distribute this software and its documentation for any purpose,
 * without fee, and without a written agreement is hereby granted, provided that the above copyright notice and this
 * paragraph and the following two paragraphs appear in all copies.
 *
 * IN NO EVENT SHALL 8Kdata BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES,
 * INCLUDING LOST PROFITS, ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF 8Kdata HAS BEEN
 * ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * 8Kdata SPECIFICALLY DISCLAIMS ANY WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE PROVIDED HEREUNDER IS ON AN "AS IS" BASIS,
 * AND 8Kdata HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
 *
 */


package com.eightkdata.phoebe.common.util;

import com.google.common.base.CharMatcher;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

/**
 * Utility class with methods to help check class invariants
 */
public class Preconditions {
    public static <T extends CharSequence> T checkTextNotNullNotEmpty(@Nonnull T argument, @Nonnull String message) {
        checkNotNull(argument, "argument");
        checkNotNull(message, "message");
        checkArgument(argument.length() > 0, "'%s' must be non-empty", message);

        return argument;
    }

    public static String checkHostname(String host) {
        if (host == null || host.isEmpty() || CharMatcher.WHITESPACE.matchesAllOf(host)) {
            throw new IllegalArgumentException("hostname cannot be null, empty, or all whitespace: " + host);
        }
        return host;
    }

    public static int checkPortNumber(int port) {
        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException("port must be in the range 0..65535: " + port);
        }
        return port;
    }

    public static int checkNonEphemeralPortNumber(int port) {
        if (port < 1 || port > 65535) {
            throw new IllegalArgumentException("non-ephemeral port must be in the range 1..65535: " + port);
        }
        return port;
    }

    private Preconditions() {}

}

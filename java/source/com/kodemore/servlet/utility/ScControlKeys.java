/*
  Copyright (c) 2005-2018 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.servlet.utility;

import com.kodemore.servlet.ScConstantsIF;
import com.kodemore.utility.Kmu;

/**
 * Static methods to manipulate control keys.
 *
 * Each ScControl is uniquely identified by its key. The keys must be
 * consistent across multiple servlet containers and and application
 * restarts. However, the keys MAY change from one version to another.
 *
 * The use of consistent keys is needed so that one server can render
 * a page, and another server can subsequently handle ajax requests.
 *
 * Persistent Keys. Most keys are generated when the UI is setup
 * during the initial servlet container startup process. Keys generated
 * during this process are assumed to be persistent and are created
 * with positive integer values.
 *
 * Transient Keys. In some cases, controls are generated on an ad hoc
 * basis. Dynamically generated controls still need keys in order to
 * coordinate the setup of the dom and javascript. However, such keys
 * are considered transient. The keys are NOT shared across multiple
 * servers and should never be submitted back to a server since there
 * is no way to reconcile them as part of an ajax request. Transient
 * keys are generated with negative integers.
 *
 * Integers vs Strings. The keys are generated, stored, and mapped
 * as integers. This saves a significant amount of memory since Strings
 * are relatively inefficient for storing short values.
 *
 * Tokens. Although keys are stored as integers, there are several cases
 * where it is helpful to coordinate the key in a safe string form. By safe
 * we mean safe to use as a javascript variable name, html tag id/name,
 * or url path. Additionally, we want to avoid the need for any special
 * rules for escaping the string value.
 *
 * Persistent Tokens. Persistent keys (positive integers) are converted
 * to a string using the prefix "P". For example, 100 => 'P100'.
 *
 * Transient Tokens. Transient keys (negative integers) are converted
 * to a string using the prefix "T" and the absolete value of the key.
 * For example, -100 => 'T100'.
 */
public class ScControlKeys
    implements ScConstantsIF
{
    //##################################################
    //# conversion
    //##################################################

    public static String keyToToken(int key)
    {
        return key >= 0
            ? PERSISTENT_KEY_PREFIX + key
            : TRANSIENT_KEY_PREFIX + -key;
    }

    public static Integer tokenToKey(String token)
    {
        if ( token.startsWith(PERSISTENT_KEY_PREFIX) )
        {
            String s = Kmu.removePrefix(token, PERSISTENT_KEY_PREFIX);
            return Kmu.parseInteger(s);
        }

        if ( token.startsWith(TRANSIENT_KEY_PREFIX) )
        {
            String s = Kmu.removePrefix(token, TRANSIENT_KEY_PREFIX);
            return -Kmu.parseInteger(s);
        }

        throw Kmu.newFatal("Invalid token");
    }

    //##################################################
    //# testing
    //##################################################

    public static boolean isPersistentKey(int key)
    {
        return key >= 0;
    }

    public static boolean isTransientKey(int key)
    {
        return !isPersistentKey(key);
    }

    public static boolean isPersistentToken(String token)
    {
        return isPersistentKey(tokenToKey(token));
    }

    public static boolean isTransientToken(String token)
    {
        return isTransientKey(tokenToKey(token));
    }
}

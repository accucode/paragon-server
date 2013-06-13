/*
  Copyright (c) 2005-2011 www.kodemore.com

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

package com.kodemore.utility;

import java.util.Properties;
import java.util.Set;

import com.kodemore.collection.KmList;
import com.kodemore.collection.KmMap;

/**
 * Convenient access to System.getProperties.
 */
public class KmSystemProperties
{
    //##################################################
    //# java
    //##################################################

    public static String getJavaVersion()
    {
        return get("java.version");
    }

    public static String getJavaVendor()
    {
        return get("java.vendor");
    }

    public static String getJavaVendorUrl()
    {
        return get("java.vendor.url");
    }

    public static String getJavaHome()
    {
        return get("java.home");
    }

    //##################################################
    //# java vm spec
    //##################################################

    public static String getJavaVmSpecificationVersion()
    {
        return get("java.vm.specification.version");
    }

    public static String getJavaVmSpecificationVendor()
    {
        return get("java.vm.specification.vendor");
    }

    public static String getJavaVmSpecificationName()
    {
        return get("java.vm.specificationName");
    }

    public static String getJavaVmVersion()
    {
        return get("java.vm.version");
    }

    public static String getJavaVmVendor()
    {
        return get("java.vm.vendor");
    }

    public static String getJavaVmName()
    {
        return get("java.vm.name");
    }

    public static String getJavaSpecificationVersion()
    {
        return get("java.specification.version");
    }

    public static String getJavaSpecificationVendor()
    {
        return get("java.specification.vendor");
    }

    public static String getJavaSpecificationName()
    {
        return get("java.specificationName");
    }

    //##################################################
    //# java other
    //##################################################

    public static String getJavaClassVersion()
    {
        return get("java.class.version");
    }

    public static String getJavaClassPath()
    {
        return get("java.class.path");
    }

    public static String getJavaLibraryPath()
    {
        return get("java.library.path");
    }

    public static String getJavaIoTmpdir()
    {
        return get("java.io.tmpdir");
    }

    public static String getJavaCompiler()
    {
        return get("java.compiler");
    }

    public static String getJavaExtDirs()
    {
        return get("java.ext.dirs");
    }

    //##################################################
    //# os
    //##################################################

    public static String getOsName()
    {
        return get("os.name");
    }

    public static String getOsArch()
    {
        return get("os.arch");
    }

    public static String getOsVersion()
    {
        return get("os.version");
    }

    //##################################################
    //# file
    //##################################################

    public static String getFileSeparator()
    {
        return get("file.separator");
    }

    public static String getPathSeparator()
    {
        return get("path.separator");
    }

    public static String getLineSeparator()
    {
        return get("line.separator");
    }

    //##################################################
    //# user
    //##################################################

    public static String getUserName()
    {
        return get("user.name");
    }

    public static String getUserHome()
    {
        return get("user.home");
    }

    public static String getUserDir()
    {
        return get("user.dir");
    }

    //##################################################
    //# general
    //##################################################

    public static KmMap<String,String> getAll()
    {
        KmMap<String,String> map = new KmMap<String,String>();
        Properties p = System.getProperties();
        Set<Object> keys = p.keySet();
        for ( Object oKey : keys )
        {
            String k = (String)oKey;
            String v = p.getProperty(k);
            map.put(k, v);
        }
        return map;
    }

    public static void dumpAll()
    {
        KmMap<String,String> m = getAll();

        KmList<String> keys;
        keys = m.getKeys();
        keys.sort();

        int pad = 0;
        for ( String key : keys )
            pad = Math.max(pad, key.length());

        for ( String key : keys )
            System.out.printf("%s = %s\n", Kmu.rightPad(key, pad), m.get(key));
    }

    public static String get(String key)
    {
        return System.getProperty(key);
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        dumpAll();
    }
}

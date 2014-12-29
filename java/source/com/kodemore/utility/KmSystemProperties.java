/*
  Copyright (c) 2005-2014 www.kodemore.com

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
        return getValue("java.version");
    }

    public static String getJavaVendor()
    {
        return getValue("java.vendor");
    }

    public static String getJavaVendorUrl()
    {
        return getValue("java.vendor.url");
    }

    public static String getJavaHome()
    {
        return getValue("java.home");
    }

    //##################################################
    //# java vm spec
    //##################################################

    public static String getJavaVmSpecificationVersion()
    {
        return getValue("java.vm.specification.version");
    }

    public static String getJavaVmSpecificationVendor()
    {
        return getValue("java.vm.specification.vendor");
    }

    public static String getJavaVmSpecificationName()
    {
        return getValue("java.vm.specificationName");
    }

    public static String getJavaVmVersion()
    {
        return getValue("java.vm.version");
    }

    public static String getJavaVmVendor()
    {
        return getValue("java.vm.vendor");
    }

    public static String getJavaVmName()
    {
        return getValue("java.vm.name");
    }

    public static String getJavaSpecificationVersion()
    {
        return getValue("java.specification.version");
    }

    public static String getJavaSpecificationVendor()
    {
        return getValue("java.specification.vendor");
    }

    public static String getJavaSpecificationName()
    {
        return getValue("java.specificationName");
    }

    //##################################################
    //# java other
    //##################################################

    public static String getJavaClassVersion()
    {
        return getValue("java.class.version");
    }

    public static String getJavaClassPath()
    {
        return getValue("java.class.path");
    }

    public static String getJavaLibraryPath()
    {
        return getValue("java.library.path");
    }

    public static String getJavaIoTmpdir()
    {
        return getValue("java.io.tmpdir");
    }

    public static String getJavaCompiler()
    {
        return getValue("java.compiler");
    }

    public static String getJavaExtDirs()
    {
        return getValue("java.ext.dirs");
    }

    //##################################################
    //# os
    //##################################################

    public static String getOsName()
    {
        return getValue("os.name");
    }

    public static String getOsArch()
    {
        return getValue("os.arch");
    }

    public static String getOsVersion()
    {
        return getValue("os.version");
    }

    //##################################################
    //# file
    //##################################################

    public static String getFileSeparator()
    {
        return getValue("file.separator");
    }

    public static String getPathSeparator()
    {
        return getValue("path.separator");
    }

    public static String getLineSeparator()
    {
        return getValue("line.separator");
    }

    //##################################################
    //# user
    //##################################################

    public static String getUserName()
    {
        return getValue("user.name");
    }

    public static String getUserHome()
    {
        return getValue("user.home");
    }

    public static String getUserDir()
    {
        return getValue("user.dir");
    }

    //##################################################
    //# general
    //##################################################

    public static KmMap<String,String> getAll()
    {
        KmMap<String,String> map = new KmMap<>();
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

    public static KmList<String> getAllKeys()
    {
        KmList<String> v;
        v = getAll().getKeys();
        v.sort();
        return v;
    }

    public static void dumpAll()
    {
        KmList<String> keys = getAllKeys();

        int pad = 0;
        for ( String key : keys )
            pad = Math.max(pad, key.length());

        for ( String key : keys )
            System.out.printf("%s = %s\n", Kmu.rightPad(key, pad), getValue(key));
    }

    public static String getValue(String key)
    {
        return System.getProperty(key);
    }

    //##################################################
    //# prefixes
    //##################################################

    public static KmList<String> getAllPrefixes()
    {
        KmList<String> v = new KmList<>();

        for ( String key : getAllKeys() )
            v.addDistinct(getPrefixFor(key));

        return v;
    }

    public static KmList<String> getAllKeysForPrefix(String prefix)
    {
        KmList<String> v = new KmList<>();

        for ( String key : getAllKeys() )
            if ( getPrefixFor(key).equals(prefix) )
                v.add(key);

        return v;
    }

    private static String getPrefixFor(String key)
    {
        int i = key.indexOf(".");

        if ( i < 0 )
            return key;

        return key.substring(0, i);
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        dumpAll();
    }
}

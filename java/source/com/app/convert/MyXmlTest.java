package com.app.convert;

import com.kodemore.utility.KmFiles;

import com.app.utility.MyInstaller;

public class MyXmlTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new MyXmlTest().run();
    }

    //##################################################
    //# run
    //##################################################

    private void run()
    {
        MyInstaller.installCore();

        String xmlPath = "converterTest/upcA.xml";
        String xml = KmFiles.readString(xmlPath);

        MyXmlConverter e;
        e = new MyXmlConverter();
        e.setAdaptorZpl();

        byte[] zpl = e.convert(xml);
        String zplString = new String(zpl);

        System.out.println(zplString);
    }
}

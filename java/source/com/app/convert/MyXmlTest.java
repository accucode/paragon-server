package com.app.convert;

import com.kodemore.utility.Kmu;

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

        String xmlFile = "converterTest/upcA.xml";
        String xml = Kmu.readTextFile(xmlFile);

        MyXmlConverter e;
        e = new MyXmlConverter();
        e.setAdaptorZpl();

        byte[] zpl = e.convert(xml);
        String zplString = new String(zpl);

        System.out.println(zplString);
    }
}

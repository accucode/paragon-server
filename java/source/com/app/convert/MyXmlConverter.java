package com.app.convert;

public class MyXmlConverter
{
    //##################################################
    //# variables 
    //##################################################

    private MyXmlLabelParser  _parser;
    private MyXmlLabelAdaptor _adaptor;
    private MyLabelSettings   _settings;

    //##################################################
    //# constructor
    //##################################################

    public MyXmlConverter()
    {
        _parser = new MyXmlLabelParser();
        _settings = new MyLabelSettings();
    }

    //##################################################
    //# settings
    //##################################################

    public MyLabelSettings getSettings()
    {
        return _settings;
    }

    public void setSettings(MyLabelSettings e)
    {
        _settings = e;
    }

    //##################################################
    //# parser
    //##################################################

    public MyXmlLabelParser getParser()
    {
        return _parser;
    }

    public void setParser(MyXmlLabelParser e)
    {
        _parser = e;
    }

    //##################################################
    //# adaptor
    //##################################################

    public MyXmlLabelAdaptor getAdaptor()
    {
        return _adaptor;
    }

    public void setAdaptor(MyXmlLabelAdaptor e)
    {
        _adaptor = e;
    }

    public void setAdaptorZpl()
    {
        setAdaptor(new MyXmlLabelAdaptorZpl());
    }

    //##################################################
    //# convert
    //##################################################

    public byte[] convert(String xml)
    {
        return _adaptor.format(_parser.parse(xml), _settings);
    }
}

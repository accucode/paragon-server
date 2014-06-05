package com.app.convert;

import com.kodemore.collection.KmList;
import com.kodemore.string.KmStringBuilder;
import com.kodemore.utility.Kmu;
import com.kodemore.xml.KmXmlAttribute;
import com.kodemore.xml.KmXmlDocument;
import com.kodemore.xml.KmXmlElement;
import com.kodemore.xml.KmXmlNode;
import com.kodemore.xml.KmXmlParser;
import com.kodemore.xml.KmXmlSourceLocation;

public class MyXmlLabelParser
{
    //##################################################
    //# public
    //##################################################

    public MyLabelJob parse(String xml)
    {
        KmXmlDocument doc;
        doc = KmXmlParser.parse(xml);
        if ( doc == null )
            error("Cannot parse xml.");

        KmXmlElement root;
        root = doc.getRoot();
        if ( root == null )
            error("No root element.");

        return parseJob(root);
    }

    //##################################################
    //# parse job
    //##################################################

    private MyLabelJob parseJob(KmXmlElement root)
    {
        String expectedTag = "print";
        if ( !root.hasTag(expectedTag) )
            errorAt(root, "Invalid root(%s), expected(%s).", root.getTag(), expectedTag);

        MyLabelJob job;
        job = new MyLabelJob();

        parseJobAttributes(job, root);
        parseJobElements(job, root);

        return job;
    }

    private void parseJobAttributes(MyLabelJob job, KmXmlElement root)
    {
        KmList<KmXmlAttribute> v = root.getAttributes();
        for ( KmXmlAttribute e : v )
            parseJobAttribute(job, root, e);
    }

    private void parseJobAttribute(MyLabelJob job, KmXmlElement root, KmXmlAttribute e)
    {
        if ( parseJobQuantity(job, root, e) )
            return;

        errorAt(root, "Unknown attribute(%s).", e.getKey());
    }

    private boolean parseJobQuantity(MyLabelJob job, KmXmlElement root, KmXmlAttribute attr)
    {
        if ( !attr.hasKey("quantity") )
            return false;

        String s = attr.getValue();
        Integer i = Kmu.parseInteger(s);
        if ( i == null || i < 1 )
            errorAt(root, "Invalid quantity.");

        job.setQuantity(i);
        return true;
    }

    private void parseJobElements(MyLabelJob job, KmXmlElement root)
    {
        KmList<KmXmlElement> v = root.getChildElements();
        for ( KmXmlElement e : v )
            parseJobElement(job, e);
    }

    private void parseJobElement(MyLabelJob job, KmXmlElement e)
    {
        if ( parseText(job, e) )
            return;

        if ( parseBarcode(job, e) )
            return;

        errorAt(e, "Unknown element(%s).", e.getTag());
    }

    //##################################################
    //# parse text
    //##################################################

    private boolean parseText(MyLabelJob job, KmXmlElement root)
    {
        String tag = "text";
        if ( !root.hasTag(tag) )
            return false;

        MyLabelText text = job.addText();
        parseTextAttributes(text, root);

        return true;
    }

    private void parseTextAttributes(MyLabelText text, KmXmlElement root)
    {
        KmList<KmXmlAttribute> v = root.getAttributes();
        for ( KmXmlAttribute e : v )
            parseTextAttribute(text, root, e);
    }

    private void parseTextAttribute(MyLabelText text, KmXmlElement root, KmXmlAttribute attr)
    {
        if ( parseTextX(text, root, attr) )
            return;

        if ( parseTextY(text, root, attr) )
            return;

        if ( parseTextHeight(text, root, attr) )
            return;

        if ( parseTextOrientation(text, root, attr) )
            return;

        if ( parseTextValue(text, root, attr) )
            return;

        errorAt(root, "Unknown attribute(%s)", attr.getKey());
    }

    private boolean parseTextX(MyLabelText text, KmXmlElement root, KmXmlAttribute attr)
    {
        if ( !attr.hasKey("x") )
            return false;

        String s = attr.getValue();
        Double d = Kmu.parseDouble(s);
        if ( d == null )
            errorAt(root, "Invalid x value(%s).", s);

        text.setX(d);
        return true;
    }

    private boolean parseTextY(MyLabelText text, KmXmlElement root, KmXmlAttribute attr)
    {
        if ( !attr.hasKey("y") )
            return false;

        String s = attr.getValue();
        Double d = Kmu.parseDouble(s);
        if ( d == null )
            errorAt(root, "Invalid y value(%s).", s);

        text.setY(d);
        return true;
    }

    private boolean parseTextHeight(MyLabelText text, KmXmlElement root, KmXmlAttribute attr)
    {
        if ( !attr.hasKey("height") )
            return false;

        String s = attr.getValue();
        Double d = Kmu.parseDouble(s);
        if ( d == null )
            errorAt(root, "Invalid height value(%s).", s);

        text.setHeight(d);
        return true;
    }

    private boolean parseTextOrientation(MyLabelText text, KmXmlElement root, KmXmlAttribute attr)
    {
        if ( !attr.hasKey("orientation") )
            return false;

        String s = attr.getValue();
        MyLabelOrientation e = MyLabelOrientation.findCode(s);
        if ( e == null )
            errorAt(root, "Invalid orientation value(%s).", s);

        text.setOrientation(e);
        return true;
    }

    private boolean parseTextValue(
        MyLabelText text,
        @SuppressWarnings("unused") KmXmlElement root,
        KmXmlAttribute attr)
    {
        if ( !attr.hasKey("value") )
            return false;

        String s = attr.getValue();
        text.setValue(s);
        return true;
    }

    //##################################################
    //# parse barcode
    //##################################################

    private boolean parseBarcode(MyLabelJob job, KmXmlElement root)
    {
        if ( !root.hasTag("barcode") )
            return false;

        MyLabelBarcode barcode = job.addBarcode();
        parseBarcodeAttributes(barcode, root);

        return true;
    }

    private void parseBarcodeAttributes(MyLabelBarcode barcode, KmXmlElement root)
    {
        KmList<KmXmlAttribute> v = root.getAttributes();
        for ( KmXmlAttribute e : v )
            parseBarcodeAttribute(barcode, root, e);
    }

    private void parseBarcodeAttribute(
        MyLabelBarcode barcode,
        KmXmlElement root,
        KmXmlAttribute attr)
    {
        if ( parseBarcodeX(barcode, root, attr) )
            return;

        if ( parseBarcodeY(barcode, root, attr) )
            return;

        if ( parseBarcodeHeight(barcode, root, attr) )
            return;

        if ( parseBarcodeOrientation(barcode, root, attr) )
            return;

        if ( parseBarcodeType(barcode, root, attr) )
            return;

        if ( parseBarcodeValue(barcode, root, attr) )
            return;

        errorAt(root, "Unknown attribute(%s)", attr.getKey());
    }

    private boolean parseBarcodeX(MyLabelBarcode barcode, KmXmlElement root, KmXmlAttribute attr)
    {
        if ( !attr.hasKey("x") )
            return false;

        String s = attr.getValue();
        Double d = Kmu.parseDouble(s);
        if ( d == null )
            errorAt(root, "Invalid x value(%s).", s);

        barcode.setX(d);
        return true;
    }

    private boolean parseBarcodeY(MyLabelBarcode barcode, KmXmlElement root, KmXmlAttribute attr)
    {
        if ( !attr.hasKey("y") )
            return false;

        String s = attr.getValue();
        Double d = Kmu.parseDouble(s);
        if ( d == null )
            errorAt(root, "Invalid y value(%s).", s);

        barcode.setY(d);
        return true;
    }

    private boolean parseBarcodeHeight(
        MyLabelBarcode barcode,
        KmXmlElement root,
        KmXmlAttribute attr)
    {
        if ( !attr.hasKey("height") )
            return false;

        String s = attr.getValue();
        Double d = Kmu.parseDouble(s);
        if ( d == null )
            errorAt(root, "Invalid height value(%s).", s);

        barcode.setHeight(d);
        return true;
    }

    private boolean parseBarcodeOrientation(
        MyLabelBarcode barcode,
        KmXmlElement root,
        KmXmlAttribute attr)
    {
        if ( !attr.hasKey("orientation") )
            return false;

        String s = attr.getValue();
        MyLabelOrientation e = MyLabelOrientation.findCode(s);
        if ( e == null )
            errorAt(root, "Invalid orientation value(%s).", s);

        barcode.setOrientation(e);
        return true;
    }

    private boolean parseBarcodeType(MyLabelBarcode barcode, KmXmlElement root, KmXmlAttribute attr)
    {
        if ( !attr.hasKey("type") )
            return false;

        String s = attr.getValue();
        MyLabelBarcodeType e = MyLabelBarcodeType.findCode(s);
        if ( e == null )
            errorAt(root, "Invalid type value(%s).", s);

        barcode.setType(e);
        return true;
    }

    private boolean parseBarcodeValue(
        MyLabelBarcode barcode,
        @SuppressWarnings("unused") KmXmlElement root,
        KmXmlAttribute attr)
    {
        if ( !attr.hasKey("value") )
            return false;

        String s = attr.getValue();
        barcode.setValue(s);
        return true;
    }

    //##################################################
    //# support
    //##################################################

    private void errorAt(KmXmlNode node, String msg, Object... args)
    {
        KmXmlSourceLocation loc;
        loc = node.getLocation();

        KmStringBuilder out;
        out = new KmStringBuilder();
        out.printfln(msg, args);
        out.printfln("Error occurred near line %s...", loc.getRow());
        out.println(loc.getSourceLine());
        out.println(loc.getMarkerLine());

        throw new RuntimeException(out.toString());
    }

    private void error(String msg, Object... args)
    {
        KmStringBuilder out;
        out = new KmStringBuilder();
        out.printfln(msg, args);

        throw new RuntimeException(out.toString());
    }

}

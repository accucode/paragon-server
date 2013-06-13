package sandbox.wlove;

import com.kodemore.collection.KmList;
import com.kodemore.file.KmFile;
import com.kodemore.file.KmFileRoot;
import com.kodemore.utility.KmConstantsIF;
import com.kodemore.utility.Kmu;

import com.app.utility.MyInstaller;

/**
 * Reads Iana time zone data files from:
 * http://www.iana.org/time-zones
 */
@SuppressWarnings("unused")
public class JkIanaTimeZoneReader
    implements KmConstantsIF
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        new JkIanaTimeZoneReader().run();
    }

    //##################################################
    //# variables
    //##################################################

    private KmList<String> _lines;
    private int            _index;

    private KmList<Rule>   _rules = new KmList<JkIanaTimeZoneReader.Rule>();
    private KmList<Zone>   _zones = new KmList<JkIanaTimeZoneReader.Zone>();

    //##################################################
    //# run
    //##################################################

    public void run()
    {
        MyInstaller.installCore();

        parse();
        printResults();
    }

    private String getSource()
    {
        String name;
        name = "europe";
        name = "asia";
        name = "northamerica";

        KmFileRoot folder = new KmFileRoot("/Users/Wlove/Downloads/tzdata2012c");
        KmFile file = folder.getChild(name);
        return file.readString();
    }

    //##################################################
    //# parse
    //##################################################

    private void parse()
    {
        String source = getSource();

        _lines = Kmu.getLines(source);
        firstLine();

        while ( !eof() )
            parseNext();
    }

    private void parseNext()
    {
        if ( parseRule() )
            return;

        if ( parseZone() )
            return;

        if ( parseLink() )
            return;

        System.out.println();
        System.out.println();
        System.out.println("Unhandled line...");
        System.out.println(_index + 1);
        System.out.println(getLine());

        nextLine();
    }

    private boolean parseRule()
    {
        String line = getLine();

        if ( !line.startsWith("Rule") )
            return false;

        KmList<String> tokens;
        tokens = Kmu.tokenize(line, KmConstantsIF.CHAR_TAB);

        if ( tokens.isEmpty() )
            return false;

        String first = tokens.removeFirst().trim();

        String name = null;
        if ( first.contains(SPACE) )
            name = Kmu.getAfterFirst(first, SPACE).trim();
        else
            name = tokens.removeFirst();

        Rule rule;
        rule = new Rule();
        rule.name = name;
        rule.fromYear = tokens.removeFirst();
        rule.toYear = tokens.removeFirst();
        rule.type = tokens.removeFirst();
        rule.inMonth = tokens.removeFirst();
        rule.onDay = tokens.removeFirst();
        rule.atTime = tokens.removeFirst();
        rule.save = tokens.removeFirst();

        _rules.add(rule);

        nextLine();
        return true;
    }

    private boolean parseZone()
    {
        String id = "Zone";

        String line = getLine();
        if ( !line.startsWith(id) )
            return false;

        nextLine();

        KmList<String> tokens = Kmu.tokenize(line, CHAR_TAB);
        String first = tokens.removeFirst().trim();

        String name;
        if ( first.contains(SPACE) )
            name = Kmu.removePrefix(first, id).trim();
        else
            name = tokens.removeFirst().trim();

        String country;
        String region;

        if ( name.contains(SLASH) )
        {
            country = Kmu.getBeforeFirst(name, "/");
            region = Kmu.getAfterFirst(name, "/");
        }
        else
        {
            country = "";
            region = name;
        }

        if ( region.contains(SPACE) )
            region = Kmu.getBeforeFirst(region, SPACE);

        region = Kmu.replaceAll(region, UNDERSCORE, SPACE);

        Zone zone;
        zone = new Zone();
        zone.name = name;
        zone.country = country;
        zone.region = region;

        boolean active = false;

        while ( true )
        {
            if ( eof() )
                break;

            line = getLine();
            if ( !line.startsWith(TAB) )
                break;

            line = line.trim();
            nextLine();

            tokens = Kmu.tokenize(line, CHAR_TAB);

            String offset = tokens.removeFirst();
            String rule = tokens.removeFirst();
            tokens.removeFirstSafe(); // format
            String until = tokens.removeFirstSafe();

            if ( until == null )
            {
                zone.offset = offset;
                zone.rule = rule;
                active = true;
            }
        }

        if ( active )
            _zones.add(zone);

        return true;
    }

    private boolean parseLink()
    {
        if ( !getLine().startsWith("Link") )
            return false;

        // currently ignoring links
        nextLine();
        return true;
    }

    //##################################################
    //# lines
    //##################################################

    private String getLine()
    {
        if ( eof() )
            return null;

        return _lines.get(_index);
    }

    private void firstLine()
    {
        _index = 0;
        skipComments();
    }

    private void nextLine()
    {
        _index++;
        skipComments();
    }

    private void skipComments()
    {
        while ( isComment() )
            _index++;
    }

    private boolean isComment()
    {
        String line = getLine();

        if ( line == null )
            return false;

        if ( line.trim().length() == 0 )
            return true;

        if ( line.startsWith("#") )
            return true;

        return false;
    }

    private boolean eof()
    {
        if ( _lines == null )
            return true;

        if ( _lines.isEmpty() )
            return true;

        if ( _lines.size() <= _index )
            return true;

        return false;
    }

    //##################################################
    //# results
    //##################################################

    private void printResults()
    {
        // printRules();
        printZones();
    }

    private void printRules()
    {
        System.out.println();
        System.out.println("Rules");

        KmList<Rule> v = _rules;
        for ( Rule e : v )
            // if ( e.name.equals("US") )
            if ( e.toYear.equals("max") )
                System.out.printf(
                    "Name(%s), in(%s), on(%s), at(%s), save(%s).\n",
                    e.name,
                    e.inMonth,
                    e.onDay,
                    e.atTime,
                    e.save);
    }

    private void printZones()
    {
        System.out.println();
        System.out.println("Zones");

        KmList<Zone> v = _zones;
        for ( Zone e : v )
            System.out.printf("%s, %s, %s, %s.\n", e.offset, e.country, e.region, e.rule);
    }

    //##################################################
    //# rule
    //##################################################

    private class Rule
    {
        String name;
        String fromYear;
        String toYear;
        String type;
        String inMonth;
        String onDay;
        String atTime;
        String save;
    }

    private class Zone
    {
        String name;
        String country;
        String region;
        String offset;
        String rule;
    }
}

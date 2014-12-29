package sandbox.wlove;

import java.io.BufferedReader;
import java.io.FileReader;

import com.kodemore.collection.KmList;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

public class JkImportTest
{
    //##################################################
    //# main
    //##################################################

    public static void main(String[] args) throws Exception
    {
        new JkImportTest().run();
    }

    //##################################################
    //# constants
    //##################################################

    private static final String FILE_PATH = "/temp/trending.txt";

    //##################################################
    //# variables
    //##################################################

    private int                 _lineNumber;
    private String              _line;
    private String[]            _parts;

    private KmList<String>      _hostNames;
    private KmList<String>      _serviceNames;

    private int                 _maximumOutputLength;
    private int                 _maximumPerformanceLength;

    private KmTimestamp         _minimumTime;
    private KmTimestamp         _maximumTime;

    //##################################################
    //# constructor
    //##################################################

    public JkImportTest()
    {
        _hostNames = new KmList<>();
        _serviceNames = new KmList<>();
    }

    //##################################################
    //# run
    //##################################################

    public void run() throws Exception
    {
        readFile();
        printHostNames();
        printServiceNames();
        printMaximumLengths();
        printTimes();
    }

    private void readFile() throws Exception
    {
        BufferedReader in = new BufferedReader(new FileReader(FILE_PATH));

        while ( true )
        {
            _line = in.readLine();
            if ( _line == null )
                break;

            _lineNumber++;
            handleLine();

            printProgress();
        }

        in.close();
    }

    private void handleLine()
    {
        _parts = _line.split("\\|\\|");

        _hostNames.addNonNullDistinct(getHostName());
        _serviceNames.addNonNullDistinct(getServiceName());

        String s;

        s = getOutputMessage();
        if ( s != null && s.length() > _maximumOutputLength )
            _maximumOutputLength = s.length();

        s = getPerformanceMessage();
        if ( s != null && s.length() > _maximumPerformanceLength )
            _maximumPerformanceLength = s.length();

        KmTimestamp ts = getTimestamp();
        if ( ts != null )
        {
            if ( _minimumTime == null )
                _minimumTime = ts;
            else
                if ( ts.isBefore(_minimumTime) )
                    _minimumTime = ts;

            if ( _maximumTime == null )
                _maximumTime = ts;
            else
                if ( ts.isAfter(_maximumTime) )
                    _maximumTime = ts;
        }
    }

    //##################################################
    //# field access
    //##################################################

    private KmTimestamp getTimestamp()
    {
        String s = getFieldAt(0);
        Integer i = Kmu.parseInteger(s);

        if ( i == null )
            return null;

        KmTimestamp ts;
        ts = KmTimestamp.create(1970, 1, 1);
        ts = ts.addSeconds(i);
        return ts;
    }

    private String getHostName()
    {
        return getFieldAt(1);
    }

    private String getServiceName()
    {
        return getFieldAt(2);
    }

    private String getOutputMessage()
    {
        return getFieldAt(3);
    }

    private String getPerformanceMessage()
    {
        return getFieldAt(4);
    }

    private String getFieldAt(int i)
    {
        if ( _parts.length <= i )
            return null;

        return _parts[i];
    }

    //##################################################
    //# print
    //##################################################

    private void printProgress()
    {
        //        KmTimestamp ts = getTimestamp();
        //        System.out.println(ts);

        if ( _lineNumber % 100 == 0 )
            System.out.println(_lineNumber);
    }

    private void printHostNames()
    {
        _hostNames.sort();

        System.out.println();
        System.out.println("Host Names");
        for ( String e : _hostNames )
            System.out.println("    " + e);
    }

    private void printServiceNames()
    {
        _serviceNames.sort();

        System.out.println();
        System.out.println("Service Names");
        for ( String e : _serviceNames )
            System.out.println("    " + e);
    }

    private void printMaximumLengths()
    {
        System.out.println();
        System.out.printf("Max Output: %s\n", _maximumOutputLength);
        System.out.printf("Max Perf:   %s\n", _maximumPerformanceLength);
    }

    private void printTimes()
    {
        double secs = _minimumTime.diff(_maximumTime).getTotalSecondsExact();
        double recsPerSec = _lineNumber / secs;

        System.out.println();
        System.out.printf("Min Time: %s\n", _minimumTime);
        System.out.printf("Max Time: %s\n", _maximumTime);
        System.out.printf("Records / sec: %s", Kmu.formatDouble(recsPerSec, 1));
    }
}

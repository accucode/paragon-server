package sandbox.wlove;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kodemore.utility.Kmu;

public class JkRegex
{
    public static void main(String[] args)
    {
        new JkRegex().run();
    }

    private void run()
    {
        // test();
        testMacro();
        // testLog();
        // testPath();
        // testGroup();
    }

    protected void testMacro()
    {
        String source;
        source = "Name $(name) and Phone $(phone).";

        String regex;
        regex = "\\$\\(.*?\\)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);

        while ( matcher.find() )
        {
            String group = matcher.group();
            System.out.println(group);
        }
    }

    protected void testGroup()
    {
        String source;
        source = "abc---defg---hi";

        String regex;
        regex = "(.+)---(.+)---(.+)";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        boolean matches = matcher.matches();

        System.out.println("JkRegex.test");
        System.out.println("    source:  " + source);
        System.out.println("    regex:   " + regex);
        System.out.println("    matches: " + matches);

        if ( matches )
        {
            int groupCount = matcher.groupCount();

            System.out.println("    groupCount: " + groupCount);
            for ( int i = 0; i <= groupCount; i++ )
                System.out.printf("    group[%s]: %s\n", i, matcher.group(i));
        }
    }

    protected void testLog()
    {
        String regex;

        // float
        regex = ".*?(\\d+(\\.\\d*)?).*";

        // int
        regex = ".*?(\\d+).*";
        regex = ".*?(\\d+(\\.\\d*)?).*";

        String source;
        source = "SOCKET COUNT OK - listen = 30, established = 84, time_wait";
        source = "DISKIO OK 208 sectors/s";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);

        boolean matches = matcher.matches();
        System.out.println("    matches: " + matches);

        if ( !matches )
            return;

        int groupCount = matcher.groupCount();
        System.out.println("    groupCount: " + groupCount);

        if ( groupCount == 0 )
            return;

        String group = matcher.group(1);
        System.out.println("    group: " + group);
    }

    protected void testPath()
    {
        // Kmu.matchesPathPattern(path, pattern);

        String path;
        path = "a/b/c/d/e/f";

        String pattern;
        pattern = "*/b/**/e/f";

        boolean matches = Kmu.matchesPath(path, pattern);

        System.out.println();
        System.out.println();
        System.out.println("Path:    " + path);
        System.out.println("Pattern: " + pattern);
        System.out.println("Matches: " + matches);

    }
}

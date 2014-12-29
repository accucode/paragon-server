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

package com.kodemore.profile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

import javax.swing.JScrollPane;
import javax.swing.JTree;

import com.kodemore.awt.KmaFrame;
import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * Expects java (1.5) to be run with the following options
 * -Xrunhprof:cpu=times,thread=y,file=prof.txt,depth=20
 *
 * 'times' may be changed to 'samples' for faster but less
 * accurate info.  If using samples, you may specify interval=[ms].
 * The default interval is probably 10.
 */
public class KmProfileReader
{
    //##################################################
    //# variables
    //##################################################

    private String                 _path;
    private KmList<KmProfileTrace> _traces;
    private KmList<KmProfileCpu>   _cpus;
    private KmProfileTraceNode     _traceNodeRoot;

    private BufferedReader         _reader;
    private String                 _line;

    //##################################################
    //# constructor
    //##################################################

    public KmProfileReader()
    {
        clear();
    }

    //##################################################
    //# accessing
    //##################################################

    public String getPath()
    {
        return _path;
    }

    public void setPath(String e)
    {
        _path = e;
        clear();
    }

    public KmList<KmProfileTrace> getTraces()
    {
        if ( _traces == null )
            _traces = _readTraces();

        return _traces;
    }

    public void setTraces(KmList<KmProfileTrace> e)
    {
        _traces = e;
    }

    public KmProfileTraceNode getTraceNodeRoot()
    {
        if ( _traceNodeRoot == null )
            _traceNodeRoot = _getTraceNodeRoot();

        return _traceNodeRoot;
    }

    public KmList<KmProfileCpu> getCpus()
    {
        if ( _cpus == null )
            _cpus = _readCpus();

        return _cpus;
    }

    public void setCpus(KmList<KmProfileCpu> e)
    {
        _cpus = e;
    }

    public void clear()
    {
        _traces = null;
        _cpus = null;
        _traceNodeRoot = null;
    }

    //##################################################
    //# read (traces)
    //##################################################

    public KmList<KmProfileTrace> _readTraces()
    {
        _openFile();
        _skipHeader();

        while ( !_line.startsWith("TRACE") )
            _readLine();

        KmList<KmProfileTrace> v = new KmList<>();

        while ( _line.startsWith("TRACE") )
            v.add(_readTrace());

        _closeFile();
        return v;
    }

    public KmProfileTrace _readTrace()
    {
        int i1, i2;
        String s;

        i1 = _line.indexOf(' ') + 1;
        i2 = _line.indexOf(':');
        s = _line.substring(i1, i2);
        int traceId = Kmu.parse_int(s);

        i1 = _line.indexOf('=') + 1;
        i2 = _line.indexOf(')');
        s = _line.substring(i1, i2);
        int threadId = Kmu.parse_int(s);

        KmProfileTrace trace;
        trace = new KmProfileTrace();
        trace.setTraceId(traceId);
        trace.setThreadId(threadId);

        while ( true )
        {
            _readLine();
            if ( _line.charAt(0) != '\t' )
                break;

            if ( _line.charAt(1) == '<' )
            {
                _readLine();
                break;
            }

            i1 = 1;
            i2 = _line.indexOf('(');
            String name = _line.substring(i1, i2);

            i1 = _line.indexOf(':') + 1;
            i2 = _line.indexOf(')');
            s = _line.substring(i1, i2);
            int lineNumber = Kmu.parse_int(s, -1);

            trace.addLine(name, lineNumber);
        }
        return trace;
    }

    //##################################################
    //# read (trace nodes)
    //##################################################

    public KmProfileTraceNode _getTraceNodeRoot()
    {
        KmProfileTraceNode root;
        root = new KmProfileTraceNode();
        root.setName("<<System Root>>");

        Iterator<KmProfileTrace> i = getTraces().iterator();
        while ( i.hasNext() )
        {
            KmProfileTrace trace = i.next();
            KmProfileCpu cpu = _findCpuTraceId(trace.getTraceId());
            root.apply(trace, cpu);
        }

        root.fillInStats();
        return root;
    }

    public KmProfileCpu _findCpuTraceId(int id)
    {
        Iterator<KmProfileCpu> i = getCpus().iterator();
        while ( i.hasNext() )
        {
            KmProfileCpu e;
            e = i.next();
            if ( e.getTraceId() == id )
                return e;
        }
        return null;
    }

    public KmList<KmProfileTraceLine> getRootLines()
    {
        KmList<String> names = new KmList<>();
        KmList<KmProfileTraceLine> lines = new KmList<>();

        Iterator<KmProfileTrace> i = getTraces().iterator();
        while ( i.hasNext() )
        {
            KmProfileTrace t = i.next();
            KmProfileTraceLine root = t.getRoot();
            if ( root != null )
            {
                String name = root.getName();
                if ( !names.contains(name) )
                {
                    names.add(name);
                    lines.add(root);
                }
            }
        }
        return lines;
    }

    public void printRoots()
    {
        Iterator<KmProfileTraceLine> i = getRootLines().iterator();
        while ( i.hasNext() )
            System.out.println("    " + i.next().getName());
    }

    //##################################################
    //# read (cpu's)
    //##################################################

    public void readCpus()
    {
        _readCpus();
    }

    public KmList<KmProfileCpu> _readCpus()
    {
        _openFile();
        _skipHeader();
        _cpus = new KmList<>();

        while ( !_line.startsWith("CPU") )
            _readLine();

        _readLine();
        _readLine();

        KmList<KmProfileCpu> v = new KmList<>();

        while ( !_line.startsWith("CPU") )
            v.add(_readCpu());

        _closeFile();
        return v;
    }

    public KmProfileCpu _readCpu()
    {
        String s;
        KmList<String> tokens = Kmu.tokenize(_line, ' ');
        Kmu.removeEmptyValues(tokens);
        Iterator<String> i = tokens.iterator();

        s = i.next();
        int rank = Kmu.parse_int(s);

        s = i.next();
        s = s.substring(0, s.length() - 1);
        double self = Kmu.parse_double(s);

        s = i.next();
        s = s.substring(0, s.length() - 1);
        double accum = Kmu.parse_double(s);

        s = i.next();
        int count = Kmu.parse_int(s);

        s = i.next();
        int traceId = Kmu.parse_int(s);

        KmProfileCpu cpu;
        cpu = new KmProfileCpu();
        cpu.setRank(rank);
        cpu.setSelf(self);
        cpu.setAccumulation(accum);
        cpu.setCount(count);
        cpu.setTraceId(traceId);

        _readLine();
        return cpu;
    }

    //##################################################
    //# read (utility)
    //##################################################

    public void _openFile()
    {
        FileReader in = null;
        try
        {
            _line = null;
            _closeFile();
            in = new FileReader(_path);
            _reader = new BufferedReader(in);
            _readLine();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
        finally
        {
            Kmu.closeSafely(in);
        }
    }

    public void _closeFile()
    {
        try
        {
            if ( _reader != null )
                _reader.close();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
        finally
        {
            _reader = null;
        }
    }

    public void _skipHeader()
    {
        while ( !_line.startsWith("--------") )
            _readLine();
    }

    public void _readLine()
    {
        try
        {
            _line = _reader.readLine();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String args[])
    {
        String path = "java.hprof.txt";
        if ( args.length > 0 )
            path = args[0];

        KmProfileReader pr;
        pr = new KmProfileReader();
        pr.setPath(path);

        System.out.println("Trace count: " + pr.getTraces().size());
        System.out.println("CPU count:   " + pr.getCpus().size());

        System.out.println();
        System.out.println("Roots...");
        pr.printRoots();
        System.out.println();

        KmProfileTraceNode root;
        root = pr.getTraceNodeRoot();

        //        String[] arr = {"java", "sun"};
        root.scaleTo(100);
        root.pruneLeafsWithTotalLessThan(0.1);
        //        root.pruneLeafsStartingWith(arr);
        //        root.collapseAllChainsStartingWith(arr);
        //        root.collapseAllChainsWithTotalLessThan(.05);
        root.sortAllChildren(KmProfileTraceNode.TOTAL_PERCENT_COMPARATOR);

        //        System.out.println("\n\n");
        //        root.printTree();

        openFrameOn(root);
    }

    public static void openFrameOn(KmProfileTraceNode root)
    {
        KmProfileTreeModel m = new KmProfileTreeModel(root);
        JTree t = new JTree(m);
        JScrollPane sp = new JScrollPane(t);

        KmaFrame f;
        f = new KmaFrame();
        f.installSingleComponent(sp);
        f.exitOnClose();
        f.setVisible(true);
    }
}

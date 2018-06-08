package com.kodemore.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.kodemore.collection.KmList;

public class KmFiles
{
    //##################################################
    //# read
    //##################################################

    public static byte[] readBytes(File file)
    {
        return readBytes(file.getPath());
    }

    public static byte[] readBytes(String path)
    {
        try (FileInputStream in = new FileInputStream(path))
        {
            return Kmu.readBytesFrom(in);
        }
        catch ( IOException ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //==================================================
    //= read :: string
    //==================================================

    public static String readString(File f)
    {
        return readString(f.getPath());
    }

    public static String readString(String path)
    {
        return Kmu.bytesToUtf(readBytes(path));
    }

    //==================================================
    //= read :: lines
    //==================================================

    public static KmList<String> readLines(File f)
    {
        return readLines(f.getPath());
    }

    public static KmList<String> readLines(String path)
    {
        String s = readString(path);
        return Kmu.parseLines(s);
    }

    //==================================================
    //= read :: integers
    //==================================================

    /**
     * Read the byte contents of the file into an integer array. Each integer in
     * the array represents one byte from the file. This is often convenient so
     * that the bytes can be processed as having a range of 0..255 instead of
     * -128..127. Exceptions are printed to System.out but are not thrown.
     */
    public static int[] readIntegers(String path)
    {
        byte[] ba = readBytes(path);
        int n = ba.length;
        int[] ia = new int[n];

        for ( int i = 0; i < n; i++ )
        {
            int x = ba[i];
            if ( x < 0 )
                x += 256;
            ia[i] = x;
        }

        return ia;
    }

    //##################################################
    //# write
    //##################################################

    /**
     * Write the byte array to the file.
     */
    public static void writeBytes(File file, byte[] arr)
    {
        writeBytes(file.getPath(), arr);
    }

    /**
     * Write the byte array to the file.
     */
    public static void writeBytes(String path, byte[] arr)
    {
        boolean append = false;
        writeBytes(path, arr, append);
    }

    /**
     * Append the value to a file. Create file if missing.
     */
    public static void appendBytes(String path, byte[] arr)
    {
        boolean append = true;
        writeBytes(path, arr, append);
    }

    /**
     * Write the byte array to the file.
     */
    public static void writeBytes(String path, byte[] arr, boolean append)
    {
        try (FileOutputStream out = new FileOutputStream(path, append))
        {
            Kmu.writeBytesTo(out, arr);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //==================================================
    //= write :: string
    //==================================================

    /**
     * Create or overwrite the contents of a file.
     */
    public static void writeString(String path, CharSequence text)
    {
        boolean append = false;
        writeString(path, text, append);
    }

    /**
     * Append the value to a file. Create the file if missing.
     */
    public static void appendString(String path, CharSequence text)
    {
        boolean append = true;
        writeString(path, text, append);
    }

    /**
     * Create or overwrite the contents of a file.
     */
    public static void writeString(String path, CharSequence text, boolean append)
    {
        byte[] bytes = Kmu.utfToBytes(text.toString());
        writeBytes(path, bytes, append);
    }

    //##################################################
    //# exists
    //##################################################

    public static boolean exists(String path)
    {
        if ( Kmu.isEmpty(path) )
            return false;

        File f = new File(path);
        return f.exists();
    }

    //##################################################
    //# copy
    //##################################################

    /**
     * Copy one file to another, overwriting the target.
     */
    public static void copyToFile(File in, File out)
    {
        writeBytes(out, readBytes(in));
    }

    /**
     * Copy a file to another folder.
     */
    public static void copyToFolder(File in, File folder)
    {
        String name = in.getName();
        File out = new File(folder, name);
        copyToFile(in, out);
    }

    //##################################################
    //# move
    //##################################################

    /**
     * Move a file from one location to another.
     */
    public static boolean moveFile(String oldPath, String newPath)
    {
        File oldFile = new File(oldPath);
        File newFile = new File(newPath);

        return oldFile.renameTo(newFile);
    }

    //##################################################
    //# delete
    //##################################################

    public static boolean deleteFile(String path)
    {
        File f = new File(path);
        return f.delete();
    }

    public static boolean deleteFile(File f)
    {
        return f.delete();
    }

    //##################################################
    //# create folder
    //##################################################

    /**
     * Ensure that the specified path exists. If it does not exist then attempt
     * to create it. Return true if the path was successfully created.  The entire
     * path is assumed to be a directory.
     * Exceptions are printed to System.out but are not thrown.
     */
    public static boolean createFolder(String s)
    {
        File f = new File(s);
        return createFolder(f);
    }

    /**
     * Ensure that the specified path exists. If it does not exist then attempt
     * to create it. Return true if the path was successfully created.
     * The entire path is assumed to be a directory.
     * Exceptions are logged but are not thrown.
     */
    public static boolean createFolder(File f)
    {
        try
        {
            f = f.getCanonicalFile();
            if ( f.exists() )
                return true;

            File p = f.getParentFile();
            if ( !createFolder(p) )
                return false;

            return f.mkdir();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# list
    //##################################################

    public static KmList<String> getFolderList(File folder)
    {
        String[] arr = folder.list();
        return arr == null
            ? KmList.createEmpty()
            : KmList.createWith(arr);
    }

}

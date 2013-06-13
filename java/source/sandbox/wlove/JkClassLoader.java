package sandbox.wlove;

import com.kodemore.utility.Kmu;

public class JkClassLoader
    extends ClassLoader
{
    public Class<?> myDefineClass(String path)
    {
        byte[] bytes = Kmu.readByteFile(path);
        return myDefineClass(bytes);
    }

    @SuppressWarnings("deprecation")
    public Class<?> myDefineClass(byte[] bytes)
    {
        Class<?> c = defineClass(bytes, 0, bytes.length);
        resolveClass(c);
        return c;
    }
}

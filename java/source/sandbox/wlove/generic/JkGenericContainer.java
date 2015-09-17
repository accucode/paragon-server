package sandbox.wlove.generic;

public class JkGenericContainer<K extends JkGenericPolicy>
{
    public K getPolicy()
    {
        return null;
    }

    public JkGenericCss getCss()
    {
        return getPolicy().getCss();
    }
}

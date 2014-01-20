package sandbox.wlove;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;

import com.kodemore.utility.Kmu;

@SuppressWarnings("deprecation")
public class JkSolve360Test
{
    public void run() throws Exception
    {
        String host = "secure.solve360.com";
        String path = "contacts";

        String user = "wlove@accucode.com";
        String password = "BemaY7A9w34ei7lb1bMff6Xd=3c3G3B5Xfe6u4wf";

        String url = "https://" + host + "/" + path;
        AuthScope authScope = new AuthScope(host, 443);
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials(user, password);

        DefaultHttpClient client;
        client = new DefaultHttpClient();
        client.getCredentialsProvider().setCredentials(authScope, creds);

        HttpGet get;
        get = new HttpGet(url);

        System.out.println(get.getRequestLine());

        HttpResponse response;
        response = client.execute(get);

        dumpResponse(response);

        // finish, and release any resources.
        response.getEntity().consumeContent();

        ClientConnectionManager mgr;
        mgr = client.getConnectionManager();
        mgr.shutdown();
        client.close();
    }

    public void dumpResponse(HttpResponse response) throws Exception
    {
        StatusLine status = response.getStatusLine();
        System.out.println(status);
        if ( status.getStatusCode() != 200 )
            return;

        HttpEntity entity = response.getEntity();
        if ( entity == null )
        {
            System.out.println("No response entity");
            return;
        }

        String s = Kmu.readStringFrom(entity.getContent());

        System.out.println("\n\n" + s);
        Kmu.writeFile("/temp/out.txt", s);
        Kmu.writeFile("/temp/out.xml", s);
    }

    public static void main(String[] args) throws Exception
    {
        new JkSolve360Test().run();
    }

}

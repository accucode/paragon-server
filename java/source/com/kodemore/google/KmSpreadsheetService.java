package com.kodemore.google;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gdata.client.spreadsheet.FeedURLFactory;
import com.google.gdata.client.spreadsheet.SpreadsheetQuery;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;

import com.kodemore.collection.KmList;
import com.kodemore.utility.Kmu;

/**
 * I wrap the Google Sheets service to provide access to spreadsheets.
 * This implementation currently requires the use of an OAuth Service Account.
 *
 * Also, this wrapper requires the use of a p12 key file, since the newer JSON
 * files are not well supported by the Google Client libraries.  Convenience
 * methods allow the client to easily provide the p12 file via the file system,
 * classpath resource, or input stream.
 *
 * For an example of typical usage,
 * @see KmSpreadsheetFrameworkTest
 */
public class KmSpreadsheetService
{
    //##################################################
    //# constants
    //##################################################

    public static final String DEFAULT_APP_NAME = "NOT USED";

    //##################################################
    //# variables
    //##################################################

    private String             _accountId;
    private PrivateKey         _privateKey;
    private String             _appName;

    private GoogleCredential   _credentials;

    private SpreadsheetService _service;

    //##################################################
    //# constructor
    //##################################################

    public KmSpreadsheetService()
    {
        _appName = DEFAULT_APP_NAME;
    }

    //##################################################
    //# accessing
    //##################################################

    public String getAccountId()
    {
        return _accountId;
    }

    public void setAccountId(String e)
    {
        _accountId = e;
    }

    public String getAppName()
    {
        return _appName;
    }

    public void setAppName(String e)
    {
        _appName = e;
    }

    //##################################################
    //# p12 private key
    //##################################################

    public void setP12FromFile(File file)
    {
        try (InputStream is = new FileInputStream(file))
        {
            setP12FromStream(is);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void setP12FromFile(String path)
    {
        try (InputStream is = new FileInputStream(path))
        {
            setP12FromStream(is);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void setP12FromResource(Class<?> clazz, String path)
    {
        try (InputStream is = clazz.getResourceAsStream(path))
        {
            setP12FromStream(is);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    public void setP12FromStream(InputStream is)
    {
        try
        {
            char[] p12Password = "notasecret".toCharArray();
            String p12KeyAlias = "privatekey";

            KeyStore keystore;
            keystore = KeyStore.getInstance("PKCS12");
            keystore.load(is, p12Password);

            _privateKey = (PrivateKey)keystore.getKey(p12KeyAlias, p12Password);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# credentials
    //##################################################

    private GoogleCredential getCredentials()
    {
        if ( _credentials == null )
            _credentials = createCredentials();

        return _credentials;
    }

    private GoogleCredential createCredentials()
    {
        try
        {
            HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            JsonFactory jsonFactory = new JacksonFactory();

            List<String> scopes;
            scopes = new ArrayList<>();
            scopes.add("https://docs.google.com/feeds");
            scopes.add("https://spreadsheets.google.com/feeds");
            scopes.add("https://spreadsheets.google.com/feeds/spreadsheets/private/basic");

            GoogleCredential.Builder b;
            b = new GoogleCredential.Builder();
            b.setTransport(httpTransport);
            b.setJsonFactory(jsonFactory);
            b.setServiceAccountId(getAccountId());
            b.setServiceAccountPrivateKey(_privateKey);
            b.setServiceAccountScopes(scopes);
            return b.build();
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    //##################################################
    //# service
    //##################################################

    private SpreadsheetService getService()
    {
        if ( _service == null )
            _service = createService();

        return _service;
    }

    private SpreadsheetService createService()
    {
        SpreadsheetService e;
        e = new SpreadsheetService(getAppName());
        e.setOAuth2Credentials(getCredentials());
        return e;
    }

    //##################################################
    //# find
    //##################################################

    /**
     * Find all available documents that exactly match the title.
     */
    public KmList<KmSpreadsheetDoc> findDoc(String title)
    {
        try
        {
            FeedURLFactory factory = FeedURLFactory.getDefault();
            URL url = factory.getSpreadsheetsFeedUrl();

            SpreadsheetQuery q;
            q = new SpreadsheetQuery(url);
            q.setTitleQuery(title);
            q.setTitleExact(true);

            Class<SpreadsheetFeed> clazz = SpreadsheetFeed.class;
            SpreadsheetFeed feed = getService().getFeed(q, clazz);
            List<SpreadsheetEntry> entries = feed.getEntries();
            return KmSpreadsheetDoc.wrap(entries);
        }
        catch ( Exception ex )
        {
            throw Kmu.toRuntime(ex);
        }
    }

    /**
     * Find all available documents that exactly match the title.
     * Throw an exception if no match is found.
     * Throw an exception if multiple matches are found.
     */
    public KmSpreadsheetDoc findUniqueDoc(String title)
    {
        KmList<KmSpreadsheetDoc> v = findDoc(title);

        if ( v.isEmpty() )
            return null;

        if ( v.isMultiple() )
            throw Kmu.newFatal("Spreadsheet doc is ambiguous: %s.", title);

        return v.getFirst();
    }
}

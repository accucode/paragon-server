package com.kodemore.google;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.gdata.client.spreadsheet.CellQuery;
import com.google.gdata.client.spreadsheet.FeedURLFactory;
import com.google.gdata.client.spreadsheet.SpreadsheetQuery;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.client.spreadsheet.WorksheetQuery;
import com.google.gdata.data.Link;
import com.google.gdata.data.spreadsheet.CellEntry;
import com.google.gdata.data.spreadsheet.CellFeed;
import com.google.gdata.data.spreadsheet.SpreadsheetEntry;
import com.google.gdata.data.spreadsheet.SpreadsheetFeed;
import com.google.gdata.data.spreadsheet.WorksheetEntry;
import com.google.gdata.data.spreadsheet.WorksheetFeed;

/**
 * This is a sample of using the Spreadsheet API with an OAuth2 Service Account.
 * This demonstrates basic authentication and access using Google's API.
 *
 * For an example of simplified usage based on the Km utility classes...
 * @see KmSpreadsheetFrameworkTest
 *
 * Since this sample relies on external OAuth2 authentication, it will likely
 * NOT work out of the box.  However, it should be easy to setup to setup
 * a service account and spreadsheet so that it does work based on the following
 * instructions.
 *
 * Google's overview is here...
 * https://developers.google.com/google-apps/spreadsheets/
 *
 * STEP 1 - Create a project
 *      Go to the Google Developers Console
 *      https://console.developers.google.com
 *      Create a new project.
 *
 * STEP 2 - Create a Service Account
 *      Go to... Enable and manage APIs.
 *      Go to... Credentials
 *      Add credentials > Service Account
 *      Select the P12 Key Type (JSON isn't supported by the client libraries yet).
 *      SAVE the .p12 key file that is downloaded - this is your only copy.
 *
 * STEP 3 - Update the constants below to match your Service Account.
 *
 * STEP 4 - Run the application.
 */
public class KmSpreadsheetApiTest
{
    //##################################################
    //# constants
    //##################################################

    /**
     * The p12 file that defines the security tokens and private keys.
     * This is the .P12 file downloaded when you create the Service Account.
     */
    private static final String P12_PATH          = "/temp/LifeCycle-eaf2070c1aa2.p12";

    /**
     * The account id.  This is the email address associated with the Service Account.
     * To share a spreadsheet with this Service Account, you manage sharing the same
     * as for any other user.  Simply open the spreadsheet, and Share it with this
     * email.
     */
    private static final String ACCOUNT_ID        = "732718102431-p6ssejt62n8pdf4appin6cd8rk0l8he9@developer.gserviceaccount.com";

    /**
     * The name used by the client library.  The purpose of this value is unclear,
     * and it doesn't seem to matter what you use.  This value does not need to match
     * any of the credentials or keys.  It does not need to match the project name
     * created in the developer console.
     */
    private static final String APP_NAME          = "NOT USED";

    /**
     * The title of the spreadsheet to be read.
     * This is the human readable title displayed in Google Drive,
     * and at the top of the spreadsheet when you open it.
     */
    // private static final String SPREADSHEET_TITLE = "Purchasing Activity Log 2015";
    private static final String SPREADSHEET_TITLE = "PAL - Purchasing Activity Log 2015 (COPY)";

    /**
     * The title of the worksheet (tab) to be read.
     * This is the human readable title displayed on the worksheet tab
     * within the spreadsheet.
     */
    private static final String WORKSHEET_TITLE   = "Activity Log";

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args) throws Exception
    {
        new KmSpreadsheetApiTest().run();
    }

    //##################################################
    //# variables
    //##################################################

    /**
     * The Google wrapper for OAuth2 credentials.
     */
    private GoogleCredential   _credentials;

    /**
     * The Google wrapper for accessing spreadsheet data.
     */
    private SpreadsheetService _service;

    private SpreadsheetEntry   _spreadsheet;

    private WorksheetEntry     _worksheet;

    //##################################################
    //# run
    //##################################################

    private void run() throws Exception
    {
        printSetup();
        installCredentials();
        installService();

        installSpreadsheet();
        installWorksheet();

        printFirstCells(3);
        // printRowCells(3);
        // printAllCells();

        System.out.println("ok.");
    }

    private void printSetup()
    {
        System.out.println("Test Google Spreadsheet");
    }

    //##################################################
    //# install
    //##################################################

    private void installCredentials() throws Exception
    {
        System.out.println("Install credentials...");
        System.out.println("    account id: " + ACCOUNT_ID);
        System.out.println("    p12 path:   " + P12_PATH);

        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        JsonFactory jsonFactory = new JacksonFactory();

        Collection<String> scopes;
        scopes = new ArrayList<>();
        scopes.add("https://docs.google.com/feeds");
        scopes.add("https://spreadsheets.google.com/feeds");
        scopes.add("https://spreadsheets.google.com/feeds/spreadsheets/private/basic");

        InputStream p12Stream;
        p12Stream = new FileInputStream(P12_PATH);
        // p12Stream = this.getClass().getResourceAsStream("Credentials.p12");

        String p12Password = "notasecret";
        String privateKeyAlias = "privatekey";

        KeyStore keystore;
        keystore = KeyStore.getInstance("PKCS12");
        keystore.load(p12Stream, p12Password.toCharArray());

        PrivateKey privateKey;
        privateKey = (PrivateKey)keystore.getKey(privateKeyAlias, p12Password.toCharArray());

        GoogleCredential.Builder b;
        b = new GoogleCredential.Builder();
        b.setTransport(httpTransport);
        b.setJsonFactory(jsonFactory);
        b.setServiceAccountId(ACCOUNT_ID);
        b.setServiceAccountPrivateKey(privateKey);
        b.setServiceAccountScopes(scopes);

        _credentials = b.build();
    }

    private void installService() throws Exception
    {
        System.out.println("Install service...");
        System.out.println("    app name: " + APP_NAME);

        SpreadsheetService e;
        e = new SpreadsheetService(APP_NAME);
        e.setOAuth2Credentials(_credentials);

        _service = e;
    }

    //##################################################
    //# doc
    //##################################################

    private void installSpreadsheet() throws Exception
    {
        System.out.println("Install spreadsheet...");
        System.out.println("    find:       " + SPREADSHEET_TITLE);

        String title = SPREADSHEET_TITLE;
        List<SpreadsheetEntry> v = findSpreadsheet(title);

        if ( v.size() == 0 )
            throw new RuntimeException("Spreadsheet not found: " + title);

        if ( v.size() >= 2 )
            throw new RuntimeException("Spreadsheet found multiple: " + title);

        SpreadsheetEntry e = v.get(0);
        String key = e.getKey();
        String browserUrl = "http://spreadsheets.google.com/ccc?key=" + key;

        System.out.println("    title:      " + e.getTitle().getPlainText());
        System.out.println("    id:         " + e.getId());
        System.out.println("    key:        " + key);
        System.out.println("    url:        " + browserUrl);
        System.out.println("    self link:  " + format(e.getSelfLink()));
        System.out.println("    edit link:  " + format(e.getEditLink()));

        _spreadsheet = e;
    }

    private List<SpreadsheetEntry> findSpreadsheet(String title) throws Exception
    {
        FeedURLFactory factory = FeedURLFactory.getDefault();
        URL url = factory.getSpreadsheetsFeedUrl();

        SpreadsheetQuery q;
        q = new SpreadsheetQuery(url);
        q.setTitleQuery(title);
        q.setTitleExact(true);

        Class<SpreadsheetFeed> clazz = SpreadsheetFeed.class;
        SpreadsheetFeed feed = _service.getFeed(q, clazz);
        return feed.getEntries();
    }

    private void installWorksheet() throws Exception
    {
        System.out.println("Install worksheet...");
        System.out.println("    find:       " + WORKSHEET_TITLE);

        String title = WORKSHEET_TITLE;
        List<WorksheetEntry> v = findWorksheet(title);

        if ( v.size() == 0 )
            throw new RuntimeException("Worksheet not found: " + title);

        if ( v.size() >= 2 )
            throw new RuntimeException("Worksheet found multiple: " + title);

        WorksheetEntry e = v.get(0);

        System.out.println("    title:      " + e.getTitle().getPlainText());
        System.out.println("    id:         " + e.getId());
        System.out.println("    rows:       " + e.getRowCount());
        System.out.println("    columns:    " + e.getColCount());
        System.out.println("    self link:  " + format(e.getSelfLink()));
        System.out.println("    edit link:  " + format(e.getEditLink()));

        _worksheet = e;
    }

    private List<WorksheetEntry> findWorksheet(String title) throws Exception
    {
        URL url = _spreadsheet.getWorksheetFeedUrl();

        WorksheetQuery q;
        q = new WorksheetQuery(url);
        q.setTitleQuery(title);
        q.setTitleExact(true);

        Class<WorksheetFeed> clazz = WorksheetFeed.class;
        WorksheetFeed feed = _spreadsheet.getService().getFeed(q, clazz);
        return feed.getEntries();
    }

    //##################################################
    //# print cells
    //##################################################

    protected void printFirstCells(int n) throws Exception
    {
        System.out.println("Print first (non-empty) cells...");

        URL url = _worksheet.getCellFeedUrl();

        CellQuery q;
        q = new CellQuery(url);
        q.setMaxResults(n);
        q.setReturnEmpty(false);

        CellFeed feed = _worksheet.getService().getFeed(q, CellFeed.class);
        List<CellEntry> v = feed.getEntries();

        printCells(v);
    }

    protected void printAllCells() throws Exception
    {
        System.out.println("Print all (non-empty) cells...");

        URL url = _worksheet.getCellFeedUrl();
        CellFeed feed = _worksheet.getService().getFeed(url, CellFeed.class);
        List<CellEntry> v = feed.getEntries();

        printCells(v);
    }

    protected void printRowCells(int row) throws Exception
    {
        System.out.println("Print all (non-empty) cells in row...");

        URL url = _worksheet.getCellFeedUrl();

        CellQuery q;
        q = new CellQuery(url);
        q.setMinimumRow(row);
        q.setMaximumRow(row);

        CellFeed feed = _worksheet.getService().getFeed(q, CellFeed.class);
        List<CellEntry> v = feed.getEntries();

        printCells(v);
    }

    private void printCells(List<CellEntry> v)
    {
        for ( CellEntry e : v )
            printCell(e);
    }

    private void printCell(CellEntry e)
    {
        System.out.printf(
            "    %s (%s,%s) = %s%n",
            e.getTitle().getPlainText(),
            e.getCell().getCol(),
            e.getCell().getRow(),
            e.getCell().getValue());
    }

    //##################################################
    //# support
    //##################################################

    private String format(Link e)
    {
        return e == null
            ? null
            : e.getHref();
    }

}

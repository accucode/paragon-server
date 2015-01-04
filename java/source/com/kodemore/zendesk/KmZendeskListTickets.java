package com.kodemore.zendesk;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import com.kodemore.collection.KmList;
import com.kodemore.io.KmIndentPrintWriter;
import com.kodemore.json.KmJsonArray;
import com.kodemore.json.KmJsonMap;

/**
 * I am used list all tickets
 *
 * Api documentation
 *      http://developer.zendesk.com/documentation/rest_api/tickets.html
 */

public class KmZendeskListTickets
{
    //##################################################
    //# variables
    //##################################################

    private KmZendeskConnection _connection;
    private String              _userId;
    private String              _apiToken;

    //##################################################
    //# constructor
    //##################################################

    public KmZendeskListTickets()
    {
    }

    //##################################################
    //# connection
    //##################################################

    public void resetConnection()
    {

        _connection = new KmZendeskConnection();
        _connection.setPath("/api/v2/tickets.json");
        _connection.setUserId(_userId);
        _connection.setApiToken(_apiToken);

    }

    private void resetConnection(String uri)
    {
        URI u;

        try
        {
            u = new URI(uri);
            _connection = new KmZendeskConnection();
            _connection.setUserId(_userId);
            _connection.setApiToken(_apiToken);
            _connection.setHost(u.getHost());
            _connection.setPath(u.getPath());
            setConnectionParameters(u);

        }
        catch ( URISyntaxException ex )
        {
            ex.printStackTrace();
        }
    }

    private void setConnectionParameters(URI u)
    {
        List<NameValuePair> decode = URLEncodedUtils.parse(u, "UTF-8");

        for ( NameValuePair nameValuePair : decode )
            _connection.setParameter(nameValuePair.getName(), nameValuePair.getValue());
    }

    //##################################################
    //# accessing
    //##################################################

    protected KmZendeskConnection getConnection()
    {
        return _connection;
    }

    //##################################################
    //# authentication
    //##################################################
    public void setZendeskUserid(String s)
    {
        _userId = s;

    }

    public void setApiToken(String s)
    {
        _apiToken = s;

    }

    //##################################################
    //# response
    //##################################################

    protected KmJsonMap getResponseJson()
    {
        return getConnection().getResponseJsonMap();
    }

    public String getResponseString()
    {
        return getConnection().getResponseString();
    }

    //##################################################
    //# submit
    //##################################################

    protected void submit()
    {
        getConnection().submitGet();
    }

    //##################################################
    //# tickets
    //##################################################
    public KmList<KmZendeskTicket> getAllTickets()
    {
        resetConnection();
        KmList<KmZendeskTicket> v = new KmList<>();

        while ( true )
        {
            submit();

            processTickets(v);

            if ( !hasNextPage() )
                return v;

            resetConnection(getNextPageUrl());

        }
    }

    private void processTickets(KmList<KmZendeskTicket> v)
    {
        KmJsonArray tickets = getTickets();
        if ( tickets == null )
            return;

        int n = tickets.size();
        for ( int i = 0; i < n; i++ )
            v.add(createTicket(tickets.getMapAt(i)));
    }

    private KmJsonArray getTickets()
    {
        return getResponseJson().getArray("tickets");
    }

    private String getNextPageUrl()
    {
        return getResponseJson().getString("next_page");
    }

    private boolean hasNextPage()
    {
        return getNextPageUrl() != null;

    }

    //##################################################
    //# create
    //##################################################

    private KmZendeskTicket createTicket(KmJsonMap e)
    {
        KmZendeskTicket t = new KmZendeskTicket();

        t.setId(e.getInteger("id"));
        t.setUrl(e.getString("url"));
        t.setExternalId(e.getInteger("external_id"));
        t.setType(e.getString("type"));
        t.setSubject(e.getString("subject"));
        t.setDescription(e.getString("description"));
        t.setPriority(e.getString("priority"));
        t.setStatus(e.getString("status"));
        t.setRecipient(e.getString("recipient"));
        t.setRequesterId(e.getInteger("requester_id"));
        t.setSubmitterId(e.getInteger("submitter_id"));
        t.setAssigneeId(e.getInteger("assignee_id"));
        t.setOrganizationId(e.getInteger("organization_id"));
        t.setGroupId(e.getInteger("group_id"));
        t.setCollaboratorIds(getIntegerList(e.getArray("collaborator_ids")));
        t.setForumTopicId(e.getInteger("forum_topic_id"));
        t.setProblemId(e.getInteger("problem_id"));
        t.setHasIncidents(e.getBoolean("has_incidents"));
        t.setDueAt(e.getString("due_at"));
        t.setTags(getStringList(e.getArray("tags")));
        t.setVia(getVia(e.getMap("via")));
        t.setCustomFields(getCustomFields(e.getArray("custom_fields")));
        t.setSatisfactionRatings(getSatisfactionRating(e.getMap("satisfaction_rating")));
        t.setSharingAgreementIds(getIntegerList(e.getArray("sharing_agreement_ids")));
        t.setFollowUpIds(getIntegerList(e.getArray("followup_ids")));
        t.setTicketFormId(e.getInteger("ticket_form_id"));
        t.setCreatedAt(e.getString("created_at"));
        t.setUpdatedAt(e.getString("updated_at"));

        return t;
    }

    private KmZendeskVia getVia(KmJsonMap map)
    {
        KmZendeskVia e = new KmZendeskVia();
        e.setChannel(map.getString("channel"));
        e.setSource(map.getMap("source"));
        return e;
    }

    private KmZendeskSatisfactionRating getSatisfactionRating(KmJsonMap map)
    {
        KmZendeskSatisfactionRating e = new KmZendeskSatisfactionRating();

        if ( map == null )
            return null;

        e.setId(map.getInteger("id"));
        e.setUrl(map.getString("url"));
        e.setAssigneeId(map.getInteger("asignee_id"));
        e.setGroupId(map.getInteger("group_id"));
        e.setRequesterId(map.getInteger("requester_id"));
        e.setTicketId(map.getInteger("ticket_id"));
        e.setScore(map.getString("score"));
        e.setCreatedAt(map.getString("created_at"));
        e.setUpdatedAt(map.getString("updated_at"));
        e.setComment(map.getString("comment"));

        return e;
    }

    private KmList<KmZendeskCustomField> getCustomFields(KmJsonArray array)
    {
        KmList<KmZendeskCustomField> v = new KmList<>();
        int n = array.size();
        for ( int i = 0; i < n; i++ )
        {
            KmZendeskCustomField via = new KmZendeskCustomField();
            KmJsonMap map = array.getMapAt(i);
            via.setId(map.getInteger("id"));
            via.setValue(map.getString("value"));
        }
        return v;
    }

    private KmList<Integer> getIntegerList(KmJsonArray array)
    {
        KmList<Integer> v = new KmList<>();
        if ( array == null )
            return v;
        int n = array.size();
        for ( int i = 0; i < n; i++ )
            v.add(array.getIntegerAt(i));
        return v;
    }

    private KmList<String> getStringList(KmJsonArray array)
    {
        KmList<String> v = new KmList<>();
        if ( array == null )
            return v;
        int n = array.size();
        for ( int i = 0; i < n; i++ )
            v.add(array.getStringAt(i));
        return v;
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        KmZendeskListTickets req;
        req = new KmZendeskListTickets();

        // You need to enter valid keys...
        req.setZendeskUserid("[zendesk Login]");
        req.setApiToken("[API Token]");

        KmList<KmZendeskTicket> v = req.getAllTickets();

        System.out.println("Total Number of Tickets: " + v.size());

        try ( KmIndentPrintWriter out = new KmIndentPrintWriter(System.out) )
        {
            int n = 1;
            for ( KmZendeskTicket ticket : v )
            {
                out.println("-----------------------------------------------------");
                out.println("Ticket # " + n);
                out.println("-----------------------------------------------------");
                out.indent();
                ticket.print(out);
                out.println();
                out.undent();
                out.println();
                n++;
            }
            out.flush();
        }
    }
}

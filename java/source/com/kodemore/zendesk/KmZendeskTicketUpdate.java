package com.kodemore.zendesk;

import com.kodemore.json.KmJsonMap;

public class KmZendeskTicketUpdate
{

    //##################################################
    //# variables 
    //##################################################

    private KmZendeskConnection _connection;

    //##################################################
    //# constructor
    //##################################################

    public KmZendeskTicketUpdate()
    {
        _connection = new KmZendeskConnection();
        _connection.setPath("/api/v2/tickets");

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
        _connection.setUserId(s);

    }

    public void setApiToken(String s)
    {
        _connection.setApiToken(s);
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
        getConnection().submitPost();
    }

    //##################################################
    //# tickets
    private void submitComment(String id, String comment)
    {
        getConnection().setPath("/api/v2/tickets/" + id + ".json");
        KmJsonMap m = createTicket(id, comment);

        getConnection().setData(m.formatJson());
        getConnection().submitPut();
    }

    private KmJsonMap createTicket(String id, String s)
    {
        KmJsonMap m = new KmJsonMap();
        KmJsonMap ticket = new KmJsonMap();

        //requester
        KmJsonMap requester = new KmJsonMap();
        requester.setString("id", id);

        KmJsonMap comment = new KmJsonMap();
        comment.setString("public", "true");
        comment.setString("body", s);
        ticket.setObject("comment", comment);

        m.setObject("ticket", ticket);

        return m;
    }

    //##################################################
    //# main
    //##################################################

    public static void main(String[] args)
    {
        KmZendeskTicketUpdate req;
        req = new KmZendeskTicketUpdate();

        // You need to enter valid keys...
        req.setZendeskUserid("[zendesk Login]");
        req.setApiToken("[API Token]");

        req.submitComment("189", "Just a comment");

        System.out.println("Ticket Updated!");
    }

}

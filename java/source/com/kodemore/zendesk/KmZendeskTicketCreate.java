package com.kodemore.zendesk;

import com.kodemore.json.*;

public class KmZendeskTicketCreate
{

    //##################################################
    //# variables 
    //##################################################

    private KmZendeskConnection _connection;

    //##################################################
    //# constructor
    //##################################################

    public KmZendeskTicketCreate()
    {
        _connection = new KmZendeskConnection();
        _connection.setPath("/api/v2/tickets.json");

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
    //##################################################//
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
    //##################################################//

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
    //##################################################//

    protected void submit()
    {
        getConnection().submitPost();
    }

    //##################################################
    //# tickets
    //##################################################//
    public Integer submitNewTicket(String name, String email, String subject, String body)
    {
        KmJsonMap m = createTicket(name, email, subject, body);
        getConnection().setData(m.formatJson());
        getConnection().submitPost();

        String resp = getConnection().getResponseString();
        KmJsonMap map = KmJsonReader.parseJsonMap(resp);

        return getNewTicketId(map);

    }

    private Integer getNewTicketId(KmJsonMap map)
    {
        KmJsonMap ticket = map.getMap("ticket");
        return ticket.getInteger("id");
    }

    private KmJsonMap createTicket(String name, String email, String subject, String body)
    {
        KmJsonMap m = new KmJsonMap();
        KmJsonMap ticket = new KmJsonMap();

        //requester 
        KmJsonMap requester = new KmJsonMap();
        requester.setString("name", name);
        requester.setString("email", email);
        ticket.setObject("requester", requester);

        //subject
        ticket.setObject("subject", subject);

        //comment
        KmJsonMap comment = new KmJsonMap();
        comment.setString("body", body);
        ticket.setObject("comment", comment);

        m.setObject("ticket", ticket);

        return m;
    }

    //##################################################
    //# main
    //##################################################//

    public static void main(String[] args)
    {
        KmZendeskTicketCreate req;
        req = new KmZendeskTicketCreate();

        // You need to enter valid keys...
        req.setZendeskUserid("[zendesk Login]");
        req.setApiToken("[API Token]");

        Integer i = req.submitNewTicket(
            "The Customer",
            "thecustomer@domaion.com",
            "My printer is on fire!",
            "The smoke is very colorful.");

        System.out.println("New Ticket Id = " + i);
    }
}

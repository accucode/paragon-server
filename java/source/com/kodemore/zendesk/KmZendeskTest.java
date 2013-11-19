package com.kodemore.zendesk;

import com.kodemore.collection.*;
import com.kodemore.io.*;

/**
 * I am used connect to Zendesk make various requests.
 * 
 * Zendesk uses Basic REST authentication
 * 
 * You will need to do the following to use this class:
 *      1.  Sign up for a Zendesk account.
 *      2.  Visit {domain}.zendesk.com and sign in as your user.
 *      3.  Get an API token from the Channels / API page.
 *      5.  Update the main method with the token and screts from the previous step.
 */
public class KmZendeskTest
{
    public static void main(String[] args)
    {
        KmZendeskListTickets req;
        req = new KmZendeskListTickets();

        // You need to enter valid keys...
        req.setZendeskUserid("");
        req.setApiToken("");

        KmList<KmZendeskTicket> v = req.getAllTickets();

        System.out.println("Total Number of Tickets: " + v.size());

        KmIndentPrintWriter out = new KmIndentPrintWriter(System.out);
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

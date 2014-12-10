package com.kodemore.zendesk;

public class KmZendeskSatisfactionRating
{

    /**
     * I am a satisfaction rating
     * 
     * Api documentation
     *     http://developer.zendesk.com/documentation/rest_api/satisfaction_ratings.html
     */

    //##################################################
    //# private
    //##################################################

    private Integer _id;
    private Integer _assigneeId;
    private Integer _groupId;
    private Integer _requesterId;
    private Integer _ticketId;

    private String  _url;
    private String  _score;
    private String  _createdAt;
    private String  _updatedAt;
    private String  _comment;

    //##################################################
    //# accessing
    //##################################################

    public Integer getId()
    {
        return _id;
    }

    public void setId(Integer id)
    {
        _id = id;
    }

    public Integer getAssigneeId()
    {
        return _assigneeId;
    }

    public void setAssigneeId(Integer assigneeId)
    {
        _assigneeId = assigneeId;
    }

    public Integer getGroupId()
    {
        return _groupId;
    }

    public void setGroupId(Integer groupId)
    {
        _groupId = groupId;
    }

    public Integer getRequesterId()
    {
        return _requesterId;
    }

    public void setRequesterId(Integer requesterId)
    {
        _requesterId = requesterId;
    }

    public Integer getTicketId()
    {
        return _ticketId;
    }

    public void setTicketId(Integer ticketId)
    {
        _ticketId = ticketId;
    }

    public String getUrl()
    {
        return _url;
    }

    public void setUrl(String url)
    {
        _url = url;
    }

    public String getScore()
    {
        return _score;
    }

    public void setScore(String score)
    {
        _score = score;
    }

    public String getCreatedAt()
    {
        return _createdAt;
    }

    public void setCreatedAt(String createdAt)
    {
        _createdAt = createdAt;
    }

    public String getUpdatedAt()
    {
        return _updatedAt;
    }

    public void setUpdatedAt(String updatedAt)
    {
        _updatedAt = updatedAt;
    }

    public String getComment()
    {
        return _comment;
    }

    public void setComment(String comment)
    {
        _comment = comment;
    }

}

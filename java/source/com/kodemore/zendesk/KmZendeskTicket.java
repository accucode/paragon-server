package com.kodemore.zendesk;

import com.kodemore.collection.KmList;
import com.kodemore.io.KmPrintWriter;
import com.kodemore.json.KmJsonMap;

/**
 * I am a ticket object
 * 
 * Api documentation
 *      http://developer.zendesk.com/documentation/rest_api/tickets.html
 */

public class KmZendeskTicket
    extends Object
{
    //##################################################
    //# variables (public)
    //##################################################

    private String                       _url;
    private String                       _type;
    private String                       _subject;
    private String                       _description;
    private String                       _priority;
    private String                       _status;
    private String                       _recipient;

    private Integer                      _id;
    private Integer                      _externalId;
    private Integer                      _requesterId;
    private Integer                      _submitterId;
    private Integer                      _assigneeId;
    private Integer                      _organizationId;
    private Integer                      _groupId;
    private Integer                      _forumTopicId;
    private Integer                      _problemId;
    private Integer                      _ticketFormId;

    private KmZendeskVia                 _via;
    private KmZendeskSatisfactionRating  _satisfactionRating;

    private KmList<Integer>              _collaboratorIds;
    private KmList<String>               _tags;
    private KmList<KmZendeskCustomField> _customFields;
    private KmList<Integer>              _sharingAgreementIds;
    private KmList<Integer>              _followupIds;

    private Boolean                      _hasIncidents;

    private String                       _dueAt;
    private String                       _createdAt;
    private String                       _updatedAt;

    //##################################################
    //# accessing
    //##################################################//

    public Integer getTicketFormId()
    {
        return _ticketFormId;
    }

    public void setTicketFormId(Integer ticketFormId)
    {
        _ticketFormId = ticketFormId;
    }

    public Integer getId()
    {
        return _id;
    }

    public void setId(Integer id)
    {
        _id = id;
    }

    public String getUrl()
    {
        return _url;
    }

    public void setUrl(String url)
    {
        _url = url;
    }

    public Integer getExternalId()
    {
        return _externalId;
    }

    public void setExternalId(Integer integer)
    {
        _externalId = integer;
    }

    public String getType()
    {
        return _type;
    }

    public void setType(String type)
    {
        _type = type;
    }

    public String getSubject()
    {
        return _subject;
    }

    public void setSubject(String subject)
    {
        _subject = subject;
    }

    public String getDescription()
    {
        return _description;
    }

    public void setDescription(String description)
    {
        _description = description;
    }

    public String getPriority()
    {
        return _priority;
    }

    public void setPriority(String priority)
    {
        _priority = priority;
    }

    public String getStatus()
    {
        return _status;
    }

    public void setStatus(String status)
    {
        _status = status;
    }

    public String getRecipient()
    {
        return _recipient;
    }

    public void setRecipient(String recipient)
    {
        _recipient = recipient;
    }

    public Integer getRequesterId()
    {
        return _requesterId;
    }

    public void setRequesterId(Integer requesterId)
    {
        _requesterId = requesterId;
    }

    public Integer getSubmitterId()
    {
        return _submitterId;
    }

    public void setSubmitterId(Integer submitterId)
    {
        _submitterId = submitterId;
    }

    public Integer getAssigneeId()
    {
        return _assigneeId;
    }

    public void setAssigneeId(Integer assigneeId)
    {
        _assigneeId = assigneeId;
    }

    public Integer getOrganizationId()
    {
        return _organizationId;
    }

    public void setOrganizationId(Integer organizationId)
    {
        _organizationId = organizationId;
    }

    public Integer getGroupId()
    {
        return _groupId;
    }

    public void setGroupId(Integer groupId)
    {
        _groupId = groupId;
    }

    public Integer getForumTopicId()
    {
        return _forumTopicId;
    }

    public void setForumTopicId(Integer forumTopicId)
    {
        _forumTopicId = forumTopicId;
    }

    public Integer getProblemId()
    {
        return _problemId;
    }

    public void setProblemId(Integer problemId)
    {
        _problemId = problemId;
    }

    public Boolean getHasIncidents()
    {
        return _hasIncidents;
    }

    public void setHasIncidents(Boolean hasIncidents)
    {
        _hasIncidents = hasIncidents;

    }

    public String getDueAt()
    {
        return _dueAt;
    }

    public void setDueAt(String dueAt)
    {
        _dueAt = dueAt;
    }

    public String getCreatedAt()
    {
        return _createdAt;
    }

    public void setCreatedAt(String createdAt)
    {
        createdAt = _createdAt;
    }

    public String getUpdatedAt()
    {
        return _updatedAt;
    }

    public void setUpdatedAt(String updatedAt)
    {
        _updatedAt = updatedAt;
    }

    public KmList<Integer> getCollaboratorIds()
    {
        return _collaboratorIds;
    }

    public void setCollaboratorIds(KmList<Integer> collaboratorIds)
    {
        _collaboratorIds = collaboratorIds;
    }

    public KmList<String> getTags()
    {
        return _tags;
    }

    public void setTags(KmList<String> tags)
    {
        _tags = tags;
    }

    public KmZendeskVia getVia()
    {
        return _via;
    }

    public void setVia(KmZendeskVia via)
    {
        _via = via;
    }

    public KmList<KmZendeskCustomField> getCustomFields()
    {
        return _customFields;
    }

    public void setCustomFields(KmList<KmZendeskCustomField> customFields)
    {
        _customFields = customFields;
    }

    public KmZendeskSatisfactionRating getSatisfactionRatings()
    {
        return _satisfactionRating;
    }

    public void setSatisfactionRatings(KmZendeskSatisfactionRating satisfactionRatings)
    {
        _satisfactionRating = satisfactionRatings;
    }

    public KmList<Integer> getSharingAgreementIds()
    {
        return _sharingAgreementIds;
    }

    public void setSharingAgreementIds(KmList<Integer> sharingAgreementIds)
    {
        _sharingAgreementIds = sharingAgreementIds;
    }

    public KmList<Integer> getFollowUpIds()
    {
        return _followupIds;
    }

    public void setFollowUpIds(KmList<Integer> followUpIds)
    {
        _followupIds = followUpIds;
    }

    //##################################################
    //# print
    //##################################################//

    public void print(KmPrintWriter out)
    {
        out.println("id: " + _id);
        out.println("url: " + _url);
        out.println("external_id: " + _externalId);
        out.println("type: " + _type);
        out.println("subject: " + _subject);
        out.println("description: " + _description);
        out.println("priority: " + _priority);
        out.println("status: " + _status);
        out.println("recipient: " + _recipient);
        out.println("requester_id: " + _requesterId);
        out.println("submitter_id: " + _submitterId);
        out.println("assignee_id: " + _assigneeId);
        out.println("organization_id: " + _organizationId);
        out.println("group_id: " + _groupId);
        out.println("collaborator_ids: " + _collaboratorIds.format());
        out.println("forum_topic_id: " + _forumTopicId);
        out.println("problem_id: " + _problemId);
        out.println("has_incidents: " + _hasIncidents);
        out.println("due_at: " + _dueAt);
        out.println("tags: " + _tags.format());
        out.println("via: " + _via.format());
        out.println("custom_fields: " + _customFields.format());
        out.println("satisfaction_rating: " + _satisfactionRating);
        out.println("sharing_agreement_ids: " + _sharingAgreementIds.format());
        out.println("followup_ids:" + _followupIds.format());
        out.println("ticket_form_id: " + _ticketFormId);
        out.println("created_at: " + _createdAt);
        out.println("updated_at: " + _updatedAt);

    }

    //##################################################
    //# json
    //##################################################//
    public KmJsonMap toJson()
    {
        //        KmJsonMap m = new KmJsonMap();
        //        m.setInteger("id: " + _id);
        //        m.setString("url: " + _url;
        //        "id: " + _id;
        //        "url: " + _url;
        //        "external_id: " + _externalId;
        //        "type: " + _type;
        //        "subject: " + _subject;
        //        "description: " + _description;
        //        "priority: " + _priority;
        //        "status: " + _status;
        //        "recipient: " + _recipient;
        //        "requester_id: " + _requesterId;
        //        "submitter_id: " + _submitterId;
        //        "assignee_id: " + _assigneeId;
        //        "organization_id: " + _organizationId;
        //        "group_id: " + _groupId;
        //        "collaborator_ids: " + _collaboratorIds.format();
        //        "forum_topic_id: " + _forumTopicId;
        //        "problem_id: " + _problemId;
        //        "has_incidents: " + _hasIncidents;
        //        "due_at: " + _dueAt;
        //        "tags: " + _tags.format();
        //        "via: " + _via.format();
        //        "custom_fields: " + _customFields.format();
        //        "satisfaction_rating: " + _satisfactionRating;
        //        "sharing_agreement_ids: " + _sharingAgreementIds.format();
        //        "followup_ids:" + _followupIds.format();
        //        "ticket_form_id: " + _ticketFormId;
        //        "created_at: " + _createdAt;
        //        "updated_at: " + _updatedAt;
        //        "external_id: " + _externalId;
        //        "type: " + _type;
        //        "subject: " + _subject;
        //        "description: " + _description;
        //        "priority: " + _priority;
        //        "status: " + _status;
        //        "recipient: " + _recipient;
        //        "requester_id: " + _requesterId;
        //        "submitter_id: " + _submitterId;
        //        "assignee_id: " + _assigneeId;
        //        "organization_id: " + _organizationId;
        //        "group_id: " + _groupId;
        //        "collaborator_ids: " + _collaboratorIds.format();
        //        "forum_topic_id: " + _forumTopicId;
        //        "problem_id: " + _problemId;
        //        "has_incidents: " + _hasIncidents;
        //        "due_at: " + _dueAt;
        //        "tags: " + _tags.format();
        //        "via: " + _via.format();
        //        "custom_fields: " + _customFields.format();
        //        "satisfaction_rating: " + _satisfactionRating;
        //        "sharing_agreement_ids: " + _sharingAgreementIds.format();
        //        "followup_ids:" + _followupIds.format();
        //        "ticket_form_id: " + _ticketFormId;
        //        "created_at: " + _createdAt;
        //        ("updated_at: " + _updatedAt);

        return null;
    }
}

package com.app.ui.page.crud.blurb;

import com.kodemore.collection.KmList;
import com.kodemore.servlet.control.ScCardFrame;
import com.kodemore.servlet.control.ScControl;
import com.kodemore.servlet.control.ScDiv;
import com.kodemore.servlet.control.ScGroup;
import com.kodemore.servlet.control.ScSimpleModelList;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.variable.ScLocalString;
import com.kodemore.utility.KmEnumIF;

import com.app.dao.base.MyDaoAccess;
import com.app.model.MyBlurb;
import com.app.model.MyBlurbOwnerIF;
import com.app.model.MyProject;
import com.app.model.base.MyBlurbOwnerType;
import com.app.model.meta.MyMetaBlurb;
import com.app.ui.control.MyBlurbGroup;
import com.app.utility.MyGlobals;

/**
 * I display the list of available templates for the current context.
 * I am used as a decoration for various models such as project and job.
 */
public class MyBlurbListTile
    extends ScDiv
{
    //##################################################
    //# variables
    //##################################################

    private ScLocalString _ownerTypeCode;
    private ScLocalString _ownerUid;

    private ScTextField                _filterField;
    private ScSimpleModelList<MyBlurb> _modelList;

    private ScCardFrame  _frame;
    private MyBlurbGroup _templateCard;
    private ScGroup      _selectCard;

    //##################################################
    //# constructor
    //##################################################

    public MyBlurbListTile()
    {
        install();
    }

    //##################################################
    //# install
    //##################################################

    private void install()
    {
        _ownerTypeCode = new ScLocalString();
        _ownerTypeCode.setAutoSave();

        _ownerUid = new ScLocalString();
        _ownerUid.setAutoSave();

        css().flexRow().rowSpacer20();
        setLabel("Blurbs");

        ScDiv root;
        root = this;

        installListOn(root);
        installPreviewOn(root);
    }

    //==================================================
    //= install :: list
    //==================================================

    private void installListOn(ScDiv root)
    {
        ScGroup group;
        group = root.addGroup();
        group.setTitle("Blurbs");
        group.setFlavorList();
        group.css().flexChildPhiSmall0();

        installListHeaderOn(group);
        installListBodyOn(group);

        _modelList.installFilterOn(_filterField);
    }

    private void installListHeaderOn(ScGroup group)
    {
        ScDiv header;
        header = group.showHeader();
        header.css().flexRow().flexAlignSpaced().flexCrossAlignCenter();
        header.css().pad10().backgroundGrayEEE();

        ScDiv left;
        left = header.addDiv();
        left.addBold("Find: ");
        left.add(createFilterField());

        ScDiv right;
        right = header.addDiv();
        right.addRefreshButton(newCheckedAction(this::handleRefresh));
    }

    private void installListBodyOn(ScGroup group)
    {
        ScDiv body;
        body = group.getBody();
        body.add(createList());
    }

    private ScSimpleModelList<MyBlurb> createList()
    {
        MyMetaBlurb x = MyBlurb.Meta;

        ScSimpleModelList<MyBlurb> e;
        e = new ScSimpleModelList<>();
        e.css().fill();
        e.setKeyFunction(x.Uid);
        e.setTitleFunction(x.Name);
        e.setSubtitleFunction(x.OwnerTypeName);
        e.setItemAction(newCheckedAction(this::handleSelect));
        _modelList = e;
        return e;
    }

    //==================================================
    //= install :: preview
    //==================================================

    private void installPreviewOn(ScDiv root)
    {
        root.add(createTemplateFrame());
    }

    private ScCardFrame createTemplateFrame()
    {
        ScCardFrame e;
        e = new ScCardFrame();
        e.css().flexChildPhiLarge0().relative();
        e.addCard(createSelectCard());
        e.addCard(createTemplateCard());
        _frame = e;
        return e;
    }

    private ScGroup createSelectCard()
    {
        ScGroup e;
        e = new ScGroup();
        e.setTitle("Template");
        e.setFlavorSummary();
        e.css().fill();

        ScDiv body;
        body = e.getBody();
        body.css().pad10().italic();
        body.addText("Select a value.");

        _selectCard = e;
        return e;
    }

    private MyBlurbGroup createTemplateCard()
    {
        MyBlurbGroup e;
        e = new MyBlurbGroup();
        e.css().fill();
        _templateCard = e;
        return e;
    }

    //==================================================
    //= install :: fields
    //==================================================

    private ScControl createFilterField()
    {
        ScTextField e;
        e = new ScTextField();
        e.disableChangeTracking();
        _filterField = e;
        return e;
    }

    //##################################################
    //# owner :: public
    //##################################################

    public void setOwner(MyBlurbOwnerIF owner)
    {
        setOwnerUid(owner);
        setOwnerType(MyBlurbOwnerType.Project);
    }

    private MyBlurbOwnerIF findOwner()
    {
        MyBlurbOwnerType type = getOwnerType();
        if ( type == null )
            return null;

        String uid = _ownerUid.getValue();
        return type.findOwnerUid(uid);
    }

    private void _setContext(Object obj)
    {
        if ( !(obj instanceof MyBlurbOwnerIF) )
        {
            clearOwner();
            return;
        }

        MyBlurbOwnerIF owner;
        owner = (MyBlurbOwnerIF)obj;

        MyBlurbOwnerType type;
        type = owner.getBlurbOwnerType();

        setOwnerType(type);
        setOwnerUid(owner);
    }

    private void setOwnerUid(MyBlurbOwnerIF e)
    {
        if ( e == null )
            _ownerUid.clearValue();
        else
            _ownerUid.setValue(e.getUid());
    }

    private void clearOwner()
    {
        _ownerTypeCode.clearValue();
        _ownerUid.clearValue();
    }

    //##################################################
    //# context type
    //##################################################

    private MyBlurbOwnerType getOwnerType()
    {
        String code = _ownerTypeCode.getValue();
        return MyBlurbOwnerType.findCode(code);
    }

    private void setOwnerType(MyBlurbOwnerType e)
    {
        String code = KmEnumIF.getCodeFor(e);
        _ownerTypeCode.setValue(code);
    }

    //##################################################
    //# apply
    //##################################################

    @Override
    protected boolean applyFromModel_here(Object model)
    {
        _setContext(model);
        return false;
    }

    @Override
    protected boolean applyToModel_here(Object model)
    {
        return false;
    }

    //##################################################
    //# render
    //##################################################

    @Override
    protected void preRender()
    {
        super.preRender();

        _modelList.setValues(findTemplates());
        _frame.setDefaultCard(_selectCard);
    }

    private KmList<MyBlurb> findTemplates()
    {
        MyBlurbOwnerIF owner = findOwner();
        if ( owner == null )
            return KmList.createEmpty();

        MyProject project = owner.getProject();
        MyBlurbOwnerType type = owner.getBlurbOwnerType();

        KmList<MyBlurb> v;
        v = project.getBlurbs().toList();
        v.retainIf(e -> e.hasOwnerType(type));
        v.retainIf(e -> e.isEnabled());
        v.sortOn(e -> e.getName());
        return v;
    }

    //##################################################
    //# handle
    //##################################################

    private void handleRefresh()
    {
        _filterField.ajaxClearFieldValue();
        ajaxClearSelection();
    }

    private void handleSelect()
    {
        String uid = getData().getStringArgument();
        MyBlurb template = getAccess().findBlurbUid(uid);
        ajaxSelect(template);
    }

    //##################################################
    //# ajax
    //##################################################

    private void ajaxSelect(MyBlurb template)
    {
        if ( template == null )
        {
            ajaxClearSelection();
            return;
        }

        _modelList.ajaxSelect(template);

        _templateCard.setTemplate(template);
        _templateCard._setOwner(findOwner());

        _frame.ajaxPrint(_templateCard);
    }

    private void ajaxClearSelection()
    {
        _modelList.ajaxClearSelection();
        _frame.ajaxPrint(_selectCard);
    }

    //##################################################
    //# support
    //##################################################

    private MyDaoAccess getAccess()
    {
        return MyGlobals.getAccess();
    }
}

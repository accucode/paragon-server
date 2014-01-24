/*
  Copyright (c) 2005-2014 www.kodemore.com

  Permission is hereby granted, free of charge, to any person obtaining a copy
  of this software and associated documentation files (the "Software"), to deal
  in the Software without restriction, including without limitation the rights
  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
  copies of the Software, and to permit persons to whom the Software is
  furnished to do so, subject to the following conditions:

  The above copyright notice and this permission notice shall be included in
  all copies or substantial portions of the Software.

  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
  THE SOFTWARE.
*/

package com.kodemore.servlet.control;

import com.kodemore.adaptor.KmAdaptorIF;
import com.kodemore.html.KmHtmlBuilder;
import com.kodemore.meta.KmMetaAttribute;
import com.kodemore.meta.KmMetaProperty;
import com.kodemore.servlet.ScEntryPageIF;
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.action.ScActionIF;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScColorField;
import com.kodemore.servlet.field.ScDropdown;
import com.kodemore.servlet.field.ScDropdownMenu;
import com.kodemore.servlet.field.ScField;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.field.ScIntegerField;
import com.kodemore.servlet.field.ScLinkList;
import com.kodemore.servlet.field.ScPasswordField;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

/**
 * I am used for controls that contain children.
 * I do not define any specific organization or layout,
 * but I do define a wide range of convenience methods 
 * that are relied upon heavily to simplify coding.
 * Most, hopefully ALL, containers will subclass from me.
 */
public abstract class ScContainer
    extends ScControl
{
    //##################################################
    //# children
    //##################################################

    /**
     * Add a child to this container.
     * All convenience methods ultimately must delgate to this
     * method.  Subclasses are responsible for providing a useful
     * implementation.
     */
    public abstract <T extends ScControl> T add(T e);

    /**
     * Return true if I do not contain any children.
     */
    public abstract boolean isEmpty();

    public final boolean isNotEmpty()
    {
        return !isEmpty();
    }

    /**
     * Remove all children.
     */
    public abstract void clear();

    //##################################################
    //# render
    //##################################################

    @Override
    protected abstract void renderControlOn(KmHtmlBuilder out);

    //##################################################
    //# fields 
    //##################################################

    public <E> ScField<E> addField(KmMetaProperty<?,E> e)
    {
        return add(e.newField());
    }

    public <E> ScField<E> addField(KmMetaProperty<?,E> e, String label)
    {
        ScField<E> f;
        f = addField(e);
        f.setLabel(label);
        return f;
    }

    public ScIntegerField addIntegerField()
    {
        return add(new ScIntegerField());
    }

    public ScTextField addTextField()
    {
        return add(new ScTextField());
    }

    public ScPasswordField addPasswordField()
    {
        return add(new ScPasswordField());
    }

    public ScTextArea addTextArea()
    {
        return add(new ScTextArea());
    }

    public <E> ScHiddenField<E> addHiddenField()
    {
        ScHiddenField<E> e = new ScHiddenField<E>();
        return add(e);
    }

    public <E> ScHiddenField<E> addHiddenField(Class<E> c)
    {
        ScHiddenField<E> e = addHiddenField();
        return add(e);
    }

    public <E> ScHiddenField<E> addHiddenField(KmMetaAttribute<?,E> attr)
    {
        ScHiddenField<E> e;
        e = addHiddenField();
        e.setValueAdaptor(attr);
        return e;
    }

    public ScDropdown addDropdown()
    {
        return add(new ScDropdown());
    }

    public ScDropdownMenu addDropdownMenu()
    {
        return add(new ScDropdownMenu());
    }

    public ScCheckboxField addCheckboxField()
    {
        return add(new ScCheckboxField());
    }

    public ScColorField addColorField()
    {
        return add(new ScColorField());
    }

    //##################################################
    //# layout
    //##################################################

    public <E> ScGrid<E> addGrid()
    {
        ScGrid<E> e = new ScGrid<E>();
        return add(e);
    }

    public ScNotebook addNotebook()
    {
        return add(new ScNotebook());
    }

    //##################################################
    //# links
    //##################################################

    public ScLink addLink()
    {
        return add(new ScLink());
    }

    public ScLink addLink(String text)
    {
        ScLink e;
        e = addLink();
        e.setText(text);
        return e;
    }

    public ScUrlLink addUrlLink()
    {
        return add(new ScUrlLink());
    }

    public ScUrlLink addUrlLink(String text, String href)
    {
        ScUrlLink e;
        e = addUrlLink();
        e.setText(text);
        e.setHref(href);
        return e;
    }

    public ScLink addLink(String title, ScActionIF action)
    {
        ScLink e;
        e = addLink(title);
        e.setAction(action);
        return e;
    }

    public ScAbstractLink addLink(ScEntryPageIF e)
    {
        return addLink(e.getTitle(), e);
    }

    public ScAbstractLink addLink(String text, ScEntryPageIF e)
    {
        ScPageLink link;
        link = new ScPageLink();
        link.setText(text);
        link.setPage(e);
        return add(link);
    }

    @SuppressWarnings("rawtypes")
    public ScLink addLink(KmAdaptorIF title, ScActionIF action)
    {
        ScLink e;
        e = addLink();
        e.setText(title);
        e.setAction(action);
        return e;
    }

    public ScLink addLink(String title, ScActionIF action, Object arg)
    {
        ScLink e;
        e = addLink(title, action);
        e.setArgument(arg);
        return e;
    }

    @SuppressWarnings("rawtypes")
    public ScLink addLink(KmAdaptorIF title, ScActionIF action, Object arg)
    {
        ScLink e;
        e = addLink(title, action);
        e.setArgument(arg);
        return e;
    }

    public ScLink addLink(KmMetaProperty<?,?> title, ScActionIF action, Object arg)
    {
        return addLink(title.getAdaptor(), action, arg);
    }

    public ScLinkList addLinkList()
    {
        return add(new ScLinkList());
    }

    public <T> ScModelList<T> addModelList()
    {
        return add(new ScModelList<T>());
    }

    //##################################################
    //# buttons
    //##################################################

    public ScActionButton addButton()
    {
        ScActionButton e;
        e = new ScActionButton();
        return add(e);
    }

    public ScActionButton addButton(String text)
    {
        ScActionButton e;
        e = addButton();
        e.setText(text);
        return e;
    }

    public ScButton addButton(ScPage e)
    {
        return addButton(e.getTitle(), e);
    }

    public ScButton addButton(String text, ScPage e)
    {
        ScPageButton b;
        b = new ScPageButton();
        b.setText(text);
        b.setPage(e);
        return add(b);
    }

    public ScActionButton addButton(String text, ScActionIF e)
    {
        ScActionButton b;
        b = addButton(text);
        b.setAction(e);
        return b;
    }

    public ScActionButton addButton(String text, ScActionIF action, KmMetaProperty<?,?> arg)
    {
        ScActionButton e;
        e = addButton(text);
        e.setAction(action);
        e.setArgument(arg);
        return e;
    }

    public ScActionButton addCancelButton(ScActionIF action)
    {
        ScActionButton e;
        e = addButton("Cancel", action);
        e.applyNegativeFlavor();
        return e;
    }

    public ScGeneralButton addGeneralButton()
    {
        ScGeneralButton e;
        e = new ScGeneralButton();
        return add(e);
    }

    //##################################################
    //# submit buttons
    //##################################################

    public ScSubmitButton addSubmitButton()
    {
        ScSubmitButton e;
        e = new ScSubmitButton();
        e.applyPrimaryFlavor();
        add(e);
        return e;
    }

    public ScSubmitButton addSubmitButton(String text)
    {
        ScSubmitButton e;
        e = addSubmitButton();
        e.setText(text);
        return e;
    }

    //##################################################
    //# groups
    //##################################################

    public ScGroup addGroup()
    {
        return add(new ScGroup());
    }

    public ScGroup addGroup(String title)
    {
        ScGroup e;
        e = addGroup();
        e.setLabel(title);
        e.setTitle(title);
        return e;
    }

    //##################################################
    //# array
    //##################################################

    public ScArray addArray()
    {
        return add(new ScArray());
    }

    public ScArray addColumn()
    {
        return addArray();
    }

    public ScArray addColumns(int n)
    {
        ScArray e;
        e = addColumn();
        e.setColumnCount(n);
        return e;
    }

    public ScArray addRow()
    {
        ScArray e;
        e = addArray();
        e.setRow();
        return e;
    }

    public ScArray addSpacedRow()
    {
        ScArray e;
        e = addRow();
        e.setHorizontalGap(30);
        return e;
    }

    //##################################################
    //# text
    //##################################################

    public ScText addText()
    {
        return add(new ScText());
    }

    public ScText addText(String s)
    {
        ScText e;
        e = addText();
        e.setValue(s);
        return e;
    }

    public ScText addText(String msg, Object... args)
    {
        String s = Kmu.format(msg, args);

        return addText(s);
    }

    public ScText addText(KmMetaProperty<?,?> attr)
    {
        return add(attr.newText());
    }

    public ScText addText(KmMetaProperty<?,?> attr, String label)
    {
        return add(attr.newText(label));
    }

    public ScBold addBold()
    {
        return add(new ScBold());
    }

    public ScBold addBold(String s)
    {
        ScBold e;
        e = addBold();
        e.addText(s);

        return e;
    }

    //##################################################
    //# styled text
    //##################################################

    public ScTextSpan addTextSpan()
    {
        return add(new ScTextSpan());
    }

    public ScTextSpan addTextSpan(CharSequence text)
    {
        ScTextSpan e;
        e = addTextSpan();
        e.setValue(text);
        return e;
    }

    public ScTextSpan addTextSpan(KmMetaProperty<?,?> attr)
    {
        return add(attr.newSpannedText());
    }

    public ScTextSpan addTextSpan(KmMetaProperty<?,?> attr, String label)
    {
        return add(attr.newSpannedText(label));
    }

    //##################################################
    //# label
    //##################################################

    /**
     * Add a label.  Read-only text that is typically displayed
     * on a line immediately preceeding a field.
     */
    public ScBox addLabel(String text)
    {
        ScBox box;
        box = addBox();
        box.css().label();
        box.addText(text);
        return box;
    }

    public ScBox addLabelFor(ScControl e)
    {
        String s = e.getLabel();
        return addLabel(s);
    }

    //##################################################
    //# forms
    //##################################################

    /**
     * Add a box used to contain readonly text for a field.
     * We often collect a value from a field, then redisplay
     * that value in a readonly box.  We use the fieldValue
     * format for those readonly boxes.
     */
    public ScBox addFieldValue()
    {
        ScBox box;
        box = addBox();
        box.css().fieldValue();
        return box;
    }

    public ScForm addForm()
    {
        return add(new ScForm());
    }

    public ScForm addForm(String label)
    {
        ScForm form;
        form = addForm();
        form.setLabel(label);
        return form;
    }

    public ScBreak addBreak()
    {
        return add(new ScBreak());
    }

    public void addBreaks(int n)
    {
        for ( int i = 0; i < n; i++ )
            addBreak();
    }

    public ScNonBreakingSpace addNonBreakingSpace()
    {
        return add(new ScNonBreakingSpace());
    }

    public ScHeader addHeader1(String s)
    {
        return addHeader(1, s);
    }

    public ScHeader addHeader(int level, String s)
    {
        ScHeader e;
        e = new ScHeader();
        e.setLevel(level);
        e.setText(s);
        return add(e);
    }

    public <E extends ScControl> E addLabeled(E c, String s)
    {
        addLabel(s);
        return add(c);
    }

    public <E extends ScControl> E addLabeled(E e)
    {
        return addLabeled(e, e.getLabel());
    }

    public void addSpace()
    {
        add(new ScNonBreakingSpace());
    }

    public void addSpaces(int n)
    {
        for ( int i = 0; i < n; i++ )
            addSpace();
    }

    public ScTable addTable()
    {
        return add(new ScTable());
    }

    public ScLiteral addHtml(String html)
    {
        ScLiteral e;
        e = addLiteral();
        e.setValue(html);
        return e;
    }

    public ScLiteral addLiteral()
    {
        return add(new ScLiteral());
    }

    public ScLiteral addLiteral(KmMetaAttribute<?,?> attr)
    {
        ScLiteral e;
        e = addLiteral();
        e.setLabel(attr.getName());
        e.setValue(attr.getAdaptor());
        return e;
    }

    public ScTransientContainer addTransientContainer()
    {
        return add(new ScTransientContainer());
    }

    public ScWrapper addWrapper()
    {
        return add(new ScWrapper());
    }

    public ScInternalFrame addInternalFrame()
    {
        return add(new ScInternalFrame());
    }

    //##################################################
    //# boxes
    //##################################################

    public ScBox addBox()
    {
        return add(new ScBox());
    }

    public ScBox addLinkBox()
    {
        ScBoxer e;
        e = addBoxer();
        e.css().linkBox();
        return e;
    }

    public ScBox addLines()
    {
        ScBoxer e;
        e = addBoxer();
        e.css().lineBox();
        return e;
    }

    public ScBoxer addBoxer()
    {
        return add(new ScBoxer());
    }

    //##################################################
    //# button box
    //##################################################

    public ScBox addButtonBox()
    {
        ScBox e;
        e = addBox();
        e.css().buttonBox();
        return e;
    }

    public ScBox addButtonBoxLeft()
    {
        ScBox e;
        e = addBox();
        e.css().buttonBoxLeft();
        return e;
    }

    public ScBox addButtonBoxRight()
    {
        ScBox e;
        e = addBox();
        e.css().buttonBoxRight();
        return e;
    }

    //##################################################
    //# fieldset
    //##################################################

    public ScFieldset addFieldset()
    {
        return add(new ScFieldset());
    }

    public ScFieldset addFieldset(String label)
    {
        ScFieldset e;
        e = addFieldset();
        e.setLabel(label);
        return e;
    }

    //##################################################
    //# pad
    //##################################################

    public ScBox addPad()
    {
        ScBox e;
        e = addBox();
        e.css().pad();
        return e;
    }

    public ScBox addGap()
    {
        ScBox e;
        e = addBox();
        e.css().gap();
        return e;
    }

    //##################################################
    //# float
    //##################################################

    public ScDiv addFloatLeft()
    {
        ScDiv e;
        e = addDiv();
        e.css().floatLeft();
        return e;
    }

    public ScDiv addFloatRight()
    {
        ScDiv e;
        e = addDiv();
        e.css().floatRight();
        return e;
    }

    //##################################################
    //# misc
    //##################################################

    public ScCardFrame addFrame()
    {
        return add(new ScCardFrame());
    }

    public ScSpan addSpan()
    {
        return add(new ScSpan());
    }

    public ScImage addImage()
    {
        return add(new ScImage());
    }

    public ScErrorBox addErrorBox()
    {
        return add(new ScErrorBox());
    }

    public ScDiv addDiv()
    {
        return add(new ScDiv());
    }

    public ScParagraph addParagraph()
    {
        return add(new ScParagraph());
    }

    public ScParagraph addParagraph(String text)
    {
        ScParagraph e;
        e = addParagraph();
        e.addText(text);
        return e;
    }

    public ScSpan addClearfix()
    {
        ScSpan e;
        e = addSpan();
        e.css().clearfix();
        return e;
    }

    public ScDialog addDialog()
    {
        return add(new ScDialog());
    }

    public ScRule addRule()
    {
        return add(new ScRule());
    }

    public ScDivider addDivider()
    {
        return add(new ScDivider());
    }

    public ScDivider addDivider(int pad)
    {
        ScDivider e;
        e = addDivider();
        e.style().padTop(pad).padBottom(pad);
        return e;
    }

    public ScBlockQuote addBlockQuote()
    {
        return add(new ScBlockQuote());
    }

    public ScFilterBox addFilterBox()
    {
        return add(new ScFilterBox());
    }

    public ScFieldTable addFields()
    {
        return add(new ScFieldTable());
    }

    public ScFilterBox addFilterBox(String title)
    {
        ScFilterBox e;
        e = addFilterBox();
        e.getGroup().setTitle(title);
        return e;
    }

    public ScEqualizeFiller addEqualizeFiller()
    {
        return add(new ScEqualizeFiller());
    }

    public ScTimeAgo addTimeAgo()
    {
        return add(new ScTimeAgo());
    }

    public ScTimeAgo addTimeAgo(KmTimestamp utcTs)
    {
        ScTimeAgo e;
        e = addTimeAgo();
        e.setUtcTs(utcTs);
        return e;
    }

    public ScDateAgo addDateAgo()
    {
        return add(new ScDateAgo());
    }

    public ScDateAgo addDateAgo(KmDate date)
    {
        ScDateAgo e;
        e = addDateAgo();
        e.setDate(date);
        return e;
    }

    public ScAccordion addAccordion()
    {
        return add(new ScAccordion());
    }

    public ScBorderLayout addBorderLayout()
    {
        return add(new ScBorderLayout());
    }

    public ScTitlePanelLayout addTitlePanelLayout()
    {
        return add(new ScTitlePanelLayout());
    }
}

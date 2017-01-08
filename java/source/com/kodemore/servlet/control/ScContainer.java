/*
  Copyright (c) 2005-2016 www.kodemore.com

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
import com.kodemore.servlet.ScPage;
import com.kodemore.servlet.ScPageIF;
import com.kodemore.servlet.action.ScAction;
import com.kodemore.servlet.field.ScCheckboxField;
import com.kodemore.servlet.field.ScColorField;
import com.kodemore.servlet.field.ScDropdownField;
import com.kodemore.servlet.field.ScDropdownMenu;
import com.kodemore.servlet.field.ScHiddenField;
import com.kodemore.servlet.field.ScHtmlIdIF;
import com.kodemore.servlet.field.ScIntegerField;
import com.kodemore.servlet.field.ScLinkList;
import com.kodemore.servlet.field.ScPasswordField;
import com.kodemore.servlet.field.ScTextArea;
import com.kodemore.servlet.field.ScTextField;
import com.kodemore.servlet.script.ScResetScript;
import com.kodemore.servlet.script.ScScriptIF;
import com.kodemore.time.KmDate;
import com.kodemore.time.KmTimestamp;
import com.kodemore.utility.Kmu;

/**
 * I am used for controls that contain children.
 * I do NOT define any specific organization or layout,
 * but I do define a wide range of convenience methods
 * that are relied upon heavily to simplify coding.
 * Most (hopefully ALL) containers will subclass from me.
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

    public <E> ScFieldIF<E> addField(KmMetaProperty<?,E> e)
    {
        ScFieldIF<E> f = e.newField();
        ScControl c = f.asControl();
        add(c);
        return f;
    }

    public <E> ScFieldIF<E> addFieldFull(KmMetaProperty<?,E> e)
    {
        return addFieldFull(e, null);
    }

    public <E> ScFieldIF<E> addFieldFull(KmMetaProperty<?,E> e, String label)
    {
        ScFieldIF<E> f = e.newField();

        if ( label != null )
            f.setLabel(label);

        if ( f instanceof ScWidthFullIF )
            ((ScWidthFullIF)f).setWidthFull();

        ScControl c = f.asControl();
        add(c);

        return f;
    }

    public <E> ScFieldIF<E> addField(KmMetaProperty<?,E> e, String label)
    {
        ScFieldIF<E> f;
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
        ScHiddenField<E> e = new ScHiddenField<>();
        return add(e);
    }

    /**
     * @param c Not used directly, but is needed for 'generic' typing
     */
    public <E> ScHiddenField<E> addHiddenField(Class<E> c)
    {
        return addHiddenField();
    }

    public <E> ScHiddenField<E> addHiddenField(KmMetaAttribute<?,E> attr)
    {
        ScHiddenField<E> e;
        e = addHiddenField();
        e.setValueAdaptor(attr);
        return e;
    }

    public <E> ScHiddenField<E> addHiddenField(KmAdaptorIF<?,E> a)
    {
        ScHiddenField<E> e;
        e = addHiddenField();
        e.setValueAdaptor(a);
        return e;
    }

    public <E> ScDropdownField<E> addDropdown()
    {
        return add(new ScDropdownField<E>());
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
        ScGrid<E> e = new ScGrid<>();
        return add(e);
    }

    public ScNotebook addNotebook()
    {
        return add(new ScNotebook());
    }

    public ScTabBook addTabBook()
    {
        return add(new ScTabBook());
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

    public ScScriptLink addScriptLink()
    {
        return add(new ScScriptLink());
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

    public ScLink addLink(String title, ScAction action)
    {
        ScLink e;
        e = addLink(title);
        e.setAction(action);
        return e;
    }

    public ScLink addLink(String title, Runnable r)
    {
        ScAction action = newCheckedAction(r);

        ScLink e;
        e = addLink(title);
        e.setAction(action);
        return e;
    }

    public ScAbstractLink addLink(ScPageIF e)
    {
        return addLink(e.getTitle(), e);
    }

    public ScAbstractLink addLink(String text, ScPageIF e)
    {
        ScPageLink link;
        link = new ScPageLink();
        link.setText(text);
        link.setPage(e);
        return add(link);
    }

    @SuppressWarnings("rawtypes")
    public ScLink addLink(KmAdaptorIF title, ScAction action)
    {
        ScLink e;
        e = addLink();
        e.setText(title);
        e.setAction(action);
        return e;
    }

    public ScLink addLink(String title, ScAction action, Object arg)
    {
        ScLink e;
        e = addLink(title, action);
        e.setArgument(arg);
        return e;
    }

    public ScLink addLink(String title, Runnable action, Object arg)
    {
        ScLink e;
        e = addLink(title, action);
        e.setArgument(arg);
        return e;
    }

    @SuppressWarnings("rawtypes")
    public ScLink addLink(KmAdaptorIF title, ScAction action, Object arg)
    {
        ScLink e;
        e = addLink(title, action);
        e.setArgument(arg);
        return e;
    }

    public <T> ScLinkList<T> addLinkList()
    {
        return add(new ScLinkList<T>());
    }

    public <T> ScSimpleModelList<T> addSimpleModelList()
    {
        return add(new ScSimpleModelList<T>());
    }

    public <T> ScCustomModelList<T> addCustomModelList()
    {
        return add(new ScCustomModelList<T>());
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

    public ScActionButton addButton(String text, ScAction e)
    {
        ScActionButton b;
        b = addButton(text);
        b.setAction(e);
        return b;
    }

    public ScActionButton addButton(final Runnable r)
    {
        ScActionButton b;
        b = addButton();
        b.setAction(r);
        return b;
    }

    public ScActionButton addButton(String text, final Runnable r)
    {
        ScActionButton b;
        b = addButton(text);
        b.setAction(r);
        return b;
    }

    public ScActionButton addButton(String text, ScAction action, KmMetaProperty<?,?> arg)
    {
        ScActionButton e;
        e = addButton(text);
        e.setAction(action);
        e.setArgument(arg);
        return e;
    }

    public ScActionButton addButton(String text, Runnable runnable, KmMetaProperty<?,?> arg)
    {
        ScActionButton e;
        e = addButton(text);
        e.setAction(runnable);
        e.setArgument(arg);
        return e;
    }

    public ScActionButton addButton(String text, ScAction action, String arg)
    {
        ScActionButton e;
        e = addButton(text);
        e.setAction(action);
        e.setArgument(arg);
        return e;
    }

    public ScActionButton addButton(String text, Runnable runnable, String arg)
    {
        ScActionButton e;
        e = addButton(text);
        e.setAction(runnable);
        e.setArgument(arg);
        return e;
    }

    //==================================================
    //= buttons :: common actions
    //==================================================

    public ScActionButton addEditButton(Runnable r)
    {
        return addEditButton(newCheckedAction(r));
    }

    public ScActionButton addEditButton(ScAction action)
    {
        ScActionButton e;
        e = addButton("", action);
        e.setFlavorIcon();
        e.setImage(getUrls().getEditButtonUrl());
        e.setHoverText("Edit");
        return e;
    }

    public ScActionButton addAuditLogButton(Runnable r)
    {
        ScActionButton e;
        e = addButton("", newCheckedAction(r));
        e.setFlavorIcon();
        e.setImage(getUrls().getAuditButtonUrl());
        e.setHoverText("Log");
        return e;
    }

    public ScActionButton addBackButton(Runnable r)
    {
        return addBackButton(newCheckedAction(r));
    }

    public ScActionButton addBackButton(ScAction action)
    {
        ScActionButton e;
        e = addButton("", action);
        e.setFlavorIcon();
        e.setImage(getUrls().getBackButtonUrl());
        e.setHoverText("Back");
        return e;
    }

    public ScActionButton addCloseButton(Runnable r)
    {
        return addCloseButton(newCheckedAction(r));
    }

    public ScActionButton addCloseButton(ScAction action)
    {
        return addButton("Close", action);
    }

    public ScActionButton addCancelButton(ScAction action)
    {
        ScActionButton e;
        e = addButton("Cancel", action);
        e.applyNegativeFlavor();
        return e;
    }

    public ScActionButton addCancelButton(Runnable r)
    {
        return addCancelButton("Cancel", r);
    }

    public ScActionButton addCancelButton(String text, Runnable r)
    {
        ScActionButton e;
        e = addButton(text, newUncheckedAction(r));
        e.applyNegativeFlavor();
        return e;
    }

    public ScActionButton addRefreshButton(Runnable r)
    {
        return addRefreshButton(newCheckedAction(r));
    }

    public ScActionButton addRefreshButton(ScAction action)
    {
        String title = null;

        ScActionButton e;
        e = addButton(title, action);
        e.setFlavorIcon();
        e.setImage(getUrls().getRefreshButtonUrl());
        e.setHoverText("Refresh");
        return e;
    }

    public ScActionButton addAddButton(Runnable r)
    {
        return addAddButton(newCheckedAction(r));
    }

    public ScActionButton addAddButton(String text, Runnable r)
    {
        ScActionButton e;
        e = addAddButton(newCheckedAction(r));
        e.setText(text);
        return e;
    }

    public ScActionButton addAddButton(ScAction action)
    {
        String title = null;

        ScActionButton e;
        e = addButton(title, action);
        e.setFlavorIcon();
        e.setImage(getUrls().getAddButtonUrl());
        e.setHoverText("Add");
        return e;
    }

    /**
     * This button is used to permanently delete data from the system.
     * @see #addDeleteMaybeButton
     */
    public ScActionButton addDeleteButton(Runnable r)
    {
        ScActionButton e;
        e = addButton("DELETE!", r);
        e.applyDeleteFlavor();
        e.setImage(getUrls().getDeleteButtonUrl());
        return e;
    }

    /**
     * This button is used to confirm whether the user really wants to
     * delete something from the system.
     *
     * @see #addDeleteButton
     */
    public ScActionButton addDeleteMaybeButton(Runnable r)
    {
        ScActionButton e;
        e = addButton("", r);
        e.setFlavorIcon();
        e.setHoverText("Delete?");
        e.setImage(getUrls().getDeleteMaybeButtonUrl());
        return e;
    }

    /**
     * This button is used to soft-delete data from the system.
     */
    public ScActionButton addRemoveButton(Runnable r)
    {
        ScActionButton e;
        e = addButton("Remove", r);
        e.applyDeleteFlavor();
        e.setImage(getUrls().getDeleteButtonUrl());
        return e;
    }

    public ScActionButton addUpButton(Runnable r)
    {
        return addUpButton(newCheckedAction(r));
    }

    public ScActionButton addUpButton(ScAction action)
    {
        ScActionButton e;
        e = addButton("", action);
        e.setImage(getUrls().getUpButtonUrl());
        e.setHoverText("Up");
        return e;
    }

    public ScActionButton addDownButton(Runnable r)
    {
        return addDownButton(newCheckedAction(r));
    }

    public ScActionButton addDownButton(ScAction action)
    {
        ScActionButton e;
        e = addButton("", action);
        e.setImage(getUrls().getDownButtonUrl());
        e.setHoverText("Down");
        return e;
    }

    public ScActionButton addPopoutButton(Runnable r)
    {
        return addPopoutButton(newCheckedAction(r));
    }

    public ScActionButton addPopoutButton(ScAction action)
    {
        ScActionButton e;
        e = addButton("", action);
        e.setImage(getUrls().getPopoutButtonUrl());
        e.setHoverText("Popout");
        return e;
    }

    //==================================================
    //= buttons :: script
    //==================================================

    public ScScriptButton addScriptButton()
    {
        return add(new ScScriptButton());
    }

    public ScScriptButton addScriptButton(String text, ScScriptIF script)
    {
        ScScriptButton e;
        e = addScriptButton();
        e.setText(text);
        e.setScript(script);
        return e;
    }

    //==================================================
    //= reset
    //==================================================

    /**
     * Add a standard button that uses client-side javascript to reset
     * fields to their original values.
     */
    public ScScriptButton addResetButton()
    {
        ScScriptButton e;
        e = addScriptButton();
        e.setText("Reset");
        e.applyNegativeFlavor();

        ScResetScript script;
        script = new ScResetScript();
        script.setSource(e);
        e.setScript(script);

        return e;
    }

    public ScScriptButton addResetButton(ScHtmlIdIF target)
    {
        ScResetScript script;
        script = new ScResetScript();
        script.setTarget(target);

        ScScriptButton e;
        e = addScriptButton();
        e.setText("Reset");
        e.setScript(script);
        e.applyNegativeFlavor();
        return e;
    }

    //==================================================
    //= buttons :: submit
    //==================================================

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

    public ScSubmitButton addSaveButton()
    {
        return addSubmitButton("Save");
    }

    public ScSubmitButton addSearchButton()
    {
        ScSubmitButton e = addSubmitButton("Search");
        e.setImage(getUrls().getSearchButtonUrl());
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

    public <T> ScGridGroup<T> addGroup(String title, ScGrid<T> grid)
    {
        ScGridGroup<T> e;
        e = new ScGridGroup<>();
        e.setTitle(title);
        e.setGrid(grid);
        return add(e);
    }

    //##################################################
    //# array
    //##################################################

    public ScArray addArray()
    {
        return add(new ScArray());
    }

    public ScArray addArrayColumn()
    {
        return addArray();
    }

    public ScArray addArrayRow()
    {
        ScArray e;
        e = addArray();
        e.setRow();
        return e;
    }

    public ScArray addArraySpacedRow()
    {
        ScArray e;
        e = addArrayRow();
        e.setHorizontalGap(30);
        return e;
    }

    //##################################################
    //# flex
    //##################################################

    /**
     * Add a FLEXBOX defaulted to a block-row layout.
     */
    public ScDiv addFlexRow()
    {
        ScDiv e;
        e = addDiv();
        e.css().flexRow();
        return e;
    }

    /**
     * Add a FLEXBOX defaulted to a block-column layout.
     */
    public ScDiv addFlexColumn()
    {
        ScDiv e;
        e = addDiv();
        e.css().flexColumn();
        return e;
    }

    /**
     * Add a child set to both grow and shrink within is flex parent.
     * The parent MUST be a flexbox.
     * Athough content can be added to the returned filler, this is
     * often used to simply add a stretchable blank area between other children.
     */
    public ScDiv addFlexChildFiller()
    {
        ScDiv e;
        e = addDiv();
        e.css().flexChildFiller();
        return e;
    }

    /**
     * Add a gap using a fixed size and static sizing (no grow, no shrink).
     * The parent must be a flexbox.
     */
    public void addFlexGap(int px)
    {
        ScDiv e;
        e = addDiv();
        e.css().flexChildStatic();
        e.style().size(px);
    }

    //##################################################
    //# multi-panel layouts
    //##################################################

    public ScTwoPanelLayout addTwoPanelLayout()
    {
        return add(new ScTwoPanelLayout());
    }

    public ScThreePanelLayout addThreePanelLayout()
    {
        return add(new ScThreePanelLayout());
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

    public ScText addText(String s, String label)
    {
        ScText e;
        e = addText();
        e.setValue(s);
        e.setLabel(label);
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
    //# field text
    //##################################################

    public ScFieldText addFieldText()
    {
        return add(new ScFieldText());
    }

    public ScFieldText addFieldText(KmMetaProperty<?,?> attr)
    {
        ScFieldText e = attr.newFieldText();
        return add(e);
    }

    public ScFieldText addFieldText(KmMetaProperty<?,?> attr, String label)
    {
        ScFieldText e = attr.newFieldText(label);
        return add(e);
    }

    //##################################################
    //# text span
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
        return add(attr.newTextSpan());
    }

    public ScTextSpan addTextSpan(KmMetaProperty<?,?> attr, String label)
    {
        return add(attr.newTextSpan(label));
    }

    //##################################################
    //# text paragraph
    //##################################################

    public ScTextParagraph addTextParagraph()
    {
        return add(new ScTextParagraph());
    }

    public ScTextParagraph addTextParagraph(CharSequence text)
    {
        ScTextParagraph e;
        e = addTextParagraph();
        e.setValue(text);
        return e;
    }

    public ScTextParagraph addTextParagraph(KmMetaProperty<?,?> attr)
    {
        return add(attr.newTextParagraph());
    }

    public ScTextParagraph addTextParagraph(KmMetaProperty<?,?> attr, String label)
    {
        return add(attr.newTextParagraph(label));
    }

    //##################################################
    //# label
    //##################################################

    /**
     * Add a label.  Read-only text that is typically displayed
     * on a line immediately preceeding a field.
     */
    public ScDiv addLabel(String text)
    {
        ScDiv box;
        box = addDiv();
        box.css().label();
        box.addText(text);
        return box;
    }

    public ScDiv addRequiredLabel(String text)
    {
        ScDiv box;
        box = addDiv();
        box.css().label();
        box.addText(text);
        box.addNonBreakingSpace();
        box.addTextSpan("*").css().requiredStar();
        return box;
    }

    public ScDiv addLabelFor(ScControl e)
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
    public ScDiv addFieldValue()
    {
        ScDiv box;
        box = addDiv();
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

    public ScLiteral addLiteral(KmMetaProperty<?,?> attr, String label)
    {
        ScLiteral e;
        e = addLiteral();
        e.setLabel(label);
        e.setValue(attr);
        return e;
    }

    public ScLiteral addLiteral(KmMetaProperty<?,?> attr)
    {
        return addLiteral(attr, attr.getLabel());
    }

    public ScTransientContainer addTransientContainer()
    {
        return add(new ScTransientContainer());
    }

    public ScTransientDiv addTransientDiv()
    {
        return add(new ScTransientDiv());
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
    //# button box
    //##################################################

    public ScDiv addButtonBox()
    {
        ScDiv e;
        e = addDiv();
        e.css().buttonBox();
        return e;
    }

    public ScDiv addButtonBox5()
    {
        ScDiv e;
        e = addDiv();
        e.css().buttonBox5();
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

    public ScDiv addPad()
    {
        ScDiv e;
        e = addDiv();
        e.css().pad();
        return e;
    }

    public ScDiv addPad5()
    {
        ScDiv e;
        e = addDiv();
        e.css().pad5();
        return e;
    }

    public ScDiv addGap()
    {
        ScDiv e;
        e = addDiv();
        e.css().gap();
        return e;
    }

    public ScDiv addGap5()
    {
        ScDiv e;
        e = addDiv();
        e.css().gap5();
        return e;
    }

    //##################################################
    //# misc
    //##################################################

    public ScCardFrame addCardFrame()
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

    public ScErrorWrapper addErrorWrapper()
    {
        return add(new ScErrorWrapper());
    }

    public ScErrorWrapper addErrorWrapperWith(ScControl child)
    {
        ScErrorWrapper e;
        e = addErrorWrapper();
        e.setChild(child);
        return e;
    }

    public ScDiv addDiv()
    {
        return add(new ScDiv());
    }

    public ScSpacedRow addSpacedRow()
    {
        return add(new ScSpacedRow());
    }

    public ScBulletedList addBullettedList()
    {
        return add(new ScBulletedList());
    }

    public ScUnorderedList addUnorderedList()
    {
        return add(new ScUnorderedList());
    }

    public ScListItem addListItem()
    {
        return add(new ScListItem());
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

    public ScBareDialog addBareDialog()
    {
        return add(new ScBareDialog());
    }

    public ScDialog addDialog()
    {
        return add(new ScDialog());
    }

    public ScRule addRule()
    {
        return add(new ScRule());
    }

    public ScBlockQuote addBlockQuote()
    {
        return add(new ScBlockQuote());
    }

    public ScFieldTable addFieldTable()
    {
        return add(new ScFieldTable());
    }

    public ScFieldLayout addFieldLayout()
    {
        return add(new ScFieldLayout());
    }

    public ScFilterBox addFilterBox()
    {
        return add(new ScFilterBox());
    }

    public ScFilterBox addFilterBox(String title)
    {
        ScFilterBox e;
        e = addFilterBox();
        e.getGroup().setTitle(title);
        return e;
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

    public ScAbsoluteLayout addAbsoluteLayout()
    {
        return add(new ScAbsoluteLayout());
    }

    public <T> ScDraggableMultiSelectList<T> addDraggableMultiList()
    {
        return add(new ScDraggableMultiSelectList<T>());
    }

    public ScSplitter addSplitter()
    {
        return add(new ScSplitter());
    }
}

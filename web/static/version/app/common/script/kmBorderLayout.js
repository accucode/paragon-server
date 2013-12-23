/**
 * Create a new border layout on a parent.
 */
function KmBorderLayout(userOptions)
{
    "use strict";

    this.installOptions(userOptions);
    this.installDom();
    this.installResize();
    this.installDebug();
    this.resetLayout();
}
    
KmBorderLayout.prototype.installOptions = function(userOptions)
{
    "use strict";
    
    this.options =
    {
        /**
         * The parent to which this layout is attached.
         * The parent is typically a valid jquery selector.
         * Only the first matching parent will be used.
         */
        parent: 'body',
        
        /**
         * This prefix used to define the default classes of
         * each child.  E.g.: borderTop.
         */
        classPrefix: 'border',
        
        /**
         * This prefix is used to define the children's ids.
         * If null, attempt to use the parent's id.
         * If the parent does not have an id, use "border".
         */
        idPrefix: null,
        
        topVisible:      false,
        topResizable:    false,
        topSize:         100,
        topOverflow:     "hidden",
               
        bottomVisible:   false,
        bottomResizable: false,
        bottomSize:      100,
        bottomOverflow:  "hidden",
               
        rightVisible:    false,
        rightResizable:  false,
        rightSize:       100,
        rightOverflow:   "hidden",
               
        leftVisible:     false,
        leftResizable:   false,
        leftSize:        100,
        leftOverflow:    "hidden",
               
        centerVisible:   true,
        centerOverflow:  "hidden",
        
        /**
         * If true, call layout repeatedly as the children are being 
         * resized.  If false, the layout is called once, when the
         * resize is done.  This only applies if the children have 
         * been made explicitly resizable.
         */
        liveResize:      false,
        
        /**
         * If true, add thick borders to all children for debugging. 
         */
        debugBorders:	 false,
        
		topSuffix:		"Top",
		bottomSuffix:	"Bottom",
		leftSuffix:		"Left",
		rightSuffix:	"Right",
		centerSuffix:	"Center"
    };
    
    for ( key in userOptions )
    {
        this.options[key] = userOptions[key];
    }

    var parent = $(this.options.parent);

    if ( ! this.options.idPrefix )
    {
        if ( parent.attr("id") )
        {
            this.options.idPrefix = parent.attr("id");
        }
        else
        {
            this.options.idPrefix = "border";
        }
    }
}

KmBorderLayout.prototype.getParent = function()
{
    return $(this.options.parent);
}

KmBorderLayout.prototype.installDom = function()
{
    // WARNING: the sequence in which children are created DOES matter.
    // This impacts the z-index, which in turn changes which controls
    // are on top during animations.

    var center;
    center = this.appendChild(this.options.centerSuffix);
    center.css("left", 0);
    center.css("right", 0);
    center.css("top", 0);
    center.css("bottom", 0);
    center.css("overflow", this.options.centerOverflow);
    
    var left;
    left = this.appendChild(this.options.leftSuffix);
    left.css("left", 0);
    left.css("width", 0);
    left.css("top", 0);
    left.css("bottom", 0);
    left.css("overflow", this.options.leftOverflow);
    
    var right;
    right = this.appendChild(this.options.rightSuffix);
    right.css("right", 0);
    right.css("width", 0);
    right.css("top", 0);
    right.css("bottom", 0);
    right.css("overflow", this.options.rightOverflow);
    
    var top;
    top = this.appendChild(this.options.topSuffix);
    top.css("left", 0);
    top.css("right", 0);
    top.css("top", 0);
    top.css("height", 0);
    top.css("overflow", this.options.topOverflow);
    
    var bottom;
    bottom = this.appendChild(this.options.bottomSuffix);
    bottom.css("left", 0);
    bottom.css("right", 0);
    bottom.css("bottom", 0);
    bottom.css("height", 0);
    bottom.css("overflow", this.options.bottomOverflow);
    
    this.getParent().data('borderLayout', this);
}

KmBorderLayout.prototype.appendChild = function(suffix)
{
    var id  = this.options.idPrefix + suffix; 
    var cls = this.options.classPrefix + suffix; 

    var e;
    e = $("<div></div>");
    e.attr("id", id);
    e.addClass(cls);
    e.css("position", "absolute");
    e.css("overflow", "hidden");
    e.css("display", "none");
    
    this.getParent().append(e);
    
    return e;
}

KmBorderLayout.prototype.installResize = function()
{
    var o = this.options;
       
    if ( o.topResizable )
        this.installResizeOn('top', 's');
       
    if ( o.bottomResizable )
        this.installResizeOn('bottom', 'n');

    if ( o.leftResizable )
        this.installResizeOn('left', 'e');
       
    if ( o.rightResizable )
        this.installResizeOn('right', 'w');
}

KmBorderLayout.prototype.installResizeOn = function(side, handle)
{
    var target = this.getChild(side);

    var thiz = this;
    var onStop = function() { thiz.layout() };
    
    var onResize = this.options.liveResize
        ? onStop
        : null; 
    
    target.resizable(
    {
        handles: handle,
        stop:    onStop,
        resize:  onResize
    });
}
        
KmBorderLayout.prototype.resetLayout = function()
{
    var o = this.options;

    var top;
    top = this.getTop();    
    top.css('height', o.topSize);
    top.setVisible(o.topVisible);
    
    var bottom;
    bottom = this.getBottom();    
    bottom.css('height', o.bottomSize);
    bottom.setVisible(o.bottomVisible);

    var left;
    left = this.getLeft();        
    left.css('width', o.leftSize);
    left.setVisible(o.leftVisible);
        
    var right;
    right = this.getRight();
    right.css('width', o.rightSize);
    right.setVisible(o.rightVisible);
        
    var center;
    center = this.getCenter();
    center.setVisible(o.centerVisible);
        
    this.layout();
}

KmBorderLayout.prototype.layout = function()
{
    var top = this.getTop();
    var bottom = this.getBottom();
    var left = this.getLeft();
    var right = this.getRight();
    var center = this.getCenter();
        
    var topOffset = 0;
    var bottomOffset = 0;
    var leftOffset = 0;
    var rightOffset = 0;

    if ( top.isVisible() )
    {
        topOffset = top.outerHeight(true);
        
        top.css('top', 0);
        top.css('width', 'auto');
        top.css('left', 0);
        top.css('right', 0);
        top.css('width', 'auto');
    }

    if ( bottom.isVisible() )
    {
        bottomOffset = bottom.outerHeight(true);
        bottom.css('top', 'auto');
        bottom.css('bottom', 0);
        bottom.css('left', 0);
        bottom.css('right', 0);
        bottom.css('width', 'auto');
    }

    if ( left.isVisible() )
    {
        leftOffset = left.outerWidth(true);
        left.css('top', topOffset);
        left.css('bottom', bottomOffset);
        left.css('height', 'auto');
        left.css('left', 0);
    }

    if ( right.isVisible() )
    {
        rightOffset = right.outerWidth(true);
        right.css('left', 'auto');
        right.css('right', 0);
        right.css('top', topOffset);
        right.css('bottom', bottomOffset);
        right.css('height', 'auto');
    }

    if ( center.is(':visible') )
    {
        centerOffset = right.outerWidth(true);
        center.css('top', topOffset);
        center.css('bottom', bottomOffset);
        center.css('left', leftOffset);
        center.css('right', rightOffset);
    }
}

KmBorderLayout.prototype.installDebug = function()
{
    if ( this.options.debugBorders )
    {
        this.getTop().css("border", "thick solid red");
        this.getRight().css("border", "thick solid green");
        this.getBottom().css("border", "thick solid blue");
        this.getLeft().css("border", "thick solid orange");
        this.getCenter().css("border", "thick solid purple");
    }
}

KmBorderLayout.prototype.getTop = function()
{
    return this.getChild('top');
}

KmBorderLayout.prototype.getBottom = function()
{
    return this.getChild('bottom');
}

KmBorderLayout.prototype.getLeft = function()
{
    return this.getChild('left');
}

KmBorderLayout.prototype.getRight = function()
{
    return this.getChild('right');
}

KmBorderLayout.prototype.getCenter = function()
{
    return this.getChild('center');
}

/**
 * Get the child matching one of the following:
 *   top, bottom, left, right, center.
 */
KmBorderLayout.prototype.getChild = function(side)
{
    var sel = this.options.idPrefix + this.getSuffix(side);
    return $('#' + sel);
}

KmBorderLayout.prototype.getSuffix = function(side)
{
    if ( side == 'top' )
        return this.options.topSuffix;
        
    if ( side == 'bottom' )
        return this.options.bottomSuffix;
        
    if ( side == 'left' )
        return this.options.leftSuffix;
        
    if ( side == 'right' )
        return this.options.rightSuffix;
        
    if ( side == 'center' )
        return this.options.centerSuffix;
        
    return null;
}

KmBorderLayout.prototype.showSide = function(side)
{
    this.getChild(side).show();
    this.layout();
}

KmBorderLayout.prototype.hideSide = function(side)
{
    this.getChild(side).hide();
    this.layout();
}

KmBorderLayout.prototype.showToggle = function(side)
{
    this.getChild(side).toggle();
    this.layout();
}

KmBorderLayout.prototype.slideToggle = function(side)
{
    var t = this;
    var fn = function() { t.layout() };
    
	this.getChild(side).slideToggle(1000, 'easeOutBounce', fn);
}

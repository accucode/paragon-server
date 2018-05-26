package com.app.ui.page.crud.abstractBase;

public enum MyCrudLayout
{
    /**
     * The contents are expected to fill the container.
     * The container will be configured as follows:
     *
     * The container uses absolute positioning to fill the available
     * space, less a standard amount of padding.
     *
     * The container has a non-static position (e.g.: relative)
     * so that children can use absolute positioning.
     *
     * The container has a flexColumn (block and column) display
     * so that children can use flexbox layout options.
     */
    fill,

    /**
     * The contents are NOT expected to exactly fill the container.
     * The contents may be smaller, or larger, than the container.
     *
     * Scrollbars are automatically included in the container if
     * the contents are too big.
     *
     * Standard padding is included between the scrollbars and
     * the contents.
     */
    scroll;
}

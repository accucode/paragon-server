//**********************************************************
//**
//** Support methods for the dropdownMenu.
//** Dependencies: jquery
//** dropdownMenu.styl
//**
//**********************************************************

var KmDropdownMenu = {};

/**
 * Install a function automatically closes any/all open
 * dropdown menus when the page receives an onclick event.
 * This should typically only be called once per page.
 */
KmDropdownMenu.installAutoClose = function()
{
    $(document).click(function()
    {
        $('.dropdownMenu').removeClass('open');
    });
}


/**
 * Install the function that toggles the menu open and/or closed
 * when the outer div is clicked.
 *
 * The parameter may be either a jquery reference to the wrapper,
 * or a css selector (e.g.: '#someId') that identifies the wrapper.
 *
 * The parameter is optional.  If not specified, the default value
 * of '.dropdownMenu' is used.
 */
KmDropdownMenu.installMenu = function(e)
{
    if ( !e )
        e = '.dropdownMenu';

    $(e).each(function()
    {
        var self = $(this);
        self.on('click', function(ev)
        {
            self.toggleClass('open');
            ev.stopPropagation();
        });
    });
}


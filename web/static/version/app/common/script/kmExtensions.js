//**********************************************************
//**
//** Javascript extensions
//**
//**********************************************************

if ( typeof String.prototype.startsWith != 'function' ) 
{
    String.prototype.startsWith = function(s)
    {
        return this.slice(0, s.length) == s;
    };
}

if ( typeof String.prototype.endsWith != 'function' ) 
{
    String.prototype.endsWith = function(s)
    {
        return this.slice(-s.length) == s;
    };
}        

//**********************************************************
//**
//** Jquery extensions
//**
//**********************************************************

(function($)
{
    $.fn.setVisible = function(bool) 
    {
  		if ( bool )
  		    this.show();
  		else
  			this.hide();        
    }
    
    $.fn.isVisible = function() 
    {
       	return this.is(':visible');
    }

    /*
     * Extend jquery to run a function when escape is pressed.
     *      $('#someField').onEscape(function(){ doSomething(); });
     */
    $.fn.onEscape = function(fn) 
    {  
        this.bind("keyup", function(ev) 
        {  
            if ( ev.keyCode === 27 ) 
                fn();   
        });
    }

    /*
     * Extend jquery to run a function when control-enter
     * is pressed.  This useful for multiline text fields. 
     *      $('#someField').onEscape(function(){doSomething();});
     */
    $.fn.onControlEnter = function(fn) 
    {  
        this.bind("keyup", function(ev) 
        {  
            if ( ev.ctrlKey && ev.keyCode === 13 ) 
                fn();   
        });
    }
    
})(jQuery);


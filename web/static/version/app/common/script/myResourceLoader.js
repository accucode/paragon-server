var MyResourceLoader =
{
    //**********************************************************
    //** files
    //**********************************************************

    library: "static/{version}/kodemore/loader",
    
    files: 
        [
            // Reset
            "static/{version}/app/theme/default/css/reset.css",

            // JQuery
            "static/{version}/jquery/core/jquery-1.10.2.min.js",
            "static/{version}/jquery/core/jquery-migrate-1.2.1.min.js",

            // JQuery UI
            "static/{version}/jquery/jquery-ui-1.10.3/themes/base/minified/jquery-ui.min.css",
            "static/{version}/jquery/jquery-ui-1.10.3/ui/minified/jquery-ui.min.js",

            // Simple Modal
            "static/{version}/jquery/simplemodal-1.4.4/simplemodal.css",
            "static/{version}/jquery/simplemodal-1.4.4/simplemodal.js",

            // Color Picker
            "static/{version}/jquery/colorpicker-09.05.23/css/colorpicker.css",
            "static/{version}/jquery/colorpicker-09.05.23/js/colorpicker.js",

            // Smooth Menu
            // "static/{version}/jquery/smoothmenu-1.5/ddsmoothmenu.css",
            // "static/{version}/jquery/smoothmenu-1.5/ddsmoothmenu-v.css",
            // "static/{version}/jquery/smoothmenu-1.5/ddsmoothmenu.js",

            // Flexigrid
            "static/{version}/jquery/flexigrid-1.1/css/flexigrid.pack.css",
            "static/{version}/jquery/flexigrid-1.1/js/flexigrid.js",
            
            // Akquinet Toasts
            "static/{version}/jquery/akquinet-0.2.0-13/resources/css/jquery.toastmessage.css",
            "static/{version}/jquery/akquinet-0.2.0-13/javascript/jquery.toastmessage.js",
            
            // CL Editor
            "static/{version}/jquery/cleditor-1.4.3/jquery.cleditor.css",
            "static/{version}/jquery/cleditor-1.4.3/jquery.cleditor.min.js",

            // Block UI
            "static/{version}/jquery/blockUi-2.64.0/jquery.blockUI.js",

            // Cookie
            "static/{version}/jquery/cookie-1.0.0/jquery.cookie.js",

            // Transit
            "static/{version}/jquery/transit-0.9.9/jquery.transit-0.9.9.min.js",
            
            // Chosen
            "static/{version}/jquery/chosen-1.0.0/chosen.min.css",
            "static/{version}/jquery/chosen-1.0.0/chosen.jquery.min.js",
            
            // Dropzone
            "static/{version}/dropzone-3.6.1/dropzone.js",
            "static/{version}/dropzone-3.6.1/dropzone.css",
            
            // Json
            "static/{version}/json-2010.11.18/json2.js",
            
            // Code39 Azalea
            "static/{version}/azaleaCode39/Code39Azalea.min.css", 
            
            // Kodemore
            "static/{version}/app/common/script/kmExtensions.js",
            "static/{version}/app/common/script/kmUtility.js",
            "static/{version}/app/common/script/kmHistory.js",
            "static/{version}/app/common/script/kmBorderLayout.js",
            
            // App
            "static/{version}/app/theme/default/css/tools.css",
            "static/{version}/app/theme/default/css/topMenu.css",
            "static/{version}/app/theme/default/css/button.css",
            "static/{version}/app/theme/default/css/theme.css"
        ],

    //**********************************************************
    //** public
    //**********************************************************
        
    /**
     * Load the files needed for local testing without a servlet container.
     */
    loadTestResources: function(userOptions, version)
    {
        var prefix = "../";
        return this._loadAppResources(userOptions, version, prefix);
    },

    /**
     * Load the files needed in production or when running inside a container.
     */
    loadAppResources: function(userOptions, version)
    {
        var prefix = "/app/";
        return this._loadAppResources(userOptions, version, prefix);
    },

    _loadAppResources: function(userOptions, version, prefix)
    {
        var localOptions = 
        {
            files: this.getFiles(prefix, version),
			library: this.getFile(this.library, prefix, version)
        }; 

        return this.run(localOptions, userOptions);
    },

    //**********************************************************
    //** private
    //**********************************************************

    run: function(localOptions, userOptions)
    {
        // jquery not loaded yet.
        // var options = $.extend({}, localOptions, userOptions);
        
        var options = {};
        
        if ( localOptions )
            for ( key in localOptions )
                options[key] = localOptions[key];
                
        if ( userOptions )
            for ( key in userOptions )
                options[key] = userOptions[key];
    
        KmResourceLoader.load(options);
    },
    
    getFiles: function(prefix, version)
    {
        var input = this.files;
        var output = new Array();
        
        for ( var i in input )
        {
            var s = this.getFile(input[i], prefix, version);
            output.push(s); 
        }
        
        return output;            
    },
    
    getFile: function(input, prefix, version)
    {
        if ( ! version )
            version = "version";
            
        var regex = new RegExp("{version}");
            
        var s;
        s = prefix + input;
        s = s.replace(regex, version);
        return s;
    }
    
}

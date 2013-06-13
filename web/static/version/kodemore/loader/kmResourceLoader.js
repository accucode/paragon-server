/*
  Copyright (c) 2005-2011 www.kodemore.com

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

/*
 * This file contains the minimal scripts used to bootstrap the rest of
 * of the application.  In particular, these scripts cannot rely on jquery.
 *
 * The focus is on dynamically loading the list of javascript and css
 * resources that are required for the rest of the application. We load
 * These files dynamically so that the browser can shows a "loading" 
 * progress bar, rather than just appearing to hang/stall while the 
 * potentially large libraries are downloaded over the internet.
 * 
 * Typical usage is something like:
 * 
 *      KmResourceLoader.load({
 *          title: 'My Title'
 *          onComplete: fn,
 *          files: [...],
 *      });
 */

/**************************************
 * public
 **************************************/

/**
 * The public global variable.
 */
var KmResourceLoader = {};

/**
 * The public method used to load all resources.
 */
KmResourceLoader.load = function(userOptions)
{
    // default options and docs.
	this.options = 
	{
	    parentNode:			document.body,	// The dom node to add this ui to.  
		title: 				null,			// The large title to be displayed.
		message: 			'Loading... ',  // The small message to be displayed.
		onComplete: 		null,          	// A function to call when all resources have been loaded.
		width:				500,			// The width of the progress bar, in pixels
		files: 				[],				// List of string file names to load; must end in ".js" or ".css".
		delay: 				0,				// The delay between files.
		library: 			null,			// The web path to the folder where this library lives.  Required to compose the "ready" files.
		debug: 				false			// If true, some debug logs will be written to the console.
	};
	
	// override options.
	if ( userOptions )
	    for ( key in userOptions )
	        this.options[key] = userOptions[key];
	
    this.fileIndex = 0;
    this.installDom();
    
    this.ready = true;
    this.nextLater();
}

/**************************************
 * private: dom
 **************************************/

KmResourceLoader.installDom = function()
{
	var options = this.options;
	
    if ( ! options.parentNode )
        return;
	
    this.containerDiv = document.createElement('div');
    this.containerDiv.style.position = 'absolute';
    this.containerDiv.style.padding = '10px';
    this.containerDiv.style.left = '0';
    this.containerDiv.style.top = '0';
    
    if ( options.title )
    {
    	var titleText;
    	titleText = document.createTextNode("");
    	titleText.data = options.title;
    	
    	var titleDiv;
    	titleDiv = document.createElement('div');
    	titleDiv.appendChild(titleText);
    	titleDiv.style.font = 'bold 36px sans-serif';
    	titleDiv.style.paddingBottom = '20px';
    
        this.containerDiv.appendChild(titleDiv);
    }
        
    this.messageText = document.createTextNode('');
    this.messageText.data = this.formatMessage();
    
    this.messageDiv = document.createElement('div');
    this.messageDiv.appendChild(this.messageText);
    this.messageDiv.style.font = 'italic bold 20px sans-serif';
    
    this.fileText = document.createTextNode("");
    this.fileText.data = this.formatFile();
    
    this.fileDiv = document.createElement('div');
    this.fileDiv.appendChild(this.fileText);
    this.fileDiv.style.font = 'italic 12px sans-serif';
    
    this.innerProgressDiv = document.createElement('div');
    this.innerProgressDiv.style.width = "0px";
    this.innerProgressDiv.style.height = '6px';
    this.innerProgressDiv.style.backgroundColor = 'green';
    
    this.outerProgressDiv = document.createElement('div');
    this.outerProgressDiv.style.width = options.width + "px";
    this.outerProgressDiv.style.border = 'thin solid green';
    this.outerProgressDiv.style.borderRadius = '6px';
    this.outerProgressDiv.style.MozBorderRadius = '6px';
    this.outerProgressDiv.style.webkitBorderRadius = '6px';
    this.outerProgressDiv.style.overflow = 'hidden';
    this.outerProgressDiv.appendChild(this.innerProgressDiv);
    
    this.containerDiv.appendChild(this.messageDiv);
    this.containerDiv.appendChild(this.outerProgressDiv);
    this.containerDiv.appendChild(this.fileDiv);
    
    options.parentNode.appendChild(this.containerDiv);
}

KmResourceLoader.uninstallDom = function()
{
    if ( this.options.parentNode && this.containerDiv )
    {
        this.options.parentNode.removeChild(this.containerDiv);
        this.containerDiv = null;
    }
}

/**************************************
 * private: support
 **************************************/

KmResourceLoader.formatMessage = function()
{
    var percent = this.getPercent();
    var msg = this.options.message;
    var suffix = percent.toString() + "%";
    
    if ( msg )
        return msg + suffix;
        
    return suffix;
}

KmResourceLoader.formatFile = function()
{
    var f = this.getCurrentFile();
    return f;
}

KmResourceLoader.isDone = function()
{
    return this.getPercent() == 100;
}

KmResourceLoader.getPercent = function()
{
    var i = this.fileIndex;
    var n = this.options.files.length;
    
    if ( !n )
        return 100;
        
    return Math.floor(i / n * 100);
}

KmResourceLoader.getCurrentFile = function()
{
    var i = this.fileIndex;
    var n = this.options.files.length;
    
    if ( i < 0 || i >= n )
        return null;
        
    return this.options.files[i];
}
    
/**************************************
 * private: process files
 **************************************/

/**
 * Update the visual status and load the next file.
 * Then recursively call myself until no more files are left. 
 */
KmResourceLoader.next = function()
{
    if ( ! this.ready )
    {
    	this.nextLater();
    	return;
    }
    
    if ( this.isDone() )
    {
        this.completeLater();
        return;
    }

    this.ready = false;
    this.loadCurrentFile();
    this.loadReadyFile();
    
    this.fileIndex++;
    
    this.fileText.data = this.formatFile();
    this.messageText.data = this.formatMessage();
    this.updateProgressBar();
    this.nextLater();
}

KmResourceLoader.updateProgressBar = function()
{
    var p = this.getPercent();
    var w = this.options.width * p / 100;
    this.innerProgressDiv.style.width = w.toString() + "px";
}

KmResourceLoader.nextLater = function()
{
    var fn = "KmResourceLoader.next();"
    var delay = this.options.delay;
    setTimeout(fn, delay);
}

KmResourceLoader.completeLater = function()
{
    var fn = "KmResourceLoader.complete();"
    var delay = this.options.delay;
    setTimeout(fn, delay);
}

KmResourceLoader.complete = function()
{
    this.uninstallDom();

    if ( this.options.onComplete )
        this.options.onComplete();
}

/**************************************
 * private: load
 **************************************/

KmResourceLoader.loadCurrentFile = function()
{
    var f = this.getCurrentFile();
    if ( f )
        this.loadFile(f);
}

KmResourceLoader.loadReadyFile = function()
{
    var f = this.options.library + "/ready" + this.fileIndex + ".js";
    this.loadFile(f);
}

KmResourceLoader.loadFile = function(file)
{
    if ( this.endsWith(file, '.js') )
        this.loadJs(file);
    
    if ( this.endsWith(file, '.css') )
        this.loadCss(file);
}

KmResourceLoader.loadJs = function(file)
{
    var e;
    e = document.createElement('script')
    e.setAttribute("type","text/javascript")
    e.setAttribute("src", file)

  	this.debug('appendToHead (js): ' + file);

    this.appendToHead(e);            
}

KmResourceLoader.loadCss = function(file)
{
    var e;
    e = document.createElement("link")
    e.setAttribute("rel", "stylesheet")
    e.setAttribute("type", "text/css")
    e.setAttribute("href", file)

	this.debug('appendToHead (css): ' + file);

    this.appendToHead(e);            
}

KmResourceLoader.appendToHead = function(e)
{
    document.getElementsByTagName('head')[0].appendChild(e);
}

/**************************************
 * private: utility
 **************************************/

KmResourceLoader.endsWith = function(s, suffix)
{
    return s.indexOf(suffix) == s.length - suffix.length;
}

KmResourceLoader.debug = function(s)
{
    if ( this.options.debug )
    	return console.log(s);
}



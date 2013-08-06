/**
 * 
 * THIS IS A TEST 
 * 
 */

(function($) {
	$.fn.equalHeightsWidths = function(minHeight, maxHeight, minWidth, maxWidth) {
		tallest = (minHeight) ? minHeight : 0;
		widest = (minWidth) ? minWidth : 0;
		this.each(function() {
			if($(this).height() > tallest) {
				tallest = $(this).height();
			}
			if($(this).width() > widest) {
				widest = $(this).width();
			}
		});
		if((maxHeight) && tallest > maxHeight) tallest = maxHeight;
		if((maxWidth) && widest > maxWidth) widest = maxWidth;
		return this.each(function() {
			$(this).height(tallest).css("overflow","auto");
			$(this).width(widest).css("overflow","auto");
		});
	}
})(jQuery);
/**
 * Popr 1.0 (modded by Wyatt Love)
 * Copyright (c) 2015 Tipue
 * popr is released under the MIT License
 * http://www.tipue.com/popr
 *
 *
 * Wyatt Love, 9/14/2016
 * Copyright (c) 2016 Accucode Inc.
 * MIT License
 * Modified the javascript and css to work correctly when used
 * inside nested relative/absolute layout. The popup is now
 * attached to the outermost html 'body' instead of attaching
 * to the original menu target. This allows the popup to be
 * correctly positioned, and also ensures that it is not clipped
 * by its container. The z-index is still hardcoded to 1000 in
 * the css but this can be adjusted as needed.
 */

(function($) {

    $.fn.popr = function(options)
    {
        var settings = $.extend(
        {
            'speed' : 200,
            'mode'  : 'bottom'

        }, options);

        return this.each(function()
        {
            var target
            target = $(this);
            target.removeAttr('title alt');

            var showing = false;

            target.click(function(event)
            {
                if ( showing )
                    return;

                event.stopPropagation();
                $('.popr_container').remove();
                showing = true;

                var mode = settings.mode;
                if ( target.attr('data-mode') )
                     mode = target.attr('data-mode')

                var out =
                      '<div class="popr_container popr_container_' + mode + '">'
                    +     '<div class="popr_point_' + mode + '">'
                    +         '<div class="popr_content">'
                    +              $('div[data-box-id="' + target.attr('data-id') + '"]').html()
                    +         '</div>'
                    +     '</div>'
                    + '</div>';
                $('body').append(out);

                var popup = $('.popr_container');

                var left = target.offset().left + (target.outerWidth() / 2) - (popup.outerWidth() / 2);

                var top = (mode == 'top')
                    ? target.offset().top - popup.outerHeight()
                    : target.offset().top + target.outerHeight();

                popup.css('left', left + 'px');
                popup.css('top',  top  + 'px');
                popup.fadeIn(settings.speed);
            });

            $('html').click(function()
            {
                $('.popr_container').remove();
                showing = false;
            });
        });
    };

})(jQuery);

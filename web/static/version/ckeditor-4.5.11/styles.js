﻿/**
 * Copyright (c) 2003-2016, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

// This file contains style definitions that can be used by CKEditor plugins.
//
// The most common use for it is the "stylescombo" plugin, which shows a combo
// in the editor toolbar, containing all styles. Other plugins instead, like
// the div plugin, use a subset of the styles on their feature.
//
// If you don't have plugins that depend on this file, you can simply ignore it.
// Otherwise it is strongly recommended to customize this file to match your
// website requirements and design properly.

CKEDITOR.stylesSet.add( 'default', [
    /* block Styles */

    // none

    /* inline Styles */

    {
        name: 'Heading 1',
        element: 'span',
        styles:
        {
            'font': 'bold 2.4rem sans-serif',
            'margin-bottom': '10px'
        }
    },
    {
        name: 'Heading 2',
        element: 'span',
        styles:
        {
            'font': 'bold italic 2rem sans-serif',
            'color': '#777',
            'margin-bottom': '10px'
        }
    },
    {
        name: 'Heading 3',
        element: 'span',
        styles:
        {
            'font-size': '1.6rem',
            'color': '#777',
            'margin-bottom': '10px'
        }
    },


    /* object Styles */

    {
        name: 'Table Borders',
        element: 'table',
        attributes: { 'class': 'rte-tableBorders' }
    }
] );


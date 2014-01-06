/*
  Copyright (c) 2005-2014 www.kodemore.com

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

package com.kodemore.sql;

import com.kodemore.log.KmLogger;
import com.kodemore.utility.KmConstantsIF;

/**
 * Constants used by the sql library.
 */
public interface KmSqlConstantsIF
    extends KmConstantsIF
{
    //##################################################
    //# loggers
    //##################################################

    KmLogger SqlStatementLogger           = KmLogger.create("com.kodemore.sql.statement");
    KmLogger SqlTransactionLogger         = KmLogger.create("com.kodemore.sql.transaction");
    KmLogger SqlConnectionLogger          = KmLogger.create("com.kodemore.sql.connection");
    KmLogger SqlPoolingLogger             = KmLogger.create("com.kodemore.sql.pooling");

    //##################################################
    //# money
    //##################################################

    String   KM_SQL_MONEY_AMOUNT_SUFFIX   = "Amount";
    String   KM_SQL_MONEY_CURRENCY_SUFFIX = "Currency";

    //##################################################
    //# strings
    //##################################################

    String   STRING_BACKSLASH             = "\\";
    String   STRING_DOT                   = ".";
    String   STRING_COLON                 = ":";
    String   STRING_DASH                  = "-";
    String   STRING_SPACE                 = " ";
    String   STRING_TICK                  = "'";
    String   STRING_BACK_TICK             = "`";
    String   STRING_QUOTE                 = "\"";
    String   STRING_OPEN_PAREN            = "(";
    String   STRING_CLOSE_PAREN           = ")";
    String   STRING_LIST_DELIMITER        = ", ";
    String   STRING_AND                   = "AND";
    String   STRING_OR                    = "OR";
    String   STRING_EQUAL                 = " = ";
    String   STRING_NEW_LINE              = "\n";

    //##################################################
    //# characters
    //##################################################

    char     CHAR_NULL                    = 0;
    char     CHAR_BACKSLASH               = '\\';
    char     CHAR_DOT                     = '.';
    char     CHAR_COLON                   = ':';
    char     CHAR_COMMA                   = ',';
    char     CHAR_DASH                    = '-';
    char     CHAR_SPACE                   = ' ';
    char     CHAR_QUOTE                   = '"';
    char     CHAR_TICK                    = '\'';
    char     CHAR_BACK_TICK               = '`';
    char     CHAR_OPEN_PAREN              = '(';
    char     CHAR_CLOSE_PAREN             = ')';
    char     CHAR_OPEN_BRACE              = '{';
    char     CHAR_CLOSE_BRACE             = '}';

}

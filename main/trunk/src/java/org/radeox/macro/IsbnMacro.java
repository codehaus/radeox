/*
 *      Copyright 2001-2004 Fraunhofer Gesellschaft, Munich, Germany, for its 
 *      Fraunhofer Institute Computer Architecture and Software Technology
 *      (FIRST), Berlin, Germany
 *      
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


package org.radeox.macro;

import org.radeox.macro.book.BookServices;
import org.radeox.macro.parameter.MacroParameter;

import java.io.IOException;
import java.io.Writer;

/*
 * Macro for displaying links to external book services, book dealers or
 * intranet libraries. IsbnMacro reads the mapping from names to
 * urls from a configuration file and then maps an ISBN number
 * like {isbn:1234} to the book e.g. on Amazon.
 *
 * @author stephan
 * @team sonicteam
 * @version $Id: IsbnMacro.java,v 1.7 2004/04/27 19:30:38 leo Exp $
 */

public class IsbnMacro extends BaseLocaleMacro {
  public String getLocaleKey() {
    return "macro.isbn";
  }

  public void execute(Writer writer, MacroParameter params)
      throws IllegalArgumentException, IOException {

    if (params.getLength() == 1) {
      BookServices.getInstance().appendUrl(writer, params.get("0"));
      return;
    } else {
      throw new IllegalArgumentException("needs an ISBN number as argument");
    }
  }
}

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

import org.radeox.macro.parameter.MacroParameter;
import org.radeox.macro.table.Table;
import org.radeox.macro.table.TableBuilder;

import java.io.IOException;
import java.io.Writer;

/*
 * Macro for defining and displaying tables. The rows of the table are
 * devided by newlins and the columns are divided by pipe symbols "|".
 * The first line of the table is rendered as column headers.
 * {table}
 *  A|B|C
 *  1|2|3
 * {table}
 *
 * @author stephan
 * @team sonicteam
 * @version $Id: TableMacro.java,v 1.9 2004/04/27 19:30:38 leo Exp $
 */

public class TableMacro extends BaseLocaleMacro {
  public String getLocaleKey() {
    return "macro.table";
  }

  public void execute(Writer writer, MacroParameter params)
      throws IllegalArgumentException, IOException {

    String content = params.getContent();

    if (null == content) throw new IllegalArgumentException("TableMacro: missing table content");

    content = content.trim() + "\n";

    Table table = TableBuilder.build(content);
    table.calc(); // calculate macros like =SUM(A1:A3)
    table.appendTo(writer);
    return;
  }
}

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


package org.radeox.util;

import org.radeox.regex.Pattern;
import org.radeox.regex.Matcher;
import org.radeox.regex.Substitution;
import org.radeox.regex.MatchResult;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*
 * Escapes and encodes Strings for web usage
 *
 * @author stephan
 * @version $Id: Encoder.java,v 1.8 2004/09/06 19:25:33 leo Exp $
 */

public class Encoder {
  private final static String DELIMITER = "&\"'<>[]";
  private final static Map ESCAPED_CHARS = new HashMap();
  // private final static Pattern entityPattern = Pattern.compile("&(#?[0-9a-fA-F]+);");

  static {
    ESCAPED_CHARS.put("&", toEntity('&'));
    ESCAPED_CHARS.put("\"", toEntity('"'));
    ESCAPED_CHARS.put("'", toEntity('\''));
    ESCAPED_CHARS.put(">", toEntity('>'));
    ESCAPED_CHARS.put("<", toEntity('<'));
    ESCAPED_CHARS.put("[", toEntity('['));
    ESCAPED_CHARS.put("]", toEntity(']'));
  }

  /**
   * Encoder special characters that may occur in a HTML so it can be displayed
   * safely.
   * @param str the original string
   * @return the escaped string
   */
  public static String escape(String str) {
    StringBuffer result = new StringBuffer();
    StringTokenizer tokenizer = new StringTokenizer(str, DELIMITER, true);
    while(tokenizer.hasMoreTokens()) {
      String currentToken = tokenizer.nextToken();
      if(ESCAPED_CHARS.containsKey(currentToken)) {
        result.append(ESCAPED_CHARS.get(currentToken));
      } else {
        result.append(currentToken);
      }
    }
    return result.toString();
  }

  public static String unescape(String str) {
    StringBuffer result = new StringBuffer();

    org.radeox.regex.Compiler compiler = org.radeox.regex.Compiler.create();
    Pattern entityPattern = compiler.compile("&(#?[0-9a-fA-F]+);");

    Matcher matcher = Matcher.create(str, entityPattern);
    result.append(matcher.substitute(new Substitution() {
      public void handleMatch(StringBuffer buffer, MatchResult result) {
        buffer.append(toChar(result.group(1)));
      }
    }));
    return result.toString();
  }

  public static String toEntity(int c) {
    return "&#" + c + ";";
  }

  public static char toChar(String number) {
    return (char) Integer.decode(number.substring(1)).intValue();
  }
}

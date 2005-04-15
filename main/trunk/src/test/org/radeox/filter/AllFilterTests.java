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


package org.radeox.filter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllFilterTests extends TestCase {
  public AllFilterTests(String name) {
    super(name);
  }

  public static Test suite() {
    TestSuite s = new TestSuite();
    s.addTestSuite(BasicRegexTest.class);
    s.addTestSuite(ItalicFilterTest.class);
    s.addTestSuite(BoldFilterTest.class);
    s.addTestSuite(KeyFilterTest.class);
    s.addTestSuite(NewlineFilterTest.class);
    s.addTestSuite(LineFilterTest.class);
    s.addTestSuite(TypographyFilterTest.class);
    s.addTestSuite(HtmlRemoveFilterTest.class);
    s.addTestSuite(StrikeThroughFilterTest.class);
    s.addTestSuite(UrlFilterTest.class);
    s.addTestSuite(ParamFilterTest.class);
    s.addTestSuite(FilterPipeTest.class);
    s.addTestSuite(EscapeFilterTest.class);
    s.addTestSuite(InterWikiTest.class);
    s.addTestSuite(LinkTestFilterTest.class);
    s.addTestSuite(WikiLinkFilterTest.class);
    s.addTestSuite(SmileyFilterTest.class);
    s.addTestSuite(ListFilterTest.class);
    s.addTestSuite(HeadingFilterTest.class);
    return s;
  }

}

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


package org.radeox.api.engine.context;

import org.radeox.api.engine.RenderEngine;

import java.util.Map;


/**
 * RenderContext stores basic data for the context
 * the RenderEngine is called in. RenderContext
 * can be used by the Engine in whatever way it likes to.
 * The Radeox RenderEngine uses RenderContext to
 * construct FilterContext.
 *
 * @author Stephan J. Schmidt
 * @version $Id: RenderContext.java,v 1.2 2004/01/30 08:42:56 stephan Exp $
 */

public interface RenderContext {
  public final static String INPUT_BUNDLE_NAME = "RenderContext.input_bundle_name";
  public final static String OUTPUT_BUNDLE_NAME = "RenderContext.output_bundle_name";
  public final static String LANGUAGE_BUNDLE_NAME = "RenderContext.language_bundle_name";
  public final static String LANGUAGE_LOCALE = "RenderContext.language_locale";
  public final static String INPUT_LOCALE = "RenderContext.input_locale";
  public final static String OUTPUT_LOCALE = "RenderContext.output_locale";
  public final static String DEFAULT_FORMATTER = "RenderContext.default_formatter";

  /**
   * Returns the RenderEngine handling this request.
   *
   * @return engine RenderEngine handling the request within this context
   */
  public RenderEngine getRenderEngine();

  /**
   * Stores the current RenderEngine of the request
   *
   * @param engine Current RenderEnginge
   */
  public void setRenderEngine(RenderEngine engine);

  public Object get(String key);

  public void set(String key, Object value);

  public Map getParameters();

  /**
   * Set the parameters for this execution context. These
   * parameters are read when encountering a variable in
   * macros like {search:$query} or by ParamFilter in {$query}.
   * Query is then read from
   * the parameter map before given to the macro
   *
   * @param parameters Map of parameters with name,value pairs
   */
  public void setParameters(Map parameters);

  public void setCacheable(boolean cacheable);

  public void commitCache();

  public boolean isCacheable();
}

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


package org.radeox.api.engine;

import org.radeox.api.engine.context.RenderContext;
import org.radeox.api.engine.context.InitialRenderContext;

import java.io.IOException;
import java.io.Writer;
import java.io.Reader;

/**
 * Interface for RenderEngines. A RenderEngine renders
 * a input string to an output string with the help
 * of filters.
 *
 * @author Stephan J. Schmidt
 * @version $Id: RenderEngine.java,v 1.2 2004/04/14 13:03:25 stephan Exp $
 */

public interface RenderEngine {
  /**
   * Name of the RenderEngine. This is used to get a RenderEngine instance
   * with EngineManager.getInstance(name);
   *
   * @return name Name of the engine
   */
  public String getName();

  /**
   * Render an input with text markup and return a String with
   * e.g. HTML
   *
   * @param content String with the input to render
   * @param context Special context for the render engine, e.g. with
   *                configuration information
   * @return result Output with rendered content
   */
  public String render(String content, RenderContext context);

  /**
   * Render an input with text markup and an write the result
   * e.g. HTML to a writer
   *
   * @param out Writer to write the output to
   * @param content String with the input to render
   * @param context Special context for the render engine, e.g. with
   *                configuration information
   */

  public void render(Writer out, String content, RenderContext context) throws IOException;

  /**
   * Render an input with text markup from a Reader and write the result to a writer
   *
   * @param in Reader to read the input from
   * @param context Special context for the render engine, e.g. with
   *                configuration information
   */
  public String render(Reader in, RenderContext context) throws IOException;

  //public void render(Writer out, Reader in, RenderContext context);

  /**
   * Return the InitialRenderContext of the RenderEngine
   *
   * @return initialRenderContext of the RenderEngine
   */
  public InitialRenderContext getInitialRenderContext();

}

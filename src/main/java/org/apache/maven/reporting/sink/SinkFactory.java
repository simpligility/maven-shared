package org.apache.maven.reporting.sink;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import org.apache.maven.doxia.module.xhtml.decoration.render.RenderingContext;
import org.apache.maven.doxia.sink.Sink;
import org.apache.maven.doxia.siterenderer.Renderer;
import org.apache.maven.doxia.siterenderer.RendererException;
import org.apache.maven.doxia.siterenderer.sink.SiteRendererSink;

import java.io.File;
import java.io.IOException;

/**
 * @author <a href="evenisse@apache.org">Emmanuel Venisse</a>
 * @version $Id: MavenReport.java 163376 2005-02-23 00:06:06Z brett $
 */
public class SinkFactory
{
    private String siteDirectory;

    private Renderer siteRenderer;

    public void setSiteRenderer( Renderer siteRenderer )
    {
        this.siteRenderer = siteRenderer;
    }

    public void setSiteDirectory( String siteDirectory )
    {
        this.siteDirectory = siteDirectory;
    }

    public Sink getSink( String outputFileName )
        throws RendererException, IOException
    {
        return createSink( new File( siteDirectory ), outputFileName );
    }

    public static SiteRendererSink createSink( File basedir, String document )
    {
        return new SiteRendererSink( new RenderingContext( basedir, document ) );
    }
}
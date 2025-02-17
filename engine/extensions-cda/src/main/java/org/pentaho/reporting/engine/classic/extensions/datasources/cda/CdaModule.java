/*!
* This program is free software; you can redistribute it and/or modify it under the
* terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
* Foundation.
*
* You should have received a copy of the GNU Lesser General Public License along with this
* program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
* or from the Free Software Foundation, Inc.,
* 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*
* This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
* without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
* See the GNU Lesser General Public License for more details.
*
* Copyright (c) 2002-2017 Hitachi Vantara..  All rights reserved.
*/

package org.pentaho.reporting.engine.classic.extensions.datasources.cda;

import org.pentaho.reporting.engine.classic.core.metadata.ElementMetaDataParser;
import org.pentaho.reporting.engine.classic.core.modules.parser.base.DataFactoryReadHandlerFactory;
import org.pentaho.reporting.engine.classic.core.modules.parser.base.DataFactoryXmlResourceFactory;
import org.pentaho.reporting.engine.classic.extensions.datasources.cda.parser.CdaDataSourceReadHandler;
import org.pentaho.reporting.engine.classic.extensions.datasources.cda.parser.CdaDataSourceXmlFactoryModule;
import org.pentaho.reporting.libraries.base.boot.AbstractModule;
import org.pentaho.reporting.libraries.base.boot.ModuleInitializeException;
import org.pentaho.reporting.libraries.base.boot.SubSystem;

public class CdaModule extends AbstractModule {
  public static final String NAMESPACE = "http://jfreereport.sourceforge.net/namespaces/datasources/cda";
  public static final String TAG_DEF_PREFIX =
    "org.pentaho.reporting.engine.classic.extensions.datasources.cda.tag-def.";

  public CdaModule() throws ModuleInitializeException {
    loadModuleInfo();
  }

  public void initialize( final SubSystem subSystem ) throws ModuleInitializeException {
    DataFactoryXmlResourceFactory.register( CdaDataSourceXmlFactoryModule.class );

    DataFactoryReadHandlerFactory.getInstance()
      .setElementHandler( NAMESPACE, "cda-datasource", CdaDataSourceReadHandler.class );

    ElementMetaDataParser.initializeOptionalDataFactoryMetaData
      ( "org/pentaho/reporting/engine/classic/extensions/datasources/cda/meta-datafactory.xml" );

  }
}

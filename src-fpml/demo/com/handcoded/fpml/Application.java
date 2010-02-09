// Copyright (C),2005-2008 HandCoded Software Ltd.
// All rights reserved.
//
// This software is licensed in accordance with the terms of the 'Open Source
// License (OSL) Version 3.0'. Please see 'license.txt' for the details.
//
// HANDCODED SOFTWARE LTD MAKES NO REPRESENTATIONS OR WARRANTIES ABOUT THE
// SUITABILITY OF THE SOFTWARE, EITHER EXPRESS OR IMPLIED, INCLUDING BUT NOT
// LIMITED TO THE IMPLIED WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
// PARTICULAR PURPOSE, OR NON-INFRINGEMENT. HANDCODED SOFTWARE LTD SHALL NOT BE
// LIABLE FOR ANY DAMAGES SUFFERED BY LICENSEE AS A RESULT OF USING, MODIFYING
// OR DISTRIBUTING THIS SOFTWARE OR ITS DERIVATIVES.

package demo.com.handcoded.fpml;

import java.io.File;
import java.io.FileFilter;
import java.util.logging.Logger;
import java.util.Vector;

import org.xml.sax.SAXException;

import com.handcoded.framework.Option;
import com.handcoded.xml.XmlUtility;
import com.handcoded.xml.resolver.Catalog;
import com.handcoded.xml.resolver.CatalogManager;
import com.handcoded.fpml.Releases;

/**
 * The <CODE>Application</CODE> contains some standard option handling
 * that is common to all FpML demonstration applications.
 *
 * @author	BitWise
 * @version	$Id$
 * @since	TFP 1.0
 */
public abstract class Application extends com.handcoded.framework.Application
{
	/**
	 * Constructs a <CODE>Application</CODE> instance.
	 * @since	TFP 1.0
	 */
	protected Application ()
	{ }

	/**
	 * {@inheritDoc}
	 * @since	TFP 1.0
	 */
	protected void startUp ()
	{
		super.startUp();

		// Initialise the default catalog
		String		catalogPath = "files/catalog-fpml.xml";
		
		if (catalogOption.isPresent ()) {
			if (catalogOption.getValue() != null)
				catalogPath = catalogOption.getValue ();
			else
				logger.severe ("Missing argument for -catalog option");
		}

		try {
			XmlUtility.setDefaultCatalog (CatalogManager.find (catalogPath));
		}
		catch (SAXException error) {
			logger.severe ("Failed to parse XML catalog");
			System.exit (1);
		}

		// Activate the FpML Schemas
		XmlUtility.getDefaultSchemaSet ().add (Releases.R4_0);
		XmlUtility.getDefaultSchemaSet ().add (Releases.R4_1);
		XmlUtility.getDefaultSchemaSet ().add (Releases.R4_2);
		XmlUtility.getDefaultSchemaSet ().add (Releases.R4_3);
		XmlUtility.getDefaultSchemaSet ().add (Releases.R4_4);
		XmlUtility.getDefaultSchemaSet ().add (Releases.R4_5);
		XmlUtility.getDefaultSchemaSet ().add (Releases.R4_6);
		XmlUtility.getDefaultSchemaSet ().add (Releases.R4_7);
		
		XmlUtility.getDefaultSchemaSet ().add (Releases.R5_0_CONFIRMATION);
		XmlUtility.getDefaultSchemaSet ().add (Releases.R5_0_PRETRADE);
		XmlUtility.getDefaultSchemaSet ().add (Releases.R5_0_REPORTING);
	}

	/**
	 * Provides access to the <CODE>Catalog</CODE> instance to be used for
	 * entity resolution. If the <CODE>-catalog</CODE> option was not specified
	 * then the result will be <CODE>null</CODE>
	 *
	 * @return	The <CODE>Catalog</CODE> instance or <CODE>null</CODE>.
	 * @since	TFP 1.0
	 */
	protected final Catalog getCatalog ()
	{
		return (catalog);
	}
	
	/**
	 * Process the paths given on the command line trying to expand out
	 * any that refer to directories.
	 * 
	 * @param 	arguments			File paths from the command line.
	 * @return	An array of XML file paths.
	 * @since	TFP 1.2
	 */
	protected String [] findFiles (String [] arguments)
	{
		Vector			result = new Vector ();
		
		for (int index = 0; index < arguments.length; ++index)
			addFile (result, new File (arguments [index]));
			
		String [] paths = new String [result.size ()];
		result.copyInto (paths);
		return (paths);
	}
	
	/**
	 * Logging instance used for error reporting.
	 * @since	TFP 1.0
	 */
	private static Logger		logger
		= Logger.getLogger ("demo.com.handcoded.fpml");

	/**
	 * A command line option that allows the default catalog to be overriden.
	 * @since	TFP 1.0
	 */
	private Option				catalogOption
		= new Option ("-catalog", "Use url to create an XML catalog for parsing", "url");

	/**
	 * The <CODE>Catalog</CODE> instance if specified by the options.
	 * @since	TFP 1.0
	 */
	private Catalog				catalog	= null;
	
	/**
	 * If the <CODE>File</CODE> argument is a file then just add it to the list
	 * of paths to be processed. If its a directory recursive look inside for
	 * more XML files and directories.
	 * 
	 * @param 	paths			A <CODE>Vector</CODE> of paths found so far.
	 * @param 	file			The <CODE>File</CODE> under consideration.
	 * @since	TFP 1.2
	 */
	private void addFile (Vector paths, File file)
	{
		if (file.isDirectory ()) {
			File [] files = file.listFiles (
				new FileFilter ()
				{
					public boolean accept (File file)
					{
						return (file.isDirectory() || (file.isFile() && file.getName().endsWith(".xml")));
					}
				});
			
			for (int index = 0; index < files.length; ++index)
				addFile (paths, files [index]);
		}
		else
			paths.add (file.getPath ());
	}
}
// Copyright (C),2005-2011 HandCoded Software Ltd.
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
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.w3c.dom.Document;

import com.handcoded.fpml.DefaultHelper;
import com.handcoded.fpml.Releases;
import com.handcoded.framework.Option;
import com.handcoded.meta.Conversion;
import com.handcoded.meta.ConversionException;
import com.handcoded.meta.Release;
import com.handcoded.meta.SchemaRelease;
import com.handcoded.meta.Specification;
import com.handcoded.xml.XmlUtility;
import com.handcoded.xml.writer.NestedWriter;

/**
 * This application demonstrates the conversion components being used to
 * convert an FpML document to another version.
 * 
 * @author	BitWise
 * @version	$Id$
 * @since	TFP 1.6
 */
public final class Convert extends Application
{
	/**
	 * Creates an application instance and invokes its <CODE>run</CODE>
	 * method passing the command line arguments.
	 * 
	 * @param 	arguments		The command line arguments
	 * @since	TFP 1.6
	 */
	public static void main (String [] arguments)
	{   
		new Convert ().run (arguments);
	}

	/**
	 * {@inheritDoc}
	 * @since	TFP 1.6
	 */
	@Override
	protected void startUp ()
	{
		super.startUp ();
		
		if (!targetOption.isPresent ()) {
			logger.severe ("No target version specified.");
			System.exit (1);
		}
		
		if (!outputOption.isPresent ()) {
			logger.severe ("No output directory was specified.");
			System.exit (1);
		}

		directory = new File (outputOption.getValue ());
		if (directory.exists ()) {
			if (!directory.isDirectory ()) {
				logger.severe ("The output target exists and is not a directory");
				System.exit (1);
			}
		}
		else {
			if (!directory.mkdir ()) {
				logger.severe ("Failed to create output directory");
				System.exit (1);
			}
		}
	}
	
	/**
	 * {@inheritDoc}
	 * @since	TFP 1.6
	 */
	@Override
	protected void execute ()
	{
		String []	arguments = findFiles (getArguments ());
		

		for (String filename : arguments) {
			File	 	file	 = new File (filename);
			Document 	document = XmlUtility.nonValidatingParse (file);
			
			System.out.println (">> " + filename);
			
			Release source = Specification.releaseForDocument (document);
			Release target = compatibleRelease (source, targetOption.getValue ());
			
			if (target == null) {
				System.out.println ("!! No compatible target FpML release");
				continue;
			}
			
			Conversion	conversion = Conversion.conversionFor (source, target);
			
			if (conversion == null) {
				System.out.println ("!! No conversion path exists to the target version");
				continue;
			}
			
			try {
				Document newDocument = conversion.convert (document, new DefaultHelper ());
				
				try {
				OutputStream	stream = new FileOutputStream (new File (directory, file.getName ()));
				
				new NestedWriter (stream).write (newDocument);
				stream.close ();
				}
				catch (Exception error) {
					logger.log (Level.SEVERE, "Exception while writing converted XML document", error);
				}
			}
			catch (ConversionException error) {
				logger.log (Level.SEVERE, "FpML document conversion failed", error);
				continue;
			}
		}
		setFinished (true);
	}

	/**
	 * {@inheritDoc} 
	 * @since	TFP 1.6
	 */
	@Override
	protected String describeArguments ()
	{
		return (" files or directories ...");
	}
	
	/**
	 * A <CODE>Logger</CODE> instance used to report serious errors.
	 * @since	TFP 1.6
	 */
	private static Logger	logger
		= Logger.getLogger ("demo.com.handcoded.fpml.Convert");

	/**
	 * The <CODE>Option</CODE> instance use to detect <CODE>-target version</CODE>
	 * @since	TFP 1.6
	 */
	private Option			targetOption
		= new Option ("-target", "The target version of FpML", "version");
	
	/**
	 * The <CODE>Option</CODE> instance use to detect <CODE>-output directory</CODE>
	 * @since	TFP 1.6
	 */
	private Option			outputOption
		= new Option ("-output", "The output directory", "directory");
	
	private File			directory;
	
	/**
	 * Constructs a <CODE>Validate</CODE> instance.
	 * @since	TFP 1.6
	 */
	private Convert ()
	{ }
	
	/**
	 * Attempts to locate a version of FpML that matches the target version
	 * number while taking the view into account if appropriate.
	 *  
	 * @param	source			The source <CODE>Release</CODE>.
	 * @param	targetVersion	The target version number.
	 * @return	The target <CODE>Release</CODE> or <CODE>null</CODE> if no
	 * 			suitable release exists.
	 * @since	TFP 1.6
	 */
	private Release compatibleRelease (Release source, String targetVersion)
	{
		if (targetVersion.startsWith ("5-")) {
			if (source.getVersion ().startsWith ("5-")) {
				String view = extractView (((SchemaRelease) source).getNamespaceUri ());
				
				Enumeration<Release> cursor = Releases.FPML.releases ();
				while (cursor.hasMoreElements ()) {
					Release target = cursor.nextElement ();
					if (target.getVersion ().equals (targetVersion)) {
						if (view.equals (extractView (((SchemaRelease) target).getNamespaceUri ())))
							return (target);
					}
				}
			}
			return (null);
		}
		
		// Otherwise 
		return (Releases.FPML.getReleaseForVersion (targetVersion));
	}
	
	/**
	 * Extract the name of the FpML view from the final section of the namespace
	 * URI string.
	 * 
	 * @param	uri				The namespace URI string.
	 * @return	The view name string (e.g. confirmation, reporting, etc.).
	 * @since	TFP 1.6
	 */
	private String extractView (String uri)
	{
		int index 		= uri.lastIndexOf ('/');
		
		return ((index != -1) ? uri.substring (index + 1) : null);
	}
}
// Copyright (C),2005-2006 HandCoded Software Ltd.
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

package com.handcoded.meta;

import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * The <CODE>SchemaRelease</CODE> class adds support for the <CODE>Schema</CODE>
 * interface to the base <CODE>Release</CODE> class.
 * 
 * @author 	BitWise
 * @version	$Id$
 * @since	TFP 1.0
 */
public class SchemaRelease extends Release implements Schema
{
	/**
	 * Constructs a <CODE>SchemaRelease</CODE> instance describing a schema
	 * based release of a particular <CODE>Specification</CODE>.
	 * <P>
	 * This constructor should be used when creating a description of a pure
	 * extension schema, i.e. one that contains no useable root elements.
	 * <P>
	 * Default implementations of <CODE>InstanceInitialiser</CODE> and
	 * <CODE>SchemaRecogniser</CODE> will be created during construction.
	 * 
	 * @param 	specification	A reference to the owning specification.
	 * @param 	version			The version identifier for this release.
	 * @param 	namespaceUri	The namespace used to identify the schema.
	 * @param 	schemaLocation	The default schema location.
	 * @param 	preferredPrefix	The preferred prefix for the namespace.
	 * @param 	alternatePrefix	The alternate prefix for the namespace.
	 * @since	TFP 1.0
	 */
	public SchemaRelease (Specification specification, final String version,
			final String namespaceUri, final String schemaLocation,
			final String preferredPrefix, final String alternatePrefix)
	{
		this (specification, version, namespaceUri, schemaLocation,
				preferredPrefix, alternatePrefix, (String []) null);
	}
	
	/**
	 * Constructs a <CODE>SchemaRelease</CODE> instance describing a schema
	 * based release of a particular <CODE>Specification</CODE>.
	 * <P>
	 * This constructor should be used when creating a description of a pure
	 * extension schema, i.e. one that contains no useable root elements.
	 * <P>
	 * If <CODE>InstanceInitialiser</CODE> and <CODE>SchemaRecogniser</CODE>
	 * instances are not provided then default ones will be created during
	 * construction.
	 * 
	 * @param 	specification	A reference to the owning specification.
	 * @param 	version			The version identifier for this release.
	 * @param 	namespaceUri	The namespace used to identify the schema.
	 * @param 	schemaLocation	The default schema location.
	 * @param 	preferredPrefix	The preferred prefix for the namespace.
	 * @param 	alternatePrefix	The alternate prefix for the namespace.
	 * @param	initialiser		The <CODE>InstanceInitialise</CODE> or <CODE>null</CODE>.
	 * @param	recogniser		The <CODE>SchemaRecogniser</CODE> or <CODE>null</CODE>.
	 * @since	TFP 1.1
	 */
	public SchemaRelease (Specification specification, final String version,
			final String namespaceUri, final String schemaLocation,
			final String preferredPrefix, final String alternatePrefix,
			final InstanceInitialiser initialiser, final SchemaRecogniser recogniser)
	{
		this (specification, version, namespaceUri, schemaLocation,
				preferredPrefix, alternatePrefix,
				initialiser, recogniser, (String []) null);
	}
	
	/**
	 * Constructs a <CODE>SchemaRelease</CODE> instance describing a schema
	 * based release of a particular <CODE>Specification</CODE>.
	 * <P>
	 * This constructor should be used when creating a description of a
	 * schema that has only a single root element.
	 * <P>
	 * Default implementations of <CODE>InstanceInitialiser</CODE> and
	 * <CODE>SchemaRecogniser</CODE> will be created during construction.
	 * 
	 * @param 	specification	A reference to the owning specification.
	 * @param 	version			The version identifier for this release.
	 * @param 	namespaceUri	The namespace used to identify the schema.
	 * @param 	schemaLocation	The default schema location.
	 * @param 	preferredPrefix	The preferred prefix for the namespace.
	 * @param 	alternatePrefix	The alternate prefix for the namespace.
	 * @param 	rootElement		The normal root element.
	 * @since	TFP 1.0
	 */
	public SchemaRelease (Specification specification, final String version,
			final String namespaceUri, final String schemaLocation,
			final String preferredPrefix, final String alternatePrefix,
			final String rootElement)
	{
		this (specification, version, namespaceUri, schemaLocation,
				preferredPrefix, alternatePrefix, new String [] { rootElement });
	}
	
	/**
	 * Constructs a <CODE>SchemaRelease</CODE> instance describing a schema
	 * based release of a particular <CODE>Specification</CODE>.
	 * <P>
	 * This constructor should be used when creating a description of a
	 * schema that has only a single root element.
	 * <P>
	 * If <CODE>InstanceInitialiser</CODE> and <CODE>SchemaRecogniser</CODE>
	 * instances are not provided then default ones will be created during
	 * construction.
	 * 
	 * @param 	specification	A reference to the owning specification.
	 * @param 	version			The version identifier for this release.
	 * @param 	namespaceUri	The namespace used to identify the schema.
	 * @param 	schemaLocation	The default schema location.
	 * @param 	preferredPrefix	The preferred prefix for the namespace.
	 * @param 	alternatePrefix	The alternate prefix for the namespace.
	 * @param	initialiser		The <CODE>InstanceInitialise</CODE> or <CODE>null</CODE>.
	 * @param	recogniser		The <CODE>SchemaRecogniser</CODE> or <CODE>null</CODE>.
	 * @param 	rootElement		The normal root element.
	 * @since	TFP 1.1
	 */
	public SchemaRelease (Specification specification, final String version,
			final String namespaceUri, final String schemaLocation,
			final String preferredPrefix, final String alternatePrefix,
			final InstanceInitialiser initialiser, final SchemaRecogniser recogniser,
			final String rootElement)
	{
		this (specification, version, namespaceUri, schemaLocation,
				preferredPrefix, alternatePrefix, 
				initialiser, recogniser, (rootElement != null) ? new String [] { rootElement } : null);
	}
	
	/**
	 * Constructs a <CODE>SchemaRelease</CODE> instance describing a schema
	 * based release of a particular <CODE>Specification</CODE>.
	 * <P>
	 * This constructor should be used when creating a description of a
	 * schema that has multiple root elements.
	 * <P>
	 * Default implementations of <CODE>InstanceInitialiser</CODE> and
	 * <CODE>SchemaRecogniser</CODE> will be created during construction.
	 * 
	 * @param 	specification	A reference to the owning specification.
	 * @param 	version			The version identifier for this release.
	 * @param 	namespaceUri	The namespace used to identify the schema.
	 * @param 	schemaLocation	The default schema location.
	 * @param 	preferredPrefix	The preferred prefix for the namespace.
	 * @param 	alternatePrefix	The alternate prefix for the namespace.
	 * @param 	rootElements	The set of possible root elements.
	 * @since	TFP 1.0
	 */
	public SchemaRelease (Specification specification, final String version,
			final String namespaceUri, final String schemaLocation,
			final String preferredPrefix, final String alternatePrefix,
			final String [] rootElements)
	{
		this (specification, version, namespaceUri, schemaLocation,
				preferredPrefix, alternatePrefix, null, null, rootElements);
	}

	/**
	 * Constructs a <CODE>SchemaRelease</CODE> instance describing a schema
	 * based release of a particular <CODE>Specification</CODE>.
	 * <P>
	 * This constructor should be used when creating a description of a
	 * schema that has multiple root elements.
	 * <P>
	 * If <CODE>InstanceInitialiser</CODE> and <CODE>SchemaRecogniser</CODE>
	 * instances are not provided then default ones will be created during
	 * construction.
	 * 
	 * @param 	specification	A reference to the owning specification.
	 * @param 	version			The version identifier for this release.
	 * @param 	namespaceUri	The namespace used to identify the schema.
	 * @param 	schemaLocation	The default schema location.
	 * @param 	preferredPrefix	The preferred prefix for the namespace.
	 * @param 	alternatePrefix	The alternate prefix for the namespace.
	 * @param	initialiser		The <CODE>InstanceInitialise</CODE> or <CODE>null</CODE>.
	 * @param	recogniser		The <CODE>SchemaRecogniser</CODE> or <CODE>null</CODE>.
	 * @param 	rootElements	The set of possible root elements.
	 * @since	TFP 1.0
	 */
	public SchemaRelease (Specification specification, final String version,
			final String namespaceUri, final String schemaLocation,
			final String preferredPrefix, final String alternatePrefix,
			final InstanceInitialiser initialiser, final SchemaRecogniser recogniser,
			final String [] rootElements)
	{
		super (specification, version, rootElements);
		
		this.namespaceUri    = namespaceUri;
		this.schemaLocation  = schemaLocation;
		this.preferredPrefix = preferredPrefix;
		this.alternatePrefix = alternatePrefix;
		
		this.recogniser		 = (recogniser  != null) ? recogniser  : new DefaultSchemaRecogniser ();
		this.initialiser	 = (initialiser != null) ? initialiser : new DefaultInstanceInitialiser ();
	}
	
	/**
	 * {@inheritDoc}
	 * @since	TFP 1.0
	 */
	public final String getNamespaceUri ()
	{
		return (namespaceUri);
	}

	/**
	 * {@inheritDoc}
	 * @since	TFP 1.0
	 */
	public final String getSchemaLocation ()
	{
		return (schemaLocation);
	}

	/**
	 * {@inheritDoc}
	 * @since	TFP 1.0
	 */
	public final String getPreferredPrefix ()
	{
		return (preferredPrefix);
	}
	
	/**
	 * {@inheritDoc}
	 * @since	TFP 1.0
	 */
	public final String getAlternatePrefix ()
	{
		return (alternatePrefix);
	}
	
	/**
	 * {@inheritDoc}
	 * @since	TFP 1.0
	 */
	public Document newInstance (final String rootElement)
	{
		Vector			releases	= new Vector ();
		SchemaRelease	mainSchema	= null;
	
		findAllImports (releases);
		for (Iterator cursor = releases.iterator (); cursor.hasNext ();) {
			SchemaRelease	release		= (SchemaRelease) cursor.next ();
			
			if (release.hasRootElement (rootElement)) {
				if (mainSchema != null) {
					logger.severe ("Multiple schemas define root element '" + rootElement + "'");
					return (null);
				}
				mainSchema = release;
			}
		}
		if (mainSchema == null) {
			logger.severe ("No schema recognised '" + rootElement + "' as a root element.");
			return (null);
		}
		
		DOMImplementation	impl = builder.getDOMImplementation ();
		Document		document = impl.createDocument (mainSchema.getNamespaceUri (), rootElement, null);
		Element			root	 = document.getDocumentElement ();
		
		root.setAttributeNS (NAMESPACES_URL, "xmlns:xsi", INSTANCE_URL);
		root.setAttributeNS (INSTANCE_URL, "xsi:schemaLocation", "");

		for (Iterator cursor = releases.iterator (); cursor.hasNext ();) {
			SchemaRelease	release		= (SchemaRelease) cursor.next ();

			release.initialiser.initialise (release, root, release == mainSchema);
		}

		return (document);
	}
	
	/**
	 * {@inheritDoc}
	 * @since	TFP 1.0
	 */
	public boolean isInstance (Document document)
	{
		if (recogniser.recognises (this, document)) {
			Element			root = document.getDocumentElement ();

			// TODO: Improve import detection
			return (true);
		}
		return (false);
	}
	
	/**
	 * Creates a bi-directional reference between this <CODE>SchemaRelease</CODE>
	 * and the meta data for other instance that it imports.
	 * 
	 * @param 	release			The imported <CODE>SchemaRelease</CODE>.
	 * @since	TFP 1.0
	 */
	public final void addImport (SchemaRelease release)
	{
		this.imports.add (release);
		release.importedBy.add (this);
	}
	
	/**
	 * Breaks the bi-directional reference between this <CODE>SchemaRelease</CODE>
	 * and the indicated one.
	 * 
	 * @param 	release			The <CODE>SchemaRelease</CODE> no longer imported.
	 * @since	TFP 1.0
	 */
	public final void removeImport (SchemaRelease release)
	{
		this.imports.remove (release);
		release.importedBy.remove (this);
	}
	
	/**
	 * Returns a <CODE>Vector</CODE> containing this <CODE>schemaRelease</CODE>
	 * and any it imports in dependency order.
	 * 
	 * @return	The <CODE>Vector</CODE> of <CODE>SchemeRelease</CODE> instances.
	 * @since	TFP 1.1
	 */
	public final Vector getImportSet ()
	{
		return (findAllImports (new Vector ()));
	}
	
	/**
	 * Java logging instance.
	 * @since 	TFP 1.0
	 */
	private static Logger		logger
		= Logger.getLogger ("com.handcoded.xml.SchemaRelease");
		
	/**
	 * The <CODE>DocumentBuilder</CODE> configured to create schema based
	 * <CODE>Document</CODE> instances.
	 * @since	TFP 1.0
	 */
	private static DocumentBuilder builder	= null;

	/**
	 * The namespace URI string.
	 * @since	TFP 1.0
	 */
	private final String		namespaceUri;
	
	/**
	 * The schema location string.
	 * @since	TFP 1.0
	 */
	private final String		schemaLocation;
	
	/**
	 * The preferred prefix for the namespace.
	 * @since	TFP 1.0
	 */
	private final String		preferredPrefix;
	
	/**
	 * The altername prefix for the namespace.
	 * @since	TFP 1.0
	 */
	private final String		alternatePrefix;
	
	/**
	 * The <CODE>InstanceInitialiser</CODE> used to build new documents.
	 * @since	TFP 1.1
	 */
	private final InstanceInitialiser	initialiser;

	/**
	 * The <CODE>SchemaRecogniser</CODE> used to determine document type.
	 * @since	TFP 1.1
	 */
	private final SchemaRecogniser		recogniser;
	
	/**
	 * The set of other <CODE>SchemaRelease</CODE> instances imported into this
	 * one.
	 * @since	TFP 1.0
	 */
	private Vector				imports		= new Vector ();
	
	/**
	 * The set of other <CODE>SchemaRelease</CODE> instances that import thia
	 * one.
	 * @since	TFP 1.0
	 */
	private Vector				importedBy	= new Vector ();

	/**
	 * Recursively build a set of <CODE>SchemaRelease</CODE> instances
	 * containing this one and any that it imports with the least
	 * dependent first.
	 * 
	 * @param 	releases		The <CODE>HashSet</CODE> of matches (so far).
	 * @return	The updated set of imported releases.
	 * @since	TFP 1.1
	 */
	private Vector findAllImports (Vector releases)
	{
		if (!releases.contains (this)) {
			// Add this schema to prevent infinte recursion
			releases.add (this);
			
			for (int index = 0; index < imports.size (); ++index) {
				((SchemaRelease) imports.elementAt (index)).findAllImports (releases);
			
				// But reposition it after any schemas it imports
				releases.remove (this);
				releases.add (this);
			}
		}
		return (releases);
	}
	
	/**
	 * Constructs a document builder used to create new document instances.
	 * @since	TFP 1.0
	 */
	static {
		DocumentBuilderFactory	factory = DocumentBuilderFactory.newInstance ();
		
		factory.setNamespaceAware (false);
		factory.setValidating (false);
		
		try {
			builder = factory.newDocumentBuilder ();
		}
		catch (ParserConfigurationException error) {
			logger.log(Level.SEVERE, "No suitable JAXP DOM implementation for schema construction", error);
		}
	}
}
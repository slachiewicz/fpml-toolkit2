// Copyright (C),2005-2007 HandCoded Software Ltd.
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

package com.handcoded.xml.resolver;

import java.util.Stack;

import org.xml.sax.SAXException;

/**
 * 
 * @author 	BitWise
 * @version	$Id$
 * @since	TFP 1.1
 */
final class DelegateUriEntry extends RelativeEntry implements UriRule
{
	public DelegateUriEntry (final GroupEntry parent, final String startString, final String catalog, final String base)
	{
		super (parent, base);
		
		this.startString  = startString;
		this.catalog = catalog;
	}
	
	/**
	 * {@inheritDoc}
	 * @since	TFP 1.0
	 */
	public String applyTo (
	final String		uri,
	Stack				catalogs)
		throws SAXException
	{
		if (uri.startsWith (startString))
			return (CatalogManager.find (catalog).getDefinition ().applyRules (uri, catalogs));

		return (null);
	}

	/**
	 * {@inheritDoc}
	 * @since	TFP 1.0
	 */
	protected String toDebug ()
	{
		return ("startString=\"" + startString + "\",catalog=\"" + catalog + "\"," + super.toDebug ());
	}

	/**
	 * @since	TFP 1.0
	 */
	final String		startString;
	
	/**
	 * @since	TFP 1.0
	 */
	final String		catalog;
}
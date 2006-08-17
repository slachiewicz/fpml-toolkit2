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

package com.handcoded.fpml.schemes;

import java.util.Vector;
import java.util.Enumeration;

/**
 * The <CODE>ClosedScheme</CODE> class provides an extended implementation of
 * <CODE>CachedScheme</CODE> which implements the <CODE>Enumerable</CODE> and
 * <CODE>Matchable</CODE> interfaces.
 * 
 * @author	BitWise
 * @version	$Id$
 * @since	TFP 1.0
 */
public class ClosedScheme extends CachedScheme implements Enumerable, Matchable
{
	/**
	 * Constructs a <CODE>ClosedScheme</CODE> instance for the indicated
	 * scheme URI.
	 *
	 * @param	uri			The URI used to reference the scheme.
	 */
	public ClosedScheme (final String uri)
	{
		super (uri);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public final Value [] values ()
	{
		Value 			result [] = new Value [values.size ()];
		
		values.values ().toArray (result);
		return (result);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public final Value [] values (final String pattern)
	{
		Vector			matches = new Vector ();
		Enumeration		cursor 	= values.elements ();

		while (cursor.hasMoreElements ()) {
			Value			value = (Value) cursor.nextElement ();
			
			if (value.getCode ().matches (pattern)) matches.add (value);
		}
		
		Value			result [] = new Value [matches.size ()];
		
		matches.copyInto (result);
		return (result);
	}
}
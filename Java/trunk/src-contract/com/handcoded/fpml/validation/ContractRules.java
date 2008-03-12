// Copyright (C),2007 HandCoded Software Ltd.
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

package com.handcoded.fpml.validation;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.handcoded.meta.Schema;
import com.handcoded.validation.Rule;
import com.handcoded.validation.RuleSet;
import com.handcoded.validation.ValidationErrorHandler;
import com.handcoded.xml.NodeIndex;
import com.handcoded.xml.XPath;

/**
 * The <CODE>ContractRules</CODE> class contains a <CODE>RuleSet</CODE>
 * initialised with validation rules for contract notification messages.
 *
 * @author	BitWise
 * @version	$Id$
 * @since	TFP 1.1
 */
public final class ContractRules
{
	/**
	 * A <CODE>Rule</CODE> instance that ensures the document contains only
	 * a contract notification message.
	 * @since	TFP 1.1
	 */
	public static final Rule	RULE01	= new Rule ("contract-1")
	{
		/**
		 * {@inheritDoc}
		 */
		public boolean validate (NodeIndex nodeIndex, ValidationErrorHandler errorHandler)
		{
			NodeList	list = nodeIndex.getElementsByName ("FpML");
			boolean		result = true;
			
			for (int index = 0; index < list.getLength (); ++index) {
				Element		root = (Element) list.item (index);
				String 		type = root.getAttributeNS (Schema.INSTANCE_URL, "type");
				
				if (type.endsWith ("ContractCreated")
					|| type.endsWith ("ContractCancelled")
					|| type.endsWith ("ContractAmended")
					|| type.endsWith ("ContractNovated")
					|| type.endsWith ("ContractPartialTermination")
					|| type.endsWith ("ContractFullTermination")
					|| type.endsWith ("ContractIncreased"))
					continue;
				
				errorHandler.error ("305", root,
						"Document must only contain a contract notification message",
						getName (), type);
				
				result = false;
			}
			return (result);
		}
	};
	
	/**
	 * A <CODE>Rule</CODE> that ensures only versioned contract identifiers
	 * are present.
	 * @since	TFP 1.1
	 */
	public static final Rule	RULE02	= new Rule ("contract-2")
	{
		/**
		 * {@inheritDoc}
		 */
		public boolean validate (NodeIndex nodeIndex, ValidationErrorHandler errorHandler)
		{
			NodeList	list 	= nodeIndex.getElementsByName ("identifier");
			boolean		result 	= true;
			
			for (int index = 0; index < list.getLength (); ++index) {
				Element		context 	= (Element) list.item (index);
				Element		identifier	= XPath.path (context, "contractId");
				
				if (identifier == null) continue;
				
				errorHandler.error("305", context,
						"Only versioned contract identifiers should be present",
						getName (), null);
				result = false;
			}
			return (result);
		}
	};
	
	/**
	 * A <CODE>Rule</CODE> that ensures that novations contain either references
	 * to the new and old contracts or a new contract definition and optionally
	 * an old contract reference.
	 * @since	TFP 1.1
	 */
	public static final Rule	RULE03	= new Rule ("contract-3")
	{
		/**
		 * {@inheritDoc}
		 */
		public boolean validate (NodeIndex nodeIndex, ValidationErrorHandler errorHandler)
		{
			NodeList	list 	= nodeIndex.getElementsByName ("novation");
			boolean		result 	= true;

			for (int index = 0; index < list.getLength (); ++index) {
				Element		context	= (Element) list.item (index);
				Element		oldRef	= XPath.path (context, "oldContractReference");
				Element		newRef	= XPath.path (context, "newContractReference");
				Element 	newDeal	= XPath.path (context, "newContract");
				
				if (((oldRef != null) && (newRef != null)) && (newDeal == null)) continue;
				if (((oldRef == null) && (newRef == null)) && (newDeal != null)) continue;
				if (((oldRef != null) && (newRef == null)) && (newDeal != null)) continue;
				
				errorHandler.error ("305", context,
						"Novations must reference either the old and new contracts "
						+ "or contain a new contract definition and optionally an "
						+ "old contract reference",
						getName (), null);
				result = false;
			}
			return (result);
		}
	};
	
	/**
	 * Provides access to the validation rule set.
	 * 
	 * @return	The data type validation rule set.
	 * @since	TFP 1.1
	 */
	public static RuleSet getRules ()
	{
		return (rules);
	}
	
	/**
	 * Ensures no instances can be created.
	 * @since	TFP 1.1
	 */
	private ContractRules ()
	{ }
	
	/**
	 * A <CODE>RuleSet</CODE> containing all the standard FpML defined
	 * validation rules.
	 * @since	TFP 1.1
	 */
	private static final RuleSet	rules = new RuleSet ();
	
	/**
	 * Initialises the <CODE>RuleSet</CODe> by copying the rule references from 
	 * the FpML and schemes rules sets.
	 * @since	TFP 1.1
	 */
	static {
		rules.add (FpMLRules.getRules ());
		rules.add (SchemeRules.getRules ());
		
		rules.add (RULE01);
		rules.add (RULE02);
		rules.add (RULE03);
	}
}
// Copyright (C),2005-2014 HandCoded Software Ltd.
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

import com.handcoded.validation.Precondition;
import com.handcoded.validation.Rule;
import com.handcoded.validation.ValidationErrorHandler;
import com.handcoded.xml.NodeIndex;
import com.handcoded.xml.XPath;

public class EsmaRules extends FpMLRuleSet
{
	/**
	 * A <CODE>Precondition</CODE> instance that any document submitted as
	 * EMIR eligible.
	 * @since	TFP 1.8
	 */
	private static Precondition ESMA
		= Precondition.ALWAYS;
	
	/**
	 * A <CODE>Precondition</CODE> instance that a record keeping document
	 * submitted for EMIR
	 * @since	TFP 1.8
	 */
	private static Precondition ESMA_RKV
		= Precondition.and (ESMA, Preconditions.RECORDKEEPING);

	/**
	 * A <CODE>Precondition</CODE> instance that any record keeping or
	 * transparency document.
	 * @since	TFP 1.8
	 */
	private static Precondition ESMA_TV
		= Precondition.and (ESMA, Preconditions.TRANSPARENCY);

	/**
	 * A <CODE>Rule</CODE> that ensures that a reporting date is present.
	 * <P>
	 * Applies to FpML 5.x
	 * @since	TFP 1.8
	 */
	public static final Rule 	RULE01_RECORDKEEPING
		= new Rule (ESMA_RKV, "esma-1[RECORDKEEPING]")
		{
			public boolean validate (NodeIndex nodeIndex, ValidationErrorHandler errorHandler)
			{
				if (nodeIndex.hasTypeInformation ()) 
					return (validate (nodeIndex.getElementsByType (determineNamespace (nodeIndex), "TradeProcessingTimestamps"), errorHandler));					
					
				return (
					  validate (nodeIndex.getElementsByName ("timestamps"), errorHandler));
			}
			
			private boolean validate (NodeList list, ValidationErrorHandler errorHandler)
			{
				boolean		result = true;
				
				for (int index = 0; index < list.getLength (); ++index) {
					Element		context = (Element) list.item (index);
					Element		ts = XPath.path (context, "nonpubliclyReported");
					
					if ((ts == null) || toToken (ts).isEmpty ()) {
						errorHandler.error ("305", context,
								"The non-public reporting time is not defined",
								getDisplayName (), null);
						result = false;
					}
				}
				
				return (result);
			}
		};
		
	/**
	 * A <CODE>Rule</CODE> that ensures that a reporting date is present.
	 * <P>
	 * Applies to FpML 5.x
	 * @since	TFP 1.8
	 */
	public static final Rule 	RULE01_TRANSPARENCY
		= new Rule (ESMA_TV, "esma-1[TRANSPARENCY]")
		{
			public boolean validate (NodeIndex nodeIndex, ValidationErrorHandler errorHandler)
			{
				if (nodeIndex.hasTypeInformation ()) 
					return (validate (nodeIndex.getElementsByType (determineNamespace (nodeIndex), "TradeProcessingTimestamps"), errorHandler));					
					
				return (
					  validate (nodeIndex.getElementsByName ("timestamps"), errorHandler));
			}
			
			private boolean validate (NodeList list, ValidationErrorHandler errorHandler)
			{
				boolean		result = true;
				
				for (int index = 0; index < list.getLength (); ++index) {
					Element		context = (Element) list.item (index);
					Element		ts = XPath.path (context, "publiclyReported");
					
					if ((ts == null) || toToken (ts).isEmpty ()) {
						errorHandler.error ("305", context,
								"The public reporting time is not defined",
								getDisplayName (), null);
						result = false;
					}
				}
				
				return (result);
			}
		};


}

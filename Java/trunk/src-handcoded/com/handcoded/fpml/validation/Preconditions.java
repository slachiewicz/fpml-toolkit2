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

package com.handcoded.fpml.validation;

import com.handcoded.fpml.Releases;
import com.handcoded.validation.Precondition;

/**
 * The <CODE>Preconditions</CODE> interface defines a set of <CODE>Precondition
 * </CODE> instances used to detect releases and various products.
 * 
 * @author	BitWise
 * @version	$Id$
 * @since	TFP 1.0
 */
public interface Preconditions
{
	/**
	 * A <CODE>Precondition</CODE> instance that detects FpML 1-0 compatible
	 * documents.
	 * @since	TFP 1.0
	 */
	public static final Precondition 	R1_0
		= new VersionPrecondition (Releases.R1_0.getVersion ());
		
	/**
	 * A <CODE>Precondition</CODE> instance that detects FpML 2-0 compatible
	 * documents.
	 * @since	TFP 1.0
	 */
	public static final Precondition 	R2_0
		= new VersionPrecondition (Releases.R2_0.getVersion ());
		
	/**
	 * A <CODE>Precondition</CODE> instance that detects FpML 3-0 compatible
	 * documents.
	 * @since	TFP 1.0
	 */
	public static final Precondition 	TR3_0
		= new VersionPrecondition (Releases.TR3_0.getVersion ());

	/**
	 * A <CODE>Precondition</CODE> instance that detects FpML 4-0 compatible
	 * documents.
	 * @since	TFP 1.0
	 */
	public static final Precondition 	R4_0
		= new VersionPrecondition (Releases.R4_0.getVersion ());

	/**
	 * A <CODE>Precondition</CODE> instance that detects FpML 4-1 compatible
	 * documents.
	 * @since	TFP 1.0
	 */
	public static final Precondition 	R4_1
		= new VersionPrecondition (Releases.R4_1.getVersion ());

	/**
	 * A <CODE>Precondition</CODE> instance that detects FpML 4-2 compatible
	 * documents.
	 * @since	TFP 1.0
	 */
	public static final Precondition 	TR4_2
		= new VersionPrecondition (Releases.TR4_2.getVersion ());

	/**
	 * A <CODE>Precondition</CODE> instance that detects FpML 4-3 compatible
	 * documents.
	 * @since	TFP 1.1
	 */
	public static final Precondition 	WD4_3
		= new VersionPrecondition (Releases.WD4_3.getVersion ());

	/**
	 * A <CODE>Precondition</CODE> instance that detects FpML versions that use
	 * XPointer syntax for intra-document links.
	 * @since	TFP 1.0
	 */
	public static final Precondition	R1_0__R2_0
			= Precondition.or (R1_0, R2_0);
	
    /**
	 * A <CODE>Precondition</CODE> instance that detects either FpML 1-0,
	 * 2-0 or 3-0 compatible documents.
	 * @since	TFP 1.0
	 */
	public static final Precondition	R1_0__TR3_0
		= Precondition.or (R1_0__R2_0, TR3_0);

    /**
	 * A <CODE>Precondition</CODE> instance that detects either FpML 2-0 or
	 * 3-0 compatible documents.
	 * @since	TFP 1.0
	 */
	public static final Precondition	R2_0__TR3_0
		= Precondition.or (R2_0, TR3_0);

	/**
	 * A <CODE>Precondition</CODE> instance that detects FpML version 2-0 and
	 * later.
	 * @since	TFP 1.0
	 */
	public static final Precondition	R2_0__LATER
		= Precondition.or (
		    Precondition.or (
			  Precondition.or (
				Precondition.or (
				  Precondition.or (R2_0, TR3_0), R4_0), R4_1), TR4_2), WD4_3);
	/**
	 * A <CODE>Precondition</CODE> instance that detects FpML version 3-0 and
	 * later.
	 * @since	TFP 1.0
	 */
	public static final Precondition	TR3_0__LATER
			= Precondition.or (
		        Precondition.or (
		          Precondition.or (
		        	Precondition.or (TR3_0, R4_0), R4_1), TR4_2), WD4_3);

    /**
	 * A <CODE>Precondition</CODE> instance that detects either FpML 3-0 or
	 * 4-0 compatible documents.
	 * @since	TFP 1.0
	 */
	public static final Precondition	TR3_0__R4_0
		= Precondition.or (TR3_0, R4_0);
	
	/**
	 * A <CODE>Precondition</CODE> instance that detects FpML versions 4-0 and
	 * later.
	 * @since	TFP 1.0
	 */
	public static final Precondition	R4_0__LATER
			= Precondition.or (
				Precondition.or (
				  Precondition.or (R4_0, R4_1), TR4_2), WD4_3);
	
	/**
	 * A <CODE>Precondition</CODE> instance that detects FpML versions 4-1 and
	 * later.
	 * @since	TFP 1.0
	 */
	public static final Precondition	R4_1__LATER
			= Precondition.or (
				Precondition.or (R4_1, TR4_2), WD4_3);

	/**
	 * A <CODE>Precondition</CODE> instance that detects FpML versions 4-2 and
	 * later.
	 * @since	TFP 1.0
	 */
	public static final Precondition	TR4_2__LATER
			= Precondition.or (TR4_2, WD4_3);

   /**
	 * A <CODE>Precondition</CODE> instance that detects all FpML versions except
	 * 4-0.
	 * @since	TFP 1.0
	 */
	public static final Precondition	NOT_R4_0
			= Precondition.not (R4_0);
}
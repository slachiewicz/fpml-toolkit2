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

package com.handcoded.xml;

import java.math.BigDecimal;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * The <CODE>Logic</CODE> class contains functions that make converting XPath/Clix
 * based rules to Java easier. Rule set container classes may be derived from this
 * class to make access to the members more (programmer) efficient.
 * 
 * @author 	BitWise
 * @version	$Id$
 * @since	TFP 1.0
 */
public abstract class Logic
{
	/**
	 * Calculates the logical-not of the given predicate result value.
	 *
	 * @param 	value			The predicate value.
	 * @return	The logical-not of the predicate value.
	 * @since	TFP 1.0
	 */
	public static boolean not (boolean value)
	{
		return (!value);
	}

	/**
	 * Calculates the logical-or of the given predicate result values.
	 * 
	 * @param	lhs				The first predicate value.
	 * @param	rhs				The second predicate value.
	 * @return	The logical-or of the predicate values.
	 * @since	TFP 1.0
	 */
	public static boolean or (boolean lhs, boolean rhs)
	{
		return (lhs || rhs);
	}

	/**
	 * Calculates the logical-and of the given predicate result values.
	 *
	 * @param	lhs				The first predicate value.
	 * @param	rhs				The second predicate value.
	 * @return	The logical-and of the predicate values.
	 * @since	TFP 1.0
	 */
	public static boolean and (boolean lhs, boolean rhs)
	{
		return (lhs && rhs);
	}

	/**
	 * Calculates the logical-implication of the given predicate result values.
	 *
	 * @param	lhs			The first predicate value.
	 * @param 	rhs			The second predicate value.
	 * @return	The logical-implication of the predicate values.
	 * @since	TFP 1.0
	 */
	public static boolean implies (boolean lhs, boolean rhs)
	{
		return (lhs ? rhs : true); 
	}

	/**
	 * Calculates the "if and only if" of the given predicate result values.
	 *
	 * @param	lhs			The first predicate value.
	 * @param	rhs			The second predicate value.
	 * @return	The "if and only if" of the predicate values.
	 * @since	TFP 1.0
	 */
	public static boolean iff (boolean lhs, boolean rhs)
	{
		return (lhs == rhs);
	}

	// --------------------------------------------------------------------

	/**
	 * Determines if a referenced <ODE>Node</CODE> exists.
	 *
	 * @param 	node			The <CODE>Node</CODE> or <CODE>null</CODE>.
	 * @return	<CODE>true</CODE> if the <CODE>Node</CODE> exists.
	 * @since	TFP 1.0
	 */
	public static boolean exists (Node node)
	{
		return (node != null);
	}

	/**
	 * Determines if a <CODE>NodeList</CODE> is not empty.
	 * 
	 * @param 	list			The <CODE>NodeList</CODE> to examine.
	 * @return	<CODE>true</CODE> if the <CODE>NodeList</CODE> is not empty.
	 * @since	TFP 1.0
	 */
	public static boolean exists (NodeList list)
	{
		return (list.getLength () > 0);
	}

	/**
	 * Determines the number of nodes in a <CODE>NodeList</CODE>.
	 * 
	 * @param	list			The <CODE>NodeList</CODE> to examine.
	 * @return	The number of nodes in the list.
	 * @since	TFP 1.0
	 */
	public static int count (NodeList list)
	{
		return (list.getLength ());
	}

	// --------------------------------------------------------------------

	/**
	 * Returns the value of the given <CODE>Node</CODE> as a string.
	 *
	 * @param 	node			The <CODE>Node</CODE> containing the value.
	 * @return	The value of the node as a Java datatype.
	 * @since	TFP 1.0
	 */
	public static String string (final Node node)
	{
		return (DOM.getInnerText ((Element) node));
	}

	/**
	 * Returns the value of the given <CODE>Node</CODE> as an boolean.
	 * 
	 * @param 	node			The <CODE>Node</CODE> containing the value.
	 * @return	The value of the node as a Java datatype.
	 * @since	TFP 1.0
	 */
	public static boolean bool (final Node node)
	{
		try {
			return (Boolean.parseBoolean (string (node)));
		}
		catch (Exception error) {
			;
		}
		return (false);
	}
	
	/**
	 * Returns the value of the given <CODE>Node</CODE> as an integer.
	 * 
	 * @param 	node			The <CODE>Node</CODE> containing the value.
	 * @return	The value of the node as a Java datatype.
	 * @since	TFP 1.0
	 */
	public static int integer (final Node node)
	{
		try {
			return (Integer.parseInt (string (node)));
		}
		catch (Exception error) {
			;
		}
		return (0);
	}

	/**
	 * Returns the value of the given <CODE>Node</CODE> as a decimal.
	 * 
	 * @param	node			The <CODE>Node</CODE> containing the value.
	 * @return	The value of the node as a Java datatype.
	 * @since	TFP 1.0
	 */
	public static BigDecimal decimal (final Node node)
	{
		try {
            return (new BigDecimal (string (node)));
		}
		catch (Exception error) {
			;
		}
		return (BigDecimal.ZERO);
	}

	/**
	 * Rounds a monetary decimal value to a given number of places. 
	 *  
	 * @param 	value			The <CODE>BigDecimal</CODE> to round.
	 * @param	places			The number of places required.
	 * @return	The rounded value.
	 * @since	TFP 1.0
	 */
	public static BigDecimal round (BigDecimal value, int places)
	{
		return (new BigDecimal (value.movePointRight (places).toBigInteger ()).movePointLeft (places));
	}

	// --------------------------------------------------------------------

	/**
	 * Determines if two nodes contain the same value.
	 *
	 * @param 	lhs				The first node to compare.
	 * @param 	rhs				The second node to compare.
	 * @return	<CODE>true</CODE> if the nodes contain the same value.
	 * @since	TFP 1.0
	 */
	public static boolean equal (final Node lhs, final Node rhs)
	{
		if ((lhs != null) && (rhs != null))
			return (equal (string (lhs), string (rhs)));
		return (false);
	}

	/**
	 * Determines if the value of a <CODE>Node</CODE> is the same as a
	 * given <CODE>string</CODE>.
	 * 
	 * @param	lhs				The <CODE>Node</CODE> to compare.
	 * @param	rhs				The <see cref="string"/> value.
	 * @return	<CODE>true</CODE> if the two values are equal.
	 * @since	TFP 1.0
	 */
	public static boolean equal (final Node lhs, final String rhs)
	{
		return ((lhs != null) ? equal (string (lhs), rhs) : false);
	}

	/**
	 * Determines if two <see cref="string"/> values have the same contents.
	 * 
	 * @param 	lhs				The <CODE>String</CODE> to compare.
	 * @param 	rhs				The <CODE>String</CODE> to compare with.
	 * @return	<CODE>true</CODE> if the <CODE>String</CODE> values are equal.
	 * @since	TFP 1.0
	 */
	public static boolean equal (final String lhs, final String rhs)
	{
		return (lhs.equals (rhs));
	}

	/**
	 * Determines if the value of a <CODE>Node</CODE> is the same as a
	 * given <see cref="int"/>.
	 * 
	 * @param	lhs				The <CODE>Node</CODE> to compare.
	 * @param 	rhs				The <see cref="int"/> value.
	 * @return	<CODE>true</CODE> if the two values are equal.
	 * @since	TFP 1.0
	 */
	public static boolean equal (final Node lhs, int rhs)
	{
		if (lhs != null) {
			try {
				return (integer (lhs) == rhs);
			}
			catch (Exception error) {
				return (false);
			}
		}
		return (false);
	}

	/**
	 * Compares two integer values.
	 * 
	 * @param 	lhs				The first value.
	 * @param 	rhs				The second value/
	 * @return	<CODE>true</CODE> if the two values are equal.
	 * @since	TFP 1.0
	 */
	public static boolean equal (int lhs, int rhs)
	{
		return (lhs == rhs);
	}

	/**
	 * Determines if two <CODE>BigDecimal</CODE> values have the same contents.
	 * 
	 * @param 	lhs				The <CODE>BigDecimal</CODE> to compare.
	 * @param 	rhs				The <CODE>BigDecimal</CODE> to compare with.
	 * @return	<CODE>true</CODE> if the <CODE>BigDecimal</CODE> values are equal.
	 * @since	TFP 1.0
	 */
	public static boolean equal (final BigDecimal lhs, final BigDecimal rhs)
	{
		return (lhs.equals (rhs));
	}

	// --------------------------------------------------------------------

	/**
	 * Determines if two nodes contain the different values.
	 * 
	 * @param 	lhs			The first node to compare.</param>
	 * @param 	rhs			The second node to compare.</param>
	 * @return	<CODE>true</CODE> if the nodes contain the different values.
	 * @since	TFP 1.0
	 */
	public static boolean notEqual (final Node lhs, final Node rhs)
	{
		if ((lhs != null) && (rhs != null))
			return (notEqual (string(lhs), string(rhs)));
		return (false);
	}

	/**
	 * Determines if the value of a <CODE>Node</CODE> is not the same as a
	 * given <see cref="string"/>.
	 *
	 * @param 	lhs			The <CODE>Node</CODE> to compare.
	 * @param 	rhs			The <CODE>String<CODE> value.
	 * @return	<CODE>true</CODE> if the values are different.
	 * @since	TFP 1.0
	 */
	public static boolean notEqual (final Node lhs, final String rhs)
	{
		return ((lhs != null) ? notEqual (string (lhs), rhs) : false);
	}

	/**
	 * Determines if two <CODE>String</CODE> values are different.
	 * 
	 * @param 	lhs			The <CODE>String</CODE> to compare.
	 * @param 	rhs			The <CODE>String</CODE> to compare to.
	 * @return	<CODE>true</CODE> if the two <CODE>String</CODE> values are
	 * 			different.
	 * @since	TFP 1.0
	 */
	public static boolean notEqual (final String lhs, final String rhs)
	{
		return (!lhs.equals (rhs));
	}

	/**
	 * Determines if the value of a <CODE>Node</CODE> is not the same as a
	 * given integer.
	 * 
	 * @param 	lhs				The <CODE>Node</CODE> to compare.
	 * @param 	rhs				The <CODE>int</CODE> value.
	 * @return	<CODE>true</CODE> if the values are different.
	 * @since	TFP 1.0
	 */
	public static boolean notEqual (final Node lhs, int rhs)
	{
		if (lhs != null) {
			try {
				return (Integer.parseInt (string (lhs)) != rhs);
			}
			catch (Exception error) {
				return (false);
			}
		}
		return (false);
	}
	
	/**
	 * Determines if the value of a <CODE>Node</CODE> is not that same as a
	 * given <CODE>BigDecimal</CODE>.
	 * 
	 * @param 	lhs				The <CODE>Node</CODE> to compare.
	 * @param 	rhs				The <CODE>BigDecimal</CODE> value.
	 * @return	<CODE>true</CODE> if the values are different.
	 * @since	TFP 1.0 
	 */
	public static boolean notEqual (final Node lhs, final BigDecimal rhs)
	{
		if (lhs != null) {
			try {
				return (new BigDecimal (string (lhs)).compareTo (rhs) != 0);
			}
			catch (Exception error) {
				return (false);
			}
		}
		return (false);
	}

	// --------------------------------------------------------------------

	/**
	 * Determines if the value of one node is less than another. If either
	 * node is null then the result is <b>false</b>.
	 * 
	 * @param 	lhs				The first node.
	 * @param 	rhs				The second node.
	 * @return	<CODE>>true</CODE> if the text value of the first node is less than
	 * 			that of the second.
	 * @since	TFP 1.0
	 */
	public static boolean less (final Node lhs, final Node rhs)
	{
		if ((lhs != null) && (rhs != null))
			return (less (string (lhs), string (rhs)));
		return (false);
	}

	/**
	 * Determines if the value of a node is less than a given string. If the
	 * node is <CODE>null<CODE> then the result is <CODE>false</CODE>.
	 * 
	 * @param 	lhs				The node to be tested.
	 * @param 	rhs				A string value to compare with.
	 * @return	<CODE>true</CODE> if the text value of the first node is less than
	 * 			the given string.
	 * @since	TFP 1.0
	 */
	public static boolean less (final Node lhs, final String rhs)
	{
		return ((lhs != null) ? less (string (lhs), rhs) : false);
	}

	/**
	 * Determines if the value of a <see cref="string"/> is lexiographically
	 * less than the value of another.
	 * 
	 * @param	lhs				The <CODE>String</CODE> to compare.
	 * @param 	rhs				The <CODE>String</CODE> to compare with.
	 * @return	<CODE>true</CODE> if the first value is less than the second.
	 * @since	TFP 1.0
	 */
	public static boolean less (final String lhs, final String rhs)
	{
		return (lhs.compareTo (rhs) < 0);
	}

	/**
	 * Determines if the value of a <see cref="decimal"/> is less than
	 * the value of another.
	 * 
	 * @param 	lhs				The <CODE>BigDecimal</CODE> to compare.
	 * @param 	rhs				The <CODE>BigDecimal</CODE> to compare with.
	 * @return	<CODE>true</CODE> if the first value is less than the second.
	 * @since	TFP 1.0
	 */
	public static boolean less (final BigDecimal lhs, final BigDecimal rhs)
	{
		return (lhs.compareTo (rhs) < 0);
	}
	
	// --------------------------------------------------------------------

	/**
	 * Compares two <CODE>Node</CODE> instances to determine if the
	 * first is larger than the second.
	 *  
	 * @param	lhs				The first node.
	 * @param	rhs				The second node.
	 * @return	<CODE>true</CODE> if the first value is greater than the second.
	 * @since	TFP 1.0
	 */
	public static boolean greater (final Node lhs, final Node rhs)
	{
		if ((lhs != null) && (rhs != null))
			return (greater (string (lhs), string (rhs)));
		return (false);
	}

	/**
	 * Compares two <CODE>String</CODE> instances to determine if the
	 * first is larger than the second.
	 * 
	 * @param 	lhs				The first string.
	 * @param 	rhs				The second string.
	 * @return	<CODE>true</CODE> if the first value is greater than the second.
	 * @since	TFP 1.0
	 */
	public static boolean greater (final String lhs, final String rhs)
	{
		return (lhs.compareTo (rhs) > 0);
	}
	
	/**
	 * Compares two integers to determine if the first is larger than the second.
	 *
	 * @param 	lhs				The first int.
	 * @param 	rhs				The second int.
	 * @return	<CODE>true</CODE> if the first value is greater than the second.
	 * @since	TFP 1.0
	 */
	public static boolean greater (int lhs, int rhs)
	{
		return (lhs > rhs);
	}

	// --------------------------------------------------------------------

	/**
	 * Compares two <CODE>Node</CODE> instances to determine if the
	 * first is equal to or smaller than the second.
	 * 
	 * @param 	lhs				The first node.
	 * @param 	rhs				The second node.
	 * @return	<CODE>true</CODE> if the first value is greater than the second.
	 * @since	TFP 1.0
	 */
	public static boolean lessOrEqual (final Node lhs, final Node rhs)
	{
		if ((lhs != null) && (rhs != null))
			return (lessOrEqual (string (lhs), string (rhs)));
		return (false);
	}

	/**
	 * Compares a <CODE>Node</CODE> instance with a double to determine
	 * if the value it holds is smaller or the same.
	 *  
	 * @param 	lhs				The node holding the value.
	 * @param 	rhs				The value to compare against.
	 * @return	<CODE>true</CODE> if the first value is greater than the second.
	 * @since	TFP 1.0
	 */
	public static boolean lessOrEqual (final Node lhs, double rhs)
	{
		try {
			return (Double.parseDouble (string (lhs)) <= rhs);
		}
		catch (Exception error) {
			return (false);
		}
	}

	/**
	 * Compares two <CODE>String</CODE> instances to determine if the
	 * first is equal to or smaller than the second.
	 * 
	 * @param 	lhs				The first string.</param>
	 * @param 	rhs				The second string.</param>
	 * @return	<CODE>true</CODE> if the first value is greater than the second.
	 * @since	TFP 1.0
	 */
	public static boolean lessOrEqual (final String lhs, final String rhs)
	{
		return (lhs.compareTo (rhs) <= 0);
	}
	
	/**
	 * Compares two <see cref="decimal"/> instances to determine if the
	 * first is equal to or smaller than the second.
	 *
	 * @param 	lhs				The first decimal.
	 * @param 	rhs				The second decimal.
	 * @return	<CODE>true</CODE> if the first value is greater than the second.
	 * @since	TFP 1.0
	 */
	public static boolean lessOrEqual (final BigDecimal lhs, final BigDecimal rhs)
	{
		return (lhs.compareTo (rhs) <= 0);
	}
	
	// --------------------------------------------------------------------

	/**
	 * Compares two <CODE>Node</CODE> instances to determine if the
	 * first is equal to or larger than the second.
	 * 
	 * @param 	lhs				The first node.
	 * @param 	rhs				The second node.
	 * @return	<CODE>true</CODE> if the first value is greater than the second.
	 * @since	TFP 1.0
	 */
	public static boolean greaterOrEqual (final Node lhs, final Node rhs)
	{
		if ((lhs != null) && (rhs != null))
			return (greaterOrEqual (string (lhs), string (rhs)));
		return (false);
	}

	/**
	 * Compares two <CODE>String</CODE> instances to determine if the
	 * first is equal to or larger than the second.
	 *
	 * @param 	lhs				The first string.
	 * @param	rhs				The second string.
	 * @return	<CODE>true</CODE> if the first value is greater than the second.
	 * @since	TFP 1.0
	 */
	public static boolean greaterOrEqual (final String lhs, final String rhs)
	{
		return (lhs.compareTo (rhs) >= 0);
	}
	
	/**
	 * Compares a <CODE>XmlNode</CODE> instance with a double to determine
	 * if the value it holds is larger or the same.
	 * 
	 * @param	lhs				The node holding the value.
	 * @param 	rhs				The value to compare against.
	 * @return	<CODE>true</CODE> if the first value is greater than the second.
	 * @since	TFP 1.0
	 */
	public static boolean greaterOrEqual (final Node lhs, double rhs)
	{
		try {
			return (Double.parseDouble(string (lhs)) >= rhs);
		}
		catch (Exception error) {
			return (false);
		}
	}

	/**
	 * Constructs a <CODE>Logic</CODE> instance.
	 * @since 	TFP 1.0
	 */
	protected Logic ()
	{ }
}
// Copyright (C),2005-2012 HandCoded Software Ltd.
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

package com.handcoded.finance;

import java.util.Vector;

public final class CalendarSet extends Calendar
{
	public CalendarSet ()
	{
		super (null);
	}
	
	public void add (Calendar calendar)
	{
		calendars.add (calendar);
	}
	
	/**
	 * Determines if the <CODE>Date</CODE> provided falls on a business day
	 * in all the <CODE>Calendar</CODE> instances in this set.
	 *
	 * @param	date			The <CODE>Date</CODE> to be tested.
	 * @return	<CODE>true</CODE> if the date is a business day,
	 *			<CODE>false</CODE> otherwise.
	 * @since	TFP 1.6
	 */
	@Override
	public boolean isBusinessDay (final Date date)
	{
		for (Calendar calendar : calendars)
			if (!calendar.isBusinessDay (date))
				return (false);
		
		return (true);
	}

	private Vector<Calendar>	calendars = new Vector<Calendar> ();
}

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

package com.handcoded.fpml.validation;

import com.handcoded.validation.Precondition;
import com.handcoded.validation.Rule;
import com.handcoded.validation.RuleSet;

/**
 * The <CODE>SchemeRules</CODE> class contains a <CODE>RuleSet</CODE>
 * initialised with validation rules for scheme values.
 *
 * @author	BitWise
 * @version	$Id$
 * @since	TFP 1.0
 */
public final class SchemeRules
{
	// FpML 1.0 ----------------------------------------------------------------
	
	/**
	 * Rule 1: The value of any <CODE>averagingMethod</CODE> element must be
	 * valid within the domain defined by its <CODE>@averagingMethodScheme</CODE>
	 * attribute.
	 * <P>
	 * Applies to FpML 1-0, 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE01
		= new SchemeRule (Preconditions.R1_0__R3_0, "scheme-1",
				new ElementContext ("averagingMethod"), "averagingMethodScheme");

	/**
	 * Rule 2: The value of any <CODE>businessCenter</CODE> element must be valid
	 * within the domain defined by its <CODE>businessCenterScheme</CODE> attribute.
	 * <P>
	 * Applies to all FpML releases.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE02
		= new SchemeRule (Preconditions.R1_0__LATER, "scheme-2",
				new ElementContext ("businessCenter"),
				new TypeContext ("BusinessCenter"), "businessCenterScheme");
	
	/**
	 * Rule 3: The value of any <CODE>businessDayConvention</CODE> element must
	 * be valid within the domain defined by its <CODE>@businessDayConventionScheme
	 * </CODE> attribute.
	 * <P>
	 * Applies to FpML 1-0, 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE03
		= new SchemeRule (Preconditions.R1_0__R3_0, "scheme-3", 
				new ElementContext ("businessDayConvention"), "businessDayConventionScheme");

	/**
	 * Rule 4: The value of any <CODE>compoundingMethod</CODE> element must be
	 * valid within the domain defined by its <CODE>@compoundingMethodScheme</CODE>
	 * attribute.
	 * <P>
	 * Applies to FpML 1-0, 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE04
		= new SchemeRule (Preconditions.R1_0__R3_0, "scheme-4", 
				new ElementContext ("compoundingMethod"), "compoundingMethodScheme");

	/**
	 * Rule 5: The value of any <CODE>Currency</CODE> type element must be valid
	 * within the domain defined by its <CODE>@currencyScheme</CODE> attribute.
	 * <P>
	 * Applies to all FpML releases.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE05
		= new SchemeRule (Preconditions.R1_0__LATER, "scheme-5",
				new ElementContext (
					new String [] {
						  "currency", "settlementCurrency", "referenceCurrency",
						  "cashSettlementCurrency", "payoutCurrency", "optionOnCurrency",
						  "faceOnCurrency", "baseCurrency", "currency1", "currency2"
					  }),
				new TypeContext ("Currency"), "currencyScheme");
	
	/**
	 * Rule 6: The value of any <CODE>dateRelativeTo</CODE> element must be valid
	 * within the domain defined by its <CODE>@dateRelativeToScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 1-0, 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE06
		= new SchemeRule (Preconditions.R1_0__R3_0, "scheme-6", 
				new ElementContext ("dateRelativeTo"), "dateRelativeToScheme");

	/**
	 * Rule 7: The value of any <CODE>dayCountFraction</CODE> element must be valid
	 * within the domain defined by its <CODE>@dayCountFractionScheme</CODE> attribute.
	 * <P>
	 * Applies to all FpML releases EXCEPT 4-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE07
		= new SchemeRule (Preconditions.NOT_R4_0, "scheme-7",
				new ElementContext ("dayCountFraction"),
				new TypeContext ("DayCountFraction"), "dayCountFractionScheme");

	/**
	 * Rule 8: The value of any <CODE>dayType</CODE> element must be valid
	 * within the domain defined by its <CODE>@dayTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 1-0, 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE08
		= new SchemeRule (Preconditions.R1_0__R3_0, "scheme-8",
				new ElementContext ("dayType"), "dayTypeScheme");

	/**
	 * Rule 9: The value of any <CODE>discountingType</CODE> element must be valid
	 * within the domain defined by its <CODE>@discountingTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 1-0, 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE09
		= new SchemeRule (Preconditions.R1_0__R3_0, "scheme-9",
				new ElementContext ("discountingType"), "discountingTypeScheme");

	/**
	 * Rule 10: The value of any <CODE>floatingRateIndex</CODE> type element must
	 * be valid within the domain defined by its <CODE>@floatingRateIndexScheme</CODE> attribute.
	 * <P>
	 * Applies to all FpML releases.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE10
		= new SchemeRule (Preconditions.R1_0__LATER, "scheme-10",
				new ElementContext (
						new String [] { null, "interestShortfall" },
						new String [] { "floatingRateIndex", "rateSource" }),
				new TypeContext ("FloatingRateIndex"), "floatingRateIndexScheme");

	/**
	 * Rule 11: The value of any <CODE>negativeInterestRateTreatment</CODE> element must be valid
	 * within the domain defined by its <CODE>@negativeInterestRateTreatmentScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 1-0, 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE11
		= new SchemeRule (Preconditions.R1_0__R3_0, "scheme-11",
				new ElementContext ("negativeInterestRateTreatment"), "negativeInterestRateTreatmentScheme");

	/**
	 * Rule 12: The value of any <CODE>payRelativeTo</CODE> element must be valid
	 * within the domain defined by its <CODE>@payRelativeToScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 1-0, 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE12
		= new SchemeRule (Preconditions.R1_0__R3_0, "scheme-12",
				new ElementContext ("payRelativeTo"), "payRelativeToScheme");

	/**
	 * Rule 13: The value of any <CODE>period</CODE> element must be valid
	 * within the domain defined by its <CODE>@periodScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 1-0, 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE13
		= new SchemeRule (Preconditions.R1_0__R3_0, "scheme-13",
				new ElementContext ("period"), "periodScheme");

	/**
	 * Rule 14: The value of any <CODE>rateTreatment</CODE> element must be valid
	 * within the domain defined by its <CODE>@rateTreatmentScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 1-0, 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE14
		= new SchemeRule (Preconditions.R1_0__R3_0, "scheme-14",
				new ElementContext ("rateTreatment"), "rateTreatmentScheme");

	/**
	 * Rule 15: The value of any <CODE>resetRelativeTo</CODE> element must be valid
	 * within the domain defined by its <CODE>@resetRelativeToScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 1-0, 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE15
		= new SchemeRule (Preconditions.R1_0__R3_0, "scheme-15",
				new ElementContext ("resetRelativeTo"), "resetRelativeToScheme");

	/**
	 * Rule 16: The value of any <CODE>rollConvention</CODE> element must be valid
	 * within the domain defined by its <CODE>@rollConventionScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 1-0, 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE16
		= new SchemeRule (Preconditions.R1_0__R3_0, "scheme-16",
				new ElementContext ("rollConvention"), "rollConventionScheme");

	/**
	 * Rule 17: The value of any <CODE>roundingDirection</CODE> element must be valid
	 * within the domain defined by its <CODE>@roundingDirectionScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 1-0, 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE17
		= new SchemeRule (Preconditions.R1_0__R3_0, "scheme-17",
				new ElementContext ("roundingDirection"), "roundingDirectionScheme");

	/**
	 * Rule 18: The value of any <CODE>stepRelativeTo</CODE> element must be valid
	 * within the domain defined by its <CODE>@stepRelativeToScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 1-0, 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE18
		= new SchemeRule (Preconditions.R1_0__R3_0, "scheme-18",
				new ElementContext ("stepRelativeTo"), "stepRelativeToScheme");

	/**
	 * Rule 19: The value of any <CODE>weeklyRollConvention</CODE> element must be valid
	 * within the domain defined by its <CODE>@weeklyRollConventionScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 1-0, 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE19
		= new SchemeRule (Preconditions.R1_0__R3_0, "scheme-19",
				new ElementContext ("weeklyRollConvention"), "weeklyRollConventionScheme");

	// FpML 2.0 ------------------------------------------------------------

	/**
	 * Rule 20: The value of any <CODE>calculationAgentParty</CODE> element must be valid
	 * within the domain defined by its <CODE>@calculationAgentPartyScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE20
		= new SchemeRule (Preconditions.R2_0__R3_0, "scheme-20",
				new ElementContext ("calculationAgentParty"), "calculationAgentPartyScheme");

	/**
	 * Rule 21: The value of any <CODE>rateSource</CODE> element must be valid
	 * within the domain defined by its <CODE>@informationProviderScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 2-0 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE21
		= new SchemeRule (Preconditions.R2_0__LATER, "scheme-21", 
				new ElementContext ("informationSource", "rateSource"),
				new TypeContext ("InformationProvider"), "informationProviderScheme");

	/**
	 * Rule 22: The value of any <CODE>buyer</CODE> or <CODE>seller</CODE> element
	 * must be valid within the domain defined by its <CODE>@payerReceiverScheme
	 * </CODE> attribute.
	 * <P>
	 * Applies to FpML 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE22
		= new SchemeRule (Preconditions.R2_0__R3_0, "scheme-22",
				new ElementContext (
						new String [] { "buyer", "seller" }), "payerReceiverScheme");

	/**
	 * Rule 23: The value of any <CODE>quotationRateType</CODE> element must be
	 * valid within the domain defined by its <CODE>@quotationRateTypeScheme</CODE>
	 * attribute.
	 * <P>
	 * Applies to FpML 2-0 and 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE23
		= new SchemeRule (Preconditions.R2_0__R3_0, "scheme-23", 
				new ElementContext ("quotationRateType"), "quotationRateTypeScheme");

	// FpML 3.0 ------------------------------------------------------------

	/**
	 * Rule 24: The value of any <CODE>clearanceSystem</CODE> element must be valid
	 * within the domain defined by its <CODE>clearanceSystemScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0 and 4-1 or later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE24A
		= new SchemeRule (Precondition.or (Preconditions.R3_0, Preconditions.R4_1__LATER), "scheme-24a", 
				new ElementContext ("clearanceSystem"),
				new TypeContext ("ClearanceSystem"), "clearanceSystemScheme");
		
	/**
	 * Rule 24: The value of any <CODE>clearanceSystem</CODE> element must be valid
	 * within the domain defined by its <CODE>clearanceSystemIdScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4-0 only.
	 * @since	TFP 1.5	
	 */
	public static final Rule	RULE24B
		= new SchemeRule (Preconditions.R4_0, "scheme-24b", 
				new ElementContext ("clearanceSystem"),
				new TypeContext ("ClearanceSystem"), "clearanceSystemIdScheme");
		
	/**
	 * Rule 26: The value of any <CODE>country</CODE> element must be valid
	 * within the domain defined by its <CODE>@countryScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE26
		= new SchemeRule (Preconditions.R3_0__LATER, "scheme-26", 
				new ElementContext ("country"),
				new TypeContext ("CountryCode"), "countryScheme");

	/**
	 * Rule 27: The value of any <CODE>cutName</CODE> element must be valid
	 * within the domain defined by its <CODE>@cutNameScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE27
		= new SchemeRule (Preconditions.R3_0__LATER, "scheme-27", 
				new ElementContext ("cutName"),
				new TypeContext ("CutName"), "cutNameScheme");
	
	/**
	 * Rule 28: The value of any <CODE>exerciseStyle</CODE> element must be valid
	 * within the domain defined by its <CODE>@exerciseStyleScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE28
		= new SchemeRule (Preconditions.R3_0, "scheme-28", 
				new ElementContext ("exerciseStyle"), "exerciseStyleScheme");
	
	/**
	 * Rule 29: The value of any <CODE>fxBarrierType</CODE> element must be valid
	 * within the domain defined by its <CODE>@fxBarrierTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE29
		= new SchemeRule (Preconditions.R3_0, "scheme-29", 
				new ElementContext ("fxBarrierType"), "fxBarrierTypeScheme");
	
	/**
	 * Rule 30: The value of any <CODE>governingLaw</CODE> element must be valid
	 * within the domain defined by its <CODE>governingLawScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE30
		= new SchemeRule (Preconditions.R3_0__LATER, "scheme-30", 
				new ElementContext ("governingLaw"),
				new TypeContext ("GoverningLaw"), "governingLawScheme");
	
	/**
	 * Rule 31: The value of any <CODE>masterAgreementType</CODE> element must be valid
	 * within the domain defined by its <CODE>masterAgreementTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE31
		= new SchemeRule (Preconditions.R3_0__LATER, "scheme-31",
				new ElementContext ("masterAgreementType"),
				new TypeContext ("MasterAgreementType"), "masterAgreementTypeScheme");
	
	/**
	 * Rule 32: The value of any <CODE>methodOfAdjustment</CODE> element must be valid
	 * within the domain defined by its <CODE>@methodOfAdjustmentScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE32
		= new SchemeRule (Preconditions.R3_0, "scheme-32", 
				new ElementContext ("methodOfAdjustment"), "methodOfAdjustmentScheme");
	
	/**
	 * Rule 33: The value of any <CODE>nationalisationOrInsolvency</CODE> element must be valid
	 * within the domain defined by its <CODE>@nationalisationOrInsolvencyOrDelistingScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE33
		= new SchemeRule (Preconditions.R3_0, "scheme-33",
				new ElementContext (
						new String [] { "nationalisationOrInsolvency", "delisting" }),
				"nationalisationOrInsolvencyOrDelistingScheme");
	
	/**
	 * Rule 35: The value of any <CODE>partyContactDetails</CODE> element must be valid
	 * within the domain defined by its <CODE>@partyContactDetailsScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0.
	 * @since	TFP 1.0	
	 */
	// TODO Needed?
	public static final Rule	RULE35
		= new SchemeRule (Preconditions.R3_0, "scheme-35", 
				new ElementContext ("partyContactDetails"), "partyContactDetailsScheme");
	
	/**
	 * Rule 36: The value of any <CODE>payout</CODE> element must be valid
	 * within the domain defined by its <CODE>@payoutScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE36
		= new SchemeRule (Preconditions.R3_0, "scheme-36", 
				new ElementContext ("payoutStyle"), "payoutScheme");

	/**
	 * Rule 37: The value of any <CODE>premiumQuoteBasis</CODE> element must be valid
	 * within the domain defined by its <CODE>@premiumQuoteBasisScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE37
		= new SchemeRule (Preconditions.R3_0, "scheme-37", 
				new ElementContext ("premiumQuoteBasis"), "premiumQuoteBasisScheme");

	/**
	 * Rule 38: The value of any <CODE>quoteBasis</CODE> element must be valid
	 * within the domain defined by its <CODE>@quoteBasisScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE38
		= new SchemeRule (Preconditions.R3_0, "scheme-38", 
				new ElementContext ("quoteBasis"), "quoteBasisScheme");

	/**
	 * Rule 39: The value of any <CODE>routingCodeId</CODE> element must be valid
	 * within the domain defined by its <CODE>routingCodeIdScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE39
		= new SchemeRule (Preconditions.R3_0__LATER, "scheme-39", 
				new ElementContext ("routingCodeId"),
				new TypeContext ("RoutingId"), "routingCodeIdScheme");
	
	/**
	 * Rule 40: The value of any <CODE>settlementMethod</CODE> element must be valid
	 * within the domain defined by its <CODE>settlementScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE40
		= new SchemeRule (Preconditions.R3_0__LATER, "scheme-40", 
				new ElementContext ("settlementMethod"),
				new TypeContext ("SettlementMethod"), "settlementMethodScheme");
	
	/**
	 * Rule 41: The value of any <CODE>settlementPriceSource</CODE> element must be valid
	 * within the domain defined by its <CODE>settlementPriceSourceScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE41
		= new SchemeRule (Preconditions.R3_0__LATER, "scheme-41", 
				new ElementContext ("settlementPriceSource"),
				new TypeContext ("SettlementPriceSource"), "settlementPriceSourceScheme");
	
	/**
	 * Rule 42: The value of any <CODE>settlementType</CODE> element must be valid
	 * within the domain defined by its <CODE>@settlementTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE42
		= new SchemeRule (Preconditions.R3_0, "scheme-42", 
				new ElementContext ("settlementType"), "settlementTypeScheme");

	/**
	 * Rule 43: The value of any <CODE>shareExtraordinaryEvent</CODE> element must be valid
	 * within the domain defined by its <CODE>@shareExtraordinaryEventScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE43
		= new SchemeRule (Preconditions.R3_0, "scheme-43", 
				new ElementContext ("shareExtraordinaryEvent"), "shareExtraordinaryEventScheme");

	/**
	 * Rule 44: The value of any <CODE>sideRateBasis</CODE> element must be valid
	 * within the domain defined by its <CODE>@sideRateBasisScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE44
		= new SchemeRule (Preconditions.R3_0, "scheme-44", 
				new ElementContext ("sideRateBasis"), "sideRateBasisScheme");

	/**
	 * Rule 45: The value of any <CODE>standardSettlementStyle</CODE> element must be valid
	 * within the domain defined by its <CODE>@standardSettlementStyleScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE45
		= new SchemeRule (Preconditions.R3_0, "scheme-45", 
				new ElementContext ("standardSettlementStyle"), "standardSettlementStyleScheme");

	/**
	 * Rule 46: The value of any <CODE>strikeQuoteBasis</CODE> element must be valid
	 * within the domain defined by its <CODE>@strikeQuoteBasisScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE46
		= new SchemeRule (Preconditions.R3_0, "scheme-46", 
				new ElementContext ("strikeQuoteBasis"), "strikeQuoteBasisScheme");

	/**
	 * Rule 47: The value of any <CODE>timeType</CODE> element must be valid
	 * within the domain defined by its <CODE>@timeTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE47
		= new SchemeRule (Preconditions.R3_0, "scheme-47",
				new ElementContext (
						new String [] {
								"latestExerciseTimeType", "equityExpirationTimeType",
								"valuationTimeType" }), "timeTypeScheme");

	/**
	 * Rule 48: The value of any <CODE>touchCondition</CODE> element must be valid
	 * within the domain defined by its <CODE>@touchConditionScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE48
		= new SchemeRule (Preconditions.R3_0, "scheme-48", 
				new ElementContext ("touchCondition"), "touchConditionScheme");

	/**
	 * Rule 49: The value of any <CODE>triggerCondition</CODE> element must be valid
	 * within the domain defined by its <CODE>@triggerConditionScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 3-0.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE49
		= new SchemeRule (Preconditions.R3_0, "scheme-49", 
				new ElementContext ("triggerCondition"), "triggerConditionScheme");

	// FpML 4.0 ------------------------------------------------------------

	/**
	 * Rule 50: The value of any <CODE>additionalTerm</CODE> element must be valid
	 * within the domain defined by its <CODE>@additionalTermScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.0 and 4.1.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE50
		= new SchemeRule (Preconditions.R4_0__R4_1, "scheme-50", 
				new ElementContext ("additionalTerm"),
				new TypeContext ("AdditionalTerm"), "additionalTermScheme");

	/**
	 * Rule 25: The value of any <CODE>contractualDefinitions</CODE> element must
	 * be valid within the domain defined by its <CODE>@contractualDefinitionsScheme</CODE>
	 * attribute.
	 * <P>
	 * Applies to FpML 4-0 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE25
		= new SchemeRule (Preconditions.R4_0__LATER, "scheme-25", 
				new ElementContext ("contractualDefinitions"),
				new TypeContext ("ContractualDefinition"), "contractualDefinitionsScheme");

	/**
	 * Rule 51: The value of any <CODE>contractualSupplement</CODE> element must
	 * be valid within the domain defined by its <CODE>contractualSupplementScheme</CODE>
	 * attribute.
	 * <P>
	 * Applies to FpML 4.0 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE51
		= new SchemeRule (Preconditions.R4_0__LATER, "scheme-51", 
				new ElementContext ("contractualSupplement"),
				new TypeContext ("ContractualSupplement"), "contractualSupplementScheme");
	
	/**
	 * Rule 52: The value of any <CODE>fxFeatureType</CODE> element must be valid
	 * within the domain defined by its <CODE>@fxFeatureTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4-0 only.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE52
		= new SchemeRule (Preconditions.R4_0, "scheme-52", 
				new ElementContext ("fxFeatureType"), "fxFeatureTypeScheme");
	
	/**
	 * Rule 53: The value of any <CODE>marketDisruption</CODE> element must be valid
	 * within the domain defined by its <CODE>marketDisruptionScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.0 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE53
		= new SchemeRule (Preconditions.R4_0__LATER, "scheme-53",
				new ElementContext (
						new String [] { "averagingPeriodIn", "averagingPeriodOut" },
						new String [] { "marketDisruption", "marketDisruption" }), "marketDisruptionScheme");
	
	/**
	 * Rule 54: The value of any <CODE>masterConfirmationType</CODE>b> element must be valid
	 * within the domain defined by its <CODE>masterConfirmationTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.0 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE54
		= new SchemeRule (Preconditions.R4_0__LATER, "scheme-54", 
				new ElementContext ("masterConfirmationType"),
				new TypeContext ("MasterConfirmationType"), "masterConfirmationTypeScheme");
	
	/**
	 * Rule 55: The value of any <CODE>restructuringType</CODE> element must be valid
	 * within the domain defined by its <CODE>restructuringTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.0 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE55
		= new SchemeRule (Preconditions.R4_0__LATER, "scheme-55", 
				new ElementContext ("restructuringType"),
				new TypeContext ("RestructuringType"), "restructuringScheme");

	/**
	 * Rule 71: The value of any <CODE>additionalTerm</CODE> element must be valid
	 * within the domain defined by its <CODE>additionalTermScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.0 and 4.1.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE71
		= new SchemeRule (Preconditions.R4_0__R4_1, "scheme-71", 
				new ElementContext ("additionalTerm"),
				new TypeContext ("AdditionalTerm"), "additionalTermScheme");
	
	// FpML 4.1 ------------------------------------------------------------

	/**
	 * Rule 56: The value of any <CODE>assetMeasure</CODE> element must be valid
	 * within the domain defined by its <CODE>assetMeasureScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.1 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE56
		= new SchemeRule (Preconditions.R4_1__LATER, "scheme-56",
				new ElementContext ("measureType"),
				new TypeContext ("AssetMeasureType"), "assetMeasureScheme");
	
	/**
	 * Rule 57: The value of any <CODE>brokerConfirmationType</CODE> element must be valid
	 * within the domain defined by its <CODE>brokerConfirmationTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.1 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE57
		= new SchemeRule (Preconditions.R4_1__LATER, "scheme-57", 
				new ElementContext ("brokerConfirmationType"),
				new TypeContext ("BrokerConfirmationType"), "brokerConfirmationTypeScheme");
	
	/**
	 * Rule 58: The value of any <CODE>compoundingFrequency</CODE> element must be valid
	 * within the domain defined by its <CODE>compoundingFrequencyScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.1 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE58
		= new SchemeRule (Preconditions.R4_1__LATER, "scheme-58", 
				new ElementContext ("compoundingFrequency"),
				new TypeContext ("CompondingFrequency"), "compoundingFrequencyScheme");
	
	/**
	 * Rule 59: The value of any <CODE>couponType</CODE> element must be valid
	 * within the domain defined by its <CODE>couponTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.1 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE59
		= new SchemeRule (Preconditions.R4_1__LATER, "scheme-59", 
				new ElementContext ("couponType"),
				new TypeContext ("CouponType"), "couponTypeScheme");
	
	/**
	 * Rule 60: The value of any <CODE>creditSeniority</CODE> element must be valid
	 * within the domain defined by its <CODE>creditSeniorityScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.1 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE60
		= new SchemeRule (Preconditions.R4_1__LATER, "scheme-60", 
				new ElementContext ("creditSeniority"),
				new TypeContext ("CreditSeniority"), "creditSeniorityScheme");
	
	/**
	 * Rule 61: The value of any <CODE>indexAnnexSource</CODE> element must be valid
	 * within the domain defined by its <CODE>indexAnnexSourceScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.1 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE61
		= new SchemeRule (Preconditions.R4_1__LATER, "scheme-61", 
				new ElementContext ("indexAnnexSource"),
				new TypeContext ("IndexAnnexSource"), "indexAnnexSourceScheme");
	
	/**
	 * Rule 62: The value of any <CODE>interpolationMethod</CODE> element must be valid
	 * within the domain defined by its <CODE>interpolationMethodScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.1 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE62
		= new SchemeRule (Preconditions.R4_1__LATER, "scheme-62", 
				new ElementContext ("interpolationMethod"),
				new TypeContext ("InterpolationMethod"), "interpolationMethodScheme");
	
	/**
	 * Rule 63: The value of any <CODE>matrixTerm</CODE> element must be valid
	 * within the domain defined by its <CODE>matrixTermScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.1 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE63
		= new SchemeRule (Preconditions.R4_1__LATER, "scheme-63", 
				new ElementContext ("matrixTerm"),
				new TypeContext ("MatrixTerm"), "matrixTermScheme");
	
	/**
	 * Rule 64: The value of any <CODE>matrixType</CODE> element must be valid
	 * within the domain defined by its <CODE>matrixTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.1 and later.
	 * @since	TFP 1.2	
	 */
	public static final Rule	RULE64
		= new SchemeRule (Preconditions.R4_1__LATER, "scheme-64", 
				new ElementContext ("matrixType"),
				new TypeContext ("MatrixType"), "matrixTypeScheme");
	
	/**
	 * Rule 65: The value of any <CODE>perturbationType</CODE> element must be valid
	 * within the domain defined by its <CODE>perturbationTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.1 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE65
		= new SchemeRule (Preconditions.R4_1__LATER, "scheme-65", 
				new ElementContext ("perturbationType"),
				new TypeContext ("PerturbationType"), "perturbationTypeScheme");
	
	/**
	 * Rule 66: The value of any <CODE>priceQuoteUnits</CODE> element must be valid
	 * within the domain defined by its <CODE>priceQuoteUnitsScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.1 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE66
		= new SchemeRule (Preconditions.R4_1__LATER, "scheme-66", 
				new ElementContext ("priceQuoteUnits"),
				new TypeContext ("PriceQuoteUnits"), "priceQuoteUnitsScheme");
	
	/**
	 * Rule 67: The value of any <CODE>pricingInputType</CODE> element must be valid
	 * within the domain defined by its <CODE>pricingInputTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.1 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE67
		= new SchemeRule (Preconditions.R4_1__LATER, "scheme-67", 
				new ElementContext ("pricingInputType"),
				new TypeContext ("PricingInputType"), "pricingInputTypeScheme");
	
	/**
	 * Rule 68: The value of any <CODE>queryParameterOperator</CODE> element must be valid
	 * within the domain defined by its <CODE>queryParameterOperatorScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.1 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE68
		= new SchemeRule (Preconditions.R4_1__LATER, "scheme-68", 
				new ElementContext ("queryParameterOperator"),
				new TypeContext ("QueryParameterOperator"), "queryParameterOperatorScheme");
	
	/**
	 * Rule 69: The value of any <CODE>quoteTiming</CODE> element must be valid
	 * within the domain defined by its <CODE>quoteTimingScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.1 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE69
		= new SchemeRule (Preconditions.R4_1__LATER, "scheme-69", 
				new ElementContext ("quoteTiming"),
				new TypeContext ("QuoteTiming"), "quoteTimingScheme");
	
	/**
	 * Rule 70: The value of any <CODE>valuationSetDetail</CODE> element must be valid
	 * within the domain defined by its <CODE>valuationSetDetailScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.1.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE70
		= new SchemeRule (Preconditions.R4_1, "scheme-70", 
				new ElementContext ("valuationSetDetail"),
				new TypeContext ("ValuationSetDetail"), "valuationSetDetailScheme");
	
	/**
	 * Rule 72: The value of any <CODE>derivativeCalculationMethod</CODE> element must be valid
	 * within the domain defined by its <CODE>derivativeCalculationMethodScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.1 and later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE72
		= new SchemeRule (Preconditions.R4_1__LATER, "scheme-72", 
				new ElementContext ("derivativeCalculationMethod"),
				new TypeContext ("DerivativeCalculationMethod"), "derivativeCalculationMethodScheme");
	
	// FpML 4.2 ------------------------------------------------------------

	/**
	 * Rule 73: The value of any <CODE>cashFlowType</CODE> type element must
	 * be valid within the domain defined by its <CODE>cashFlowTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.2 and later.
	 * @since	TFP 1.6	
	 */
	public static final Rule	RULE73
		= new SchemeRule (Preconditions.R4_2__LATER, "scheme-73", 
				new ElementContext ("cashflowType"),
				new TypeContext ("CashflowType"), "cashflowTypeScheme");
	
	/**
	 * Rule 74: The value of any <CODE>entityType</CODE> type element must
	 * be valid within the domain defined by its <CODE>entityTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.2 and later.
	 * @since	TFP 1.6	
	 */
	public static final Rule	RULE74
		= new SchemeRule (Preconditions.R4_2__LATER, "scheme-74", 
				new ElementContext ("entityType"),
				new TypeContext ("EntityTypeType"), "entityTypeScheme");
	
	/**
	 * Rule 75: The value of any <CODE>productType</CODE> type element must
	 * be valid within the domain defined by its <CODE>productTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.2 and later.
	 * @since	TFP 1.6	
	 */
	public static final Rule	RULE75
		= new SchemeRule (Preconditions.R4_2__LATER, "scheme-75", 
				new ElementContext ("productType"),
				new TypeContext ("ProductType"), "productTypeScheme");
	
	/**
	 * Rule 76: The value of any <CODE>reasonCode</CODE> type element must
	 * be valid within the domain defined by its <CODE>reasonCodeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.2 and later.
	 * @since	TFP 1.6	
	 */
	public static final Rule	RULE76
		= new SchemeRule (Preconditions.R4_2__LATER, "scheme-76", 
				new ElementContext ("reasonCode"),
				new TypeContext ("ReasonCode"), "reasonCodeScheme");
	
	/**
	 * Rule 77: The value of any <CODE>matrixSource</CODE> type element must
	 * be valid within the domain defined by its <CODE>settledEntityMatrixSourceScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.2 and later.
	 * @since	TFP 1.6	
	 */
	public static final Rule	RULE77
		= new SchemeRule (Preconditions.R4_2__LATER, "scheme-77", 
				new ElementContext ("matrixSource"),
				new TypeContext ("MatrixSource"), "settledEntityMatrixSourceScheme");
	
	/**
	 * Rule 78: The value of any <CODE>scheduledDate/type</CODE> type element must
	 * be valid within the domain defined by its <CODE>scheduledDateTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.2 and later.
	 * @since	TFP 1.6	
	 */
	public static final Rule	RULE78
		= new SchemeRule (Preconditions.R4_2__LATER, "scheme-78", 
				new ElementContext ("scheduledDate", "type"),
				new TypeContext ("ScheduleDateType"), "scheduledDateTypeScheme");
	
	/**
	 * Rule 79: The value of any <CODE>spreadSchedule/type</CODE> type element must
	 * be valid within the domain defined by its <CODE>spreadScheduleTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.2 and later.
	 * @since	TFP 1.6	
	 */
	public static final Rule	RULE79
		= new SchemeRule (Preconditions.R4_2__LATER, "scheme-79", 
				new ElementContext ("spreadSchedule", "type"),
				new TypeContext ("SpreadScheduleType"), "spreadScheduleTypeScheme");
	
	/**
	 * Rule 80: The value of any <CODE>FpML/status</CODE> type element must
	 * be valid within the domain defined by its <CODE>tradeCashflowsStatusScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.2 and later.
	 * @since	TFP 1.6	
	 */
	public static final Rule	RULE80
		= new SchemeRule (Preconditions.R4_2__LATER, "scheme-80", 
				new ElementContext (
						new String [] { "FpML", "nettedTradeCashflowsMatchResult" },
						new String [] { "status", "status" }),
				new TypeContext ("TradeCashflowsStatus"), "tradeCashflowsStatusScheme");
	
	// FpML 4.3 ------------------------------------------------------------

	/**
	 * Rule 81: The value of any <CODE>FacilityType</CODE> type element must
	 * be valid within the domain defined by its <CODE>facilityTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.3 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE81
		= new SchemeRule (Preconditions.R4_3__LATER, "scheme-81", 
				new ElementContext ("facilityType"),
				new TypeContext ("FacilityType"), "facilityTypeScheme");
	
	/**
	 * Rule 82: The value of any <CODE>Lien</CODE> type element must
	 * be valid within the domain defined by its <CODE>lienScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.3 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE82
		= new SchemeRule (Preconditions.R4_3__LATER, "scheme-82", 
				new ElementContext ("lien"),
				new TypeContext ("Lien"), "lienScheme");
	
	/**
	 * Rule 83: The value of any <CODE>UnderlyingAssetTranche</CODE> type element must
	 * be valid within the domain defined by its <CODE>loanTrancheScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.3 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE83
		= new SchemeRule (Preconditions.R4_3__LATER, "scheme-83", 
				new ElementContext ("tranche"),
				new TypeContext ("UnderlyingAssetTranche"), "loanTrancheScheme");
	
	/**
	 * Rule 84: The value of any <CODE>MortgateSector</CODE> type element must
	 * be valid within the domain defined by its <CODE>mortgageSectorScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.3 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE84
		= new SchemeRule (Preconditions.R4_3__LATER, "scheme-84", 
				new ElementContext ("sector"),
				new TypeContext ("MortgateSector"), "mortgageSectorScheme");
	
	/**
	 * Rule 85: The value of any <CODE>PositionMatchStatus</CODE> type element must
	 * be valid within the domain defined by its <CODE>positionStatusScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.3 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE85
		= new SchemeRule (Preconditions.R4_3__R4_X, "scheme-85", 
				new ElementContext ("positionMatchResult", "status"),
				new TypeContext ("PositionMatchStatus"), "positionStatusScheme");
	
	// FpML 4.4 ------------------------------------------------------------

	/**
	 * Rule 86: The value of any <CODE>CreditSupportAgreementType</CODE> type element must
	 * be valid within the domain defined by its <CODE>creditSupportAgreementTypeScheme</CODE>
	 * attribute.
	 * <P>
	 * Applies to FpML 4.4 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE86
		= new SchemeRule (Preconditions.R4_4__LATER, "scheme-86", 
				new ElementContext ("creditSupportAgreement", "type"),
				new TypeContext ("CreditSupportAgreementType"), "creditSupportAgreementTypeScheme");
	
	// FpML 4.5 ------------------------------------------------------------
	
	/**
	 * Rule 87: The value of any <CODE>CommodityBusinessCalendar</CODE> type element must
	 * be valid within the domain defined by its <CODE>commodityBusinessCalendarScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.5 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE87
		= new SchemeRule (Preconditions.R4_5__LATER, "scheme-87", 
				new ElementContext (
						new String [] { "startTime", "endTime" },
						new String [] { "businessCalendar", "businessCalendar" }),
				new TypeContext ("CommodityBusinessCalendar"), "commodityBusinessCalendarScheme");
	
	/**
	 * Rule 88: The value of any <CODE>CommodityFrequencyType</CODE> type element must
	 * be valid within the domain defined by its <CODE>commodityFrequencyTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.5 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE88
		= new SchemeRule (Preconditions.R4_5__LATER, "scheme-88", 
				new ElementContext ("dayDistribution"),
				new TypeContext ("CommodityFrequencyType"), "commodityFrequencyTypeScheme");
	
	/**
	 * Rule 89: The value of any <CODE>CommodityFxType</CODE> type element must
	 * be valid within the domain defined by its <CODE>commodityFxTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.5 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE89
		= new SchemeRule (Preconditions.R4_5__LATER, "scheme-89", 
				new ElementContext ("fxType"),
				new TypeContext ("CommodityFxType"), "commodityFxTypeScheme");
	
	/**
	 * Rule 90: The value of any <CODE>DisruptionFallback</CODE> type element must
	 * be valid within the domain defined by its <CODE>commodityMarketDisruptionFallbackScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.5 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE90
		= new SchemeRule (Preconditions.R4_5__LATER, "scheme-90", 
				new ElementContext ("disruptionFallback", "fallback"),
				new TypeContext ("DisruptionFallback"), "commodityMarketDisruptionFallbackScheme");
	
	/**
	 * Rule 91: The value of any <CODE>MarketDisruptionEvent</CODE> type element must
	 * be valid within the domain defined by its <CODE>commodityMarketDisruptionScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.5 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE91
		= new SchemeRule (Preconditions.R4_5__LATER, "scheme-91", 
				new ElementContext ("marketDisruptionEvent"),
				new TypeContext ("MarketDisruptionEvent"), "commodityMarketDisruptionScheme");
	
	/**
	 * Rule 92: The value of any <CODE>MasterAgreementVersion</CODE> type element must
	 * be valid within the domain defined by its <CODE>masterAgreementVersionScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.5 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE92
		= new SchemeRule (Preconditions.R4_5__LATER, "scheme-92", 
				new ElementContext ("masterAgreementVersion"),
				new TypeContext ("MasterAgreementVersion"), "masterAgreementVersionScheme");
	
	/**
	 * Rule 93: The value of any <CODE>CommodityQuantityFrequency</CODE> type element must
	 * be valid within the domain defined by its <CODE>quantityFrequencyScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.5 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE93
		= new SchemeRule (Preconditions.R4_5__LATER, "scheme-93", 
				new ElementContext ("quantityFrequency"),
				new TypeContext ("CommodityQuantityFrequency"), "quantityFrequencyScheme");
	
	/**
	 * Rule 94: The value of any <CODE>QuantityUnit</CODE> type element must
	 * be valid within the domain defined by its <CODE>quantityUnitScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.5 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE94
		= new SchemeRule (Preconditions.R4_5__LATER, "scheme-94", 
				new ElementContext (
						new String [] { "unit", "quantityUnit", "priceUnit" }),
				new TypeContext ("QuantityUnit"), "quantityUnitScheme");
	
	// FpML 4.6 ------------------------------------------------------------
	
	/**
	 * Rule 95: The value of any <CODE>BullionDeliveryLocation</CODE> type element must
	 * be valid within the domain defined by its <CODE>bullionDeliveryLocationScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.6 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE95
		= new SchemeRule (Preconditions.R4_6, "scheme-95", 
				new ElementContext ("deliveryLocation"),
				new TypeContext ("BullionDeliveryLocation"), "bullionDeliveryLocationScheme");
	
	/**
	 * Rule 96: The value of any <CODE>CoalQualityAdjustments</CODE> type element must
	 * be valid within the domain defined by its <CODE>commodityCoalProductTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.6.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE96_OLD
		= new SchemeRule (Preconditions.R4_6, "scheme-96[OLD]", 
				new ElementContext (
						new String [] { "coal", "coal" },
						new String [] { "btuQualityAdjustments", "so2QualityAdjustments" }),
				new TypeContext ("CoalQualityAdjustments"), "commodityCoalProductTypeScheme");
	
	/**
	 * Rule 96: The value of any <CODE>CoalQualityAdjustments</CODE> type element must
	 * be valid within the domain defined by its <CODE>commodityCoalQualityAdjustmentsScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.7 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE96
		= new SchemeRule (Preconditions.R4_7__LATER, "scheme-96", 
				new ElementContext (
						new String [] { "coal", "coal" },
						new String [] { "btuQualityAdjustments", "so2QualityAdjustments" }),
				new TypeContext ("CoalQualityAdjustments"), "commodityCoalQualityAdjustmentsScheme");
	
	/**
	 * Rule 97: The value of any <CODE>CoalTransportationEquipment</CODE> type element must
	 * be valid within the domain defined by its <CODE>commodityCoalTransportationEquipmentScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.6 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE97
		= new SchemeRule (Preconditions.R4_6__LATER, "scheme-97", 
				new ElementContext ("transportationEquipment"),
				new TypeContext ("CoalTransportationEquipment"), "commodityCoalTransportationEquipmentScheme");
	
	/**
	 * Rule 98: The value of any <CODE>OilProductType</CODE> type element must
	 * be valid within the domain defined by its <CODE>commodityOilProductTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.6 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE98
		= new SchemeRule (Preconditions.R4_6__LATER, "scheme-98", 
				new ElementContext ("oil", "type"),
				new TypeContext ("OilProductType"), "commodityOilProductTypeScheme");
	
	/**
	 * Rule 99: The value of any <CODE>CommodityPayRelativeToEvent</CODE> type element must
	 * be valid within the domain defined by its <CODE>commodityPayRelativeToEventScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.6 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE99
		= new SchemeRule (Preconditions.R4_6__LATER, "scheme-99", 
				new ElementContext ("payRelativeToEvent"),
				new TypeContext ("CommodityPayRelativeToEvent"), "commodityPayRelativeToEventScheme");
	
	/**
	 * Rule 100: The value of any <CODE>CommodityDeliveryRisk</CODE> type element must
	 * be valid within the domain defined by its <CODE>deliveryRiskScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.6 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE100
		= new SchemeRule (Preconditions.R4_6__LATER, "scheme-100", 
				new ElementContext ("risk"),
				new TypeContext ("CommodityDeliveryRisk"), "deliveryRiskScheme");
	
	/**
	 * Rule 101: The value of any <CODE>DeterminationMethod</CODE> type element must
	 * be valid within the domain defined by its <CODE>determinationMethodScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.6 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE101
		= new SchemeRule (Preconditions.R4_6__LATER, "scheme-101", 
				new ElementContext ("determinationMethod"),
				new TypeContext ("DeterminationMethod"), "determinationMethodScheme");
	
	/**
	 * Rule 102: The value of any <CODE>ElectricityTransmissionContingencyType</CODE> type element must
	 * be valid within the domain defined by its <CODE>electricityTransmissionContingencyScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.6 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE102
		= new SchemeRule (Preconditions.R4_6__LATER, "scheme-102", 
				new ElementContext ("contingency"),
				new TypeContext ("ElectricityTransmissionContingencyType"), "electricityTransmissionContingencyScheme");
	
	/**
	 * Rule 103: The value of any <CODE>GasQuality</CODE> type element must
	 * be valid within the domain defined by its <CODE>gasQualityScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.6 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE103
		= new SchemeRule (Preconditions.R4_6__LATER, "scheme-103", 
				new ElementContext ("gas", "quality"),
				new TypeContext ("GasQuality"), "gasQualityScheme");
	
	/**
	 * Rule 104: The value of any <CODE>MasterConfirmationAnnexType</CODE> type element must
	 * be valid within the domain defined by its <CODE>masterConfirmationAnnexTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.6 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE104
		= new SchemeRule (Preconditions.R4_6__LATER, "scheme-104", 
				new ElementContext ("masterConfirmationAnnexType"),
				new TypeContext ("MasterConfirmationAnnexType"), "masterConfirmationAnnexTypeScheme");
	
	/**
	 * Rule 105: The value of any <CODE>TZLocation</CODE> type element must
	 * be valid within the domain defined by its <CODE>tzLocationScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.7 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE105
		= new SchemeRule (Preconditions.R4_6, "scheme-105", 
				new ElementContext (
						new String [] { "time", "supplyStartTime", "supplyEndTime" },
						new String [] { "location", "location", "location" }),
				new TypeContext ("TZLocation"), "tzLocationScheme");
		
	// FpML 4.7 ------------------------------------------------------------
	
	/**
	 * Rule 106: The value of any <CODE>CoalProductSource</CODE> type element must
	 * be valid within the domain defined by its <CODE>commodityCoalProductSourceScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.7 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE106
		= new SchemeRule (Preconditions.R4_7__LATER, "scheme-106", 
				new ElementContext ("coal", "type"),
				new TypeContext ("CoalProductSource"), "commodityCoalProductSourceScheme");
		
	/**
	 * Rule 107: The value of any <CODE>CoalQualityAdjustments</CODE> type element must
	 * be valid within the domain defined by its <CODE>commodityCoalQualityAdjustmentsScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.7 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE107
		= new SchemeRule (Preconditions.R4_7__LATER, "scheme-107", 
				new ElementContext (
						new String [] { "coal", "coal" },
						new String [] { "btuQualityAdjustments", "so2QualityAdjustments" }),
				new TypeContext ("CoalQualityAdjustments"), "commodityCoalQualityAdjustmentsScheme");
		
	/**
	 * Rule 108: The value of any <CODE>SettlementPriceDefaultElection</CODE> type element must
	 * be valid within the domain defined by its <CODE>settlementPriceDefaultElectionScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.7 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE108
		= new SchemeRule (Preconditions.R4_7__LATER, "scheme-108", 
				new ElementContext ("settlementPriceDefaultElection"),
				new TypeContext ("SettlementPriceDefaultElection"), "settlementPriceDefaultElectionScheme");
		
	/**
	 * Rule 109: The value of any <CODE>TimezoneLocation</CODE> type element must
	 * be valid within the domain defined by its <CODE>timezoneLocationScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.7 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE109
		= new SchemeRule (Preconditions.R4_7__LATER, "scheme-109", 
				new ElementContext (
						new String [] { "time", "supplyStartTime", "supplyEndTime" },
						new String [] { "location", "location", "location" }),
				new TypeContext ("TimezoneLocation"), "timezoneLocationScheme");
		
	// FpML 4.8 ------------------------------------------------------------
	
	/**
	 * Rule 110: The value of any <CODE>CommodityExpireRelativeToEvent</CODE> type element must
	 * be valid within the domain defined by its <CODE>commodityExpireRelativeToEventScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 4.8 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE110
		= new SchemeRule (Preconditions.R4_8__LATER, "scheme-110", 
				new ElementContext ("expireRelativeToEvent"),
				new TypeContext ("CommodityExpireRelativeToEvent"), "commodityExpireRelativeToEventScheme");
		
	// FpML 5.0 ------------------------------------------------------------
	
	/**
	 * Rule 111: The value of any <CODE>AssetClass</CODE> type element must
	 * be valid within the domain defined by its <CODE>assetClassScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 5.0 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE111
		= new SchemeRule (Preconditions.R5_0__LATER, "scheme-111", 
				new ElementContext ("assetClass"),
				new TypeContext ("AssetClass"), "assetClassScheme");
		
	/**
	 * Rule 112: The value of any <CODE>CreditRating</CODE> type element must
	 * be valid within the domain defined by its <CODE>creditRatingScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 5.0 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE112
		= new SchemeRule (Preconditions.R5_0__LATER, "scheme-112", 
				new ElementContext ("creditRating"),
				new TypeContext ("CreditRating"), "creditRatingScheme");
		
	/**
	 * Rule 113: The value of any <CODE>EventStatus</CODE> type element must
	 * be valid within the domain defined by its <CODE>eventStatusScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 5.0 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE113
		= new SchemeRule (Preconditions.R5_0__LATER, "scheme-113", 
				new ElementContext ("statusItem", "status"),
				new TypeContext ("EventStatus"), "eventStatusScheme");
		
	/**
	 * Rule 114: The value of any <CODE>IndustryClassification</CODE> type element must
	 * be valid within the domain defined by its <CODE>industryClassificationScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 5.0 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE114
		= new SchemeRule (Preconditions.R5_0__LATER, "scheme-114", 
				new ElementContext ("classification"),
				new TypeContext ("IndustryClassification"), "industryClassificationScheme");
		
	/**
	 * Rule 115: The value of any <CODE>PartyRole</CODE> type element must
	 * be valid within the domain defined by its <CODE>partyRoleScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 5.0 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE115
		= new SchemeRule (Preconditions.R5_0__LATER, "scheme-115", 
				new ElementContext ("relatedParty", "role"),
				new TypeContext ("PartyRole"), "partyRoleScheme");
		
	/**
	 * Rule 116: The value of any <CODE>PartyRoleType</CODE> type element must
	 * be valid within the domain defined by its <CODE>partyRoleTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 5.0 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE116
		= new SchemeRule (Preconditions.R5_0__LATER, "scheme-116", 
				new ElementContext ("relatedParty", "type"),
				new TypeContext ("PartyRoleType"), "partyRoleTypeScheme");
		
	/**
	 * Rule 117: The value of any <CODE>PositionUpdateReasonCode</CODE> type element must
	 * be valid within the domain defined by its <CODE>positionUpdateReasonCodeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 5.0 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE117
		= new SchemeRule (Preconditions.R5_0__LATER, "scheme-117", 
				new ElementContext ("reason", "code"),
				new TypeContext ("PositionUpdateReasonCode"), "positionUpdateReasonCodeScheme");
		
	/**
	 * Rule 118: The value of any <CODE>ReportingCurrencyType</CODE> type element must
	 * be valid within the domain defined by its <CODE>reportingCurrencyTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 5.0 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE118
		= new SchemeRule (Preconditions.R5_0__LATER, "scheme-118", 
				new ElementContext ("currencyType"),
				new TypeContext ("ReportingCurrencyType"), "reportingCurrencyTypeScheme");
		
	// FpML 5.2 ------------------------------------------------------------
	
	/**
	 * Rule 119: The value of any <CODE>ClearingStatus</CODE> type element must
	 * be valid within the domain defined by its <CODE>clearingStatusScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 5.2 and later.
	 * @since	TFP 1.7	
	 */
	public static final Rule	RULE119
		= new SchemeRule (Preconditions.R5_2__LATER, "scheme-119", 
				new ElementContext ("clearingStatusValue"),
				new TypeContext ("ClearingStatusValue"), "clearingStatusScheme");
		
	
	
	
	
	// FpML 5.3 ------------------------------------------------------------
	
	/**
	 * Rule 34: The value of any <CODE>optionType</CODE> element must be valid
	 * within the domain defined by its <CODE>@optionTypeScheme</CODE> attribute.
	 * <P>
	 * Applies to FpML 5-3 and Later.
	 * @since	TFP 1.0	
	 */
	public static final Rule	RULE34
		= new SchemeRule (Preconditions.R5_3__LATER, "scheme-34",
				new ElementContext (
						new String [] { "genericProduct" },
						new String [] { "optionType" }),
				new TypeContext ("OptionType"), "optionTypeScheme");
	
	/**
	 * Provides access to the scheme validation rule set.
	 * 
	 * @return	The scheme validation rule set.
	 * @since	TFP 1.0
	 */
	public static RuleSet getRules ()
	{
		return (rules);
	}
	
	/**
	 * A <CODE>RuleSet</CODE> containing validation rules for scheme values.
	 * @since	TFP 1.0	
	 */
	private static final RuleSet	rules = RuleSet.forName ("SchemeRules");
	
	/**
	 * Ensures no instances can be created.
	 * 
	 * @since	TFP 1.0	
	 */
	private SchemeRules ()
	{ }
}
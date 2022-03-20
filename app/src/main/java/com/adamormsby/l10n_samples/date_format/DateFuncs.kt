package com.adamormsby.l10n_samples.date_format

import android.content.Context
import android.text.format.DateUtils
import java.text.DateFormat
import java.util.*

/**
 * Returns only time value from [Date], respects Locale
 * @return [String]
 */
fun Date.asTime(context: Context): String =
    DateUtils.formatDateTime(context, time, DateUtils.FORMAT_SHOW_TIME)

/**
 * Formats [Date] as date with year, respects Locale
 * @param numeric format as numeric date, default false
 * @param abbreviated use abbreviated month name, default false
 * @returns [String]
 */
fun Date.asDateWithYear(
    context: Context,
    numeric: Boolean = false,
    abbreviated: Boolean = false
): String {
    var formatFlags = DateUtils.FORMAT_SHOW_DATE
    if (numeric) formatFlags = formatFlags or DateUtils.FORMAT_NUMERIC_DATE
    if (abbreviated) formatFlags = formatFlags or DateUtils.FORMAT_ABBREV_MONTH

    return DateUtils.formatDateTime(context, time, formatFlags)
}

/**
 * Formats date as time value or date value depending on if input day is today or not
 * @return [String]
 */
fun Date.asTimeOrRecentDate(): String =
    DateUtils.formatSameDayTime(
        time,
        Date().time,
        DateFormat.LONG,
        DateFormat.SHORT
    ).toString()

/**
 * Flexible date formatter with many options that respects Locale
 * @param showWeekday show weekday as part of date, default false
 * @param showMonth show month in date, default true
 * @param showMonthDay show day number in date with month, default true
 * @param showYear show year as part of date, default false
 * @param showYear show time as part of date, default false
 * @param numeric format month/day/year as numeric date, default false
 * @param abbreviated use abbreviated names for weekday/month, default false
 * @returns[String]
 */
fun Date.flexFormatted(
    context: Context,
    showWeekday: Boolean = false,
    showMonth: Boolean = true,     // check this one
    showMonthDay: Boolean = true,  // check this one
    showYear: Boolean = false,
    showTime: Boolean = false,
    numeric: Boolean = false,
    abbreviated: Boolean = false,
): String {
    var formatFlags = 0 // starts blank
    if (showWeekday) formatFlags = formatFlags or DateUtils.FORMAT_SHOW_WEEKDAY
    if (showMonth) formatFlags = formatFlags or DateUtils.FORMAT_SHOW_DATE
    if (!showMonthDay) formatFlags = formatFlags or DateUtils.FORMAT_NO_MONTH_DAY
    if (!showYear) formatFlags = formatFlags or DateUtils.FORMAT_NO_YEAR
    if (showTime) formatFlags = formatFlags or DateUtils.FORMAT_SHOW_TIME
    if (numeric) formatFlags = formatFlags or DateUtils.FORMAT_NUMERIC_DATE
    if (abbreviated) formatFlags = formatFlags or DateUtils.FORMAT_ABBREV_MONTH or DateUtils.FORMAT_ABBREV_WEEKDAY

    return DateUtils.formatDateTime(context, time, formatFlags)
}
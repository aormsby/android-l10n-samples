package com.adamormsby.l10n_samples.date_format

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.adamormsby.l10n_samples.R
import java.util.*

@SuppressLint("SetTextI18n")
class DateFormatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_format)

        val layout = findViewById<LinearLayout>(R.id.date_format_linear_layout)

        // first ever World Rivers Day #history
        val testDate = Date(1127676778000L)

        val textViews = listOf(
            TextView(this).apply {
                text = "Full test date -> ${
                    testDate.flexFormatted(
                        context,
                        showWeekday = true,
                        showMonth = true,
                        showMonthDay = true,
                        showYear = true
                    )
                }"
            },

            TextView(this).apply { text = "Time value only -> ${testDate.asTime(context)}" },

            TextView(this).apply { text = "Date with year -> ${testDate.asDateWithYear(context)}" },
            TextView(this).apply {
                text = "Date with year, numeric -> ${testDate.asDateWithYear(context, numeric = true)}"
            },
            TextView(this).apply {
                text = "Date with year, abbreviated -> ${testDate.asDateWithYear(context, abbreviated = true)}"
            },

            TextView(this).apply {
                text = "As time or recent date (current time used here) -> ${Date().asTimeOrRecentDate()}"
            },
            TextView(this).apply {
                text = "As time or recent date -> ${testDate.asTimeOrRecentDate()}"
            },


            TextView(this).apply {
                text = "Flex - date and time -> ${testDate.flexFormatted(context, showTime = true)}"
            },
            TextView(this).apply {
                text = "Flex - date and year -> ${testDate.flexFormatted(context, showYear = true)}"
            },
            TextView(this).apply {
                text = "Flex - weekday, date, year, abbreviated and numeric -> ${
                    testDate.flexFormatted(
                        context,
                        showWeekday = true,
                        showYear = true,
                        numeric = true,
                        abbreviated = true
                    )
                }"
            },
            TextView(this).apply {
                text = "Flex - month -> ${testDate.flexFormatted(context, showMonthDay = false)}"
            },
        )


        textViews.forEach { layout.addView(it) }
    }

    // TODO: add locale switcher
}
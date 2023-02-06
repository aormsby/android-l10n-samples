package com.adamormsby.l10n_samples.locale_changer

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.LocaleManagerCompat
import androidx.core.os.LocaleListCompat
import com.adamormsby.l10n_samples.R
import java.util.*

@SuppressLint("SetTextI18n")
class LocaleChangerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_locale_changer)

        val activeLocale = findViewById<TextView>(R.id.locale_changer_active_locale)
        activeLocale.text = "Active Locale -> ${getActiveLocale()}"

        val languageList = findViewById<ListView>(R.id.language_list_view)
        val languageOptions = listOf(
            "en", "es", "ja-JP", "zh-Hant-TW"
        )

        languageList.adapter = ArrayAdapter(
            this, R.layout.language_list_item, R.id.language_item_text_view, languageOptions
        )

        languageList.setOnItemClickListener { _, view, _, _ ->
            changeActiveLocale(view, activeLocale)
        }
    }

    private fun changeActiveLocale(view: View, activeLocale: TextView) {
        AppCompatDelegate.setApplicationLocales(
            LocaleListCompat.forLanguageTags(
                // junk code, but I'll take it
                (view.findViewById<TextView>(R.id.language_item_text_view)).text.toString()
            )
        )

        // update text
        activeLocale.text = "Active Locale -> ${getActiveLocale()}"
    }

    private fun getActiveLocale(): String {
        val locale = AppCompatDelegate.getApplicationLocales()[0]
            ?: LocaleManagerCompat.getSystemLocales(this)[0]

        return locale!!.toLanguageTag()
    }
}
package com.adamormsby.l10n_samples

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.adamormsby.l10n_samples.date_format.DateFormatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sampleActivities = arrayOf(
            Pair("Date Format", DateFormatActivity::class.java)
        )

        val adapter = ArrayAdapter<String>(
            this,
            R.layout.directory_list_item,
            sampleActivities.map { it.first })

        val listView: ListView = findViewById(R.id.sample_list_view)
        listView.adapter = adapter

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            startActivity(Intent(this, sampleActivities[position].second))
        }
    }
}
package com.example.app1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var searchAdapter: MainActivity2
    private val searchList = mutableListOf<String>()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchInput: EditText = findViewById(R.id.searchInput)
        val tagInput: EditText = findViewById(R.id.tagInput)
        val saveButton: Button = findViewById(R.id.saveButton)
        val clearButton: Button = findViewById(R.id.clearButton)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        searchAdapter = MainActivity2(searchList)
        recyclerView.adapter = searchAdapter

        saveButton.setOnClickListener {
            val searchQuery = searchInput.text.toString()
            val tag = tagInput.text.toString()
            if (searchQuery.isNotEmpty() && tag.isNotEmpty()) {
                searchList.add("$tag: $searchQuery")
                searchAdapter.notifyDataSetChanged()
                searchInput.text.clear()
                tagInput.text.clear()
            }
        }

        clearButton.setOnClickListener {
            searchList.clear()
            searchAdapter.notifyDataSetChanged()
        }
    }
}

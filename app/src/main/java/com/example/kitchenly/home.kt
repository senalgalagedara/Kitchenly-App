package com.kitchenly.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    private lateinit var etSearch: EditText
    private lateinit var btnAll: TextView
    private lateinit var btnFood: TextView
    private lateinit var btnDrink: TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSearch()
        setupCategoryButtons()
    }


    private fun setupSearch() {
        etSearch.setOnClickListener {
            Toast.makeText(context, "Search clicked", Toast.LENGTH_SHORT).show()
        }

        etSearch.setOnEditorActionListener { _, _, _ ->
            val query = etSearch.text.toString().trim()
            if (query.isNotEmpty()) {
            }
            true
        }
    }

    private fun setupCategoryButtons() {
        btnAll.setOnClickListener {
            selectCategory(btnAll)
        }

        btnFood.setOnClickListener {
            selectCategory(btnFood)
        }

        btnDrink.setOnClickListener {
            selectCategory(btnDrink)
        }
    }

    private fun selectCategory(selectedButton: TextView) {
        resetCategoryButtons()

        selectedButton.isSelected = true
        selectedButton.setTextColor(resources.getColor(R.color.text_white, null))
    }

    private fun resetCategoryButtons() {
        btnAll.isSelected = false
        btnFood.isSelected = false
        btnDrink.isSelected = false

        btnAll.setTextColor(resources.getColor(R.color.text_secondary, null))
        btnFood.setTextColor(resources.getColor(R.color.text_secondary, null))
        btnDrink.setTextColor(resources.getColor(R.color.text_secondary, null))
    }

}
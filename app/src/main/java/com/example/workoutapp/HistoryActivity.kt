package com.example.workoutapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.workoutapp.databinding.ActivityHistoryBinding
import kotlinx.coroutines.launch

class HistoryActivity : AppCompatActivity() {
    private var binding: ActivityHistoryBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setTheme(R.style.Theme_WorkoutApp)
        setContentView(binding?.root)
        setSupportActionBar(binding?.historyToolbar)
        if (supportActionBar != null) {
            supportActionBar?.title = "History"
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.historyToolbar?.setNavigationOnClickListener {
            onBackPressed()
        }

        lifecycleScope.launch {
            (application as WorkOutApp).db.historyDao().getHistory().collect {
                if (it.isNotEmpty()) {
                    val historyAdapter = HistoryAdapter(it)
                    binding?.rvHistory?.adapter = historyAdapter
                }
            }
        }
    }
}
package com.example.workoutapp

import android.annotation.SuppressLint
import android.app.Dialog
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.workoutapp.databinding.ActivityExcerciseBinding
import com.example.workoutapp.databinding.DialogCustomBackConfirmationBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class ExerciseActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private var binding: ActivityExcerciseBinding? = null
    private var restTimer: CountDownTimer? = null
    private var restProgress = 0
    private var tts: TextToSpeech? = null
    private var player: MediaPlayer? = null
    private var exerciseList: ArrayList<ExerciseModel>? = null
    private var currentExercisePosition = -1
    private var adapter: ExerciseStatusAdapter? = null
    private var startDate: String? = null
    private var endDate: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExcerciseBinding.inflate(layoutInflater)
        setTheme(R.style.Theme_WorkoutApp)
        setContentView(binding?.root)

        tts = TextToSpeech(this, this)

        setSupportActionBar(binding?.toolBarExercise)
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        exerciseList = Constants.defaultExerciseList()
        adapter = ExerciseStatusAdapter(exerciseList!!)
        binding?.rvExerciseStatus?.adapter = adapter

        binding?.toolBarExercise?.setNavigationOnClickListener {
            customDialogForBackButton()
        }
        binding?.finishButton?.setOnClickListener { finish() }
        // here we can also set count down for exercise by copying frameLayout and making visible when we need it.
        // but here we used trick if we have timer == 10 then we just have to start again with timer == 30.
        setUpCountDownView(10)
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        customDialogForBackButton()
//        super.onBackPressed()
    }

    override fun onInit(status: Int) {

        startDate = getCurrentTime()
            if (status == TextToSpeech.SUCCESS) {
                val result = tts!!.setLanguage(Locale.US)
                if (result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA)
                    Log.d("TAG", "Language is not supported!")
            } else {
                Log.d("TAG", "Initialization is failed!")
            }
    }

    private fun getCurrentTime(): String {
        val calendar = Calendar.getInstance()
        val dateTime = calendar.time
        val sdf = SimpleDateFormat("dd MM yyyy hh:mm:ss", Locale.getDefault())
        return sdf.format(dateTime)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
        }
        if (tts != null) {
            tts?.stop()
            tts?.shutdown()
        }
        if (player != null) {
            player?.stop()
        }
        binding = null
    }

    private fun addDateToDatabase(historyDao: HistoryDao) {


        lifecycleScope.launch {
            historyDao.insertHistory(
                HistoryEntity(
                    startDate = startDate ?: "",
                    endDate = endDate ?: ""
                )
            )
        }
    }

    private fun setUpCountDownView(maxVal: Int) {
        val animation = AnimationUtils.loadAnimation(
            this@ExerciseActivity,
            R.anim.fade_in
        )
        binding?.svImgAndTimer?.startAnimation(animation)
        if (restTimer != null) {
            restTimer?.cancel()
            restProgress = 0
            binding?.progressBar?.max = maxVal
        }
        setProgressBar(maxVal)
    }

    private fun setProgressBar(maxVal: Int) {
        binding?.progressBar?.progress = maxVal

        if (maxVal == 10) {
            binding?.rvExerciseStatus?.visibility = View.GONE
            try {
                val soundURI =
                    Uri.parse("android.resource://com.example.workoutapp/" + R.raw.press_start)
                player = MediaPlayer.create(applicationContext, soundURI)
                player?.isLooping = false
                player?.start()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        } else binding?.rvExerciseStatus?.visibility = View.VISIBLE

        restTimer = object : CountDownTimer((maxVal.toLong() * 1000) + 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding?.progressBar?.progress = maxVal - restProgress
                binding?.tvTimer?.text = (maxVal - restProgress).toString()
                restProgress++
            }

            override fun onFinish() {
                if (currentExercisePosition < exerciseList!!.size - 1) {
                    binding?.ivExrImg?.visibility = View.VISIBLE
                    currentExercisePosition++
                    val exercise = exerciseList?.get(currentExercisePosition)
                    speakOut(exercise?.name ?: "")
                    binding?.tvTitle?.text = exercise?.name
                    binding?.ivExrImg?.setImageResource(exercise!!.image)
                    changeExerciseStatusRV(exercise!!)
                    setUpCountDownView(30)
                } else {
                    speakOut("workout completed!")
                    binding?.ivExrImg?.visibility = View.GONE
                    binding?.flProgress?.visibility = View.GONE
                    binding?.exerciseDoneAnimation?.visibility = View.VISIBLE
                    binding?.finishButton?.visibility = View.VISIBLE
                    exerciseList!![currentExercisePosition].isSelected = false
                    exerciseList!![currentExercisePosition].isCompleted = true
                    adapter?.notifyDataSetChanged()
                    binding?.tvTitle?.text = "Workout completed!"
                }
            }
        }.start()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun changeExerciseStatusRV(exercise: ExerciseModel) {
        exercise.isSelected = true
        if (exercise.id > 1) {
            exerciseList!![exercise.id - 2].isSelected = false
            exerciseList!![exercise.id - 2].isCompleted = true
        }
        adapter?.notifyDataSetChanged()
    }

    private fun speakOut(text: String) {
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    private fun customDialogForBackButton() {
        endDate = getCurrentTime()
        val customDialog = Dialog(this)
        val dialogBinding = DialogCustomBackConfirmationBinding.inflate(layoutInflater)
        customDialog.setContentView(dialogBinding.root)
        customDialog.setCanceledOnTouchOutside(false)
        dialogBinding.yesButton.setOnClickListener {
            val historyDao = (application as WorkOutApp).db.historyDao()
            addDateToDatabase(historyDao)
            customDialog.dismiss()
            finish()
        }
        dialogBinding.noButton.setOnClickListener {
            customDialog.dismiss()
        }
        customDialog.show()
    }
}
package com.example.workoutapp;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u000eH\u0003J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u0019H\u0017J\u0012\u0010!\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\b\u0010$\u001a\u00020\u0019H\u0014J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\tH\u0016J\u0010\u0010\'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020\u00192\u0006\u0010(\u001a\u00020\tH\u0002J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010+\u001a\u00020\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/example/workoutapp/ExerciseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "()V", "adapter", "Lcom/example/workoutapp/ExerciseStatusAdapter;", "binding", "Lcom/example/workoutapp/databinding/ActivityExcerciseBinding;", "currentExercisePosition", "", "endDate", "", "exerciseList", "Ljava/util/ArrayList;", "Lcom/example/workoutapp/ExerciseModel;", "Lkotlin/collections/ArrayList;", "player", "Landroid/media/MediaPlayer;", "restProgress", "restTimer", "Landroid/os/CountDownTimer;", "startDate", "tts", "Landroid/speech/tts/TextToSpeech;", "addDateToDatabase", "", "historyDao", "Lcom/example/workoutapp/HistoryDao;", "changeExerciseStatusRV", "exercise", "customDialogForBackButton", "getCurrentTime", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInit", "status", "setProgressBar", "maxVal", "setUpCountDownView", "speakOut", "text", "app_debug"})
public final class ExerciseActivity extends androidx.appcompat.app.AppCompatActivity implements android.speech.tts.TextToSpeech.OnInitListener {
    @org.jetbrains.annotations.Nullable()
    private com.example.workoutapp.databinding.ActivityExcerciseBinding binding;
    @org.jetbrains.annotations.Nullable()
    private android.os.CountDownTimer restTimer;
    private int restProgress = 0;
    @org.jetbrains.annotations.Nullable()
    private android.speech.tts.TextToSpeech tts;
    @org.jetbrains.annotations.Nullable()
    private android.media.MediaPlayer player;
    @org.jetbrains.annotations.Nullable()
    private java.util.ArrayList<com.example.workoutapp.ExerciseModel> exerciseList;
    private int currentExercisePosition = -1;
    @org.jetbrains.annotations.Nullable()
    private com.example.workoutapp.ExerciseStatusAdapter adapter;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String startDate;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String endDate;
    
    public ExerciseActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    @android.annotation.SuppressLint(value = {"MissingSuperCall"})
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    public void onInit(int status) {
    }
    
    private final java.lang.String getCurrentTime() {
        return null;
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final void addDateToDatabase(com.example.workoutapp.HistoryDao historyDao) {
    }
    
    private final void setUpCountDownView(int maxVal) {
    }
    
    private final void setProgressBar(int maxVal) {
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    private final void changeExerciseStatusRV(com.example.workoutapp.ExerciseModel exercise) {
    }
    
    private final void speakOut(java.lang.String text) {
    }
    
    private final void customDialogForBackButton() {
    }
}
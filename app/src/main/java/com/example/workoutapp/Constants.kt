package com.example.workoutapp

object Constants {
    fun defaultExerciseList(): ArrayList<ExerciseModel> {
        return arrayListOf(
            ExerciseModel(1, "Abdominal crunch", R.drawable.exr_abdominal_crunch),
            ExerciseModel(2, "High knees", R.drawable.exr_high_knees),
            ExerciseModel(3, "Jumping jacks", R.drawable.exr_jumping_jacks),
            ExerciseModel(4, "Lungs", R.drawable.exr_lungs),
            ExerciseModel(5, "Plank", R.drawable.exr_plank),
            ExerciseModel(6, "Push up", R.drawable.exr_push_up),
            ExerciseModel(7, "Push up and Rotation", R.drawable.exr_push_up_and_rotation),
            ExerciseModel(8, "Side plank", R.drawable.exr_side_plank),
            ExerciseModel(9, "Squat", R.drawable.exr_squat),
            ExerciseModel(10, "Step onto chair", R.drawable.exr_step_onto_chair),
            ExerciseModel(11, "Triceps dip", R.drawable.exr_triceps_dip),
            ExerciseModel(12, "Wall sit", R.drawable.exr_wall_sit),
        )
    }
}
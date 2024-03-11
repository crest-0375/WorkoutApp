package com.example.workoutapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {

    @Insert
    suspend fun insertHistory(historyEntity: HistoryEntity)

    @Query("SELECT * FROM `history-table`")
    fun getHistory(): Flow<List<HistoryEntity>>

}
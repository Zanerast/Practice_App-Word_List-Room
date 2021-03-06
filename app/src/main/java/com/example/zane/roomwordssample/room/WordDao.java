package com.example.zane.roomwordssample.room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface WordDao {

	@Insert(onConflict = OnConflictStrategy.IGNORE)
	void insert(WordEntity wordEntity);

	@Delete
	void deleteWord(WordEntity wordEntity);

	@Query("DELETE FROM word_table")
	void deleteAll();

	@Query("SELECT * FROM word_table ORDER BY word_column ASC")
	LiveData<List<WordEntity>> getAllWords();

	@Query("SELECT * FROM word_table LIMIT 1")
	WordEntity[] getAnyWord();
}

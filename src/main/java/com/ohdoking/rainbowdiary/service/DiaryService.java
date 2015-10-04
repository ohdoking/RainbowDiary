package com.ohdoking.rainbowdiary.service;

import java.util.Date;
import java.util.List;

import com.ohdoking.rainbowdiary.model.Diary;


public interface DiaryService {
	
	/*
	 * CREATE and UPDATE
	 */
	public void saveDiary(Diary diary);

	/*
	 * READ
	 */
	public List<Diary> listDiarys(Date date,String memberId);

	public Diary getDiary(Long id);

	/*
	 * DELETE
	 */
	public void deleteDiary(Long id);

//	public List<Diary> getDiaryAll();

}

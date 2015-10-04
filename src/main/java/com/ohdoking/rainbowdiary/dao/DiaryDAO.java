package com.ohdoking.rainbowdiary.dao;

import java.util.Date;
import java.util.List;

import com.ohdoking.rainbowdiary.model.Diary;

public interface DiaryDAO {
	
	public void addDiary(Diary d);
    public void updateDiary(Diary d);
    public List<Diary> listDiarys(Date date, String memberId);
    public Diary getDiaryById(Long id);
    public void removeDiary(Long id);

}

package com.ohdoking.rainbowdiary.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ohdoking.rainbowdiary.dao.DiaryDAO;
import com.ohdoking.rainbowdiary.model.Diary;

@Service("diaryService")
public class DiaryServiceImpl implements DiaryService {

	@Autowired
	private DiaryDAO diaryDao;
	
	@Transactional
	public void saveDiary(Diary diary) {
		diaryDao.addDiary(diary);		
	}

	@Transactional
	public List<Diary> listDiarys(Date date,String memberId) {
		return diaryDao.listDiarys(date,memberId);
	}
	

	@Transactional
	public Diary getDiary(Long id) {
		return diaryDao.getDiaryById(id);
	}

	@Transactional
	public void deleteDiary(Long id) {
		diaryDao.removeDiary(id);

		
	}


}
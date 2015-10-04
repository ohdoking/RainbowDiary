package com.ohdoking.rainbowdiary.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ohdoking.rainbowdiary.controller.DiaryController;
import com.ohdoking.rainbowdiary.model.Diary;
import com.ohdoking.rainbowdiary.model.User;

@Repository("diaryDAO")
public class DiaryDAOImpl implements DiaryDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(DiaryDAOImpl.class);
	
	@Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
           this.sessionFactory = sessionFactory;
    }
   
    protected Session getSession(){
//           return sessionFactory.openSession();
           Session sess = sessionFactory.getCurrentSession();
           if (sess == null) {
                  sess = sessionFactory.openSession();
           }
           return sess;
    }

	public void addDiary(Diary d) {
		
		Session session=getSession();
		   Transaction trans=session.beginTransaction();
		   session.save(d);
		   trans.commit();
	}

	public void updateDiary(Diary d) {
		// TODO 차후에 구현 해야할지도

	}

	public List<Diary> listDiarys(Date date,String memberId) {
		
		/*Date startDate = date;
		Calendar c = Calendar.getInstance(); 
		c.setTime(startDate); 
		c.add(Calendar.MONTH, +1);
		Date endDate = c.getTime(); 
		*/
		logger.info(date.getYear() +"/"+ date.getMonth()+"//"+memberId);
		
		Session session = sessionFactory.openSession();
		//Query using Hibernate Query Language
		String SQL_QUERY ="FROM Diary as o,User as u where o.memberId = u.id and u.userId = ? and year(o.timestamp) = ? and month(o.timestamp) = ?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,memberId);
		query.setParameter(1,date.getYear());
		query.setParameter(2,date.getMonth());
		
		List<Diary> list = query.list();

		session.close();

		return list;
	}

	public Diary getDiaryById(Long id) {
		return (Diary) getSession().get(Diary.class, id);
	}

	public void removeDiary(Long id) {

		Diary diary = (Diary) getSession().get(Diary.class, id);

         if (null != diary) {
                getSession().delete(diary);
         }
	}
	
}

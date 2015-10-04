package com.ohdoking.rainbowdiary.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class Diary{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private Long memberId;
	
	@Column
	private String diaryContent;
	@Column
	private Integer feeling;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date timestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getDiaryContent() {
		return diaryContent;
	}

	public void setDiaryContent(String diaryContent) {
		this.diaryContent = diaryContent;
	}

	public Integer getFeeling() {
		return feeling;
	}

	public void setFeeling(Integer feeling) {
		this.feeling = feeling;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
	
}

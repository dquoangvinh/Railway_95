package com.vti.entity;

public class Answer {
	private int id;
	private String content;
	private Question question;
	private Boolean isCorrect;

	public Answer() {
	}

	public Answer(int id, String content, Question question, Boolean isCorrect) {
		super();
		this.id = id;
		this.content = content;
		this.question = question;
		this.isCorrect = isCorrect;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Boolean getCorrect() {
		return isCorrect;
	}

	public void setCorrect(Boolean correct) {
		isCorrect = correct;
	}

	@Override
	public String toString() {
		return "Answer{" + "id=" + id + ", content='" + content + '\'' + ", question=" + question + ", isCorrect="
				+ isCorrect + '}';
	}
}

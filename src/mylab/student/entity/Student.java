package mylab.student.entity;

import mylab.student.exception.InvalidGradeException;

public class Student {
	//필드: 학번(studentId), 이름(name), 전공(major), 학년(grade) → 모두 private
	private int studentId;
	private String name;
	private String major;
	private int grade;
	
	public Student() {
		
	}
	public Student(int studentId, String name, String major, int grade) {
        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.grade = grade;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) throws InvalidGradeException {
        if (grade < 1 || grade > 4) {
            throw new InvalidGradeException("학년은 1~4 사이의 값이어야 합니다.");
        }
        this.grade = grade;
    }
}

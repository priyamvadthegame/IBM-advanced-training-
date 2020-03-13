package com.hibernate.rrelationshipinhibernate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

	private long studentId;
	private String studentName;
	private List<Course> courses;

	public Student() {
	}

	public Student(String studentName) {
		this.studentName = studentName;
	}

	public Student(String studentName, List<Course> courses) {
		this.studentName = studentName;
		this.courses = courses;
	}

	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID")
	public long getStudentId() {
		return this.studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	@Column(name = "STUDENT_NAME", nullable = false, length = 100)
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "STUDENT_COURSE", 
				joinColumns = { @JoinColumn(name = "STUDENT_ID") }, 
				inverseJoinColumns = { @JoinColumn(name = "COURSE_ID") })
	public List<Course> getCourses() {
		return this.courses;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + "]";
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
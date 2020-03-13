package com.hibernate.rrelationshipinhibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE")
public class EmployeeHibernate {
	
		@Id
		@GeneratedValue
		@Column(name="id")
		private Long employeeId;

		@Column(name="name")
		private String name;
		
		@Column(name="sal")
		private double sal;

		@OneToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, fetch=FetchType.LAZY)
		@JoinColumn(name="profile_id")
		private Profile profile;
		
		public EmployeeHibernate() {
			
		}
		
		public EmployeeHibernate(String name, double sal) {
			this.name = name;
			this.sal = sal;
		}

		public EmployeeHibernate(String name, double sal, Profile profile) {
			this.name = name;
			this.sal = sal;
			this.profile = profile;
		}

		public Long getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(Long employeeId) {
			this.employeeId = employeeId;
		}

		public Profile getProfile() {
			return profile;
		}

		public void setProfile(Profile profile) {
			this.profile = profile;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getSal() {
			return sal;
		}

		public void setSal(double sal) {
			this.sal = sal;
		}
		public String toString() {
			return employeeId + " - " + name + " - " + sal + " - profile: " + profile;
		}
	}

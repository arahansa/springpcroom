package com.arahansa.pcroom.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String userid;
	
	private String password;
	
	private String phone;
	
	private int mileage;
	
	private int age;
	
	
	public Member() {}
	public Member(String userid, String password){
		this.userid = userid;
		this.password = password;
	}
	
	public Member(String userid, String password, String phone, int mileage, int age) {
		super();
		this.userid = userid;
		this.password = password;
		this.phone = phone;
		this.mileage = mileage;
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", userid=" + userid + ", password=" + password + ", phone=" + phone + ", mileage="
				+ mileage + ", age=" + age + "]";
	}
	
	
	
	
	
	
	
	
	
	
}

/**
 * 
 */
package com.hik.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @ClassName: User
 * @Description: TODO
 * @author jed
 * @date 2017年2月26日下午6:19:11
 *
 */

@Entity
@Table(name="t_user")
public class User {
	
	private int id;
	private String trueName; //真实姓名 
	private String userName; //用户名
	private String password; //密码
	private String sex;  //性别
	private Date birthday; //出生日期
	private String dentityCode; //身份证
	private String email; //邮箱
	private String mobile; //手机号码
	private String address; //地址
	private int status = 1; //status = 1 普通用户 ,status = 2 管理员
	
	private List<Order> orderList = new ArrayList<Order>(); //用户和订单一对多关系，一个用户有多个订单。
	
	@Id
	@GeneratedValue(generator="_native")
	@GenericGenerator(name="_native",strategy="native")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(length=20)
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}
	
	@Column(length=20)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(length=20)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(length=5)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Column(length=20)
	public String getDentityCode() {
		return dentityCode;
	}
	public void setDentityCode(String dentityCode) {
		this.dentityCode = dentityCode;
	}
	
	@Column(length=20)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(length=20)
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Column(length=200)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@OneToMany(targetEntity=Order.class,cascade=CascadeType.ALL)
	@JoinColumn(name="userId",updatable=false) //外键关联
	public List<Order> getOrderList() {
		return orderList;
	}
	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	
}

/**
 * 
 */
package com.hik.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;

/**
 * @ClassName: Order
 * @Description: 订单
 * @author jed
 * @date 2017年2月26日下午7:36:07
 *
 */
@Entity
@Table(name="t_order")
public class Order {
	
	private int id;
	private String orderNo; //订单号
	private Date createTime; //创建时间
	private float cost; //订单总价
	private int status; //订单状态  1、（待审核）已下单 2、（审核通过）已付款 3、卖家已发货 4、买家已收货
	
	private User user; //订单和用户是多对一关系
	private List<OrderProduct> orderProductList = new ArrayList<OrderProduct>(); //订单和订单商品是一对多关系
	
	@Id
	@GeneratedValue(generator="_native")
	@GenericGenerator(name="_native",strategy="native")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@ManyToOne
	@JoinColumn(name="userId",updatable=false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	@OneToMany(fetch=FetchType.EAGER)
    @Cascade(value={CascadeType.SAVE_UPDATE})
	@JoinColumn(name="orderId")
	public List<OrderProduct> getOrderProductList() {
		return orderProductList;
	}
	public void setOrderProductList(List<OrderProduct> orderProductList) {
		this.orderProductList = orderProductList;
	}
	
}

/**
 * 
 */
package com.hik.entity;

/**
 * @ClassName: ShoppingCartItem
 * @Description: 购物车条目类实体
 * @author jed
 * @date 2017年4月2日上午10:48:13
 *
 */
public class ShoppingCartItem {

	private int id;
	private Product product; //商品
	private int count;  //商品数量 
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}

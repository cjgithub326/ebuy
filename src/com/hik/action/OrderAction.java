/**
 * 
 */
package com.hik.action;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.stereotype.Controller;

import com.hik.entity.Order;
import com.hik.entity.OrderProduct;
import com.hik.entity.Product;
import com.hik.entity.ShoppingCart;
import com.hik.entity.ShoppingCartItem;
import com.hik.entity.User;
import com.hik.service.OrderService;
import com.hik.util.DateUtil;
import com.hik.util.NavUtil;
import com.hik.util.ResponseUtil;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ResolverUtil.NameEndsWith;

import net.sf.json.JSONObject;

/**
 * @ClassName: OrderAction
 * @Description: TODO
 * @author jed
 * @date 2017��4��25������9:35:46
 *
 */
@Controller
public class OrderAction extends ActionSupport implements ServletRequestAware{

	/**
	 * ���к�
	 */
	private static final long serialVersionUID = 1L;

	private HttpServletRequest request;
	
	private String mainPage;
	
	private String navCode;
	
	private Order order;
	
	private int status;
	
	private String orderNo;
	
	private List<Order> orderList;
	
	@Resource
	private OrderService orderService;
	
	/**
	 * 
	 * @MethodName: save
	 * @Description: �ύ����
	 * @author jed
	 * @date 2017��4��25������10:47:51
	 * @param @return
	 * @param @throws Exception    
	 * @return String    ��������
	 * @return
	 * @throws Exception
	 *
	 */
	public String save() throws Exception{
		HttpSession session = request.getSession();
		Order order = new Order();
		User currentUser = (User) session.getAttribute("currentUser");
		order.setUser(currentUser);
		order.setCreateTime(new Date());
		order.setOrderNo(DateUtil.getCurrentDateStr());
		order.setStatus(1);
		
		ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("shoppingCart");
		List<ShoppingCartItem> shoppingCartItemList = shoppingCart.getShoppingCartItems();
		
		float cost = 0;
		List<OrderProduct> orderProductList = new LinkedList<OrderProduct>();
		for(ShoppingCartItem shoppingCartItem : shoppingCartItemList){
			OrderProduct orderProduct = new OrderProduct();
			Product product = shoppingCartItem.getProduct();
			orderProduct.setProduct(product);
			orderProduct.setOrder(order);
			orderProduct.setNum(shoppingCartItem.getCount());
			orderProductList.add(orderProduct);
			cost+=product.getPrice()*shoppingCartItem.getCount(); //�����ܼ�
		}
		
		order.setOrderProductList(orderProductList);
		order.setCost(cost);
		orderService.saveOrder(order);
		navCode = NavUtil.genNavCode("����");
		mainPage ="shopping/shopping-result.jsp";
		session.removeAttribute("shoppingCart");  //��չ��ﳵ,���session
		return SUCCESS;
	}
	
	/**
	 * 
	 * @MethodName: findOrder
	 * @Description: ��ѯ�������ж���
	 * @author jed
	 * @date 2017��4��29������4:30:05
	 * @param @return    
	 * @return String    ��������
	 * @return
	 *
	 */
	public String findOrder(){
		//��ȡ��ǰ�û�
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("currentUser");
		if(order==null){
			order = new Order(); //��ʼ�� 
		}
		order.setUser(currentUser);
		orderList = orderService.findOrder(order, null);
		navCode=NavUtil.genNavCode("�������� ");
		mainPage="userCenter/orderList.jsp";
		return "orderList";
	}
	
	/**
	 * 
	 * @MethodName: confirmReceive
	 * @Description: ȷ���ջ�
	 * @author jed
	 * @date 2017��4��29������9:56:50
	 * @param @return    
	 * @return String    ��������
	 * @return
	 * @throws Exception 
	 *
	 */
	public String confirmReceive() throws Exception{
		orderService.updateOrderStatus(status, orderNo);
		JSONObject result = new JSONObject();
		result.put("success", true);
		ResponseUtil.write(ServletActionContext.getResponse(), result);
		return null;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String getMainPage() {
		return mainPage;
	}

	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}

	public String getNavCode() {
		return navCode;
	}

	public void setNavCode(String navCode) {
		this.navCode = navCode;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	

}
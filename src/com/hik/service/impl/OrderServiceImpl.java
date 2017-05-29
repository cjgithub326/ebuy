/**
 * 
 */
package com.hik.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hik.dao.BaseDAO;
import com.hik.entity.Order;
import com.hik.entity.PageBean;
import com.hik.service.OrderService;
import com.hik.util.StringUtil;

/**
 * @ClassName: OrderServiceImpl
 * @Description: TODO
 * @author jed
 * @date 2017��4��25������9:30:49
 *
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Resource
	private BaseDAO<Order> baseDao;

	@Override
	public void saveOrder(Order order) {
		baseDao.save(order);
	}

	@Override
	public List<Order> findOrder(Order order, PageBean pageBean) {
		List<Object> param = new LinkedList<Object>();
		StringBuffer hql = new StringBuffer("from Order");
		if(order!=null){ //ĳ���û��Ķ���
			if(order.getUser()!=null && order.getUser().getId()!=0){
				hql.append(" and user.id = ?");
				param.add(order.getUser().getId());
			}
			if(StringUtil.isNotEmpty(order.getOrderNo())){
				hql.append(" and orderNo like ?");
				param.add("%"+order.getOrderNo().trim()+"%");
			}
		}
		hql.append(" order by createTime desc");
		if(pageBean!=null){
			return null;
		}else{
			return baseDao.find(hql.toString().replaceFirst("and", "where"), param);
		}
	}

	@Override
	public void updateOrderStatus(int status, String orderNo) {
		List<Object> param = new LinkedList<Object>();
		StringBuffer hql = new StringBuffer("update Order set status = ? where orderNo = ? ");
		param.add(status);
		param.add(orderNo);
		baseDao.executeHql(hql.toString(), param);
	}

}
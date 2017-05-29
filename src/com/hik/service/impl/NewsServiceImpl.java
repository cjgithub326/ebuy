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
import com.hik.entity.News;
import com.hik.entity.PageBean;
import com.hik.service.NewsService;

/**
 * @ClassName: NewsServiceImpl
 * @Description: TODO
 * @author jed
 * @date 2017��3��5������8:19:54
 *
 */
@Service("newsService")
public class NewsServiceImpl implements NewsService{

	@Resource
	private BaseDAO<News> baseDao;
	@Override
	public List<News> findNewsList(News news, PageBean pageBean) {
		List<Object> param = new LinkedList<Object>();
		StringBuffer sb = new StringBuffer("from News");
		if(pageBean!=null){
			return baseDao.find(sb.toString(), param, pageBean);
		}else{
			return null;
		}
	}
	
	@Override
	public News getNewsById(int newsId) {
		return baseDao.get(News.class, newsId);
	}

}

package com.sh.bos.web.action.base;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sh.bos.utils.PageBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 表现层通用实现
 * @author
 *
 * @param <T>
 */
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	protected PageBean pageBean = new PageBean();
	DetachedCriteria detachedCriteria = null;
	public void setPage(int page) { pageBean.setCurrentPage(page); }
	public void setRows(int rows) { pageBean.setPageSize(rows); }
	/**
	 * 将制定java对象转化为json，并响应到客户端页面
	 * @param o
	 * @param exclueds
	 */
	public void java2Json(Object o,String[] exclueds){
		JsonConfig jsonConfig = new JsonConfig();
		// 指定哪些属性不需要转json
		jsonConfig.setExcludes(exclueds);
		// 使用json-lib将pageBean对象转为json,通过输出流写回页面中
		// JSONObject -- 将单一对象转为json
		// JSONArray -- 将数组或者集合对象转为json
		String json = JSONObject.fromObject(o,jsonConfig).toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void java2Json(List o, String[] exclueds){
		JsonConfig jsonConfig = new JsonConfig();
		// 指定哪些属性不需要转json
		jsonConfig.setExcludes(exclueds);
		// 使用json-lib将pageBean对象转为json,通过输出流写回页面中
		// JSONObject -- 将单一对象转为json
		// JSONArray -- 将数组或者集合对象转为json
		String json = JSONArray.fromObject(o,jsonConfig).toString();
		ServletActionContext.getResponse().setContentType("text/json;charset=utf-8");
		try {
			ServletActionContext.getResponse().getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final String HOME = "home";
	public static final String LIST = "list";

	//模型对象
	protected T model;
	public T getModel() {
		return model;
	}

	//在构造方法中动态获取实体类型，通过反射创建model对象
	public BaseAction() {
		ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		//获得BaseAction上声明的泛型数组
		Type[] actualTypeArguments = genericSuperclass.getActualTypeArguments();
		Class<T> entityClass = (Class<T>) actualTypeArguments[0];
		detachedCriteria = DetachedCriteria.forClass(entityClass);
		pageBean.setDetachedCriteria(detachedCriteria);
		//通过反射创建对象
		try {
			model = entityClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}

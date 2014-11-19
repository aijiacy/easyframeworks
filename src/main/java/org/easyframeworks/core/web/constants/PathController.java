package org.easyframeworks.core.web.constants;

import org.apache.commons.lang.StringUtils;
import org.easyframeworks.base.controller.DictTypeController;
import org.easyframeworks.utils.GenericsUtils;
import org.easyframeworks.utils.StringExUtils;


/**
 * 页面路径构建器
 * @author CaoYong
 * @date 2014年4月13日下午5:20:43
 */
public class PathController {
	/**
	 * @fields entityClass 简单的实体类
	 */
	private Class<?> entityClass = null;
	/**
	 * @fields URL_SEPARATOR 路径分隔符
	 */
	private static final String URL_SEPARATOR = "/";
	/**
	 * @fields entityName 实体名称
	 */
	private String entityName = null;
	/**
	 * @fields words 实体类路径
	 */
	private String[] words = null;
	
	private String baseUrlPath;
	
	public <T> PathController(Class<T> genericClass,String baseUrlPath) {
		if (genericClass == null) throw new IllegalArgumentException("[genericClass] - must not be null!");

		entityClass = GenericsUtils.getSuperClassGenricType(genericClass);

		if (entityClass == null) throw new IllegalArgumentException(genericClass.getName() + "不是泛型类型！");

		words = getWords(entityClass.getSimpleName(),1);
		entityName = words[words.length - 1];
		this.baseUrlPath = baseUrlPath;
	}

	/**
	 * 获取显示页面路径  
	 * @return String "pub/org/viewOrg" 
	 */
	public String getInitViewPath() {
		StringBuilder sb = new StringBuilder();
		sb.append(getBasePath());
		sb.append(PagePrefix.VIEW);
		sb.append(StringExUtils.firstUpperCase(entityName));
		return sb.toString();
	}

	/**
	 * 显示列表路径
	 * @return String "pub/org/listOrg" 
	 */
	public String getListViewPath() {
		StringBuilder sb = new StringBuilder();
		sb.append(getBasePath());
		sb.append(PagePrefix.LIST);
		sb.append(StringExUtils.firstUpperCase(entityName));
		return sb.toString();
	}
	
	/**
	 * 添加页面路径信息
	 * @return
	 */
	public String getAddViewPath() {
		StringBuilder sb = new StringBuilder();
		sb.append(getBasePath());
		sb.append(PagePrefix.ADD);
		sb.append(StringExUtils.firstUpperCase(entityName));
		return sb.toString();
	}
	/**
	 * 添加页面路径信息
	 * @return
	 */
	public String getEditViewPath() {
		StringBuilder sb = new StringBuilder();
		sb.append(getBasePath());
		sb.append(PagePrefix.EDIT);
		sb.append(StringExUtils.firstUpperCase(entityName));
		return sb.toString();
	}

	/**
	 * 获取删除返回路径,默认重定向到列表页面
	 * @return
	 */
	public String getRedirectListPath() {
		return "redirect:/" + getBasePath();
	}
	
	/**
	 * 获取实体的名称，全小写
	 * @return
	 */
	public String getEntityName() {
		return entityName;
	}
	
	/**
	 * 以字符串中的大写字母为标示拆分字符串,如果字符串为null或空则返回null
	 * @param str
	 * @return String[] 拆分后的字符串，已转换为全小写
	 */
	@SuppressWarnings("unused")
	private String[] getWords(String str) {
		if (StringUtils.isEmpty(str)) return null;
		String[] words = str.split("(?<!^)(?=[A-Z])");
		for (int i = 0; i < words.length; i++) {
			words[i] = StringExUtils.firstLowerCase(words[i]);
		}
		return words;
	}
	
	/**
	 * 以字符串中的大写字母为标示拆分字符串,如果字符串为null或空则返回null
	 * @param str
	 * @return String[] 拆分后的字符串，已转换为全小写
	 */
	private String[] getWords(String str, int l) {
		if (StringUtils.isEmpty(str)) return null;
		String[] words = str.split("(?<!^)(?=[A-Z])");
		words[0] = StringExUtils.firstLowerCase(words[0]);
		StringBuilder strBuf = new StringBuilder();
		for(int i = 0; i < words.length; i++){
			strBuf.append(words[i]);
		}
		return new String[]{strBuf.toString()};
	}

	/**
	 * 获取类名路径信息，例如：PubOrg 则返回  "pub/org/"
	 * @param clazz 类
	 * @return String 类名路径信息
	 */
	private String getBasePath() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.baseUrlPath).append(URL_SEPARATOR);
		for (String word : words) {
			sb.append(word).append(URL_SEPARATOR);
		}
		return sb.toString();
	}
	
	public static void main(String[] agrs){
		PathController path = new PathController(DictTypeController.class,"admin");
		System.out.println(path.getEntityName());
		System.out.println(path.getBasePath());
		System.out.println(path.getInitViewPath());
		System.out.println(path.getAddViewPath());
		System.out.println(path.getEditViewPath());
		System.out.println(path.getListViewPath());
		System.out.println(path.getRedirectListPath());
	}
}

package org.easyframeworks.core.interceptors;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.easyframeworks.core.web.manager.Client;
import org.easyframeworks.core.web.manager.ClientManager;
import org.easyframeworks.utils.LoggerUtils;
import org.easyframeworks.utils.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

public class AuthInterceptor<T extends Serializable> implements HandlerInterceptor {

	//包含不需要拦截的URL地址
	private List<String> excludeUrls;
	private List<String> excludeDirs;
	
	public List<String> getExcludeUrls() {
		return excludeUrls;
	}
	
	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}
	
	public List<String> getExcludeDirs() {
		return excludeDirs;
	}
	
	public void setExcludeDirs(List<String> excludeDirs) {
		this.excludeDirs = excludeDirs;
	}

	/**
	 * 控制器访问后处理
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex) throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav) throws Exception {
	}

	/**
	 * 控制器访问前处理
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object obj) throws Exception {
		LoggerUtils.debug("进入拦截器");
		String requestPath = ResourceUtils.getRequestPath(request);// 用户访问的资源地址
		HttpSession session = org.easyframeworks.utils.ContextHolderUtils.getSession();
		Client<T> client = (Client<T>) ClientManager.getInstance().getClient(session.getId());
		if(client == null){
			client = (Client<T>) ClientManager.getInstance().getClient(request.getParameter("sessionId"));
		}
		
		boolean isExists = false;
		for	(String excludeDir : excludeDirs){
			if(requestPath.contains(excludeDir)){
				isExists = true;
			}
		}
		
		for	(String excludeUrl : excludeUrls){
			if(requestPath.equals(excludeUrl)){
				isExists = true;
			}
		}
		if(isExists){
			return true;
		}else{
			if (client != null /*&& client.getSysUser() !=null*/ ) {
				return true;
			}else{
				forward(request, response);
				return false;
			}
		}
	}
	
	/**
	 * 转发
	 * 
	 * @param user
	 * @param req
	 * @return
	 */
	@RequestMapping(params = "forword")
	public ModelAndView forword(HttpServletRequest request) {
		return new ModelAndView(new RedirectView("/"));
	}

	private void forward(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String base = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
//		request.getRequestDispatcher(base + "global/error").forward(request, response);
		response.sendRedirect(base + "global/error");
	}

}

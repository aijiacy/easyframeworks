package org.easyframeworks.base.controller;

import java.io.OutputStream;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.easyframeworks.base.entity.User;
import org.easyframeworks.base.service.IUserService;
import org.easyframeworks.core.exception.EasyMVCException;
import org.easyframeworks.core.web.constants.ResultMsg;
import org.easyframeworks.core.web.manager.Client;
import org.easyframeworks.core.web.manager.ClientManager;
import org.easyframeworks.security.VaildCodeGen;
import org.easyframeworks.utils.IPAddrUtils;
import org.easyframeworks.utils.StringExUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @class: LoginController
 * @description : 系统登陆页面控制
 * @author CaoYong
 * @date 2014年5月11日 下午7:18:12
 */
@RestController
@RequestMapping("/index")
public class LoginController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/login")
	public ModelAndView initLogin() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login/login");
		return mav;
	}

	@RequestMapping(value = "/ajaxLogin")
	@ResponseBody
	public ResultMsg doLogin(User user, String code, HttpServletRequest request) {
		ResultMsg resultMsg = new ResultMsg();
		if (StringExUtils.isEmpty(code)) {
			resultMsg.pushError("验证码不能为空!");
		} else {
			String validCode = request.getSession(false).getAttribute("VALID_CODE").toString();
			if (!code.equalsIgnoreCase(validCode)) {
				resultMsg.pushError("验证码错误!");
			} else {
				if(StringExUtils.isEmpty(user.getUsername())){
					resultMsg.pushError("用户名不能为空!");
				}else if(StringExUtils.isEmpty(user.getPassword())){
					resultMsg.pushError("密码不能为空!");
				}else{
					User sysUser = this.userService.checkUser(user);
					if (sysUser == null) {
						resultMsg.pushError("用户名或密码错误!");
					} else {
						Client<User> client = new Client<User>();
						client.setIp(IPAddrUtils.getIpAddr(request));
						client.setLogindatetime(new Date());
						client.setSysUser(sysUser);
						ClientManager.getInstance().addClinet(request.getSession().getId(), client);
						resultMsg.pushOK("登陆成功！");
					}
				}
			}
		}
		return resultMsg;
	}

	@RequestMapping(value = "/doLogin")
	public ModelAndView index(User user, String code, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		ResultMsg resultMsg = new ResultMsg();
		if (StringExUtils.isEmpty(user.getUsername())) {
			mav.setViewName("redirect:/index/login");
			resultMsg.pushError("用户名不能为空！");
		} else if (StringExUtils.isEmpty(user.getPassword())) {
			mav.setViewName("redirect:/index/login");
			resultMsg.pushError("用户名不能为空！");
		} else if (StringExUtils.isEmpty(code)) {
			mav.setViewName("redirect:/index/login");
			resultMsg.pushError("验证码不能为空！");
		} else {
			User sysUser = this.userService.checkUser(user);
			if (sysUser == null) {
				mav.setViewName("redirect:/index/login");
				resultMsg.pushError("用户名或密码错误！");
			} else {
				mav.setViewName("redirect:/index/");
				resultMsg.pushOK("登陆成功！");
				Client<User> client = new Client<User>();
				client.setIp(IPAddrUtils.getIpAddr(request));
				client.setLogindatetime(new Date());
				client.setSysUser(sysUser);
				ClientManager.getInstance().addClinet(request.getSession().getId(), client);
			}
		}
		mav.addObject("RESULTMSG", resultMsg);
		return mav;
	}

	@RequestMapping("/logout")
	public ModelAndView loginOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ClientManager.getInstance().removeClinet(session.getId());
		ModelAndView mav = new ModelAndView("redirect:/index/login");
		return mav;
	}

	@RequestMapping(value = "/imgCode")
	public void getCode(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		VaildCodeGen imgGen = new VaildCodeGen();
		String strCode = imgGen.createCode();
		session.setAttribute("VALID_CODE", strCode);
		try {
			OutputStream os = response.getOutputStream();
			ImageIO.write(imgGen.createValidCode(), "JPEG", os);
			os.flush();
			os.close();
		} catch (Exception ex) {
			EasyMVCException easyMVC = new EasyMVCException();
			easyMVC.resolveException(request, response, "获取验证码异常", ex);
		}
	}
}

package xiu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{
	//请求处理完成后调用
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	//处理器执行后调用
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}
	//处理器执行前调用
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		Object studentid=arg0.getSession().getAttribute("studentid");
//		System.out.println("-------------------");
//		System.out.println(studentid);
//		System.out.println("-------------------");
		if (studentid==null) {
			//Session中无id跳转到登录页面
			arg1.sendRedirect("http://localhost:8080/xiu/login/tologin.xiu");
			return false;
		}
		return true;
	}
}

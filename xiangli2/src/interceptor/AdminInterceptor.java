package interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AdminInterceptor implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public String intercept(ActionInvocation arg0) throws Exception {
		Map<String, Object> sessionMap=arg0.getInvocationContext().getSession();
		Object admin=sessionMap.get("adminid");
		if (admin==null) {
			return "login";
		}else {
			return arg0.invoke();
		}
	}

}

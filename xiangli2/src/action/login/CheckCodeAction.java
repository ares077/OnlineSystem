package action.login;

import java.util.HashMap;
import java.util.Map;

import action.BaseAction;

public class CheckCodeAction extends BaseAction {
	private String vcode;
	private Map<String, Object> info = new HashMap<String, Object>();

	public String execute() {
		String imageCode = (String) session.get("imageCode");
		if (imageCode == null
				|| !imageCode.toUpperCase().equals(vcode.toUpperCase())) {
			info.put("success", false);
			info.put("message", "验证码错误");
		} else {
			info.put("success", true);
			info.put("message", "V");
		}
		return "success";
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public Map<String, Object> getInfo() {
		return info;
	}

	public void setInfo(Map<String, Object> info) {
		this.info = info;
	}

}

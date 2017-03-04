package action.admin.studentlists;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import action.BaseAction;
import dao.InStudentDAO;
@Controller
@Scope("prototype")
public class DeleteStudentAction extends BaseAction{
	private String studentid;
	private String delete_msg;
	@Resource
	private InStudentDAO inStudentDAO;
	public String execute() {
		try {
			if (inStudentDAO.delete(studentid)) {
				delete_msg="删除成功";
				return "success";
			}else {
				delete_msg="删除失败，请稍后重试";
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String getStudentid() {
		return studentid;
	}
	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}
	public String getDelete_msg() {
		return delete_msg;
	}
	public void setDelete_msg(String deleteMsg) {
		delete_msg = deleteMsg;
	}
	
}

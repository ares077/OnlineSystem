package action.admin.questionlists;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import action.BaseAction;
import dao.InQuestionDAO;
@Controller
@Scope("prototype")
public class DeleteQuestionAction extends BaseAction{
	private String questionid;
	private String delete_msg;
	@Resource
	private InQuestionDAO inQuestionDAO;
	public String execute() {
		try {
			if (inQuestionDAO.delete(questionid)) {
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
	public String getQuestionid() {
		return questionid;
	}
	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}
	public String getDelete_msg() {
		return delete_msg;
	}
	public void setDelete_msg(String deleteMsg) {
		delete_msg = deleteMsg;
	}
}

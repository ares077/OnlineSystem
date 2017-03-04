package xiu.controller.note;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xiu.dao.ExamDAO;
import xiu.entity.Note;
import xiu.entity.QuesID;
import xiu.entity.Question;

@Controller
@Scope("prototype")
@RequestMapping("/cuoti")
public class CuotiController {
	@Resource
	private ExamDAO dao;
	@RequestMapping("/ct")
	public String execute(String noteid,Model model){
		try {
			Note note=dao.findNoteById(noteid);
			if (Integer.parseInt(note.getTotal())<70) {
				return "stu/note/notct";
			}
			String cuoti=note.getCuoti();
			String[] cuotis=cuoti.split(",");
			LinkedList<String> qid=new LinkedList<String>();
			for (String string : cuotis) {
				qid.add(string);
			}
			List<Question> questions=dao.findAnswer(new QuesID(qid));
			List<Question> questionsSin=new ArrayList<Question>();
			List<Question> questionsMul=new ArrayList<Question>();
			for (Question question : questions) {
				if (question.getType().equals("单选")) {
					questionsSin.add(question);
				}else {
					questionsMul.add(question);
				}
			}
			model.addAttribute("questionsSin", questionsSin);
			model.addAttribute("questionsMul", questionsMul);
			return "stu/note/cuoti";
		} catch (Exception e) {
			e.printStackTrace();
			return "stu/note/notct";
		}
	}
}

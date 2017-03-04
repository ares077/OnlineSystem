package xiu.controller.exam;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xiu.dao.ExamDAO;
import xiu.entity.Exam;
import xiu.entity.Note;
import xiu.entity.QuesID;
import xiu.entity.Question;

@Controller
@Scope("prototype")
@RequestMapping("/finish")
public class CountScoreController {
	@Resource
	private ExamDAO dao;

	@RequestMapping("/cs.xiu")
	public String execute(Exam exam, Model model) {
		try {
			
			//System.out.println("finish/cs" + "----------------------------------------------");
			
			String courseid=dao.findCidByPid(exam.getPaperid());
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			String date=sdf.format(Calendar.getInstance().getTime());
			String studentid=exam.getStudentid();
			String noteid=studentid+date;
			if (studentid.equals("xiuxiu")) {
				noteid=studentid+new Random().nextInt(10000);
			}else if (studentid.equals("xiaojin")) {
				noteid=studentid+new Random().nextInt(1000);
			}
			Note note1=new Note();
			note1.setNoteid(noteid);
			note1.setCourseid(courseid);
			Note note2=dao.findNoteID(note1);
			if (note2!=null) {
				return "stu/exam/already";
			}
			LinkedList<String> qid = exam.getAllQIDlist();
			QuesID quesID = new QuesID(qid);
			List<Question> notes=dao.findAnswer(quesID);
			HashMap<Integer, Question> trueAns=new HashMap<Integer, Question>();
			for(int i=0;i<notes.size();i++){
				trueAns.put(i+1, notes.get(i));
			}
			HashMap<Integer, Question> userAns=exam.getAllAnswer();
			int scoreSin = 0;
			int scoreMul=0;
			String cuoti = "";
			for (int i = 0; i < trueAns.size(); i++) {
				for (int j = 0; j < userAns.size(); j++) {
					//判断Qid是否相等
					if (trueAns.get(i+1).getQuestionid().equals(userAns.get(j+1).getQuestionid())) {
						//判断答案是否相等
						if (trueAns.get(i+1).getAnswer().equals(userAns.get(j+1).getAnswer())) {
							//判断此题的类型
							if (trueAns.get(i+1).getType().equals("单选")) {
								scoreSin+=10;
							}else {
								scoreMul+=10;
							}
						}else {
							//判断是用户做错还是没答
							if (!userAns.get(j+1).getAnswer().equals("Z")){
								cuoti+=userAns.get(j+1).getQuestionid()+",";
							}
						}
					}
				}
			}
			int score=scoreMul+scoreSin;
			model.addAttribute("score", score);
			String nandu=exam.getAllNandu();
			Note note=new Note(noteid, studentid, courseid, scoreSin+"", scoreMul+"", score+"", nandu, cuoti);
			dao.addNote(note);
			return "stu/exam/score";
		} catch (Exception e) {
			e.printStackTrace();
			return "main/error";
		}
	}
}

package xiu.controller.exam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import xiu.dao.ExamDAO;
import xiu.entity.Course;
import xiu.entity.Note;
import xiu.entity.Question;

@Controller
@Scope("prototype")
@RequestMapping("/exam")
public class ExamController {
	@Resource
	private ExamDAO dao;
	@RequestMapping("/load.xiu")
	public String execute(Model model){
		try {
			List<Course> courses=dao.findCourses();
			model.addAttribute("courses", courses);
			return "stu/exam/exam";
		} catch (Exception e) {
			e.printStackTrace();
			return "main/error";
		}
	}
	@RequestMapping("/exam.xiu")
	public String execute2(Model model,String courseid,String paperid,String studentid,HttpSession session){
		try {
			//判断此学生今天是否参加过考试
		//	String studentid=(String)session.getAttribute("studentid");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			String date=sdf.format(Calendar.getInstance().getTime());
			String nid=studentid+date;
			Note note1=new Note();
			note1.setNoteid(nid);
			note1.setCourseid(courseid);
			Note note=dao.findNoteID(note1);
			if (note!=null) {	
				return "stu/exam/already";
			}else {
				List<Question> Single=new ArrayList<Question>();
				List<Question> Multi=new ArrayList<Question>();
				Random ran=new Random();
				//查询出试卷的单选 双选题。
				List<Question> questionsSin=dao.findQuestionsSin(paperid.substring(0, paperid.length()-1));
				List<Question> questionsMul=dao.finQuestionsMul(paperid.substring(0, paperid.length()-1));
				if (paperid.endsWith("A")) {
					// 单选 2个A1 2个A2 2个B1 1个B2    双选 2个C1 1个C2
					int a1=0,a2=0,b1=0,b2=0,c1=0,c2=0;
					while(Single.size()<7){
						int sin=ran.nextInt(questionsSin.size());
						if (questionsSin.get(sin).getLevel().equals("A1")) {
							if (a1<2) {
								Single.add(questionsSin.remove(sin));
								a1++;
							}else {
								questionsSin.remove(sin);
							}
						}else if (questionsSin.get(sin).getLevel().equals("A2")) {
							if (a2<2) {
								Single.add(questionsSin.remove(sin));
								a2++;
							}else {
								questionsSin.remove(sin);
							}
						}else if (questionsSin.get(sin).getLevel().equals("B1")) {
							if (b1<2) {
								Single.add(questionsSin.remove(sin));
								b1++;
							}else {
								questionsSin.remove(sin);
							}
						}else if (questionsSin.get(sin).getLevel().equals("B2")) {
							if (b2<1) {
								Single.add(questionsSin.remove(sin));
								b2++;
							}else {
								questionsSin.remove(sin);
							}
						}else {
							questionsSin.remove(sin);
						}
					}
					while(Multi.size()<3){
						int mul=ran.nextInt(questionsMul.size());
						if (questionsMul.get(mul).getLevel().equals("C1")) {
							if (c1<2) {
								Multi.add(questionsMul.remove(mul));
								c1++;
							}else {
								questionsMul.remove(mul);
							}
						}else if (questionsMul.get(mul).getLevel().equals("C2")) {
							if (c2<1) {
								Multi.add(questionsMul.remove(mul));
								c2++;
							}else {
								questionsMul.remove(mul);
							}
						}else {
							questionsMul.remove(mul);
						}
					}
				}else if (paperid.endsWith("B")) {
					//全部B1以上难度  随机出题
					while(Single.size()<7){
						int sin=ran.nextInt(questionsSin.size());
						if (questionsSin.get(sin).getLevel().equals("A1")||questionsSin.get(sin).getLevel().equals("A2")) {
							questionsSin.remove(sin);
						}else {
							Single.add(questionsSin.remove(sin));
						}
					}
					while(questionsMul.size()>3)questionsMul.remove(ran.nextInt(questionsMul.size()));
					Multi=questionsMul;
				}else if (paperid.endsWith("C")) {
					while(questionsSin.size()>7)questionsSin.remove(ran.nextInt(questionsSin.size()));
					while(questionsMul.size()>3)questionsMul.remove(ran.nextInt(questionsMul.size()));
				  Single=questionsSin;
				  Multi=questionsMul;
				}else if (paperid.endsWith("D")) {
					while(questionsSin.size()>7)questionsSin.remove(ran.nextInt(questionsSin.size()));
					while(questionsMul.size()>3)questionsMul.remove(ran.nextInt(questionsMul.size()));
					Single=questionsSin;
					  Multi=questionsMul;
				}
				model.addAttribute("questionsMul", Multi);
				model.addAttribute("questionsSin", Single);
				model.addAttribute("studentid", studentid);
				model.addAttribute("paperid", paperid);
				return "stu/exam/questions";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "main/error";
		}
	}
}

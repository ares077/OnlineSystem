package xiu.controller.note;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import xiu.dao.NoteDAO;
import xiu.entity.Course;
import xiu.entity.Note;
import xiu.entity.Page;

@Controller
@Scope("prototype")
@RequestMapping("/note")
@SessionAttributes({"nowPage","nowPage2"})
public class NoteController {
	@Resource
	private NoteDAO dao;
	@RequestMapping("/notelist.xiu")
	public String execute(HttpSession session,String nowPage,Model model){
		try {
			String studentid=(String)session.getAttribute("studentid");
			int now=1;
			Page page2=new Page(studentid, dao.countNote(studentid), 7, 1);
			int maxPage=page2.getTotalPages();
			if (nowPage!=null){
				now=Integer.parseInt(nowPage);
			}else {
				if (session.getAttribute("nowPage")!=null){
					now=Integer.parseInt(session.getAttribute("nowPage").toString());
				}
			}
			now=now<1?1:now;
			now=now>maxPage?maxPage:now;
			page2.setPage(now);
			List<Course> courses=dao.findCourses();
			if (page2.getTotalPages()==0) {
				model.addAttribute("courses", courses);
				return "stu/note/notfound";
			}
			List<Note> notes=dao.findByPage(page2);
			model.addAttribute("courses", courses);
			model.addAttribute("notes", notes);
			model.addAttribute("nowPage", now);
			return "stu/note/notelist";
		} catch (Exception e) {
			e.printStackTrace();
			return "main/error";
		}
	}
	@RequestMapping("/notelist2.xiu")
	public String execute2(HttpSession session,String nowPage2,Model model,String courseid){
		try {
			String studentid=(String)session.getAttribute("studentid");
			int now=1;
			Page page =new Page();
			page.setStudentid(studentid);
			page.setCourseid(courseid);
			page=new Page(studentid, dao.countNoteByCID(page), 7, 1);
			page.setCourseid(courseid);
			int maxPage=page.getTotalPages();
			if (nowPage2!=null){
				now=Integer.parseInt(nowPage2);
			}else {
				if (session.getAttribute("nowPage2")!=null){
					now=Integer.parseInt(session.getAttribute("nowPage2").toString());
				}
			}
			now=now<1?1:now;
			now=now>maxPage?maxPage:now;
			page.setPage(now);
			List<Course> courses=dao.findCourses();
			if (page.getTotalPages()==0) {
				model.addAttribute("courses", courses);
				return "stu/note/notfound";
			}
			List<Note> notes=dao.findByPageByCID(page);
			model.addAttribute("courseid", courseid);
			model.addAttribute("courses", courses);
			model.addAttribute("notes", notes);
			model.addAttribute("nowPage2", now);
			return "stu/note/notelist2";
		} catch (Exception e) {
			e.printStackTrace();
			return "main/error";
		}
	}
}

package xiu.controller.lexique;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sun.org.apache.bcel.internal.generic.NEW;

import xiu.dao.LexiqueDAO;
import xiu.entity.Course;
import xiu.entity.Lexique;
import xiu.entity.Note;
import xiu.entity.Page;
import xiu.entity.PageLexique;

@Controller
@Scope("prototype")
@RequestMapping("motre")
@SessionAttributes({"nowPage","nowPageparlimit"})
public class LexiqueRe {
	@Resource
	private LexiqueDAO lexiqueDAO;
	@RequestMapping("relist.xiu")
	private String execute(HttpSession session,String nowPage,Model model){
		try {
			String user=(String)session.getAttribute("studentid");
			int now=1;
			PageLexique pageLexique1= new PageLexique(user, lexiqueDAO.countAll(user), 7, 1);		
			int maxPage=pageLexique1.getTotalPages();
			if (nowPage!=null){
				now=Integer.parseInt(nowPage);
			}else {
				if (session.getAttribute("nowPage")!=null){
					now=Integer.parseInt(session.getAttribute("nowPage").toString());
				}
			}
			now=now<1?1:now;
			now=now>maxPage?maxPage:now;
			pageLexique1.setPage(now);
			List<Lexique> lexiques=lexiqueDAO.findByPage(pageLexique1);
			int totalnotes=pageLexique1.getTotalNotes();
			model.addAttribute("totalnotes", totalnotes);
			model.addAttribute("maxPage", maxPage);
			model.addAttribute("lexiques", lexiques);
			model.addAttribute("nowPage", now);
			return "lexique/repage";
		} catch (Exception e) {
			e.printStackTrace();
			return "main/error";
		}
	}
	@RequestMapping("relistparlimit.xiu")
	private String execute(HttpSession session,String nowPageparlimit,Model model,String mot,String declinaison
			,String aaaa,String mm,String jj){
		try {	
			PageLexique limit=new PageLexique();		
			if (mot!=null&&mot!="") {
				model.addAttribute("mot", mot);
				limit.setMot(mot);	
				aaaa=null;
				declinaison=null;
				jj=null;
				mm=null;
			}
			String jour=aaaa;	
			model.addAttribute("aaaa", aaaa);
			if (declinaison!=null&&declinaison!="") {
				limit.setDeclinaison(declinaison);
				model.addAttribute("declinaison", declinaison);
			}
			if (jour!=null&&mm!=null) {
				jour+=mm;
				model.addAttribute("mm", mm);
				if (jj!=null) {
					jj.equals("1");
					if (jj.equals("1")||jj.equals("2")||jj.equals("3")||jj.equals("4")||jj.equals("5")||jj.equals("6")||jj.equals("7")||jj.equals("8")||jj.equals("9")){
						jj="0"+jj;
					}
					jour+=jj;
					model.addAttribute("jj", jj);
				}
			}	
			limit.setJour(jour);
			String user=(String)session.getAttribute("studentid");
			limit.setUser(user);
			int now=1;
			PageLexique pageLexique1= new PageLexique(user, lexiqueDAO.countLimit(limit), 7, 1);
			if (pageLexique1.getTotalNotes()<=0) {
				return "lexique/repageparlimit";
			}
			pageLexique1.setJour(limit.getJour());
			pageLexique1.setMot(limit.getMot());
			pageLexique1.setDeclinaison(limit.getDeclinaison());
			int maxPage=pageLexique1.getTotalPages();
			if (nowPageparlimit!=null){
				now=Integer.parseInt(nowPageparlimit);
			}else {
				if (session.getAttribute("nowPageparlimit")!=null){
					now=Integer.parseInt(session.getAttribute("nowPageparlimit").toString());
				}
			}
			now=now<1?1:now;
			now=now>maxPage?maxPage:now;
			pageLexique1.setPage(now);
			List<Lexique> lexiques=lexiqueDAO.findByLimit(pageLexique1);
			int totalnotes=pageLexique1.getTotalNotes();
			model.addAttribute("totalnotes", totalnotes);
			model.addAttribute("maxPage", maxPage);
			model.addAttribute("lexiques", lexiques);
			model.addAttribute("nowPageparlimit", now);
			return "lexique/repageparlimit";
		} catch (Exception e) {
			e.printStackTrace();
			return "main/error";
		}
	}
}

package xiu.controller.lexique;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import xiu.dao.LexiqueDAO;
import xiu.entity.Lexique;

@Controller
@Scope("prototype")
@RequestMapping("/lexique")
@SessionAttributes("modi_msg")
public class LexiqueMain {


	@Resource
	private LexiqueDAO lexiqueDAO;
    @RequestMapping("/lexiquemain.xiu")
    public String execute1(){
    	return "lexique/mainpage";
    }
    @RequestMapping("/modipage.xiu")
    public String execute2(HttpSession session,String lexid,Model model){
    	try {
    		String userid= (String) session.getAttribute("studentid");
			Lexique lexique= lexiqueDAO.findById(new Lexique(Integer.parseInt(lexid), userid));
			
			model.addAttribute("lexique", lexique);
    		return "lexique/modipage";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "main/error";
		}
    }
    @RequestMapping("/modimot.xiu")
    public String execute3(@ModelAttribute("lexique")Lexique lexique,Model model){
    	try {
    		
    		lexiqueDAO.modify(lexique);
			model.addAttribute("modi_msg", "modif-réussi!");
    		return "lexique/modipage";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "main/error";
		}
    }
    @RequestMapping("/delete.xiu")
    public String execute4(String lexiqueid,Model model){
    	try {
    		lexiqueDAO.delete(Integer.parseInt(lexiqueid));
			model.addAttribute("modi_msg", "delete-réussi!");
			model.addAttribute("lexid", lexiqueid);
    		return "redirect:modipage.xiu";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "main/error";
		}
    }
    @RequestMapping("/remettre.xiu")
    public String execute5(String lexiqueid,Model model){
    	try {
    		lexiqueDAO.remettre(Integer.parseInt(lexiqueid));
			model.addAttribute("modi_msg", "remettre-réussi!");
			model.addAttribute("lexid", lexiqueid);
			return "redirect:modipage.xiu";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "main/error";
		}
    }
    @RequestMapping("/addpage.xiu")
    public String execute3(){
    	return "lexique/addpage";
    }
}


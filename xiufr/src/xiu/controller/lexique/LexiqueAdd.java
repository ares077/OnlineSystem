package xiu.controller.lexique;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


import xiu.dao.LexiqueDAO;
import xiu.entity.Lexique;

@Controller
@Scope("prototype")
@RequestMapping("/mot")
@SessionAttributes("add_msg")
public class LexiqueAdd {
	@Resource
	private LexiqueDAO lexiqueDAO;
	@RequestMapping("/addmot.xiu")
	private String execute(@ModelAttribute("lexique")Lexique lexique,Model model){
		try {
			if (lexique.getSensfr()==null) {
				lexique.setSensfr("");
			}else if (lexique.getLocution1()==null) {
				lexique.setLocution1("");
			}else if (lexique.getLocution2()==null) {
				lexique.setLocution2("");
			}else if (lexique.getLocution3()==null) {
				lexique.setLocution3("");
			}else if (lexique.getPhrase1()==null) {
				lexique.setPhrase1("");
			}else if (lexique.getPhrase2()==null) {
				lexique.setPhrase2("");
			}else if (lexique.getPhrase3()==null) {
				lexique.setPhrase3("");
			}
			Lexique canaddd=new Lexique(lexique.getMot(), lexique.getUser());
			Lexique flagca=lexiqueDAO.findByName(canaddd);
			if (flagca==null) {
				lexiqueDAO.add(lexique);
				model.addAttribute("add_msg", "réussi!");
				return "redirect:/lexique/addpage.xiu";
			}else {
				model.addAttribute("add_msg", "déjà déposé");
				return "redirect:/lexique/addpage.xiu";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "main/error";
		}
	}
	@RequestMapping("isexist.xiu")
	@ResponseBody
	private Map<String, String> execute(String mot,HttpSession session){
		try {
			String userid=(String) session.getAttribute("studentid");
			Lexique lx1=new Lexique(mot,userid);
			Lexique lx=lexiqueDAO.findByName(lx1);
			Map<String, String> map=new HashMap<String, String>();
			if (lx==null) {
				map.put("flag", "canadd");
			}else {
				map.put("flag", "exist");
			}
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

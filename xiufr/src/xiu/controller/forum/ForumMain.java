package xiu.controller.forum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import xiu.dao.ForumDAO;
import xiu.entity.Forum;
import xiu.entity.Lexique;
import xiu.entity.PageForum;

@Controller
@Scope("prototype")
@RequestMapping("/forum")
@SessionAttributes("nowPageforum")
public class ForumMain {

	
	@Resource
	private ForumDAO forumDAO;
	
	
	 @RequestMapping("/forummain.xiu")
	    public String execute1(HttpSession session,String nowPageforum,Model model,String author,String title,String category){
		 try {	
			    Properties cata=new Properties();
			    cata.load(ForumMain.class.getClassLoader().getResourceAsStream("xiu/controller/forum/cata.properties"));
			    String names=cata.getProperty("names");
				String categorylists[]=names.split(",");
			//	String usr=(String)session.getAttribute("studentid");
				if(title!=null&&title.length()<1)title=null;
				if(category!=null&&category.length()<1)category=null;
				if(author!=null&&author.length()<1)author=null;
				PageForum pageForum=new PageForum(title,category,author);
				
				int now=1;
				PageForum pageForumlists= new PageForum(title,category,author,forumDAO.countLimit(pageForum),7);
				if (pageForumlists.getTotalNotes()<=0) {
					model.addAttribute("category",category);
					model.addAttribute("author",author);
					model.addAttribute("title",title);
					model.addAttribute("categorylists", categorylists);
					model.addAttribute("nowPageforum", now);
					return "forum/lists";
				}
				int maxPage=pageForumlists.getTotalPages();
				if (nowPageforum!=null){
					now=Integer.parseInt(nowPageforum);
				}else {
					if (session.getAttribute("nowPageforum")!=null){
						now=Integer.parseInt(session.getAttribute("nowPageforum").toString());
					}
				}
				now=now<1?1:now;
				now=now>maxPage?maxPage:now;
				pageForumlists.setPage(now);
				List<Forum> posts=forumDAO.findByLimit(pageForumlists);
				int totalnotes=pageForumlists.getTotalNotes();
				model.addAttribute("totalnotes", totalnotes);
				model.addAttribute("maxPage", maxPage);
				model.addAttribute("posts", posts);
				model.addAttribute("nowPageforum", now);
				model.addAttribute("category",category);
				model.addAttribute("author",author);
				model.addAttribute("title",title);
				model.addAttribute("categorylists", categorylists);
				return "forum/lists";
			} catch (Exception e) {
				e.printStackTrace();
				return "main/error";
			}
	    	
	    }
	 @RequestMapping("/addpage.xiu")
	 public String execute2(HttpSession session,Model model){
		 try {
			 Properties cata=new Properties();
			 cata.load(ForumMain.class.getClassLoader().getResourceAsStream("xiu/controller/forum/cata.properties"));
			 String names=cata.getProperty("names");
		     String categorylists[]=names.split(",");
		 	String stuid=(String)session.getAttribute("studentid");
		 	String name=forumDAO.getName(stuid);
		 	
		 	model.addAttribute("name", name);
		     model.addAttribute("categorylists", categorylists);
			return "forum/addforum";
		} catch (Exception e) {
			e.printStackTrace();
			return "main/error";
		}
	 }
		@RequestMapping("/addpost.xiu")
	 private String execute(@ModelAttribute("forum")Forum forum,HttpSession session){
			try {
				if (forum.getContent()==null) {
					forum.setContent("");
				}else if (forum.getLien()==null) {
					forum.setLien("");
				}
				
					forumDAO.add(forum);
					session.setAttribute("add_msg", "réussi!");
					return "redirect:/forum/addpage.xiu";
			} catch (Exception e) {
				e.printStackTrace();
				return "main/error";
			}
		}
		@RequestMapping("/modipage.xiu")
		private String execute3(String postsid,Model model){
			try {
				
					Forum forum=forumDAO.findById(postsid);
				 	model.addAttribute("forum", forum);
					return "forum/modi";
			} catch (Exception e) {
				e.printStackTrace();
				return "main/error";
			}
		}
		@RequestMapping("/post.xiu")
		private String execute6(String postsid,Model model){
			try {
				
					Forum forum=forumDAO.findById(postsid);
				 	model.addAttribute("forum", forum);
					return "forum/post";
			} catch (Exception e) {
				e.printStackTrace();
				return "main/error";
			}
		}
		@RequestMapping("/modi.xiu")
		@ResponseBody
		private Map<String, String> execute4(String postsid,String title,String category,String content,String lien
				,HttpSession session,Model model){
			try {
				Forum forum=new Forum();
				forum.setTitle(title);
				forum.setCategory(category);
				forum.setContent(content);
				forum.setLien(lien);
				forum.setPostsid(Integer.parseInt(postsid));
				Map<String, String> map=new HashMap<String, String>();
				forumDAO.modifer(forum);
				 map.put("flag", "modi");
				return map;

			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
}

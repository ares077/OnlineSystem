package xiu.controller.feedback;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Scope("prototype")
@RequestMapping("/feedback")
public class FeedBackController {
	@RequestMapping("fb.xiu")
	public String execute2(){
		return "stu/feedback/feedback";
	}
	@RequestMapping("/add.xiu")
	public String execute(HttpSession session,String feedback){
		try {
			String name=(String) session.getAttribute("stuname");
			String id=(String) session.getAttribute("studentid");
			String message=name+"("+id+")"+":"+feedback+"\r\n";
			/*
			//RandomAccessFile实现写入
			RandomAccessFile raf=new RandomAccessFile("../webapps/xiu/feedback.txt", "rw");
			raf.seek(raf.length());
			raf.writeBytes(message);
			raf.close();
			*/
			//流实现
			PrintWriter pw=new PrintWriter(
					new OutputStreamWriter(new FileOutputStream(new File("../webapps/xiu/feedback.txt"), true), "utf-8"));
			pw.write(message);
			pw.close();
			
			return "redirect:/feedback/fb.xiu";
		} catch (Exception e) {
			e.printStackTrace();
			return "main/error";
		}
	}
}

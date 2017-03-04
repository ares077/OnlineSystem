package action.feedback;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class FeedBackAction {
	private String feedback;
	public String execute(){
		try {
			/*
			//RandomAccessFile实现读出 
			RandomAccessFile raf=new RandomAccessFile("../webapps/xiu/feedback.txt", "rw");
			String str="";
			while((str=raf.readLine())!=null){
				feedback+=str+"\r\n";
			}
			*/
			//流实现]
			BufferedReader br=new BufferedReader(
					new InputStreamReader(new FileInputStream(new File("../webapps/xiu/feedback.txt")), "utf-8"));
			String str="";
			while((str=br.readLine())!=null){
				if (feedback==null) {
					feedback=str+"\r\n";
				}
				feedback+=str+"\r\n";
			}
			br.close();
			return "success";
		} catch (FileNotFoundException e2) {
			return "ss2";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	
}

package xiu.controller.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@Scope("prototype")
@RequestMapping("/login")
public class CreateImageController {
	@RequestMapping("/createImage.xiu")
	public void execute(HttpServletRequest request,
	          HttpServletResponse response) throws Exception{
		BufferedImage image=new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		Random r=new Random();
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		g.fillRect(0, 0, 80, 30);
		String number=getNumber(4);
		HttpSession session=request.getSession();
		session.setAttribute("imageCode", number);
		g.setColor(new Color(0,0,0));
		g.setFont(new Font(null, Font.BOLD, 24));
		g.drawString(number, 5, 25);
		for (int i = 0; i < 8; i++) {
			g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
			g.drawLine(r.nextInt(100), r.nextInt(30), r.nextInt(100), r.nextInt(30));
		}
		response.setContentType("image/jpeg");
		OutputStream ops=response.getOutputStream();
		ImageIO.write(image, "jpeg", ops);
		ops.close();
	}

	private String getNumber(int i) {
		String str="1QAZ2wsx3EDC4rfv5TGB6yhn7UJM8ik9OL01lo2PpIK3ujm4YHN5bgt6RFVc7deW8SXz9a0q";
		String number="";
		Random random=new Random();
		for (int j = 0; j < i; j++) {
			number+=str.charAt(random.nextInt(str.length()));
		}
		return number;
	}
}

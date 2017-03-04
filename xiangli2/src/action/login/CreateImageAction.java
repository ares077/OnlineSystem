package action.login;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.BaseAction;
import util.ImageUtil;

public class CreateImageAction extends BaseAction{
	public ByteArrayInputStream inputStream;
	public String execute() {
		Map<String, BufferedImage> imageMap=ImageUtil.createImage();
		String imageCode=imageMap.keySet().iterator().next();
		session.put("imageCode", imageCode);
		BufferedImage image=imageMap.get(imageCode);
		try {
			ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
			ImageIO.write(image, "jpeg", outputStream);
			ByteArrayInputStream input=new ByteArrayInputStream(outputStream.toByteArray());
			this.setInputStream(input);
			input.close();
			outputStream.close();
	 
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public ByteArrayInputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(ByteArrayInputStream inputStream) {
		this.inputStream = inputStream;
	}	
}

package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;





public final class ImageUtil {
	private static final char[] chars={'1','q','a','z','2','w','s','x','3','e','d','c','4','r','f','v','5','t'
		                              ,'g','b','6', 'y','h','n','7','u','j','m','8','i','k','9','o','l','0','p'
		                               ,'1','Q','A','Z','2','W','S','X','3','E','D','C','4','R','F','V','5','T'
		                              ,'G','B','6','Y','H','N','7','U','J','M','8','I','K','9','O','L','0','P'};
	private static final int SZIE=4;
	private static final int LINES=5;
	private static final int WIDTH=80;
	private static final int HEIGHT=40;
	private static final int FNOT_SIZE=30;
	public static Map<String, BufferedImage>createImage(){
		StringBuffer sBuffer=new StringBuffer();
		BufferedImage image=new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics graphics=image.getGraphics();
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		Random ran=new Random();
		for (int i = 0; i < SZIE; i++) {
			int r=ran.nextInt(chars.length);
			graphics.setColor(getRandomColor());
			graphics.setFont(new Font(null, Font.BOLD+Font.ITALIC, FNOT_SIZE));
			graphics.drawString(chars[r]+"", (i-1)*WIDTH/SZIE+20, HEIGHT/2+10);
			sBuffer.append(chars[r]);
		}
		for (int i = 0; i < LINES; i++) {
			graphics.setColor(getRandomColor());
			graphics.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
		}
		Map<String, BufferedImage>map=new HashMap<String, BufferedImage>();
		map.put(sBuffer.toString(), image);
		return map;
	}
//	public static InputStream getInputStream(BufferedImage image) throws IOException{
//		ByteArrayOutputStream bos=new ByteArrayOutputStream();
//		JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(bos);
//		encoder.encode(image);
//		byte[] imageBts=bos.toByteArray();
//		InputStream in=new ByteArrayInputStream(imageBts);
//		return in;
//	}
	private static Color getRandomColor() {
		Random random=new Random();
		Color color=new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
		return color;
	}
}

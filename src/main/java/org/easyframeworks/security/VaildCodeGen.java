package org.easyframeworks.security;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

import org.easyframeworks.utils.LoggerUtils;
import org.easyframeworks.utils.ResourceUtils;

public class VaildCodeGen {
	private static final String charsets = "abcdefghkmnprstuvwxyzABCDEFGHKMNPRSTUVWXYZ23456789";
	private String code; // 验证码
	private int codelen = 4; // 验证码长度
	private int width = 130; // 宽度
	private int height = 40; // 高度
	private Font font; // 指定的字体
	private int fontsize = 30; // 指定字体大小

	public VaildCodeGen() {
		try {
			String path = ResourceUtils.getClassPath() + "fonts\\elephant.ttf";
			LoggerUtils.debug(path);
			File file = new File(path);
			FileInputStream fis = new FileInputStream(file);
			Font dyaFont = Font.createFont(Font.TRUETYPE_FONT, fis);
			this.font = dyaFont.deriveFont(Font.BOLD, fontsize);
			fis.close();
		} catch (Exception e) {
			LoggerUtils.error("加载验证码字体失败，使用默认字体", e);
			this.font = new Font("Consolas", Font.BOLD, fontsize);
		}
	}

	public String createCode() {
		int len = charsets.length() - 1;
		char[] chs = new char[this.codelen];
		for (int i = 0; i < this.codelen; i++) {
			chs[i] = charsets.charAt(new Random().nextInt(len));
		}
		String genCode = new String(chs, 0, chs.length);
		this.code = genCode;
		return genCode;
	}

	// 生成背景
	private BufferedImage createBg() {
		BufferedImage imgbg = new BufferedImage(this.width, this.height,
				BufferedImage.TYPE_INT_RGB);
		int min = 200;
		int max = 255;
		int r = (int)(Math.random()*(max+1-min)+min);
		int g = (int)(Math.random()*(max+1-min)+min);
		int b = (int)(Math.random()*(max+1-min)+min);
		LoggerUtils.debug("r:" + r + " g:" + g + " b:" + b);
		Color color = new Color(r,g,b);
		Graphics graphics = imgbg.getGraphics();
		graphics.setColor(color);
		graphics.fillRect(0, 0, this.width, this.height);
		return imgbg;
	}

	//生成文字
	private BufferedImage createFont() {
		int x = this.width / this.codelen;
		BufferedImage fontImg = this.createBg();
		Graphics graphics = fontImg.getGraphics();
		Random rand = new Random();
		for (int i = 0; i < this.codelen; i++) {
			Color fColor = new Color(rand.nextInt(156), rand.nextInt(156), rand.nextInt(156));
			graphics.setFont(this.font);
			graphics.setColor(fColor);
			String fontStr = String.valueOf(this.code.charAt(i));
//			LoggerUtils.debug(fontStr);
			int x1 = x * i + rand.nextInt(5);
			int y = Integer.parseInt(new java.text.DecimalFormat("0").format(this.height / 1.4));
//			LoggerUtils.debug("x:" + x1 + " y:" + y);
			graphics.drawString(fontStr, x1, y);
		}
		return fontImg;
	}
	
	//生成线条、雪花  
    public BufferedImage createValidCode() {  
    	Random rand = new Random();
    	BufferedImage fullImg = this.createFont();
    	Graphics graphics = fullImg.getGraphics();
        for (int i=0;i<8;i++) {  
        	Color color = new Color(rand.nextInt(156), rand.nextInt(156), rand.nextInt(156));
        	graphics.setColor(color);
        	graphics.drawLine(rand.nextInt(this.width), rand.nextInt(this.height), rand.nextInt(this.width), rand.nextInt(this.height)); 
        }  
    	int min = 200;
		int max = 255;
        for (int i=0;i<80;i++) {
        	int r = (int)(Math.random()*(max+1-min)+min);
    		int g = (int)(Math.random()*(max+1-min)+min);
    		int b = (int)(Math.random()*(max+1-min)+min);
        	Color color = new Color(r,g,b); 
            graphics.setColor(color);
            graphics.drawString("-", rand.nextInt(this.width), rand.nextInt(this.height));
        }
        return fullImg;
    }  
}

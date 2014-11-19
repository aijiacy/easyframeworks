package org.easyframeworks.security;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.FontUIResource;

/**
 * 
 * @class: VryImgGen
 * @description : 验证码生成器
 * @author CaoYong
 * @date 2014年5月2日 上午2:09:58
 */
public class VryImgGen {

    public static String ChineseChars = "";
    /**
     * English and Number String
     */
    protected static final String EnglishOrNumChars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    /**
     * Global Random Number
     */
    private Random random;
    // Code Length default Length is Six(6)
    private int codeLen = 4;

    public int getCodeLen() {
        return codeLen;
    }

    public void setCodeLen(int codeLen) {
        this.codeLen = codeLen;
    }
    // Font Size default Size is fifteen(15)
    private int fontSize = 15;

    public int getFontSize() {
        return fontSize;
    }

    public void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }
    // padding default is four(4)
    private int padding = 4;

    public int getPadding() {
        return padding;
    }

    public void setPadding(int padding) {
        this.padding = padding;
    }
    // Noise Point default is true
    private boolean noisePoint = true;

    public boolean getNoisePoint() {
        return noisePoint;
    }

    public void setNoisePoint(boolean noisePoint) {
        this.noisePoint = noisePoint;
    }
    // Noise Point Color default is lightGray
    private Color noiseColor = Color.lightGray;

    public Color getNoiseColor() {
        return noiseColor;
    }

    public void setNoiseColor(Color noiseColor) {
        this.noiseColor = noiseColor;
    }
    //Background Color default is white.
    private Color backgroundColor = Color.white;

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }
    // Color array.
    Color[] colors = {Color.black, Color.red, Color.blue, Color.green, Color.orange, Color.PINK, Color.cyan, Color.yellow};

    public Color[] getColors() {
        return colors;
    }

    public void setColors(Color[] colors) {
        this.colors = colors;
    }
    private String[] fonts = {"Consolas", "Verdana", "Courier New"};

    public String[] getFonts() {
        return fonts;
    }

    public void setFonts(String[] fonts) {
        this.fonts = fonts;
    }
//    private final double PI = 3.1415926535897932384626433832795;
    private final double PI2 = 6.283185307179586476925286766559;

    /**
     * default constructs
     * init Random
     */
    public VryImgGen() {
        random = new Random(new Date().getTime());
    }

    /**
     * 正弦曲线Wave扭曲图片
     * @param srcImg
     * @param bXDir
     * @param dMultValue
     * @param dPhase
     * @return
     */
    public BufferedImage TwistImage(BufferedImage srcImg, boolean bXDir, double dMultValue, double dPhase) {
        BufferedImage destImg = new BufferedImage(srcImg.getWidth(), srcImg.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics graph = destImg.getGraphics();
        graph.fillRoundRect(0, 0, srcImg.getWidth(), srcImg.getHeight(), 0, 0);
        double dBaseAxisLen = bXDir ? (double) destImg.getHeight() : (double) destImg.getWidth();
        for (int i = 0; i < destImg.getWidth(); i++) {
            for (int j = 0; j < destImg.getHeight(); j++) {
                double dx = 0;
                dx = bXDir ? (PI2 * (double) j) / dBaseAxisLen : (PI2 * (double) i) / dBaseAxisLen;
                dx += dPhase;
                double dy = Math.asin(dx);

                // 取得当前点的颜色
                int nOldX = 0, nOldY = 0;
                nOldX = bXDir ? i + (int) (dy * dMultValue) : i;
                nOldY = bXDir ? j : j + (int) (dy * dMultValue);
                if (nOldX >= 0 && nOldX < destImg.getWidth() && nOldY >= 0 && nOldY < destImg.getHeight()) {
                    destImg.setRGB(nOldX, nOldY, srcImg.getRGB(i, j));
                }
            }
        }
        return destImg;
    }

    /**
     * 生成校验码图片
     * @param code
     * @return
     */
    public BufferedImage createImage(String code) {
        int fSize = getFontSize();
        int fWidth = fSize + getPadding();
        int imageWidth = (int) (code.length() * fWidth) + 4 + getPadding() * 2;
        int imageHeight = fWidth + getPadding() * 2;
        BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(getBackgroundColor());
        g.fillRect(0, 0, imageWidth, imageHeight);
        g.setColor(noiseColor);
        //给背景添加随机生成的燥点
        if (getNoisePoint()) {
            int c = getCodeLen() * 10;
            for (int i = 0; i < c; i++) {
                int x = random.nextInt(image.getWidth());
                int y = random.nextInt(image.getHeight());
                g.drawOval(x, y, 1, 1);
            }
        }

        int left = getPadding(), top = 0, top1 = 1, top2 = 1;
        int n1 = (imageHeight - getFontSize() - getPadding() * 2);
        int n2 = n1 / 4;
        top1 = n2;
        top2 = n2 * 2;
        Font f;
        int cindex, findex;

        //随机字体和颜色的验证码字符
        for (int i = 0; i < code.length(); i++) {
            cindex = random.nextInt(getColors().length - 1);
            findex = random.nextInt(getFonts().length - 1);

            f = new FontUIResource(getFonts()[findex], Font.BOLD, fSize);

            if (i % 2 == 1) {
                top = top2;
            } else {
                top = top1;
            }
            left = i * fWidth;
            g.setFont(f);
            g.setColor(this.getColors()[cindex]);
            g.drawString(String.valueOf(code.charAt(i)), left, top + 20);
        }
        //画一个边框 边框颜色为Color.Gainsboro
        g.drawRect(0, 0, image.getWidth() - 1, image.getHeight() - 1);
        g.dispose();
        //产生波形
        image = TwistImage(image, false, 8, 4);
        return image;
    }

    /**
     * 生成汉字字符
     * @return
     */
    protected char CreateZhChar() {
        //若提供了汉字集，查询汉字集选取汉字
        if (ChineseChars.length() > 0) {
            return ChineseChars.charAt(random.nextInt(ChineseChars.length()));
        } //若没有提供汉字集，则根据《GB2312简体中文编码表》编码规则构造汉字
        else {
            byte[] bytes = new byte[2];
            //第一个字节值在0xb0, 0xf7之间
            bytes[0] = (byte) random.nextInt(0xf8);
            //第二个字节值在0xa1, 0xfe之间
            bytes[1] = (byte) random.nextInt(0xff);
            //根据汉字编码的字节数组解码出中文汉字
            String str1 = "";
            try {
                str1 = new String(bytes, "gb2312");
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(VryImgGen.class.getName()).log(Level.SEVERE, null, ex);
            }
            return str1.charAt(0);
        }
    }

    /**
     * 生成英文或数字字符
     * @return
     */
    protected char CreateEnOrNumChar() {
        return EnglishOrNumChars.charAt(random.nextInt(EnglishOrNumChars.length()));
    }

    public String CreateVerifyCode(int Len, int zhCharsCount) {
    	this.setCodeLen(Len);
        char[] chs = new char[codeLen];

        int index;
        for (int i = 0; i < zhCharsCount; i++) {
            index = random.nextInt(codeLen);
            if (chs[index] == '\0') {
                chs[index] = CreateZhChar();
            } else {
                --i;
            }
        }
        for (int i = 0; i < codeLen; i++) {
            if (chs[i] == '\0') {
                chs[i] = CreateEnOrNumChar();
            }
        }
        return new String(chs, 0, chs.length);
    }

    /**
     * 生成默认的随机码
     * @return
     */
    public String CreateVerifyCode() {
        return CreateVerifyCode(getCodeLen(), 0);
    }
}
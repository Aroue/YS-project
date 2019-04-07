package org.ys.utils;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.*;
import java.util.List;

/**
 * FROM https://github.com/GustinLau/captcha
 * Created by Gustin Lau on 2016/4/21.
 */
@Component
public class CaptchaHelper {

    public class CaptchaException extends Exception {
        public CaptchaException(String message) {
            super(message);
        }
    }

    private static CaptchaHelper captchaHelper = new CaptchaHelper();

    @Bean
    public static CaptchaHelper getCaptchaHelper() {
        return captchaHelper;
    }


    private final String FILE_SEPARATOR = File.separator;
    private final String CAPTCHA_PATH = this.getClass().getResource("").getPath() + FILE_SEPARATOR;

    private Random random = new Random();  //随机器

    /*=============Config值===================*/
    private String seKey = "org.ys";       // 验证码加密密钥
    private String codeSet = "2345678abcdefhijkmnpqrstuvwxyzABCDEFGHJKLMNPQRTUVWXY";     // 英文验证码字符集合
    private Long expire = 60000L;        // 验证码过期时间（ms）
    private Boolean useZh = false;      // 使用中文验证码
    private String zhSet = "";       // 中文验证码字符串
    private Boolean useImgBg = false;   // 使用背景图片
    private Float fontSize = 16F;       // 验证码字体大小(px)
    private Boolean useCurve = true;   // 是否画混淆曲线
    private Boolean useNoise = true;   // 是否添加杂点
    private Integer imageH = 40;        // 验证码图片高度
    private Integer imageW = 120;        // 验证码图片宽度
    private Integer length = 4;        // 验证码位数
    private String fontttf = "";       // 验证码字体，不设置随机获取
    private Color bg = new Color(243, 251, 254);           // 背景颜色
    private Boolean reset = true;      // 验证成功后是否重置

    //region Setter
    public void setSeKey(String seKey) {
        this.seKey = seKey;
    }

    public void setCodeSet(String codeSet) {
        this.codeSet = codeSet;
    }

    public void setExpire(long expire) {
        this.expire = expire;
    }

    public void setUseZh(boolean useZh) {
        this.useZh = useZh;
    }

    public void setZhSet(String zhSet) {
        this.zhSet = zhSet;
    }

    public void setUseImgBg(boolean useImgBg) {
        this.useImgBg = useImgBg;
    }

    public void setFontSize(Float fontSize) {
        this.fontSize = fontSize;
    }

    public void setUseCurve(boolean useCurve) {
        this.useCurve = useCurve;
    }

    public void setUseNoise(boolean useNoise) {
        this.useNoise = useNoise;
    }

    public void setImageH(int imageH) {
        this.imageH = imageH;
    }

    public void setImageW(int imageW) {
        this.imageW = imageW;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setFontttf(String fontttf) {
        this.fontttf = fontttf;
    }

    public void setBg(Color bg) {
        this.bg = bg;
    }

    public void setReset(boolean reset) {
        this.reset = reset;
    }

    //endregion

    public void generate(HttpServletRequest request, HttpServletResponse response, String id) {
        try {
            entry(request, response, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 画验证码调用方法
     *
     * @param request  request
     * @param response response
     */
    public void generate(HttpServletRequest request, HttpServletResponse response) {
        generate(request, response, null);
    }


    /**
     * 验证码验证
     *
     * @param code 用户验证码
     * @param id   验证码标识
     * @return bool 用户验证码是否正确
     */
    public boolean verify(HttpServletRequest request, String code, String id) {
        //id 空值判断
        id = id == null ? "" : id;
        String key = authcode(seKey) + id;
        // 验证码不能为空
        Map secode = (HashMap) request.getSession().getAttribute(key);
        if (code == null || secode == null) {
            return false;
        }
        // session 过期
        if (System.currentTimeMillis() - (Long) secode.get("captcha_time") > expire) {
            request.getSession().setAttribute(key, null);
            return false;
        }
        if (authcode(code.toUpperCase()).equals(secode.get("captcha_code").toString())) {
            if (reset)
                request.getSession().setAttribute(key, null);
            return true;
        }
        return false;
    }


    /**
     * 验证码验证
     *
     * @param code 用户验证码
     * @return bool 用户验证码是否正确
     */
    private boolean verify(HttpServletRequest request, String code) {
        return verify(request, code, null);
    }


    /**
     * 输出验证码并把验证码的值保存的session中
     * 验证码保存到session的格式为： HashMap 'captcha_code' => '验证码值', 'captcha_time' => '验证码创建时间';
     *
     * @param id 标记
     * @throws Exception
     */
    private void entry(HttpServletRequest request, HttpServletResponse response, String id) throws Exception {
        //id 空值判断
        id = id == null ? "" : id;
        // 图片宽(px)
        if (imageW == 0)
            imageW = (int) (length * fontSize * 2);
        // 图片高(px)
        if (imageH == 0)
            imageH = (int) (fontSize * 2.5);
        // 建立一幅 $this->imageW x $this->imageH 的图像
        BufferedImage image = new BufferedImage(imageW, imageH, BufferedImage.TYPE_INT_RGB);
        // 设置背景
        Graphics2D g = (Graphics2D) image.getGraphics();
        // 设置颜色
        g.setColor(bg);
        // 填充区域
        g.fillRect(0, 0, imageW, imageH);
        if (useImgBg) {
            //设置背景
            writeBackground(g);
        }
        if (useNoise) {
            // 绘噪点
            writeNoise(g);
        }
        if (useCurve) {
            // 绘干扰线
            writeCurve(g);
        }
        // 验证码字体随机颜色
        Color color = new Color(random.nextInt(150) + 1, random.nextInt(150) + 1, random.nextInt(150) + 1);
        g.setColor(color);
        //设置字体
        InputStream ttfFile = CaptchaHelper.class.getResourceAsStream("/org/ec/utils/captcha.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, ttfFile);
        font = font.deriveFont(fontSize);
        g.setFont(font);
        // 绘验证码
        char[] chars = new char[length]; // 验证码
        float codeNX; // 验证码第N个字符的左边距
        int degree;
        String wordSet;
        if (useZh) { // 中文验证码
            wordSet = zhSet;
        } else {
            wordSet = codeSet;
        }
        for (int i = 0; i < length; i++) {
            chars[i] = wordSet.charAt(random.nextInt(wordSet.length()));
            // 设置字体旋转角度
            degree = new Random().nextInt(61) - 30;
            codeNX = (float) (fontSize * (i + 1) * 1.5);
            // 正向角度
            g.rotate(degree * Math.PI / 180, codeNX, fontSize / 2);
            g.drawString(String.valueOf(chars[i]), codeNX, fontSize + random.nextInt(imageH / 4 + 1) + imageH / 4);
            // 反向角度
            g.rotate(-degree * Math.PI / 180, codeNX, imageH / 2);
        }
        // 保存验证码
        String key = authcode(seKey) + id;
        String code = authcode(String.copyValueOf(chars).toUpperCase());
        Map<String, Object> seconds = new HashMap<>();
        seconds.put("captcha_code", code); // 把校验码保存到session
        seconds.put("captcha_time", System.currentTimeMillis());  // 验证码创建时间
        request.getSession().setAttribute(key, seconds);
        response.setHeader("Cache-Control", "private, max-age=0, no-store, no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("content-type", "image/gif");
        // 输出图像
        g.dispose();
        ImageIO.write(image, "GIF", response.getOutputStream());
        ttfFile.close();
    }

    /**
     * 画一条由两条连在一起构成的随机正弦函数曲线作干扰线(你可以改成更帅的曲线函数)
     * 高中的数学公式咋都忘了涅，写出来
     * 正弦型函数解析式：y=Asin(ωx+φ)+b
     * 各常数值对函数图像的影响：
     * A：决定峰值（即纵向拉伸压缩的倍数）
     * b：表示波形在Y轴的位置关系或纵向移动距离（上加下减）
     * φ：决定波形与X轴位置关系或横向移动距离（左加右减）
     * ω：决定周期（最小正周期T=2π/∣ω∣）
     */
    private void writeCurve(Graphics2D g) {
        double px, py = 0;
        // 曲线前部分
        double A = random.nextInt(imageH / 2) + 1;                  // 振幅
        double b = random.nextInt(imageH / 2 + 1) - imageH / 4;   // Y轴方向偏移量
        double f = random.nextInt(imageH / 2 + 1) - imageH / 4;   // X轴方向偏移量
        double T = random.nextInt(imageW * 2 - imageH + 1) + imageH;// 周期
        double w = (2 * Math.PI) / T;
        int px1 = 0;  // 曲线横坐标起始位置
        int px2 = random.nextInt((int) (imageW * 0.8) - imageW / 2 + 1) + imageW / 2;// + mt_rand($this -> imageW / 2, $this -> imageW * 0.8);  // 曲线横坐标结束位置
        for (px = px1; px <= px2; px = px + 1) {
            if (w != 0) {
                py = A * Math.sin(w * px + f) + b + (double) imageH / 2;  // y = Asin(ωx+φ) + b
                int i = (int) (fontSize / 5);
                while (i > 0) {
                    g.drawLine((int) px + i, (int) py + i, (int) px + i + 1, (int) py + i + 1);
                    i--;
                }
            }
        }
        // 曲线后部分
        A = random.nextInt(imageH / 2) + 1;                  // 振幅
        f = random.nextInt(imageH / 2 + 1) - imageH / 4;   // X轴方向偏移量
        T = random.nextInt(imageW * 2 - imageH + 1) + imageH;  // 周期
        w = (2 * Math.PI) / T;
        b = py - A * Math.sin(w * px + f) - imageH / 2;
        px1 = px2;
        px2 = imageW;
        for (px = px1; px <= px2; px = px + 1) {
            if (w != 0) {
                py = A * Math.sin(w * px + f) + b + imageH / 2;  // y = Asin(ωx+φ) + b
                int i = (int) (fontSize / 5);
                while (i > 0) {
                    g.drawLine((int) px + i, (int) py + i, (int) px + i + 1, (int) py + i + 1);
                    i--;
                }
            }
        }
    }

    /**
     * 画噪点
     * 往图片上写不同颜色的字母或数字
     */
    private void writeNoise(Graphics2D g) {
        String codeSet = "0123456789abcdefghijklmnopqrstuvwxyz";
        Color noiseColor;
        for (int i = 0; i < 10; i++) {
            //噪点颜色
            noiseColor = new Color(random.nextInt(106) + 150, random.nextInt(106) + 150, random.nextInt(106) + 150);
            g.setColor(noiseColor);
            for (int j = 0; j < 5; j++) {
                g.drawString(String.valueOf(codeSet.charAt(random.nextInt(codeSet.length()))), random.nextInt(imageW + 10) - 10, random.nextInt(imageH + 10) - 10);
            }
        }
    }

    /**
     * 绘制背景图片
     * 注：如果验证码输出图片比较大，将占用比较多的系统资源
     */
    private void writeBackground(Graphics2D g) throws IOException {
        String bgspath = CAPTCHA_PATH + "bgs" + FILE_SEPARATOR;
        File file = new File(bgspath);
        File[] tempList = file.listFiles();
        List<File> bgs = new ArrayList<>();
        String bgName;
        if (tempList != null) {
            for (File aTempList : tempList) {
                if (aTempList.isFile()) {
                    bgName = aTempList.toString();
                    if (bgName.substring(bgName.length() - 4, bgName.length()).equals(".jpg")) {
                        bgs.add(aTempList);
                    }
                }
            }
        }
        bgName = bgs.get(random.nextInt(bgs.size())).toString();
        Image backgroundImage = ImageIO.read(new File(bgName));
        backgroundImage = backgroundImage.getScaledInstance(imageW, imageH, Image.SCALE_FAST);
        g.drawImage(backgroundImage, 0, 0, imageW, imageH, null);
    }

    /**
     * 加密
     *
     * @return String 加密结果
     */
    private String authcode(String str) {
        String key = Objects.requireNonNull(md5(seKey)).substring(5, 8);
        str = Objects.requireNonNull(md5(str)).substring(8, 10);
        return md5(key + str);
    }

    /**
     * MD5加密算法抽取
     *
     * @param string 待加密字符串
     * @return 加密结果
     */
    private String md5(String string) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            byte[] strTemp = string.getBytes();
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 通过请求体验证
     *
     * @param request 请求体
     * @param captcha 输入的验证码的值
     * @return
     */
    public boolean validate(HttpServletRequest request, String captcha) {
        return captchaHelper.verify(request, captcha);
    }


    /**
     * 验证校验码并自动抛异常，返回值给前端
     *
     * @param request 请求体
     * @param captcha 输入的验证码的值
     */
    public void validateThrow(HttpServletRequest request, String captcha) throws CaptchaException {
        if (!captchaHelper.verify(request, captcha)) {
            throw new CaptchaException("验证码错误或已过期");
        }
    }
}
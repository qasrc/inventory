package com.msunsoft.utils;

import com.msunsoft.exception.ServiceException;
import com.msunsoft.model.User_Bill;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 帮助类
 */
public class CommonHelper {


    /**
     * 验证是否为有效的字符串,非空长度大于0
     *
     * @param s 需要验证的字符串
     * @return 如果有效，则返回true,否则返回false
     */
    public static boolean isValidString(String s) {
        return s != null && s.length() > 0;
    }

    /**
     * 得到现在的时间
     *
     * @return 现在的时间
     */
    public static Calendar getNow() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        return cal;
    }

    /**
     * 得到年份
     *
     * @return 现在的年份
     */
    public static Integer getYear() {
        Calendar cal = getNow();
        return cal.get(Calendar.YEAR);
    }


    /**
     * 得到月份
     *
     * @return 当前月份
     */
    public static Integer getMonth() {
        Calendar cal = getNow();
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * 得到月份中的第几天
     *
     * @return 当前月份的某一天
     */
    public static Integer getDayOfMonth() {
        Calendar cal = getNow();
        return cal.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 得到当前的user
     *
     * @param httpSession 当前会话
     * @return 当前用户
     */
    public static User_Bill getCurrentUser(HttpSession httpSession) {
        User_Bill user = (User_Bill) httpSession.getAttribute("user");
        if (user == null)
            throw new ServiceException("用户无效，请重新登录");
        return user;
    }


    /**
     * 根据传过来的日历对象获取对应的年份
     *
     * @param calendar 需要获取年份的日历对象
     * @return 当前日历对应的年份
     */
    public static Integer getYearByCalendar(Calendar calendar) {
        return calendar.get(Calendar.YEAR);
    }


    /**
     * 根据传过来的日历对象获取对应的月份
     *
     * @param calendar 需要获取月份的日历对象
     * @return 当前日历对应的月份
     */
    public static Integer getMonthByCalendar(Calendar calendar) {
        return calendar.get(Calendar.MONTH) + 1;
    }


    /**
     * 根据传过来的日历对象获取对应月份中的某一天
     *
     * @param calendar 需要获取天数的日历对象
     * @return 当前日历对应的月份中的某一天
     */
    public static Integer getDayOfMontyByCalendar(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }



    /**
     * 计算整数各项的和
     *
     * @param nums 需要求和的数
     * @return 总和
     */
    public static Integer getSumInteger(Integer... nums) {
        Integer sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }


    /**
     * 计算小数各项的和
     *
     * @param nums 需要求和的数
     * @return 各个参数的总和
     */
    public static Double getSumDouble(Double... nums) {
        Double sum = 0.0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }





    /**
     * 对字符串进行md5加密
     *
     * @param p 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String makeMD5(String p) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("md5");
            md.update(p.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }


    /**
     * 将对象的两边添加上引号
     *
     * @param object 需要添加引号的对象
     * @return 将对象添加引号之后的字符串表示
     */
    public static String putMarksObject(Object object) {
        //使用转义字符
        return "\"" + object + "\"";
    }

    /**
     * @param str 需要将首字母小写的字符串
     * @return 首字母小写之后的字符串
     */
    public static String initialToLowerCase(String str) {
        return str.substring(0, 1).toLowerCase() + str.substring(1, str.length());
    }

    /**
     * 是不是有效的手机号码，以一开关，10位数
     *
     * @param mobile 需要验证的手机号码
     * @return 如果是手机号码则返回true, 否则返回false
     */
    public static boolean isMobileNO(String mobile) {
        Pattern pattern = Pattern.compile("^[1]\\d{10}$");
        Matcher mt = pattern.matcher(mobile);
        return mt.matches();
    }

    /**
     * 是不是有效的email
     *
     * @param email 需要验证的email
     * @return 如果是email则是true, 否则为false
     */
    public static boolean isEmail(String email) {
        Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
        Matcher mt = pattern.matcher(email);
        return mt.matches();
    }

    /**
     * 是不是有效的QQ
     *
     * @param qq 需要验证的qq
     * @return 如果是qq则返回true，否则返回false
     */
    public static boolean isQQ(String qq) {
        //创建一个正则表达式对象
        Pattern pattern = Pattern.compile("^\\d{5,}$");
        Matcher mt = pattern.matcher(qq);
        return mt.matches();
    }

    /**
     * 创建一个json并返回给浏览器
     *
     * @param httpServletResponse 用于给浏览器返回json数据
     * @param message             需要给浏览器返回的信息
     */
    public static void buildSimpleJson(HttpServletResponse httpServletResponse, String message) {
        String result = "{\"message\":\"" + message + "\"}";
        httpServletResponse.setContentType("application/json");
        PrintWriter out = null;
        try {
            out = httpServletResponse.getWriter();
            out.write(result);
        } catch (Exception e) {
            e.getMessage();
        } finally {
            out.close();
        }
    }

    /**
     * 对两个字符串进行比较，如果第一个字符串的字典顺序大于第二个字符串，则返回一个大于0的数
     * 如果第一个字符串的字典顺序小于第二个字符串，则返回一个小于0的数
     * 数值的具体大小取决于所在位置char值的差
     *
     * @param one     需要比较的第一个字符串
     * @param another 需要比较的第二个字符串
     * @return 如果第一个字符串的字典顺序大于第二个字符串，则返回一个大于0的数
     * 如果第一个字符串的字典顺序小于第二个字符串，则返回一个小于0的数
     */
    public static int compareToString(String one, String another) {
        return one.compareTo(another);
    }

    /**
     * 创建一个json
     *
     * @param httpServletResponse 当前response对象
     */
    public static void buildSimpleJson(HttpServletResponse httpServletResponse) {
        buildSimpleJson(httpServletResponse, null);
    }


    /**
     * 根据字符串时间来获取Calendar对象
     *
     * @param strTime 需要获取时间对象的字符串
     * @return 当前字符串对应的Calendar对象
     */
    public static Calendar getCalendarByString(String strTime) {
        //创建一个calendar对象
        Calendar calendar = Calendar.getInstance();
        //创建一个格式化日期类
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            //对字符串进行格式化
            Date date = simpleDateFormat.parse(strTime);
            //设置calendar对象的时间
            calendar.setTime(date);
        } catch (ParseException e) {
            throw new ServiceException("设置时间失败");
        }
        return calendar;
    }

    /**
     * 将最后的时间设置为23时59分59秒
     *
     * @param calendar 设置后的时间
     */
    public static Calendar setLastTime(Calendar calendar) {
        Calendar calendarAfter = calendar;
        calendarAfter.set(Calendar.HOUR, 23);
        calendarAfter.set(Calendar.MINUTE, 59);
        calendarAfter.set(Calendar.SECOND, 59);
        return calendarAfter;
    }



    /**
     * 去除字符串的多余的空格，注意只能去除头部和尾部的空格
     *
     * @param s 需要去除空格的字符串
     * @return 去除空格后的字符串
     */
    public static String deleteTrim(String s) {
        return s.trim();
    }

    /**
     * 判断两个路径是否相等
     *
     * @param url1 需要比较的第一个路径
     * @param url2 需要比较的第二个路径
     * @return 如果两个路径相等则返回true, 否则返回false
     */
    public static boolean pathMatchersURLS(String url1, String url2) {
        return url1.equals(url2);
    }

    /**
     * 得到文件的名字
     *
     * @param file 需要获取文件名的文件
     * @return 当前文件对应的文件名
     */
    public static String getFileName(MultipartFile file) {
        return file.getName();
    }

    /**
     * 获取当前会话对应的上传路径
     *
     * @param httpSession 当前会话
     * @return 上传路径
     */
    public static String getUploadPath(HttpSession httpSession) {
        String rootPath = httpSession.getServletContext().getRealPath("/");
        return rootPath.substring(0, rootPath.lastIndexOf("\\")) + Common.UPDATE_DIR;
    }


    /**
     * 得到当前请求的url
     * 如请求的url为：/bysj/mail/sendMail.html
     * 则返回的url为：/mail/sendMail.html
     *
     * @param httpServletRequest 当前的请求对象
     * @return 请求的url
     */
    public static String getRequestUrl(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getRequestURI();
    }

    /**
     * 用于调度
     */
    private static final Logger logger = Logger.getLogger(CommonHelper.class);

    /**
     * 文件上传
     *
     * @param file        需要上传的文件
     * @param httpSession 当前会话
     * @param folderName  文件夹的名字
     * @param fileName    文件的名字
     * @return 上传文件后对应的路径
     */
    public static String fileUpload(MultipartFile file, HttpSession httpSession, String folderName, String fileName) {
        // 文件夹名称：应用程序的根路径+上传目录
        String folder = CommonHelper.getUploadPath(httpSession);
        logger.error("file:  " + file.getOriginalFilename() + "   fileIndexOf" + file.getOriginalFilename().lastIndexOf("."));
        // 文件的扩展名
        String extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."),
                file.getOriginalFilename().length());
        String name = folderName + "/" + fileName;
        // 上传文件
        if (!file.isEmpty()) {
            try {
                File tempFile = new File(folder + name);
                // 如果不存在该文件夹，则创建
                if (!tempFile.exists())
                    tempFile.mkdirs();
                file.transferTo(tempFile);
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return name;
    }

    /**
     * 根据模版获取当前的日期
     *
     * @param patter 要获取的日期模版
     * @return 当前日期
     */
    public static String getCurrentDateByPatter(String patter) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patter);
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        return simpleDateFormat.format(date);
    }

    /**
     * 不根据文件名而是根据id来上传文件
     *
     * @param file        需要上传的文件
     * @param httpSession 当前会话
     * @param folderName  文件夹的名字
     * @param id          当前文件对应的id
     * @return 文件上传的路径
     */
    public static String fileUpload(MultipartFile file, HttpSession httpSession, String folderName, Integer id) {
        return CommonHelper.fileUpload(file, httpSession, folderName, id.toString());
    }


    /**
     * 下载文件
     *
     * @param httpSession 当前会话
     * @param url         需要下载的文件的url
     * @param name        下载文件显示的名称
     * @param subDir      子目录
     * @return 下载文件
     * @throws IOException
     */
    public static ResponseEntity<byte[]> download(HttpSession httpSession, String url, String name, String subDir)
            throws IOException {
        //获取上传的路径
        String folder = CommonHelper.getUploadPath(httpSession);
        File file = new File(folder + url);
        if (!file.exists()) {
            throw new FileNotFoundException();
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment",
                URLEncoder.encode(name, "utf-8").replaceAll("\\+", "%20"));
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }

    /**
     * 以文件名和路径来下载文件
     *
     * @param httpSession 当前会话
     * @param url         下载文件的url
     * @param name        下载文件的名字
     * @return 将文件对应的二进制流输出到客户端
     * @throws IOException
     */
    public static ResponseEntity<byte[]> download(HttpSession httpSession, String url, String name) throws IOException {
        return download(httpSession, url, name, "");
    }

    /**
     * 删除文件
     *
     * @param httpSession 当前会话
     * @param url 需要删除的文件的路径
     */
    public static void delete(HttpSession httpSession, String url) {

        //获取上传的路径
        String uploadPath = CommonHelper.getUploadPath(httpSession);
        //获取当前文件完整的url
        String path = uploadPath + url;
        //创建一个file对象
        File file = new File(path);
        //如果存在则删除
        if (file.exists()) {
            file.delete();
        }
    }


    /**
     * 判断当前时是否在起止时间之间。
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 如果当前时间在开始和结束时间之间则返回true，否则返回false
     */
    public static Boolean isNowInPeroid(Calendar startTime, Calendar endTime) {
        //获取当前时间的Calendar对象
        Calendar nowCalendar = CommonHelper.getNow();
        return (startTime.before(nowCalendar) && endTime.after(nowCalendar));
    }


    /**
     * 获取当前页,用于分页查询
     * 如果当前页为空，则默认赋值为0
     * @param pageNo 当前页
     * @param pageSize 每页的条数，该参数没有用到。调用该方法时，pageSize可赋值为null
     * @return 当前页
     */
    public static Integer getPageNo(Integer pageNo, Integer pageSize) {
        if (pageNo == null) {
            return 0;
        }
        return pageNo - 1;
    }


    /**
     * 获取每页的条数，用于在分页查询时使用
     * 如果当前页的条数为空，则默认赋值为每页10条记录
     * 如果不为空，则返回方法的实参
     * @param pageSize 每页的条数
     * @return 每页的条数
     */
    public static Integer getPageSize(Integer pageSize) {
        if (pageSize == null) {
            return 10;
        }
        return pageSize;
    }


    /**
     * 将“结束日期”设为当天的最后时刻--23：59：59
     * @param endCalendar 需要设置时间的Calendar对象
     */
    public static void setEndCalendarHMS(Calendar endCalendar) {
        //23时
        endCalendar.set(Calendar.HOUR, 23);
        //59分
        endCalendar.set(Calendar.MINUTE, 59);
        //59秒
        endCalendar.set(Calendar.SECOND, 59);
    }


    /**
     *获得服务器上的根路径
     * @param httpSession 当前会话
     * @return 上传路径
     */
    public static String getRootPath(HttpSession httpSession) {
        //getServletContent获取servlet容器对象，getRealPath获取实际路径，“/"代表项目根目录
        return httpSession.getServletContext().getRealPath("/");
    }





}

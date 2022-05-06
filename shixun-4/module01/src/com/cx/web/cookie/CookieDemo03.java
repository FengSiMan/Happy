package com.cx.web.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CookieDemo03")
public class CookieDemo03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应数据格式以及编码
        response.setContentType("text/html;charset=utf-8");
        boolean flag = false; //没有cookie name 为 lastName
        //cookie存在
        //a.获取cookies
        Cookie[] cookies = request.getCookies(); //lastName
        //b.遍历cookies
        if (cookies !=null && cookies.length>0){
            for (Cookie cookie : cookies){
                //c.获取cookie的name
                String name = cookie.getName();
                if ("lastName".equals(name)){
                    flag = true;
                    //处理Date
                    Date date = new Date();  //时间的格式
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String str_date = sdf.format(date);
                    //编码
                    str_date = URLEncoder.encode(str_date,"utf-8");
                    cookie.setValue(str_date); //设置值
                    //设置可以保留多长的时间
                    cookie.setMaxAge(60*60*24);
                    response.addCookie(cookie);
                    //响应
                    String value = cookie.getValue();
                    //解码
                    value = URLDecoder.decode(value, "utf-8");
                    response.getWriter().write("<h1>welcome , 再次访问，时间为:"+value+"</h1");
                }

            }
        }
        //cookie不存在
        if (cookies==null || cookies.length==0 || flag==false )
        {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String str_date = sdf.format(date);
            str_date = URLEncoder.encode(str_date, "utf-8");
            Cookie cookie = new Cookie("lastName", str_date);
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
            response.getWriter().write("<h1>首次访问该网页</h1>");

        }
    }
}

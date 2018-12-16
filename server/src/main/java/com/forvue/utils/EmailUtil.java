package com.forvue.utils;
import javax.mail.Message;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import java.util.Properties;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by gqc on 2018/12/13.
 * 基于javaMail 的邮件类
 */

public class EmailUtil {
    //创建java 配置类
    public void forEmail (String weatherText)throws Exception {
        Properties prop = new Properties();
        //设置邮件服务器
        prop.setProperty("mail.host","smtp.sina.com");
        //设置协议
        prop.setProperty("mail.transport.protocol","smtp");
        prop.setProperty("mail.smtp.auth", "true");
        //基于javaMail 实现邮件发送


        //第一步建立Session javax.mail的Session
        Session session=Session.getInstance(prop);
        //开启Session的debug模式 可以看到邮件状态
        session.setDebug(true);
        //第二步 通过session获得transport对象

        //第三步使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，
        // 用户名和密码都通过验证之后才能够正常发送邮件给收件人。
        Transport ts=session.getTransport();
        ts.connect("smtp.sina.com","aseveng","wagwwa7");
        //第四步 创建邮件
        Message message= createSimpleMail(session,weatherText);

        ts.sendMessage(message, message.getAllRecipients());
        ts.close();
    }

    /**
     *  发送邮件方法
     * @param session text
     * @return MimeMessage
     */
    public MimeMessage createSimpleMail(Session session,String text) throws Exception {
        //创建邮件对象
        MimeMessage message=new MimeMessage(session);
        //指明邮件的发件人
        message.setFrom(new InternetAddress("610286036@qq.com"));
        //指明邮件的收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("610286036@qq.com"));
        //标题
        if(text.indexOf("雨")!=-1) {
            message.setSubject("今日有雨,媳妇请带伞");
        }else if(text.indexOf("雪")!=-1){
            message.setSubject("今日有雪,媳妇要加衣");
        }else{
            message.setSubject("今日无雨");
        }

        //内容（纯文本）
        message.setContent(text, "text/html;charset=UTF-8");
        return message;
    }


}

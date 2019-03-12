package cn.wangz.clientutil.mail;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * Created by hadoop on 2018/11/15.
 * 发送邮件
 */
public class SendMailHelper {

    private static String smtpHost = "smtp.exmail.qq.com";
    private static String from = "******@**.com";
    private static String password = "*****";
    private static String subject = "SUBJECT";

    private static Properties properties;
    static  {
        properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp"); // 使用的协议（JavaMail规范要求）
        properties.setProperty("mail.smtp.host", smtpHost); // 发件人的邮箱的 SMTP服务器地址
        properties.setProperty("mail.smtp.auth", "true"); // 请求认证，参数名称与具体实现有关
    }

    public static void send(String addresses, String type, String name, String date, Integer minute, String value) throws Exception {
        // 创建Session实例对象
        Session session = Session.getDefaultInstance(properties);
        // 创建MimeMessage实例对象
        MimeMessage message = new MimeMessage(session);
        // 设置发件人
        message.setFrom(new InternetAddress(from));
        // 设置收件人
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addresses));
        // 设置发送日期
        message.setSentDate(new Date());
        // 设置邮件主题
        message.setSubject(subject);
        // 设置纯文本内容的邮件正文
        String msg = initAnticheatingMsg(type, name, date, minute, value);
        message.setText(msg);
        // 保存并生成最终的邮件内容
        message.saveChanges();

        try (Transport transport = session.getTransport("smtp")) { // 获取Transport对象
            // 第2个参数需要填写的是QQ邮箱的SMTP的授权码
            transport.connect(from, password);
            // 发送，message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
            transport.sendMessage(message, message.getAllRecipients());
        }
    }

    private static String initAnticheatingMsg(String type, String name, String date, Integer minute, String value) {
        StringBuilder sb = new StringBuilder();
        sb.append("type: ").append(name)
                .append("\nname: ").append(type)
                .append("\ndate: ").append(date)
                .append("\nminute: ").append(minute);
        if (value != null) {
            sb.append("\nvalue: ").append(value);
        }
        return sb.toString();
    }
}

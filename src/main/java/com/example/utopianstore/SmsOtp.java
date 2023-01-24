//package com.example.utopianstore;
//
//import javax.mail.Message;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
//import javax.swing.*;
//import java.util.Properties;
//
//public class SmsOtp {
//
//    public void sendmail(){
//
//        //Code to send email otp
//        Properties props=new Properties();
//        props.put("mail.smtp.host","smtp.gmail.com");
//        props.put("mail.smtp.port",465);
//        props.put("mail.smtp.user","mkcomputeredu03@gmail.com");
//        props.put("mail.smtp.auth",true);
//        props.put("mail.smtp.starttls.enable",true);
//        props.put("mail.smtp.debug",true);
//        props.put("mail.smtp.socketFactory.port",465);
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.socketFactory.fallback",false);
//
//        JOptionPane JOptionPane = new JOptionPane();
//        try {
//            Session session = Session.getDefaultInstance(props, null);
//            session.setDebug(true);
//            MimeMessage message = new MimeMessage(session);
//            java.awt.Label jTextField7 = null;
//            message.setText("Your OTP is " + jTextField7.getText());
//            message.setSubject("OTP For your Neftola Account");
//            message.setFrom(new InternetAddress("mkcomputeredu03@gmail.com"));
//            java.awt.Label jTextField3 = null;
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress(jTextField3.getText().trim()));
//            message.saveChanges();
//            try
//            {
//                Transport transport = session.getTransport("smtp");
//                transport.connect("smtp.gmail.com","hsatone@gmail.com","your email password");
//                transport.sendMessage(message, message.getAllRecipients());
//                transport.close();
//
//                jTextField8.setEditable(true);
//                jPanel4.setVisible(false);
//                jPanel6.setVisible(true);
//
//                JOptionPane.showMessageDialog(null,"OTP has send to your Email id");
//            }catch(Exception e)
//            {
//                JOptionPane.showMessageDialog(null,"Please check your internet connection");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null,e);
//        }
//    }
//}

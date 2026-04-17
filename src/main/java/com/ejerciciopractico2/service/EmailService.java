package com.ejerciciopractico2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarCorreo(String para) {

        try {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(para);
            mail.setSubject("Registro exitoso");
            mail.setText("Bienvenido al sistema de eventos");

            mailSender.send(mail);

            System.out.println("Correo enviado correctamente a: " + para);

        } catch (Exception e) {
            System.out.println("Error al enviar correo: " + e.getMessage());
        }
    }
}
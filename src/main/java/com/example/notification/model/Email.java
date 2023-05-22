package com.example.notification.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Email {

    String content;

    public String getContent() {
        return content;
    }

    public Email(String client, String pet, LocalDate date, LocalTime time) {
        this.content = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            background-image: url(\"https://images.hola.com/imagenes/mascotas/20191111153492/perros-campo-mas-felices-perros-ciudad-cs/0-743-190/perro-ciudad-campo-t.jpg\");\n" +
                "            background-repeat: no-repeat;\n" +
                "            background-size: cover;\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            color: #333333;\n" +
                "            padding: 20px;\n" +
                "        }\n" +
                "        \n" +
                "        .container {\n" +
                "            max-width: 600px;\n" +
                "            margin: 0 auto;\n" +
                "            padding: 20px;\n" +
                "            background-color: #ffffff;\n" +
                "            border-radius: 5px;\n" +
                "            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\n" +
                "        }\n" +
                "        \n" +
                "        h1 {\n" +
                "            text-align: center;\n" +
                "            color: #ff9900;\n" +
                "        }\n" +
                "        \n" +
                "        p {\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "        \n" +
                "        .button {\n" +
                "            display: inline-block;\n" +
                "            background-color: #ff9900;\n" +
                "            color: #ffffff;\n" +
                "            text-decoration: none;\n" +
                "            padding: 10px 20px;\n" +
                "            border-radius: 3px;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <h1>¡Tu mascota está lista para ser recogida!</h1>\n" +
                "        \n" +
                "        <p>Estimado(a)"+ client +",</p>\n" +
                "        \n" +
                "        <p>Nos complace informarte que tu querida mascota <b>"+pet+" </b> está lista para ser recogida en nuestro centro de adopción.</p>\n" +
                "        \n" +
                "        <p>Por favor, acude a nuestras instalaciones para recoger a tu mascota.</p>\n" +
                "        \n" +
                "       <p>Fecha: <b>"+date+"</b></p>\n" +
                "        \n" +
                "       <p>Hora: <b>"+time+"</b></p>\n" +
                "        \n" +
                "        <p>Si tienes alguna pregunta o necesitas más información, no dudes en contactarnos.</p>\n" +
                "        \n" +
                "        <p>¡Esperamos verte pronto!</p>\n" +
                "        \n" +
                "        <p>Atentamente,</p>\n" +
                "        <p>El equipo de adopción de mascotas</p>\n" +
                "        \n" +
                "        <p style=\"text-align: center;\">\n" +
                "            <a class=\"button\" href=\"http://localhost:5173/\">Visita nuestro sitio web</a>\n" +
                "        </p>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>";;
    }
}

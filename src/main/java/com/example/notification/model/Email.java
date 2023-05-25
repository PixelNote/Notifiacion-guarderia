package com.example.notification.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Email {

    String content;

    public String getContent() {
        return content;
    }

    public Email(String client, String pet, LocalDate date, LocalTime time) {
        this.content ="¡Tu mascota está lista para ser recogida!\n" +
                "\n" +
                "Estimado(a) " + client + ",\n" +
                "\n" +
                "Nos complace informarte que tu querida mascota " + pet + " está lista para ser recogida.\n" +
                "\n" +
                "Por favor, acude a nuestras instalaciones para recoger a tu mascota.\n" +
                "\n" +
                "Fecha: " + date + "\n" +
                "\n" +
                "Hora: " + time + "\n" +
                "\n" +
                "Si tienes alguna pregunta o necesitas más información, no dudes en contactarnos.\n" +
                "\n" +
                "¡Esperamos verte pronto!\n" +
                "\n" +
                "Atentamente,\n" +
                "Bebitos Felices\n";;;
    }
}

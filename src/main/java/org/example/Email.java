package org.example;

import java.io.Serializable;

class Email implements Serializable {
    private String emailAddress;
    private String to;
    private String subject;
    private String text;

     public Email(String emailAddress, String to, String subject, String text) {
         this.emailAddress = emailAddress;
         this.to = to;
         this.subject = subject;
         this.text = text;
     }

     public String getEmailAddress() {
         return emailAddress;
     }

     public void setEmailAddress(String emailAddress) {
         this.emailAddress = emailAddress;
     }

     public String getTo() {
         return to;
     }

     public void setTo(String to) {
         this.to = to;
     }

     public String getSubject() {
         return subject;
     }

     public void setSubject(String subject) {
         this.subject = subject;
     }

     public String getText() {
         return text;
     }

     public void setText(String text) {
         this.text = text;
     }

     @Override
     public String toString() {
         return "Email{" +
                 "emailAddress='" + emailAddress + '\'' +
                 ", to='" + to + '\'' +
                 ", subject='" + subject + '\'' +
                 ", text='" + text + '\'' +
                 '}';
     }
 }

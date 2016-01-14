/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.web.mail;

import java.io.Serializable;
import java.util.Properties;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author carlo
 */
@ManagedBean
public class MandarEmail implements Serializable{
    
    public void enviar() {
        try {

            // Configuramos las propiedades
            Properties props = new Properties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.host", "mail.lineadecodigo.com");

            // Creo la sesión y un nuevo mensaje de correo
//            Autentificacion pwd = new Autentificacion();
//            Session mailSession = Session.getInstance(props, pwd);
//            Message msg = new MimeMessage(mailSession);
//
//            // Configuramos los campos del mensaje
//            msg.setFrom(new InternetAddress("yo@lineadecodigo.com"));
//            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("destinatario@email.com"));
//            msg.setSubject("Tema del mensaje");
//            String msgBody = "Cuerpo del mensaje";
//            DataHandler dh = new DataHandler(msgBody, "text/plain");
//            msg.setDataHandler(dh);
//
//            // Pedimos a la clase Transport que envie el mensaje de correo
//            javax.mail.Transport.send(msg);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

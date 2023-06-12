package br.com.api.aula.services;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.api.aula.domain.Aluno;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	@Autowired
	JavaMailSender emailSender;
	
	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
		Properties properties = new Properties();
		
		//essas são as configurações para o gmail
		emailSender.setHost("smtp.gmail.com");
		emailSender.setPort(587);
		emailSender.setUsername("turma06deby@gmail.com");
		emailSender.setPassword("pwkscdavgflatrno");
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		emailSender.setJavaMailProperties(properties);
		
		return emailSender;
	}
	
	public void envioEmailCadastro(String email, Aluno aluno) throws MessagingException {
		this.emailSender = javaMailSender();
		MimeMessage messageAluno = emailSender.createMimeMessage();
		MimeMessageHelper helperAluno = new MimeMessageHelper(messageAluno, true);
		
		try {
			helperAluno.setFrom("turma06deby@gmail.com");
			helperAluno.setTo("cpnnatalie@gmail.com");
			helperAluno.setSubject(email);
			
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("<html>\r\n");
			stringBuilder.append("     <body>\r\n");
			stringBuilder.append("          <div align=\"center\">\r\n");
			stringBuilder.append("            <h1>Cadastro Concluido\r\n</h1>");
			stringBuilder.append("          </div>\r\n");
			stringBuilder.append("          <div>\r\n");
			stringBuilder.append("          <br/>\r\n");
			stringBuilder.append("           Status: " + aluno.isAtivo());
			stringBuilder.append("          </div>\r\n");
			stringBuilder.append("     </body>\r\n");
			stringBuilder.append("</html>\r\n");
			
			helperAluno.setText(stringBuilder.toString (), true);
			emailSender.send(messageAluno);
		}
		catch(Exception e) {
			e.printStackTrace();
		
		}
	}
}

package com.luan.vocemaistech.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.luan.vocemaistech.model.PostBlog;
import com.luan.vocemaistech.model.User;
import com.luan.vocemaistech.model.enums.CategoryPost;
import com.luan.vocemaistech.model.enums.Profile;
import com.luan.vocemaistech.repositories.PostBlogRepository;
import com.luan.vocemaistech.repositories.UserRepository;

@Service
public class DBService {

	@Autowired
	private UserRepository studentRepository;
	@Autowired
	private PostBlogRepository postBlogRepository;

	@Autowired
	private PasswordEncoder encoder;

	public void instanciaDB() {

		User u1 = new User(null, "Abneradmin", "113456789-99", "abner@mail.com", encoder.encode("123"));
		u1.addProfile(Profile.ADMIN);	

		User u5 = new User(null, "andrey", "113456789-89", "andrey@mail.com", encoder.encode("123"));
		u1.addProfile(Profile.USER);

		User u2 = new User(null, "luan", "111456789-99", "luan@mail.com", encoder.encode("123"));

		User u3 = new User(null, "carol", "111456789-79", "carol@mail.com", encoder.encode("123"));
		

		User u4 = new User(null, "rosberval", "123456789-99", "rosberval@mail.com", encoder.encode("123"));
		
		PostBlog p7 = new PostBlog(null, "teste title", "teste text", CategoryPost.PROGRAMACAO, "subcategoria", "abnerluan", 
				u2, "https://s3.amazonaws.com/www.vocemaistech.com.br/assets/img/new-post-banner.jpg");

		PostBlog p1 = new PostBlog(null, "Titulo do Post",
				"1Lorem Ipsum é simplesmente uma simulação \"\r\n"
						+ "				+ \"de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um \"\r\n"
						+ "				+ \"impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de \"\r\n"
						+ "				+ \"tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, \"\r\n"
						+ "				+ \"permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques \"\r\n"
						+ "				+ \"contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de \"\r\n"
						+ "				+ \"editoração eletrônica como Aldus PageMaker.",
				CategoryPost.SOCIALMEDIA, "java", u1.getName(), u1, "https://s3.amazonaws.com/www.vocemaistech.com.br/assets/img/new-post-banner.jpg");


		PostBlog p2 = new PostBlog(null, "2Titulo do Post2",
				"2Lorem Ipsum é simplesmente uma simulação "
						+ "de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um "
						+ "impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de "
						+ "tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, "
						+ "permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques "
						+ "contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de "
						+ "editoração eletrônica como Aldus PageMaker.",
				CategoryPost.SOCIALMEDIA, "ANGULAR", u1.getName(), u1, "https://s3.amazonaws.com/www.vocemaistech.com.br/assets/img/new-post-banner.jpg");

		PostBlog p3 = new PostBlog(null, "3Titulo do Post3",
						"3Lorem Ipsum é simplesmente uma simulação "
						+ "de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um "
						+ "impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de "
						+ "tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, "
						+ "permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques "
						+ "contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de "
						+ "editoração eletrônica como Aldus PageMaker.",
				CategoryPost.SOCIALMEDIA, "java", u4.getName(),u4, "https://s3.amazonaws.com/www.vocemaistech.com.br/assets/img/new-post-banner.jpg");

		PostBlog p4 = new PostBlog(null, "4Titulo do Post2",
				"4Lorem Ipsum é simplesmente uma simulação "
						+ "de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um "
						+ "impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de "
						+ "tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, "
						+ "permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques "
						+ "contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de "
						+ "editoração eletrônica como Aldus PageMaker.",
				CategoryPost.SOCIALMEDIA, "ANGULAR", u3.getName(), u3, "https://s3.amazonaws.com/www.vocemaistech.com.br/assets/img/new-post-banner.jpg");

		PostBlog p5 = new PostBlog(null, "5Titulo do Post",
				"5Lorem Ipsum é simplesmente uma simulação "
						+ "de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um "
						+ "impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de "
						+ "tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, "
						+ "permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques "
						+ "contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de "
						+ "editoração eletrônica como Aldus PageMaker.",
				CategoryPost.SOCIALMEDIA, "java", u2.getName(), u2, "https://s3.amazonaws.com/www.vocemaistech.com.br/assets/img/new-post-banner.jpg");

		PostBlog p6 = new PostBlog(null, "6Titulo do Post",
				"6Lorem Ipsum é simplesmente uma simulação "
						+ "de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um "
						+ "impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de "
						+ "tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, "
						+ "permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques "
						+ "contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de "
						+ "editoração eletrônica como Aldus PageMaker.",
				CategoryPost.SOCIALMEDIA, "ANGULAR", u1.getName(), u1, "https://s3.amazonaws.com/www.vocemaistech.com.br/assets/img/new-post-banner.jpg");

		studentRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
		postBlogRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));
		  
	}

}

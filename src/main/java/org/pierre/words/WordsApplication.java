package org.pierre.words;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WordsApplication implements ApplicationRunner {
	@Autowired 
    private WordsRepository wordsRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(WordsApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("ciao bella gioia");
		Words one = new Words();
		one.setWord("mamma");
		wordsRepository.save(one);
	}
}

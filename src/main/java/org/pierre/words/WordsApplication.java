package org.pierre.words;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WordsApplication implements ApplicationRunner {
	
	@Autowired 
    private WordsRepository wordsRepository;
	@Autowired 
    private ScansRepository scansRepository;	

	public static void main(String[] args) {
		SpringApplication.run(WordsApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Logger logger = LoggerFactory.getLogger(WordsApplication.class);

		List<String> allWords = new ArrayList<String>();
		String fileName = "D:\\pierre\\calibre\\Clifford D. Simak\\All'Ombra Di Tycho (275)\\All'Ombra Di Tycho - Clifford D. Simak.txt.transoutdestination";
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			while ((line = br.readLine()) != null) {
				List<String> words = Arrays.asList(line.split("[,:; ?.@]+"));
				System.out.println(line);
				for (String word: words) {
					String cleanedWord = word.replaceAll("\\.", "").replaceAll(",", "").replaceAll(";", "").replaceAll(":", "");
					allWords.add(cleanedWord);
					System.out.println(cleanedWord);
				}
			}
		}

		List<Words> allExistingWords = new ArrayList<>();
		wordsRepository.findAll().forEach(allExistingWords::add);

		System.out.println("");
		Words one = new Words();
		one.setWord("mamma");
		wordsRepository.save(one);
		
		// save scan to DB
		List<Scans> existingScans = scansRepository.findByFilename(fileName);
		Scans scan = null;
		if (existingScans.size() == 0) {
			logger.debug("creating SCANS record");
			scan = new Scans();
			scan.setFilename(fileName);
			DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmss");
			scan.setDate(dateFormat.format(new Date()));
			scansRepository.save(scan);
		}
		else {
			logger.debug("updating SCANS record");
			scan = existingScans.get(0);
		}
		
		

	}
}

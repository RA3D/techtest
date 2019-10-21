package com.happn.techtest.config;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.happn.techtest.entities.InterestPoints;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author zack
 *
 */

@Configuration
@ComponentScan
@Slf4j
public class Config {
	private static final String REGEX_TAB = "\\t";

	/**
	 * load TSV file on startup, to reload the file we should restart the
	 * application
	 * 
	 * @return
	 */
	@Bean(name = "loadTSVFile")
	public List<InterestPoints> loadTSVFile() {
		log.info("Attempt to load TSV file ..");
		List<InterestPoints> parsed = null;
		File file = null;
		String path=null;
		try {
			file = new ClassPathResource("pois.tsv").getFile();
		    path = file.getAbsolutePath();
			log.info("TSV file loaded successfully ..");
		} catch (IOException e) {
			log.error(e.toString());
		}

		try (final Stream<String> lines = Files.lines(Paths.get(path))) {
			parsed = lines.skip(1).map(line -> line.split(REGEX_TAB)).map(line -> {
				final String id = line[0];
				final double latitude = Double.parseDouble(line[1]);
				final double longitude = Double.parseDouble(line[2]);
				return new InterestPoints(id, latitude, longitude);
			}).collect(Collectors.toList());
		} catch (Exception e) {
			log.error(e.toString());
		}
		log.info("TSV file parsed successfully ..");
		return parsed;
	}

}

package iuresti.training.peopleandcars;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PeopleAndCarsApplication  implements CommandLineRunner {

	@Value("${process.people.path}")
	private String peoplePath;

	@Value("${process.people.threads-count}")
	private int peopleThreadCount;

	@Value("${process.people.thread-prefix}")
	private String peopleThreadPrefix;
	private static Logger LOG = LoggerFactory.getLogger(PeopleAndCarsApplication.class);
	public static void main(String[] args) {
		LOG.info("STARTING  APPLICATION");
		SpringApplication.run(PeopleAndCarsApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println(peoplePath);
		System.out.println(peopleThreadCount);
		System.out.println(peopleThreadPrefix);

	}
}

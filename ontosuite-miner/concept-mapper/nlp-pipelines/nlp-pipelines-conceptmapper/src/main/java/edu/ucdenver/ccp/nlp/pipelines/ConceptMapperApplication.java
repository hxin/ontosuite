package edu.ucdenver.ccp.nlp.pipelines;

import com.sun.istack.internal.NotNull;
import edu.ucdenver.ccp.nlp.pipelines.conceptmapper.EntityFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;


/**
 * Created by xinhe on 26/04/2017.
 */
@SpringBootApplication
public class ConceptMapperApplication {

    @NotNull
    @Value("${conceptermapper.inputDir}")
    private String inputDir;

    @NotNull
    @Value("${conceptermapper.outputDir}")
    private String outputDir;

    @NotNull
    @Value("${conceptermapper.ontology}")
    private String ontology;

    @NotNull
    @Value("${conceptermapper.oboPath}")
    private String oboPath;

    @NotNull
    @Value("${conceptermapper.oboDir}")
    private String oboDir;

    @NotNull
    @Value("${conceptermapper.cleanDictionaryFile}")
    private String cleanDictionaryFile;

    public static void main(String[] args) {
        System.out.println("Starting ConceptMapper...");
        ApplicationContext ctx = SpringApplication.run(ConceptMapperApplication.class, args);


        System.out.println("Application executed successfully!");
//        System.out.println(cleanDictionaryFile);
        SpringApplication.exit(ctx);
    }

    @Bean
    CommandLineRunner run() {
        return strings -> {

            String[] args = {inputDir,outputDir,ontology,oboPath,oboDir,cleanDictionaryFile};
System.out.print(args.toString());
            EntityFinder ef = new EntityFinder();
            ef.run(args);

            System.out.println("Done!!!!");

        };
    }
}




package edu.greenriver.sdev.programminglanguages;

import edu.greenriver.sdev.programminglanguages.db.ILanguageRepository;
import edu.greenriver.sdev.programminglanguages.model.Language;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProgrammingLanguagesApplication
{
    public static void main(String[] args)
    {
        //get my spring container
        ApplicationContext context = SpringApplication.run(ProgrammingLanguagesApplication.class, args);

        //ask the spring container for a spring bean (our data layer)
        ILanguageRepository repo = context.getBean(ILanguageRepository.class);

        //add a few DB objects
        Language[] languages = {
            Language.builder().name("C#").ranking(1).looselyTyped(false).build(),
            Language.builder().name("Java").ranking(3).looselyTyped(false).build(),
            Language.builder().name("Javascript").ranking(2).looselyTyped(true).build(),
            Language.builder().name("PHP").ranking(6).looselyTyped(true).build(),
            Language.builder().name("Python").ranking(4).looselyTyped(true).build(),
            Language.builder().name("C++").ranking(5).looselyTyped(false).build()
        };

        for (Language language : languages)
        {
            //persist this Language object to the database
            repo.save(language);
        }
        System.out.println("All languages saved to DB");
    }
}

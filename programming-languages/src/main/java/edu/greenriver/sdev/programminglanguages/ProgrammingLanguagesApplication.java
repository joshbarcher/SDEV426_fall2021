package edu.greenriver.sdev.programminglanguages;

import edu.greenriver.sdev.programminglanguages.db.ILanguageRepository;
import edu.greenriver.sdev.programminglanguages.db.IUserRepository;
import edu.greenriver.sdev.programminglanguages.model.Language;
import edu.greenriver.sdev.programminglanguages.model.Permission;
import edu.greenriver.sdev.programminglanguages.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ProgrammingLanguagesApplication
{
    public static void main(String[] args)
    {
        //get my spring container
        ApplicationContext context = SpringApplication.run(ProgrammingLanguagesApplication.class, args);

        loadLanguages(context);
        loadAdminAccount(context);
    }

    private static void loadAdminAccount(ApplicationContext context)
    {
        //get the beans we need
        IUserRepository repo = context.getBean(IUserRepository.class);
        BCryptPasswordEncoder encoder = context.getBean(BCryptPasswordEncoder.class);

        //test admin account
        User admin = User.builder()
            .username("admin")
            .password(encoder.encode("pass"))
            .build();

        Permission adminRole = new Permission(0, "admin", admin);
        Permission userRole = new Permission(0, "user", admin);
        admin.setPermissions(new ArrayList<>());
        admin.getPermissions().add(adminRole);
        admin.getPermissions().add(userRole);

        repo.save(admin);

        //test user account
        User regular = User.builder()
            .username("user")
            .password(encoder.encode("pass"))
            .build();

        userRole = new Permission(0, "user", regular);
        regular.setPermissions(new ArrayList<>());
        regular.getPermissions().add(userRole);

        repo.save(regular);
    }

    private static void loadLanguages(ApplicationContext context)
    {
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

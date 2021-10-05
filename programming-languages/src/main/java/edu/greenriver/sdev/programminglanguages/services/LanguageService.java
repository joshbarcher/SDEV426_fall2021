package edu.greenriver.sdev.programminglanguages.services;

import edu.greenriver.sdev.programminglanguages.db.ILanguageRepository;
import edu.greenriver.sdev.programminglanguages.model.Language;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class LanguageService
{
    //access the data layer using dependency injection
    //the ILanguageRepository is a Spring bean
    private ILanguageRepository repo;

    public LanguageService(ILanguageRepository repo)
    {
        this.repo = repo;
    }

    public List<Language> allLanguages()
    {
        return repo.findAll();
    }

    public Language random()
    {
        List<Language> all = repo.findAll();
        Random random = new Random();
        Language randLang = all.get(random.nextInt(all.size()));

        return randLang;
    }

    public List<Language> topThree()
    {
        return null;
    }

    public Language favorite()
    {
        return null;
    }

    public Language languageByRank(int rank)
    {
        return null;
    }
}

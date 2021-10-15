package edu.greenriver.sdev.programminglanguages.services;

import edu.greenriver.sdev.programminglanguages.db.ILanguageRepository;
import edu.greenriver.sdev.programminglanguages.model.Language;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

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
        List<Language> all = repo.findAll();
        List<Language> top3 = all.stream()
            .sorted()
            .limit(3)
            .collect(Collectors.toList());

        return top3;
    }

    public Language languageById(int id)
    {
        return repo.findById(id).orElse(null);
    }

    public Language favorite()
    {
        return null;
    }

    public Language languageByRank(int rank)
    {
        return repo.findByRankingIs(rank);
    }

    public void saveLanguage(Language lang)
    {
        //validate that the language object has valid data

        repo.save(lang);
    }
}













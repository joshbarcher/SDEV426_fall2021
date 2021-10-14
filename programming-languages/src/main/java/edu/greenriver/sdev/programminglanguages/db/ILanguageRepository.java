package edu.greenriver.sdev.programminglanguages.db;

import edu.greenriver.sdev.programminglanguages.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//The generic types says that this data layer is used to access
//Language objects which are identified using an Integer
@Repository
public interface ILanguageRepository extends JpaRepository<Language, Integer>
{
    Language findByRankingIs(int rank);
    /*Language findById(int id);*/
}

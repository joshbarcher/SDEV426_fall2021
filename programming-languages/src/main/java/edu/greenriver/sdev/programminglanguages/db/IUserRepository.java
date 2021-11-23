package edu.greenriver.sdev.programminglanguages.db;

import edu.greenriver.sdev.programminglanguages.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer>
{
    User findByUsername(String username);
}

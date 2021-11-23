package edu.greenriver.sdev.programminglanguages.services;

import edu.greenriver.sdev.programminglanguages.db.IUserRepository;
import edu.greenriver.sdev.programminglanguages.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService
{
    private IUserRepository repo;

    public LoginService(IUserRepository repo)
    {
        this.repo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = repo.findByUsername(username);

        if (user != null)
        {
            return user;
        }
        throw new UsernameNotFoundException("Username is not recognized");
    }
}

















package edu.greenriver.sdev.programminglanguages.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Permission implements GrantedAuthority
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int permissionId;

    private String role;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Override
    public String getAuthority()
    {
        return role;
    }
}












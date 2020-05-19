package com.jugal.adminsecurity.security;

import com.jugal.adminsecurity.model.Role;
import com.jugal.adminsecurity.model.User;
import com.jugal.adminsecurity.repository.RoleRepository;
import com.jugal.adminsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    boolean alreadySetup = true;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        User user = userRepository.findByUsername("super");
        if (null == user) {
            createRoleIfNotFound("ROLE_ADMIN");
            createRoleIfNotFound("ROLE_USER");
            createRoleIfNotFound("ROLE_SUPER_ADMIN");
            Role adminRole = roleRepository.findByName("ROLE_ADMIN");
            Role superAdminRole = roleRepository.findByName("ROLE_SUPER_ADMIN");
            user = new User();
            user.setUsername("super");
            //user.setFirstName("superadmin");
            //user.setLastName("superadmin");
            user.setPassword(passwordEncoder.encode("mm"));
            //user.setEmailId("replaceIfAlreadyExist@replaceIfAlreadyExist.com");
            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);
            roles.add(superAdminRole);
            user.setRoles(roles);
            userRepository.save(user);
            alreadySetup = true;
        }
    }

    @Transactional
    public Role createRoleIfNotFound(String name) {
        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role();
            role.setName(name);
            roleRepository.save(role);
        }
        return role;
    }
}

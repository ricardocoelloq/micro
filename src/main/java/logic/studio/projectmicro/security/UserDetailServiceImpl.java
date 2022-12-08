package logic.studio.projectmicro.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import logic.studio.projectmicro.service.api.UserServiceAPI;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private UserServiceAPI userService;

    @Autowired
    public UserDetailServiceImpl(UserServiceAPI userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var userRegister = userService.findUserByEmail(email);

        return new UserDetailsImpl(userRegister);
    }
}

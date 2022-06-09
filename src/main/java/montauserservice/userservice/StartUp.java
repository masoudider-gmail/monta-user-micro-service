package montauserservice.userservice;

import montauserservice.userservice.domain.MontaUser;
import montauserservice.userservice.service.MontaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartUp implements CommandLineRunner {

    @Autowired
    private MontaUserService service;

    @Override
    public void run(String... args) throws Exception {

        service.save(new MontaUser(1,"user_A","family_a"));
        service.save(new MontaUser(2,"user_B","family_b"));
        service.save(new MontaUser(3,"user_C","family_c"));
        service.save(new MontaUser(4,"user_D","family_d"));
    }
}

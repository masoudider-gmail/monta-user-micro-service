package montauserservice.userservice.domain.repository;

import montauserservice.userservice.domain.MontaUser;
import org.springframework.data.repository.CrudRepository;

public interface MontaUserRepository extends CrudRepository<MontaUser, Integer> {
}

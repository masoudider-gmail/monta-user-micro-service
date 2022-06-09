package montauserservice.userservice.service;

import montauserservice.userservice.domain.MontaUser;
import montauserservice.userservice.domain.ResultModel;

import java.util.List;

/**
 * Interface of methods to work with Monta users like saving
 */
public interface MontaUserService {

    MontaUser save(MontaUser montaUser);

    List<ResultModel> findUsersAndTheNumberOfExams();

}

package montauserservice.userservice.service.implementations;

import montauserservice.userservice.domain.MontaUser;
import montauserservice.userservice.domain.ResultModel;
import montauserservice.userservice.domain.repository.MontaUserRepository;
import montauserservice.userservice.service.ExamService;
import montauserservice.userservice.service.MontaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MontaUserServiceImp implements MontaUserService {

    @Autowired
    private MontaUserRepository userRepository;

    @Autowired
    private ExamService examService;

    @Override
    public MontaUser save(MontaUser montaUser) {
        return userRepository.save(montaUser);
    }

    @Override
    public List<ResultModel> findUsersAndTheNumberOfExams() {

        Map<Integer, Integer> map = examService.get();

        List<ResultModel> users = new ArrayList<>();
        userRepository.findAll().forEach(
                montaUser -> {
                    users.add(new ResultModel(montaUser.getId(), montaUser.getName(), montaUser.getFamily(), map.get(montaUser.getId())));
                });
        return users;
    }
}

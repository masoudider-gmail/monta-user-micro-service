package montauserservice.userservice.service;

import montauserservice.userservice.domain.MontaUser;
import montauserservice.userservice.domain.ResultModel;
import montauserservice.userservice.domain.repository.MontaUserRepository;
import montauserservice.userservice.service.implementations.MontaUserServiceImp;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class MontaUserServiceTest {

    @Mock
    MontaUserRepository repository;

    @Mock
    ExamService examService;

    @InjectMocks
    MontaUserServiceImp service;

    MontaUser montaUser;

    Map<Integer, Integer> map = new HashMap<>();

    @BeforeEach
    void setUp() {
        montaUser = new MontaUser(1, "john", "lx");
        map.put(1, 3);
    }

    @Test
    void save() {

        when(repository.save(any(MontaUser.class))).thenReturn(montaUser);

        MontaUser savedUser = service.save(new MontaUser(1, "john", "lx"));

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getName()).isEqualTo(montaUser.getName());

        verify(repository).save(any(MontaUser.class));
    }

    @Test
    void findUsersAndTheNumberOfExams() {

        List<MontaUser> users = new ArrayList<>();
        users.add(montaUser);

        when(examService.get()).thenReturn(map);
        when(repository.findAll()).thenReturn(users);

        List<ResultModel> result = service.findUsersAndTheNumberOfExams();

        verify(examService).get();
        verify(repository).findAll();

        assertThat(result).isNotNull();

        assertThat(result.get(0).getExamsNo()).isEqualTo(map.get(montaUser.getId()));
    }
}
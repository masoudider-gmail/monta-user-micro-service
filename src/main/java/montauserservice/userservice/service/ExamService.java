package montauserservice.userservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * Feign client that gets the map with the key of user id and the value of the number of exams the user have
 */
@FeignClient(name = "MONTA-exam-service")
public interface ExamService {

    @GetMapping("/exams")
    public Map<Integer, Integer> get();
}

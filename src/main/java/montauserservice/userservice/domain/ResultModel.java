package montauserservice.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * the object that is provided to be shown to the client
 */
@Data
@AllArgsConstructor
public class ResultModel {
    private int id;
    private String name;
    private String family;
    private int examsNo;
}

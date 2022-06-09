package montauserservice.userservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entity user
 */
@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MontaUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String family;

    public MontaUser(String name, String family) {
        this.name = name;
        this.family = family;
    }

    @Override
    public String toString() {
        return "{name='" + name + '\'' +
                ", family='" + family + '\'';
    }
}

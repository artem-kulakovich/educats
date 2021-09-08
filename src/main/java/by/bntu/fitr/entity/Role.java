package by.bntu.fitr.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "role_seq")
    @SequenceGenerator(name = "role_seq",sequenceName = "role_id_seq",allocationSize = 1)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "role")
    private Set<User> users;

    public Role(String name) {
        this.name = name;
    }
}

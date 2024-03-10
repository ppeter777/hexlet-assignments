package exercise.model;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;
import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// BEGIN

import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@Table(name = "people")
//@AllArgsConstructor
//@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
}
// END

package exercise.model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

// BEGIN
@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;
    private String title;
    private String description;
    @GeneratedValue
    private LocalDate createdAt;
    @GeneratedValue
    private LocalDate updatedAt;
}
// END

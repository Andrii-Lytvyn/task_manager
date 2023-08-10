package de.ait.taskmanager.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String description;

    private String title;

    private LocalDate startDate;

    private LocalDate finishDate;

    @ManyToOne
    @JoinColumn(name = "about_id")
    private User executor;
}

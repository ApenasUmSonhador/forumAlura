package br.com.forumAlura.api.course;

import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private long id;
    private String name;
    private String category;
}

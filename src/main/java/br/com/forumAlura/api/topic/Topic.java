package br.com.forumAlura.api.topic;

import java.time.LocalTime;

import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Table(name = "topic")
@Entity(name = "topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String message;
    private LocalTime creationDate;
    private String status;

    public Topic(TopicRegisterData topicRegisterData) {
        this.title = topicRegisterData.title();
        this.message = topicRegisterData.message();
        this.creationDate = null;
        this.status = "NOT_ANSWERED";
    }

    public Object update(@Valid TopicUpdateData json) {
        if (json.title() != null) {
            this.title = json.title();
        }
        if (json.message() != null) {
            this.message = json.message();
        }
        if (json.status() != null) {
            this.status = json.status();
        }
        return this;
    }
}

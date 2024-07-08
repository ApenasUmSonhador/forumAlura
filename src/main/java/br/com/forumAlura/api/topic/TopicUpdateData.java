package br.com.forumAlura.api.topic;

import jakarta.validation.constraints.NotBlank;

public record TopicUpdateData(
        @NotBlank long id,
        String title,
        String message,
        String status) {

}

package br.com.forumAlura.api.topic;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public record TopicRegisterData(
        @NotBlank @JsonProperty("title") String title,
        @NotBlank @JsonProperty("message") String message) {

}

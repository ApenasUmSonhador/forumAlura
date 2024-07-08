package br.com.forumAlura.api.topic;

public record TopicListData(String title, String message, String status, String creationDate) {
    public TopicListData(Topic topic) {
        this(topic.getTitle(), topic.getMessage(), topic.getStatus(), topic.getCreationDate().toString());
    }
}

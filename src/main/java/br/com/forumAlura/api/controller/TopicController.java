package br.com.forumAlura.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import br.com.forumAlura.api.topic.Topic;
import br.com.forumAlura.api.topic.TopicListData;
import br.com.forumAlura.api.topic.TopicRegisterData;
import br.com.forumAlura.api.topic.TopicRepository;
import br.com.forumAlura.api.topic.TopicUpdateData;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicRepository repository;

    @PostMapping
    public void topic(@RequestBody @Valid TopicRegisterData json) {
        System.out.println("entrei aqui");
        repository.save(new Topic(json));
    }

    @GetMapping
    public Page<TopicListData> getTopicList(@PageableDefault(size = 10, sort = { "title" }) Pageable pageable) {
        return repository.findAll(pageable).map(TopicListData::new);
    }

    @PutMapping
    @Transactional
    public void update(@RequestBody @Valid TopicUpdateData json) {
        repository.findById(json.id()).ifPresent(topic -> topic.update(json));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void delete(@PathVariable long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }
}

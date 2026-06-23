package com.example.first_project.service;

import com.example.first_project.entity.Tag;
import com.example.first_project.repository.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag createTag(Tag tag){
        return tagRepository.save(tag);
    }

    public List<Tag> getAllTags(){
        return tagRepository.findAll();
    }

    public Tag getTagById(Long id){
        return tagRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(("Tag not found")));
    }

    public void deleteTag(Long id){
        tagRepository.deleteById(id);
    }
}

package com.sparta.posting.controller;

import com.sparta.posting.dto.PostingRequestDto;
import com.sparta.posting.dto.PostingResponseDto;
import com.sparta.posting.service.PostingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostingController {

    private final PostingService postingService;

    public PostingController(PostingService postingService) {
        this.postingService = postingService;
    }
    @PostMapping("/postings")
    public PostingResponseDto createPosting(@RequestBody PostingRequestDto requestDto){
        return postingService.createPosting(requestDto);
    }
    @GetMapping("/postings")
    public List<PostingResponseDto> getPostings(){
        return postingService.getPostings();
    }
    @GetMapping("/postings/{id}")
    public List<PostingResponseDto> getPostingById(@PathVariable Long id){
        return postingService.getPostingById(id);
    }

    @PutMapping("/postings/{id}")
    public PostingResponseDto updatePosting(@PathVariable Long id,
                              @RequestBody PostingRequestDto requestDto){
        return postingService.updatePosting(id, requestDto);
    }
    @DeleteMapping("/postings/{id}")
    public Long deletePosting(@PathVariable Long id,
                              @RequestBody PostingRequestDto requestDto){
        return postingService.deletePosting(id, requestDto);
    }
}

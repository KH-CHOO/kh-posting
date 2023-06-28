package com.sparta.posting.service;

import com.sparta.posting.dto.PostingRequestDto;
import com.sparta.posting.dto.PostingResponseDto;
import com.sparta.posting.entity.Posting;
import com.sparta.posting.repository.PostingRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostingService {

    private final PostingRepository postingRepository;

    public PostingResponseDto createPosting(PostingRequestDto requestDto){
        Posting posting = requestDto.toEntity();
        postingRepository.save(posting);
        return new PostingResponseDto(posting);
    }

    public List<PostingResponseDto> getPostings(){
        return postingRepository.findAllByOrderByCreatedAtDesc().stream().map(PostingResponseDto::new).toList();
    }

    public List<PostingResponseDto> getPostingById(Long id){
        return postingRepository.findAllById(id).stream().map(PostingResponseDto::new).toList();
    }
    public PostingResponseDto getPostingById2(Long id){
        Optional<Posting> optionalPosting = postingRepository.findById(id);
        if (optionalPosting.isPresent()){
            Posting posting = optionalPosting.get();
            return new PostingResponseDto(posting);
        }else {
            // Handle the case when no posting is found with the given id
            throw new IllegalArgumentException("일치하는 id가 없습니다");
        }

    }

    @Transactional
    public PostingResponseDto updatePosting(Long id, PostingRequestDto requestDto) {
        // 비밀번호 검사
        Posting posting = checkPosting(id, requestDto.getPassword());
        // posting 내용 수정
        posting.update(requestDto);
        return new PostingResponseDto(posting);

    }

    public Long deletePosting(Long id,PostingRequestDto requestDto) {
        // 비밀번호 검사
        Posting posting = checkPosting(id, requestDto.getPassword());

        // posting 삭제
        postingRepository.delete(posting);
        // id가 리턴되면 삭제되었다는 뜻
        return id;
    }

    private Posting checkPosting(Long id, String password){
        Posting posting = postingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 존재하지 않습니다."));

        if (!posting.getPassword().equals(password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return posting;
    }


}

package com.sparta.posting.dto;
import com.sparta.posting.entity.Posting;
import lombok.Getter;

import java.time.LocalDateTime;
@Getter
public class PostingResponseDto {
    // 조회
    // id, 제목, 작성자명, 작성 내용, 작성 날짜
    private Long id;
    private String title;
    private String username;
    private String contents;
    private LocalDateTime createdAt;

    public PostingResponseDto(Posting posting) {
        this.id = posting.getId();
        this.title = posting.getTitle();
        this.username = posting.getUsername();
        this.contents = posting.getContents();
        this.createdAt = posting.getCreatedAt();

    }
}

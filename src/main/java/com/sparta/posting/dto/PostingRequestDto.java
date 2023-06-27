package com.sparta.posting.dto;
import com.sparta.posting.entity.Posting;
import lombok.Getter;
@Getter
public class PostingRequestDto {

    // 작성, 수정, 삭제
    // 제목, 작성자명, 비밀번호, 작성 내용
    private String title;
    private String username;
    private String password;
    private String contents;

    public Posting toEntity() {
        return Posting.builder()
                .title(title)
                .username(username)
                .password(password)
                .contents(contents)
                .build();
    }
}

package com.sparta.posting.dto;
import lombok.Getter;
@Getter
public class PostingRequestDto {

    // 작성, 수정, 삭제
    // 제목, 작성자명, 비밀번호, 작성 내용
    private String title;
    private String username;
    private String password;
    private String contents;
}

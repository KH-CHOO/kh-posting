package com.sparta.posting.entity;

import com.sparta.posting.dto.PostingRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter // Setter는 조심해서 사용해야 함을 잊지 말것
@Table(name = "posting") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class Posting extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment
    private Long id;

    //제목, 작성자명, 비밀번호, 작성 내용
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "contents", nullable = false, length = 500)
    private String contents;

    public Posting(PostingRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }

    public void update(PostingRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}

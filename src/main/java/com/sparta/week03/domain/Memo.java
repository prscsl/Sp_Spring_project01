package com.sparta.week03.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Memo extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String pswd;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    public Memo(String name, String pswd, String title, String contents) {
        this.name = name;
        this.pswd = pswd;
        this.title = title;
        this.contents = contents;
    }

    public Memo(MemoRequestDto requestDto) {
        this.name = requestDto.getName();
        this.pswd = requestDto.getPswd();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

    public void update(MemoRequestDto requestDto) {
        this.name = requestDto.getName();
        this.pswd = requestDto.getNpswd();
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }

}

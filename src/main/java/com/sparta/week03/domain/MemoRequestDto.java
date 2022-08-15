package com.sparta.week03.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class MemoRequestDto {
    private final String name;
    private final String pswd;
    private final String title;
    private final String contents;
    private final String npswd;
}

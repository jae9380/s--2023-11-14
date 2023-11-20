package com.example.sb20231114.domain.member.member.entity;

import lombok.*;

@AllArgsConstructor
@Data
@ToString
public class Member {
    private Long id;
    private String username;
    private String password;

    public Member(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
package com.example.sb20231114.domain.member.member.controller;

import com.example.sb20231114.domain.member.member.entity.Member;
import com.example.sb20231114.domain.member.member.service.MemberService;
import com.example.sb20231114.global.rq.Rq;
import com.example.sb20231114.global.rsData.RsData;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    private final Rq rq;

    @PreAuthorize("isAnonymous()")
    @GetMapping("/member/login")
    String showLogin() {
        return "member/member/login";
    }

    @PreAuthorize("isAnonymous()")
    @GetMapping("/member/join")
    String showJoin() {
        return "member/member/join";
    }

    @Data
    public static class JoinForm {
        @NotBlank
        private String username;
        @NotBlank
        private String password;
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/member/join")
    String join(@Valid JoinForm joinForm) {
        try {
            RsData<Member> joinRs = memberService.join(joinForm.username, joinForm.password);

            if ( joinRs.isFail() ) {
                return rq.historyBack(joinRs.getMsg());
            }

            return rq.redirect("/member/login", joinRs.getMsg());
        } catch (RuntimeException e) {
            return rq.historyBack(e.getMessage());
        }
    }
}
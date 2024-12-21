package com.example.demo.member;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userNumber") // 테이블의 실제 컬럼명과 매핑
    private Integer userNumber;

    @Column(name = "userName", nullable = false, length = 100)
    private String userName;

    @Column(name = "userId", nullable = false, unique = true, length = 100)
    private String userId;

    @Column(name = "userPwd", nullable = false, length = 255)
    private String userPwd;

    @Column(name = "nickName", nullable = false, length = 15)
    private String nickName;

    @Column(name = "comName", nullable = false, length = 100)
    private String comName;

    @Enumerated(EnumType.STRING)
    @Column(name = "userType", nullable = false)
    private UserType userType;

    @Column(name = "birth", nullable = false)
    private LocalDate birth;

    @Column(name = "tel", nullable = false, length = 15)
    private String tel;

    @Column(name = "signDate", nullable = false, updatable = false)
    private LocalDateTime signDate = LocalDateTime.now();

    public enum UserType {
        EMPLOYER, SEEKER, MANAGER
    }
}
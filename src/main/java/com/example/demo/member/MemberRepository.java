package com.example.demo.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    boolean existsByUserId(String userId);
    Optional<Member> findByUserIdAndUserPwd(String userId, String userPwd);

}
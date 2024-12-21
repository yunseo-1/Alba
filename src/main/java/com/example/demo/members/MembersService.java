package com.example.demo.members;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembersService {

    @Autowired
    private MembersRepository membersRepository;

    public List<MemberDto> getAllMembers() {
        return membersRepository.findAllMembers();
    }

    public void deleteMembers(List<String> selectedIds) {
        membersRepository.deleteMembersByIds(selectedIds);
    }
}

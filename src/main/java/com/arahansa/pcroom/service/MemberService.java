package com.arahansa.pcroom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arahansa.pcroom.model.Member;
import com.arahansa.pcroom.repository.MemberRepository;

@Service
public class MemberService {

	@Autowired MemberRepository repoMember;
	
	public void saveMember(Member member){
		repoMember.save(member);
	}
	
	public boolean loginCheck(Member member){
		return true;
	}
	
	public int count(){
		return (int) repoMember.count();
	}
	
}

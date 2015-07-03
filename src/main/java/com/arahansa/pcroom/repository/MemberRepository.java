package com.arahansa.pcroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arahansa.pcroom.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	

}

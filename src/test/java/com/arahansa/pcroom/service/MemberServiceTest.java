package com.arahansa.pcroom.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.arahansa.pcroom.Application;
import com.arahansa.pcroom.config.PersistenceContext;
import com.arahansa.pcroom.model.Member;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
@Transactional
public class MemberServiceTest {

	@Autowired MemberService servMember;
	
	
	private static final int _100 = 100;
	private static final int _0 = 0;
	private static final String PHONENUMBER = "phonenumber";
	private static final String PASSWORD = "password";
	private static final String ARAHANSA = "arahansa";
	Member member;
	
	@Before
	public void setup(){
		member = new Member(ARAHANSA, PASSWORD, PHONENUMBER, _0, _100);
		servMember.saveMember(member);
		
	}
	
	@Test
	public void loginCheck() {
		Member loginMember = new Member(ARAHANSA, PASSWORD);
		assertEquals(true, servMember.loginCheck(loginMember));
		
	}

}

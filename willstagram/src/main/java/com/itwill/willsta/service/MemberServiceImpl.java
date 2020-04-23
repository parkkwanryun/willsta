package com.itwill.willsta.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itwill.willsta.domain.Member;
import com.itwill.willsta.exception.MemberNotFoundException;
import com.itwill.willsta.exception.PasswordMismatchException;
import com.itwill.willsta.repository.MemberDao;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDao memberDao;
	
	String uploadFolder ="/var/lib/tomcat8/webapps/willstagram/contents/member_image/";
	@Override
	public boolean insertMember(Member member) {
		return memberDao.insertMember(member);
	}

	@Override
	public Member selectById(String mId) {
		return memberDao.selectById(mId);
	}
	
	@Override
	public boolean updateMember(Member member) {
		// TODO Auto-generated method stub
		return memberDao.updateMember(member);
	}	
	
	@Override
	public boolean updateMemberImg(String mId, MultipartFile uploadImg){
		String mImage;
		
		String originalFile = uploadImg.getOriginalFilename();
		System.out.println(originalFile);
		// 파일명 중 확장자만 추출
		// lastIndexOf(".") - 뒤에 있는 . 의 index번호
		String originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
		/*
		 * 파일이름 중복 방지 UUID클래스 - (특수문자를 포함한)문자를 랜덤으로 생성 "-"라면 생략으로 대체
		 */
		String storedFileName = UUID.randomUUID().toString().replaceAll("-", "") + originalFileExtension;

		// 파일이름을 mImage에 넣어줌
		mImage = storedFileName;
		boolean insertOk = memberDao.updateMemberImg(mId,mImage);
		// 파일을 저장하기 위한 파일 객체 생성
		if (insertOk) {
			File file = new File(uploadFolder, storedFileName);
			// 파일을 contents/member_image 폴더에 저장
			try {
				uploadImg.transferTo(file);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return memberDao.updateMemberImg(mId,mImage);
	}

	@Override
	public boolean deleteMember(String mPass, String mEmail, String mRetire) {
		return memberDao.deleteMember(mPass, mEmail, mRetire);
	}

	@Override
	public boolean accountOn(String mRetire, String mEmail) {
		return memberDao.accountOn(mRetire, mEmail);
	}

	@Override
	public boolean existedMember(String mId) {
		return memberDao.existedMember(mId);
	}
	
	@Override
	public boolean existedPassword(String mPass) {
		return memberDao.existedPassword(mPass);
	}
	
	@Override
	public Member findId(String mEmail, String mName) {
		return memberDao.findId(mEmail, mName);
	}

	@Override
	public Member findPw(String mId, String mEmail) {
		return memberDao.findPw(mId, mEmail);
	}

	@Override
	public Member getTempPw(String mPass, String mId) {
		return memberDao.getTempPw(mPass, mId);
	}

	@Override
	public List<Member> memberList() {
		return memberDao.memberList();
	}

	@Override
	public List<Member> addMemberList(String lastId) {
		return memberDao.addMemberList(lastId);
	}

	@Override
	public List<Member> findMemberList(String search) {
		return memberDao.findMemberList(search);
	}

	@Override
	public Member signIn(String mId, String mPass)
			throws Exception, PasswordMismatchException, MemberNotFoundException {
		Member member = memberDao.selectById(mId);
		if (member == null) {
			throw new MemberNotFoundException(mId + " 는 없는 아이디 입니다.");
		}
		if (!member.isMatchPassword(mPass)) {
			throw new PasswordMismatchException("패스워드가 일치하지 않습니다.");
		}
		return member;
	}

	@Override
	public Member selectByIdContainFollowInfo(String mId) {
		return memberDao.selectByIdContainFollowInfo(mId);

	}

	@Override
	public List<Member> selectByRandom(String mId) {
		return memberDao.selectByRandom(mId);
	}

	
}

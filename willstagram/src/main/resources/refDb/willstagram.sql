/*--------------------------DROP--------------------------*/
/*회원*/
DROP TABLE member CASCADE CONSTRAINTS;
/*포스트(게시판)*/
DROP TABLE post CASCADE CONSTRAINTS;
/*포스트이미지*/
DROP TABLE post_image CASCADE CONSTRAINTS;
/*팔로우*/
DROP TABLE follow CASCADE CONSTRAINTS;
/*좋아요*/
DROP TABLE likes CASCADE CONSTRAINTS;
/*댓글*/
DROP TABLE comments CASCADE CONSTRAINTS;
/*DM(Direct Message)*/
DROP TABLE dm CASCADE CONSTRAINTS;
/*DM 내용*/
DROP TABLE dm_contents CASCADE CONSTRAINTS;


/*--------------------------1.MEMBER--------------------------*/
CREATE TABLE member(
	mId	varchar2(50)	NOT NULL,
	mPass	varchar2(50)    NOT NULL,
	mName	varchar2(50)    NOT NULL,
	mEmail	varchar2(50)    NOT NULL,
	mPhone	varchar2(50)    NOT NULL,
	mNick	varchar2(50)    NOT NULL,
	mImage	varchar2(100),
	MRETIRE CHAR(10) DEFAULT 'on'
);

COMMENT ON TABLE member IS '회원정보';

COMMENT ON COLUMN member.mId IS '아이디';

COMMENT ON COLUMN member.mPass IS '비밀번호';

COMMENT ON COLUMN member.mName IS '회원이름';

COMMENT ON COLUMN member.mEmail IS '이메일';

COMMENT ON COLUMN member.mPhone IS '전화번호';

COMMENT ON COLUMN member.mNick IS '닉네임';

COMMENT ON COLUMN member.mImage IS '프로필이미지';

COMMENT ON COLUMN MEMBER.MRETIRE IS '탈퇴유무';

ALTER TABLE member ADD CONSTRAINT PK_MEMBER PRIMARY KEY (mId);

/*--------------------------2.POST--------------------------*/
CREATE TABLE post (
	pNo     	 number(5)	    NOT NULL,
	mId	       varchar2(50)	NOT NULL,
	pTitle	   varchar2(50)	NOT NULL,
	pContents  varchar2(500)	NOT NULL,
	hasTag  	 varchar2(50)	NOT NULL,
	pViewCount number(10),
	pDate	     DATE,
	status		varchar2(1)
);
COMMENT ON TABLE post IS '포스트';

COMMENT ON COLUMN post.pNo IS '포스트번호';

COMMENT ON COLUMN post.mId IS '아이디';

COMMENT ON COLUMN post.pTitle IS '포스트제목';

COMMENT ON COLUMN post.pContents IS '포스트내용';

COMMENT ON COLUMN post.hasTag IS '해쉬태그';

COMMENT ON COLUMN post.pViewCount IS '조회수';

COMMENT ON COLUMN post.pDate IS '작성시간';

ALTER TABLE post ADD CONSTRAINT PK_POST PRIMARY KEY (pNo);

/*--------------------------3.POST_IMAGE--------------------------*/
CREATE TABLE post_Image (
	pNo				number(5)				NOT NULL,
	fileName	varchar2(100)		NOT NULL
);

COMMENT ON TABLE post_Image IS '포스트이미지';

COMMENT ON COLUMN post_Image.pNo IS '포스트번호';

COMMENT ON COLUMN post_Image.fileName IS '업로드파일명';

ALTER TABLE post_image ADD CONSTRAINT PK_POST_IMAGE PRIMARY KEY (pNo);

/*--------------------------4.FOLLOW--------------------------*/
CREATE TABLE follow (
	mId	    				varchar2(50)	NOT NULL,
	mIdYou					varchar2(50)	NULL
);

ALTER TABLE follow ADD CONSTRAINT PK_FOLLOW PRIMARY KEY (mId);

COMMENT ON TABLE follow IS '팔로우';

COMMENT ON COLUMN follow.mId IS '팔로잉';

COMMENT ON COLUMN follow.mIdYou IS '팔로워';


/*--------------------------5.LIKES--------------------------*/
CREATE TABLE likes (
	pNo	      number(5)	    NOT NULL,
	mIdYou  	varchar2(50)	NULL
);

ALTER TABLE likes ADD CONSTRAINT PK_LIKE PRIMARY KEY (pNo);

COMMENT ON TABLE likes IS '좋아요';

COMMENT ON COLUMN likes.pNo IS '포스트번호';

COMMENT ON COLUMN likes.mIdYou IS '상대방아이디';


/*--------------------------6.COMMENTS--------------------------*/
CREATE TABLE comments (
	cNo	          number(5)	    NOT NULL,
	pNo	          number(5)	    NOT NULL,
	mId	          varchar2(50)	NOT NULL,
	cContents	    varchar2(300)	NOT NULL,
	cTime	        DATE,
	recNo NUMBER(5,0)
);

ALTER TABLE comments ADD CONSTRAINT PK_COMMENTS PRIMARY KEY (cNo);

COMMENT ON TABLE comments IS '댓글';

COMMENT ON COLUMN comments.cNo IS '댓글번호';

COMMENT ON COLUMN comments.pNo IS '포스트번호';

COMMENT ON COLUMN comments.mId IS '아이디';

COMMENT ON COLUMN comments.cContents IS '댓글내용';

COMMENT ON COLUMN comments.cTime IS '댓글작성시간';

COMMENT ON COLUMN comments.recNo IS '참고댓글번호';

/*--------------------------7.DM--------------------------*/
CREATE TABLE dm (
	dmNo	      number(5)	    NOT NULL,
	mId     	varchar2(50)	NOT NULL,
	dmDate	    Date
);

ALTER TABLE dm ADD CONSTRAINT PK_DM PRIMARY KEY (dmNo);
ALTER TABLE dm ADD CONSTRAINT UK_DM UNIQUE (mId);
COMMENT ON TABLE dm IS '디엠';

COMMENT ON COLUMN dm.dmNo IS 'DM방 번호';

COMMENT ON COLUMN dm.mId IS '아이디';

COMMENT ON COLUMN dm.dmDate IS '송수신일';

/*--------------------------8.DM_CONTENTS--------------------------*/
CREATE TABLE dm_contents (
	"DMNO" NUMBER(5,0), 
	"DMCONTENTSNO" NUMBER(10,0), 
	"DMCONTENTSMESSAGE" VARCHAR2(300), 
	"DMCONTENTSDATE" DATE DEFAULT sysdate, 
	"DMSENDERID" VARCHAR2(100), 
	"DMCONTENTSIMAGE" VARCHAR2(100), 
	"DMCHATREAD" NUMBER(1,0)
);

ALTER TABLE dm_contents ADD CONSTRAINT PK_DM_CONTENTS PRIMARY KEY (dmNo);

COMMENT ON COLUMN DM_CONTENTS.DMNO IS 'DM방번호';
COMMENT ON COLUMN DM_CONTENTS.DMCONTENTSNO IS 'DM번호';
COMMENT ON COLUMN DM_CONTENTS.DMCONTENTSMESSAGE IS 'DM내용(채팅내용)';
COMMENT ON COLUMN DM_CONTENTS.DMCONTENTSDATE IS '송수신시간';
COMMENT ON COLUMN DM_CONTENTS.DMSENDERID IS '송신자아이디';
COMMENT ON COLUMN DM_CONTENTS.DMCONTENTSIMAGE IS '유저이미지';

/***********************************SEQUENCE********************************/
drop sequence comments_number_seq;
create sequence comments_number_seq start with 1 INCREMENT BY 1;
drop sequence post_number_seq;
create sequence post_number_seq start with 1 INCREMENT BY 1;
drop sequence dm_number_seq;
create sequence dm_number_seq start with 1 INCREMENT BY 1;
drop sequence follow_followingCount_seq;
create sequence follow_followingCount_seq start with 1 INCREMENT BY 1;
drop sequence follow_followerCount_seq;
create sequence follow_followerCount_seq start with 1 INCREMENT BY 1;

commit;

/******************Default Value set for each Table Columns******************/
ALTER TABLE post MODIFY (pViewCount DEFAULT 0);   
ALTER TABLE post MODIFY (pDate DEFAULT sysdate);       
ALTER TABLE comments MODIFY (cTime DEFAULT sysdate);   
ALTER TABLE dm MODIFY (dmDate DEFAULT sysdate);  
ALTER TABLE dm_contents MODIFY (DMCONTENTSDATE DEFAULT sysdate);  
commit;

/****************************************************************************/

ALTER TABLE post ADD CONSTRAINT FK_mId_TO_Post FOREIGN KEY (mId)
REFERENCES member (mId);

ALTER TABLE post_image ADD CONSTRAINT FK_Post_TO_POST_Image FOREIGN KEY (pNo)
REFERENCES post (pNo);

ALTER TABLE follow ADD CONSTRAINT FK_mId_TO_Follow FOREIGN KEY (mId)
REFERENCES member (mId);

ALTER TABLE likes ADD CONSTRAINT FK_mId_TO_Like FOREIGN KEY (mIdYou)
REFERENCES member (mId);

ALTER TABLE comments ADD CONSTRAINT FK_Post_TO_Comments FOREIGN KEY (pNo)
REFERENCES post(pNo);

ALTER TABLE comments ADD CONSTRAINT FK_mId_TO_Comments FOREIGN KEY (mId)
REFERENCES member (mId);

ALTER TABLE dm ADD CONSTRAINT FK_mId_TO_DM FOREIGN KEY (mId)
REFERENCES member(mId);

ALTER TABLE dm_contents ADD CONSTRAINT FK_DM_TO_DM_CONTENTS FOREIGN KEY (dmNo)
REFERENCES dm(dmNo);
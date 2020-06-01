RIRO 
DB 
생성쿼리
최종 수정일
2020-06-01

차재영ㅇㅇ
// 시퀀스는 따로 만들어야합니다.
// 수정사항 : datetime -> date
// 테이블명 긴 것 일부 줄임 
// 다지우는 쿼리 SELECT 'DROP TABLE "' || TABLE_NAME || '" CASCADE CONSTRAINTS;' FROM user_tables;
이밑에서부터 끝까지 복사해서 붙여넣기
//06.01 이경준 상세카테고리 테이블, 상품테이블에 상세카테고리fk 추가


-- 유저테이블
CREATE TABLE r_user (
		r_id NUMBER primary key,
		userid VARCHAR2(50) NOT NULL ,
		userpw VARCHAR2(50) NULL,
		username VARCHAR2(50) NOT NULL,
		gender CHAR(1) NULL,
		birth DATE NULL,
		nickname VARCHAR2(50) NULL unique,
		profile CLOB NULL,
		phone VARCHAR2(30) NULL,
		joindate date DEFAULT sysdate,
		addr CLOB NULL,
		addr2 CLOB NULL,
		point NUMBER DEFAULT 0,
		role CHAR(1) NULL
);

-- 회사정보
CREATE TABLE company (
		c_id number(10) NOT NULL primary key,
		r_id NUMBER NULL,
		c_name VARCHAR2(100) NOT NULL,
		c_content CLOB NOT NULL,
		c_reader VARCHAR2(50) NOT NULL,
		c_phone VARCHAR2(30) NOT NULL,
		c_program VARCHAR2(50) NOT NULL,
		c_category VARCHAR2(20) NOT NULL,
		c_startdate DATE NULL,
		c_enddate DATE NULL,
		c_budget NUMBER NOT NULL,
		c_confirm CHAR(1) NULL
);

-- 프로그램
CREATE TABLE program (
		program_id NUMBER primary key,
		p_name VARCHAR2(50) NOT NULL,
		p_image CLOB NOT NULL,
		p_category VARCHAR2(20) NOT NULL
);
-- 프로그램 관리자 
CREATE TABLE p_manager (
		r_id NUMBER NULL,
		program_id NUMBER NULL
);

-- 프로그램관리자
ALTER TABLE p_manager
	ADD CONSTRAINT FK_r_user_TO_p_manager 
	FOREIGN KEY (
		r_id 
	)
	REFERENCES r_user ( 
		r_id 
	);

-- 오디션심사위원
CREATE TABLE judge (
		judge_id NUMBER primary key,
		program_id NUMBER NULL,
		r_id NUMBER NULL
);

-- 오디션심사위원
ALTER TABLE judge
	ADD CONSTRAINT FK_program_TO_judge 
	FOREIGN KEY (
		program_id
	)
	REFERENCES program ( 
		program_id 
	);



-- 심사범위
CREATE TABLE judge_range (
		judge_id NUMBER NULL,
		judge_start NUMBER NULL,
		judge_end NUMBER NULL
);

-- 심사범위
ALTER TABLE judge_range
	ADD CONSTRAINT FK_judge_TO_judge_range 
	FOREIGN KEY (
		judge_id 
	)
	REFERENCES judge ( 
		judge_id 
	);

-- 인기인/후보자게시판
CREATE TABLE popular (
		popular_id NUMBER primary key,
		p_name VARCHAR2(50) NULL,
		p_image CLOB NULL,
		program_id NUMBER NULL
);
-- 인기인/후보자게시판
ALTER TABLE popular
	ADD CONSTRAINT FK_program_TO_popular 
	FOREIGN KEY (
		program_id 
	)
	REFERENCES program ( 
		program_id 
	);

-- 인기인글
CREATE TABLE popular_board (
		p_id NUMBER primary key,
		popular_id NUMBER NULL,
		p_title VARCHAR2(50) NOT NULL,
		p_content CLOB NOT NULL,
		p_date DATE default sysdate,
		p_mdate DATE NULL,
		p_view_count NUMBER default 0,
		p_reply_count NUMBER default 0,
		r_id NUMBER NULL
);

-- 인기인글
ALTER TABLE popular_board
	ADD CONSTRAINT FK_popular_TO_popular_board -- 인기인/후보자게시판 -> 인기인글
	FOREIGN KEY (
		popular_id -- 인기인번호
	)
	REFERENCES popular ( -- 인기인/후보자게시판
		popular_id -- 인기인번호
	);

-- 인기인글
ALTER TABLE popular_board
	ADD CONSTRAINT FK_r_user_TO_popular_board 
	FOREIGN KEY (
		r_id
	)
	REFERENCES r_user ( 
		r_id 
	);

 
-- 방송
		CREATE TABLE broadcast (
		broadcast_id NUMBER primary key,
		b_name VARCHAR2(50) NOT NULL,
		b_round NUMBER NULL,
		program_id NUMBER NULL
);

-- 방송
ALTER TABLE broadcast
	ADD CONSTRAINT FK_program_TO_broadcast 
	FOREIGN KEY (
		program_id 
	)
	REFERENCES program ( 
		program_id
	);


-- 주간핫클립
CREATE TABLE hotclib (
		hotclib_id NUMBER primary key,
		h_title VARCHAR2(50) NULL,
		h_content CLOB NULL,
		h_date date default sysdate,
		h_mdate date NULL,
		h_view_count NUMBER default 0,
		h_reply_count NUMBER default 0,
		h_reply CHAR(1) NULL,
		broadcast_id NUMBER NULL,
		r_id NUMBER NULL
);
    
-- 주간핫클립
ALTER TABLE hotclib
	ADD CONSTRAINT FK_broadcast_TO_hotclib -- 방송 -> 주간핫클립
	FOREIGN KEY (
		broadcast_id -- 방송번호
	)
	REFERENCES broadcast ( -- 방송
		broadcast_id -- 방송번호
	);

-- 주간핫클립
ALTER TABLE hotclib
	ADD CONSTRAINT FK_r_user_TO_hotclib -- 회원 -> 주간핫클립
	FOREIGN KEY (
		r_id -- 회원번호
	)
	REFERENCES r_user ( -- 회원
		r_id -- 회원번호
	);

-- 댓글
CREATE TABLE reply (
		reply_id NUMBER primary key,
		r_content CLOB NOT NULL,
		r_date DATE NULL,
		hotclib_id NUMBER NULL,
		p_id NUMBER NULL,
		depth NUMBER NULL,
		r_id NUMBER NULL
);

-- 댓글
ALTER TABLE reply
	ADD CONSTRAINT FK_hotclib_TO_reply 
	FOREIGN KEY (
		hotclib_id 
	)
	REFERENCES hotclib ( 
		hotclib_id
	);

-- 댓글
ALTER TABLE reply
	ADD CONSTRAINT FK_popular_board_TO_reply 
	FOREIGN KEY (
		p_id
	)
	REFERENCES popular_board ( 
		p_id 
	);

-- 댓글
ALTER TABLE reply
	ADD CONSTRAINT FK_reply_TO_reply 
	FOREIGN KEY (
		depth 
	)
	REFERENCES reply ( 
		reply_id 
	);


-- 댓글
ALTER TABLE reply
	ADD CONSTRAINT FK_r_user_TO_reply -- 회원 -> 댓글
	FOREIGN KEY (
		r_id -- 회원번호
	)
	REFERENCES r_user ( -- 회원
		r_id -- 회원번호
	);
    
-- 방청권응모글
CREATE TABLE b_apply (
		apply_id NUMBER primary key,
		a_title VARCHAR2(50) NOT NULL,
		a_content CLOB NOT NULL,
		a_date date default sysdate,
		a_mdate date NULL,
		a_view_count NUMBER default 0,
		a_recruits NUMBER NULL,
		a_view CHAR(1) NULL,
		a_limit NUMBER NULL,
		a_startdate DATE NULL,
		a_enddate DATE NULL,
		r_id NUMBER NULL,
		a_price NUMBER NULL,
		broadcast_id NUMBER NULL
);    
    
-- 방청권응모글
ALTER TABLE b_apply
	ADD CONSTRAINT FK_broadcast_TO_b_apply -- 방송 -> 방청권응모글
	FOREIGN KEY (
		broadcast_id -- 방송번호
	)
	REFERENCES broadcast ( -- 방송
		broadcast_id -- 방송번호
	);    

-- 방청권응모글
ALTER TABLE b_apply
	ADD CONSTRAINT FK_r_user_TO_b_apply -- 회원 -> 방청권응모글
	FOREIGN KEY (
		r_id -- 회원번호
	)
	REFERENCES r_user ( -- 회원
		r_id -- 회원번호
	);
 
-- 첨부파일
CREATE TABLE r_file (
		hotclib_id NUMBER NULL,
		apply_id NUMBER NULL,
		p_id NUMBER NULL,
		filename CLOB NULL
);

-- 첨부파일
ALTER TABLE r_file
	ADD CONSTRAINT FK_hotclib_TO_r_file -- 주간핫클립 -> 첨부파일
	FOREIGN KEY (
		hotclib_id -- 핫클립글번호
	)
	REFERENCES hotclib ( -- 주간핫클립
		hotclib_id -- 핫클립글번호
	);

-- 첨부파일
ALTER TABLE r_file
	ADD CONSTRAINT FK_b_apply_TO_r_file -- 방청권응모글 -> 첨부파일
	FOREIGN KEY (
		apply_id -- 응모글번호
	)
	REFERENCES b_apply ( -- 방청권응모글
		apply_id -- 응모글번호
	);

-- 첨부파일
ALTER TABLE r_file
	ADD CONSTRAINT FK_popular_board_TO_r_file -- 인기인글 -> 첨부파일
	FOREIGN KEY (
		p_id -- 인기인글번호
	)
	REFERENCES popular_board ( -- 인기인글
		p_id -- 인기인글번호
	);


-- 방청권응모내역
CREATE TABLE a_detail (
		apply_id NUMBER NOT NULL,
		r_id NUMBER NOT NULL,
		confirm CHAR(1) NULL
);    

-- 방청권응모내역
ALTER TABLE a_detail
	ADD CONSTRAINT FK_b_apply_TO_a_detail -- 방청권응모글 -> 방청권응모내역
	FOREIGN KEY (
		apply_id -- 응모글번호
	)
	REFERENCES b_apply ( -- 방청권응모글
		apply_id -- 응모글번호
	);

-- 방청권응모내역
ALTER TABLE a_detail
	ADD CONSTRAINT FK_r_user_TO_a_detail -- 회원 -> 방청권응모내역
	FOREIGN KEY (
		r_id -- 회원번호
	)
	REFERENCES r_user ( -- 회원
		r_id -- 회원번호
	);
    
  -- 해시태그
CREATE TABLE hashtag (
		popular_id NUMBER NULL,
		hotclib_id NUMBER NULL,
		hashtag CLOB NULL
);
 
 
 -- 해시태그
ALTER TABLE hashtag
	ADD CONSTRAINT FK_popular_TO_hashtag -- 인기인/후보자게시판 -> 해시태그
	FOREIGN KEY (
		popular_id -- 인기인번호
	)
	REFERENCES popular ( -- 인기인/후보자게시판
		popular_id -- 인기인번호
	);

-- 해시태그
ALTER TABLE hashtag
	ADD CONSTRAINT FK_hotclib_TO_hashtag -- 주간핫클립 -> 해시태그
	FOREIGN KEY (
		hotclib_id -- 핫클립글번호
	)
	REFERENCES hotclib ( -- 주간핫클립
		hotclib_id -- 핫클립글번호
	); 
    
    -- 오디션홍보글
CREATE TABLE audition (
		audition_id NUMBER primary key,
		a_title VARCHAR2(50) NOT NULL,
		a_category VARCHAR2(50) NOT NULL,
		a_startdate DATE NOT NULL,
		a_enddate DATE NOT NULL,
		a_recruits NUMBER NOT NULL,
		a_issue DATE NOT NULL,
		program_id NUMBER NULL,
		r_id NUMBER NULL
);

-- 오디션홍보글
ALTER TABLE audition
	ADD CONSTRAINT FK_r_user_TO_audition -- 회원 -> 오디션홍보글
	FOREIGN KEY (
		r_id -- 회원번호
	)
	REFERENCES r_user ( -- 회원
		r_id -- 회원번호
	);

-- 오디션홍보글
ALTER TABLE audition
	ADD CONSTRAINT FK_program_TO_audition -- 프로그램 -> 오디션홍보글
	FOREIGN KEY (
		program_id -- 프로그램번호
	)
	REFERENCES program ( -- 프로그램
		program_id -- 프로그램번호
	);
    
 

-- 오디션신청/심사내역
CREATE TABLE audition_con (
		form_id NUMBER primary key,
		f_title VARCHAR2(50) NOT NULL,
		f_profile VARCHAR2(50) NOT NULL,
		f_addr CLOB NOT NULL,
		f_addr2 CLOB NOT NULL,
		f_education CLOB NOT NULL,
		f_gender CHAR(1) NOT NULL,
		f_height VARCHAR2(3) NOT NULL,
		f_weight VARCHAR2(3) NOT NULL,
		f_blood VARCHAR2(1) NOT NULL,
		f_family CLOB NOT NULL,
		f_hobby CLOB NOT NULL,
		f_ability CLOB NOT NULL,
		f_carrer CLOB NULL,
		f_motive CLOB NULL,
		f_category VARCHAR2(10) NULL,
		f_introduction CLOB NULL,
		f_job VARCHAR2(20) NULL,
		confirm CHAR(1) NULL,
		r_id NUMBER NULL,
		audition_id NUMBER NULL
);

-- 오디션신청/심사내역
ALTER TABLE audition_con
	ADD CONSTRAINT FK_audition_TO_audition_con
	FOREIGN KEY (
		audition_id -- 오디션홍보글번호
	)
	REFERENCES audition ( -- 오디션홍보글
		audition_id -- 오디션홍보글번호
	);


-- 오디션신청/심사내역
ALTER TABLE audition_con
	ADD CONSTRAINT FK_r_user_TO_audition_con
-- 회원 -> 오디션신청/심사내역
	FOREIGN KEY (
		r_id -- 회원번호
	)
	REFERENCES r_user ( -- 회원
		r_id -- 회원번호
	);


-- 상품카테고리번호
CREATE TABLE product_category (
		category_id NUMBER primary key,
		category VARCHAR2(50) NOT NULL
);


 -- 상품
CREATE TABLE product (
		product_id NUMBER primary key,
		program_id NUMBER NULL,
		category_id NUMBER NULL,
		p_name VARCHAR2(100) NOT NULL,
		p_price NUMBER NOT NULL,
		p_content CLOB NOT NULL,
		p_detail CLOB NULL,
		p_upload TIMESTAMP NOT NULL,
		p_state CHAR(1) NOT NULL,
		p_enddate DATE NULL,
		p_manager NUMBER NOT NULL,
		r_id NUMBER NULL
);
-- 상품
ALTER TABLE product
	ADD CONSTRAINT FK_program_TO_product -- 프로그램 -> 상품
	FOREIGN KEY (
		program_id -- 프로그램번호
	)
	REFERENCES program ( -- 프로그램
		program_id -- 프로그램번호
	);

-- 상품
ALTER TABLE product
	ADD CONSTRAINT FK_r_user_TO_product -- 회원 -> 상품
	FOREIGN KEY (
		r_id -- 회원번호
	)
	REFERENCES r_user ( -- 회원
		r_id -- 회원번호
	);


-- 상품
ALTER TABLE product
	ADD CONSTRAINT FK_product_category_TO_product -- 상품카테고리번호 -> 상품
	FOREIGN KEY (
		category_id -- 카테고리번호
	)
	REFERENCES product_category ( -- 상품카테고리번호
		category_id -- 카테고리번호
	);   
    
 
 -- 상품이미지
CREATE TABLE product_image (
		product_id NUMBER primary key,
		product_image CLOB NOT NULL,
		image_state CHAR(1) NOT NULL
);   

-- 사이즈
CREATE TABLE p_size (
		size_id NUMBER primary key,
		p_size VARCHAR2(10) NOT NULL
);

-- 색상
CREATE TABLE p_color (
		color_id NUMBER primary key,
		p_color VARCHAR2(10) NOT NULL
);

-- 상세옵션
CREATE TABLE product_option (
		option_id VARCHAR2(300) primary key,
		product_id NUMBER NOT NULL,
		size_id NUMBER NULL,
		color_id NUMBER NULL,
		p_stock NUMBER NOT NULL
);

-- 상세옵션
ALTER TABLE product_option
	ADD CONSTRAINT FK_product_TO_product_option -- 상품 -> 상세옵션
	FOREIGN KEY (
		product_id -- 상품번호
	)
	REFERENCES product ( -- 상품
		product_id -- 상품번호
	);

-- 상세옵션
ALTER TABLE product_option
	ADD CONSTRAINT FK_p_size_TO_product_option -- 사이즈 -> 상세옵션
	FOREIGN KEY (
		size_id -- 사이즈코드
	)
	REFERENCES p_size ( -- 사이즈
		size_id -- 사이즈코드
	);

-- 상세옵션
ALTER TABLE product_option
	ADD CONSTRAINT FK_p_color_TO_product_option -- 색상 -> 상세옵션
	FOREIGN KEY (
		color_id -- 색상코드
	)
	REFERENCES p_color ( -- 색상
		color_id -- 색상코드
	);

    CREATE TABLE r_order (
		order_id NUMBER primary key,
		r_id NUMBER NULL,
		reciever VARCHAR2(50) NULL,
		addr CLOB NOT NULL,
		addr2 CLOB NULL,
		phone VARCHAR2(30) NULL,
		invoice VARCHAR2(100) NULL,
		oraderdate TIMESTAMP NULL,
		state CHAR(1) NULL,
		price NUMBER NULL
);    
    
    
-- 주문
ALTER TABLE r_order
	ADD CONSTRAINT FK_r_user_TO_r_order -- 회원 -> 주문
	FOREIGN KEY (
		r_id -- 회원번호
	)
	REFERENCES r_user ( -- 회원
		r_id -- 회원번호
	);
    
  -- 주문상세
CREATE TABLE orderlist (
		orderlist_id NUMBER primary key,
		option_id VARCHAR2(300) NULL,
		order_id NUMBER NULL,
		count NUMBER NOT NULL,
		price NUMBER NOT NULL
);  

-- 주문상세
ALTER TABLE orderlist
	ADD CONSTRAINT FK_product_option_TO_orderlist -- 상세옵션 -> 주문상세
	FOREIGN KEY (
		option_id -- 옵션번호
	)
	REFERENCES product_option ( -- 상세옵션
		option_id -- 옵션번호
	);

-- 주문상세
ALTER TABLE orderlist
	ADD CONSTRAINT FK_r_order_TO_orderlist -- 주문 -> 주문상세
	FOREIGN KEY (
		order_id -- 주문번호
	)
	REFERENCES r_order ( -- 주문
		order_id -- 주문번호
	);

-- vote
CREATE TABLE vote (
		voteid NUMBER primary key,
		title VARCHAR2(50) NOT NULL,
		writer VARCHAR2(50) NOT NULL,
		address CLOB NULL,
		count NUMBER NULL
);

-- candidate
CREATE TABLE candidate (
		id NUMBER primary key,
		voteid NUMBER NULL,
		name VARCHAR2(50) NOT NULL,
		img CLOB NOT NULL
);

-- candidate
ALTER TABLE candidate
	ADD CONSTRAINT FK_vote_TO_candidate -- vote -> candidate
	FOREIGN KEY (
		voteid -- 투표 id
	)
	REFERENCES vote ( -- vote
		voteid -- 투표 id
	);
   
    
-- voter
CREATE TABLE voter (
		id NUMBER primary key,
		voteid NUMBER NULL,
		userid VARCHAR2(50) NOT NULL,
		state NUMBER NULL,
		hash CLOB NULL
);

-- voter
ALTER TABLE voter
	ADD CONSTRAINT FK_vote_TO_voter -- vote -> voter
	FOREIGN KEY (
		voteid -- 투표 id
	)
	REFERENCES vote ( -- vote
		voteid -- 투표 id
	);        
-- voter
CREATE TABLE voter (
		id NUMBER primary key,
		voteid NUMBER NULL,
		userid VARCHAR2(50) NOT NULL,
		state NUMBER NULL,
		hash CLOB NULL
);

-- product_category_d
CREATE TABLE PRODUCT_CATEGORY_D"(	
	"CATEGORY_D_ID" NUMBER, 
	"CATEGORY_D" VARCHAR2(50), 
	"CATEGORY" NUMBER
   )


--------------------------------------------------------
--  파일이 생성됨 - 월요일-6월-01-2020   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PRODUCT_CATEGORY_D
--------------------------------------------------------

  CREATE TABLE "PRODUCT_CATEGORY_D" ("CATEGORY_D_ID" NUMBER, "CATEGORY_D" VARCHAR2(50), "CATEGORY" NUMBER)
--------------------------------------------------------
--  DDL for Index PRODUCT_CATEGORY_D_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "PRODUCT_CATEGORY_D_PK" ON "PRODUCT_CATEGORY_D" ("CATEGORY_D_ID")
--------------------------------------------------------
--  Constraints for Table PRODUCT_CATEGORY_D
--------------------------------------------------------

  ALTER TABLE "PRODUCT_CATEGORY_D" MODIFY ("CATEGORY_D" NOT NULL ENABLE)
  ALTER TABLE "PRODUCT_CATEGORY_D" ADD CONSTRAINT "PRODUCT_CATEGORY_D_PK" PRIMARY KEY ("CATEGORY_D_ID") ENABLE
  ALTER TABLE "PRODUCT_CATEGORY_D" MODIFY ("CATEGORY_D_ID" NOT NULL ENABLE)
--------------------------------------------------------
--  Ref Constraints for Table PRODUCT_CATEGORY_D
--------------------------------------------------------

  ALTER TABLE "PRODUCT_CATEGORY_D" ADD CONSTRAINT "PRODUCT_CATEGORY_D_FK1" FOREIGN KEY ("CATEGORY") REFERENCES "PRODUCT_CATEGORY" ("CATEGORY_ID") ENABLE

--------------------------------------------------------
--  Add Column for Table PRODUCT
--------------------------------------------------------
ALTER TABLE "PRODUCT_CATEGORY_D" ADD("PRODUCT_CATEGORY_D" NUMBER);
--------------------------------------------------------
--  Ref Constraints for Table PRODUCT
--------------------------------------------------------
ALTER TABLE "PRODUCT" ADD CONSTRAINT "FK_PRD_CATE_D_TO_PRODUCT" FOREIGN KEY ("PRODUCT_CATEGORY_D") REFERENCES "PRODUCT_CATEGORY_D" ("CATEGORY_D_ID") ENABLE
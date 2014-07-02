

/* Create Tables */

CREATE TABLE FOLLOW
(
	FOLLOW_ID INT(100) NOT NULL UNIQUE AUTO_INCREMENT COMMENT 'フォローID',
	YOU_ID INT(100) NOT NULL UNIQUE COMMENT 'フォローする人のID : 会員のID
',
	MEMBER_ID INT(100) NOT NULL COMMENT 'フォローされる人のID : フォローしている自分のID
',
	INS_DATETIME DATETIME NOT NULL COMMENT 'insert日時',
	UPD_DATETIME DATETIME NOT NULL COMMENT 'UPD_DATETIME',
	INS_TRACE VARCHAR(256) NOT NULL COMMENT 'Insertトレース',
	UPD_TRACE VARCHAR(256) NOT NULL COMMENT 'UPD トレース',
	DEL_FLG CHAR(1) DEFAULT 'N' NOT NULL COMMENT 'DEL_FLG : 削除フラグ Y=削除　N=削除していない',
	PRIMARY KEY (FOLLOW_ID)
) COMMENT = 'フォロー';


CREATE TABLE LOGIN
(
	LOGIN_ID INT NOT NULL AUTO_INCREMENT COMMENT 'ログインID : ログインした瞬間のID
',
	MEMBER_ID INT(100) NOT NULL COMMENT '会員ID : 会員のID
',
	INS_DATETIME DATETIME NOT NULL COMMENT 'insert日時',
	UPD_DATETIME DATETIME NOT NULL COMMENT 'UPD_DATETIME',
	INS_TRACE VARCHAR(256) NOT NULL COMMENT 'Insertトレース',
	UPD_TRACE VARCHAR(256) NOT NULL COMMENT 'UPD トレース',
	PRIMARY KEY (LOGIN_ID)
) COMMENT = 'ログイン';


CREATE TABLE MEMBER
(
	MEMBER_ID INT(100) NOT NULL UNIQUE AUTO_INCREMENT COMMENT '会員ID : 会員のID
',
	EMAIL_ADDRESS VARCHAR(100) NOT NULL UNIQUE COMMENT 'メールアドレス : 会員のメールアドレス',
	USER_NAME VARCHAR(50) NOT NULL UNIQUE COMMENT '会員ユーザ名 : 会員のユーザ名',
	BIRTHDATE DATE COMMENT '生年月日 : 会員の生年月日',
	PROFILE VARCHAR(200) COMMENT 'プロフィール',
	INS_DATETIME DATETIME NOT NULL COMMENT 'insert日時',
	UPD_DATETIME DATETIME NOT NULL COMMENT 'UPD_DATETIME',
	INS_TRACE VARCHAR(256) NOT NULL COMMENT 'Insertトレース',
	UPD_TRACE VARCHAR(256) NOT NULL COMMENT 'UPD トレース',
	PRIMARY KEY (MEMBER_ID)
) COMMENT = '会員';


CREATE TABLE MEMBER_SECURITY
(
	MEMBER_ID INT(100) NOT NULL UNIQUE COMMENT '会員ID : 会員のID
',
	PASSWORD VARCHAR(50) NOT NULL COMMENT 'パスワード',
	INS_DATETIME DATETIME NOT NULL COMMENT 'insert日時',
	UPD_DATETIME DATETIME NOT NULL COMMENT 'UPD_DATETIME',
	INS_TRACE VARCHAR(256) NOT NULL COMMENT 'Insertトレース',
	UPD_TRACE VARCHAR(256) NOT NULL COMMENT 'UPD トレース',
	PRIMARY KEY (MEMBER_ID)
) COMMENT = '会員セキュリティ';


CREATE TABLE MEMBER_WITHDRAW
(
	MEMBER_ID INT(100) NOT NULL UNIQUE COMMENT '会員ID : 会員のID
',
	WITHDRAWAL_REASON_ID INT COMMENT '退会理由ID : 会員の退会理由ID',
	WITHDRAWAL_REASON_INPUT_TEXT TEXT COMMENT '退会理由入力テキスト',
	WITHDRAWAL_DATETIME DATETIME NOT NULL COMMENT 'withdrawal_datetime : 退会日時',
	PRIMARY KEY (MEMBER_ID)
) COMMENT = '会員退会';


CREATE TABLE TWEET
(
	TWEET_ID INT NOT NULL UNIQUE AUTO_INCREMENT COMMENT 'TWEET_ID',
	MEMBER_ID INT(100) NOT NULL COMMENT '会員ID : tweetした人のID',
	TWEET VARCHAR(140) NOT NULL COMMENT 'TWEET',
	INS_DATETIME DATETIME NOT NULL COMMENT 'insert日時',
	UPD_DATETIME DATETIME NOT NULL COMMENT 'UPD_DATETIME',
	INS_TRACE VARCHAR(256) NOT NULL COMMENT 'Insertトレース',
	UPD_TRACE VARCHAR(256) NOT NULL COMMENT 'UPD トレース',
	TWEET_DATETIME VARCHAR(50) NOT NULL COMMENT 'TWEET日時 : ツィートした日時（共通カラムではなく、画面に表示するためのもの）',
	PRIMARY KEY (TWEET_ID)
) COMMENT = 'TWEET';



/* Create Foreign Keys */

ALTER TABLE FOLLOW
	ADD FOREIGN KEY (YOU_ID)
	REFERENCES MEMBER (MEMBER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE FOLLOW
	ADD FOREIGN KEY (MEMBER_ID)
	REFERENCES MEMBER (MEMBER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE LOGIN
	ADD FOREIGN KEY (MEMBER_ID)
	REFERENCES MEMBER (MEMBER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE MEMBER_SECURITY
	ADD FOREIGN KEY (MEMBER_ID)
	REFERENCES MEMBER (MEMBER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE MEMBER_WITHDRAW
	ADD FOREIGN KEY (MEMBER_ID)
	REFERENCES MEMBER (MEMBER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE TWEET
	ADD FOREIGN KEY (MEMBER_ID)
	REFERENCES MEMBER (MEMBER_ID)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;




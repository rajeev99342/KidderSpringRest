
drop table ki_user_tbl;
drop table ki_kidder_quest_tbl;
drop table ki_txt_quest_tbl;
drop table ki_next_object_id;
drop table ki_dgrm_img_tbl;



create table ki_user_tbl(

	user_id numeric(19,0) NOT NULL,
	user_name varchar(255) NOT NULL,
	user_username varchar(255)  NOT NULL,
	user_password varchar(255)  NOT NULL,
	user_email varchar(255),
	user_phone_number numeric(10,0),
	unique_code varchar(255) NOT NULL,
	delete_fl character(1) NOT NULL,
	CONSTRAINT ki_user_tbl_pk PRIMARY KEY(user_id)

);

create table ki_txt_quest_tbl(

txt_ques_id numeric(19,0) NOT NULL,
ques_txt varchar(5000)  NOT NULL,
delete_fl character(1) NOT NULL,
unique_code varchar(255) NOT NULL,

CONSTRAINT ki_txt_quest_tbl_pk PRIMARY KEY(txt_ques_id)

);

create table ki_kidder_quest_tbl(
	
	ki_kidder_quest_id numeric(19,0) NOT NULL,
	ki_kidder_quest_name varchar(255),
	ki_kidder_quest_optionA varchar(255)  NOT NULL,
	ki_kidder_quest_optionB varchar(255)  NOT NULL,
	ki_kidder_quest_optionC varchar(255)  NOT NULL,
	ki_kidder_quest_optionD varchar(255)  NOT NULL,
	ki_kidder_quest_sub varchar(255)  NOT NULL,
	ki_kidder_quest_topic varchar(255) ,
	ki_kidder_quest_level numeric(3,0),
	ki_kidder_quest_ans varchar(255)  NOT NULL,
	ki_kidder_quest_marks numeric(19,0) NOT NULL,
	user_id numeric(19,0),
	txt_ques_id numeric(19,0),
	unique_code varchar(255) NOT NULL,
	delete_fl character(1) NOT NULL,
	CONSTRAINT ki_kidder_quest_tbl_pk PRIMARY KEY(ki_kidder_quest_id)


);
create table ki_dgrm_img_tbl(
	dgrm_img_id numeric(19,0) NOT NULL,
	dgrm_img_name varchar(255) NOT NULL,
	dgrm_img_path varchar(255) NOT NULL,
	dgrm_img_desc varchar(255),
	dgrm_img_base64 varchar(255),
	delete_fl character(1) NOT NULL,
	unique_code varchar(255) NOT NULL,
	ki_kidder_quest_id numeric(19,0) NOT NULL,
	CONSTRAINT ki_dgrm_img_tbl_PK PRIMARY KEY(dgrm_img_id)
);
create table ki_next_object_id(
	noi_object_name varchar(255),
	noi_current_no numeric(19,0),
	CONSTRAINT ki_next_object_id_pk PRIMARY KEY(noi_object_name)
)
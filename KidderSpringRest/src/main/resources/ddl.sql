drop table ki_user_tbl;
drop table ki_kidder_quest_tbl;
drop table ki_txt_quest_tbl;
drop table ki_next_object_id;
drop table ki_dgrm_img_tbl;
drop table ki_group_tbl;
drop table ki_grp_part_tbl;
drop table ki_quiz_tbl;
drop table ki_user_quest_tbl;

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
	
	kq_id numeric(19,0) NOT NULL,
	kq_name varchar(255),
	quiz_id  numeric(19,0),
	kq_option_a varchar(255)  NOT NULL,
	kq_option_b varchar(255)  NOT NULL,
	kq_option_c varchar(255)  NOT NULL,
	kq_option_d varchar(255)  NOT NULL,
	kq_sub varchar(255) ,
	kq_topic varchar(255) ,
	kq_lvl numeric(3,0),
	kq_ans varchar(255)  NOT NULL,
	kq_marks numeric(19,0) NOT NULL,
	user_id numeric(19,0),
	txt_ques_id numeric(19,0),
	unique_code varchar(255) NOT NULL,
	delete_fl character(1) NOT NULL,
	CONSTRAINT ki_kidder_quest_tbl_pk PRIMARY KEY(kq_id)


);
create table ki_dgrm_img_tbl(
	dgrm_img_id numeric(19,0) NOT NULL,
	dgrm_img_name varchar(255) NOT NULL,
	dgrm_img_path varchar(255) NOT NULL,
	dgrm_img_desc varchar(255),
	dgrm_img_base64 varchar(255),
	delete_fl character(1) NOT NULL,
	unique_code varchar(255) NOT NULL,
	kq_id numeric(19,0) NOT NULL,
	CONSTRAINT ki_dgrm_img_tbl_PK PRIMARY KEY(dgrm_img_id)
);

create table ki_img_tbl(
	img_id numeric(19,0) NOT NULL,
	img_name varchar(255) NOT NULL,
	img_path varchar(255) NOT NULL,
	img_desc varchar(255),
	img_base64 varchar(255),
	delete_fl character(1) NOT NULL,
	unique_code varchar(255) NOT NULL,
	user_quest_id numeric(19,0),
	CONSTRAINT ki_img_tbl_pk PRIMARY KEY(img_id)
);


create table ki_group_tbl(

	grp_id numeric(19,0) NOT NULL,
	grp_name varchar(255) NOT NULL,
	grp_admin varchar(255)  NOT NULL,
	grp_desc varchar(255),
	unique_code varchar(255) NOT NULL,
	delete_fl character(1) NOT NULL,
	CONSTRAINT ki_group_tbl_pk PRIMARY KEY(grp_id)

);

create table ki_grp_part_tbl(

	grp_part_id numeric(19,0) NOT NULL,
	grp_id numeric(19,0) NOT NULL,
	user_id numeric(19,0) NOT NULL,
	is_admin character(1) NOT NULL,
	unique_code varchar(255) NOT NULL,
	delete_fl character(1) NOT NULL,
	CONSTRAINT grp_part_tbl_pk PRIMARY KEY(grp_part_id)

);

create table ki_quiz_tbl(

	quiz_id numeric(19,0) NOT NULL,
	grp_id  numeric(19,0) NOT NULL,
	quiz_name varchar(255) NOT NULL,
	user_id numeric(19,0) NOT NULL,
	quiz_num_of_quest numeric(4,0)  NOT NULL,
	quiz_created_date varchar(255)  NOT NULL,
	quiz_sub varchar(255),
	quiz_published_date varchar(255),
	quiz_duration numeric(4,0),
	quiz_marks numeric(3,0),
	quiz_status numeric(3,0),
	unique_code varchar(255) NOT NULL,
	delete_fl character(1) NOT NULL,
	CONSTRAINT ki_quiz_tbl_pk PRIMARY KEY(quiz_id)

);

create table ki_user_quest_tbl(
	user_quest_id numeric(19,0) NOT NULL,
	quiz_id  numeric(19,0) NOT NULL,
	user_id numeric(19,0) NOT NULL,
	user_quest_name  varchar(255),
	user_quest_optionA varchar(255),
	user_quest_optionB varchar(255),
	user_quest_optionC varchar(255),
	user_quest_optionD varchar(255),
	user_quest_ans varchar(255),
	user_quest_marks numeric(3,0),
	txt_ques_id numeric(19,0),
	unique_code varchar(255) NOT NULL,
	delete_fl character(1) NOT NULL,
	CONSTRAINT ki_user_quest_tbl_pk PRIMARY KEY(user_quest_id)
);

create table ki_next_object_id(
	noi_object_name varchar(255),
	noi_current_no numeric(19,0),
	CONSTRAINT ki_next_object_id_pk PRIMARY KEY(noi_object_name)
)
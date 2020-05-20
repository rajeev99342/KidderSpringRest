drop table grp_part_tbl,ki_dgrm_img_tbl,ki_group_tbl,ki_grp_reqst_tbl,ki_img_tbl,ki_kidder_quest_tbl,ki_next_object_id,ki_quiz_tbl,ki_sub_tbl,ki_topic_tbl,ki_txt_quest_tbl,ki_user_tbl,test_tbl2,user_quest_info_tbl;


drop table ki_next_object_id;
create table ki_next_object_id(
	noi_object_name varchar(255),
	noi_current_no numeric(19,0),
	CONSTRAINT ki_next_object_id_pk PRIMARY KEY(noi_object_name)
)
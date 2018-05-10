create table archm_test_entity_one
(
	id serial not null
		constraint archm_test_entity_one_pkey
			primary key,
	this_is_a_string varchar(32)
)
;


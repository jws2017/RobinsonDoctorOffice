--Remember to add a type for the ROLE field
create table ?.USERS 
	(USERNAME varchar[50] NOT NULL,
	ROLE varchar[20] NOT NULL,
	PASSWORD varchar[50] NOT NULL,
	PRIMARY KEY (USERNAME));
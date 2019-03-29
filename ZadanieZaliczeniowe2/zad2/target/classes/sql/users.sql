create table if not exists
	users (
	username varchar(45) NOT NULL,
	password varchar(45) NOT NULL,
	email varchar(45) NOT NULL UNIQUE,
	usertype varchar(10) NOT NULL, 
	PRIMARY KEY(username)
	);
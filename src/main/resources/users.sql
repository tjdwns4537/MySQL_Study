CREATE SCHEMA study;

use study;

CREATE TABLE users(
                      user_id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
                      user_name varchar(30) NOT NULL,
                      phone_number varchar(30) not null
);

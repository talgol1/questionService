DROP TABLE IF EXISTS customer_order;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS question;
DROP TABLE IF EXISTS answer;

CREATE TABLE customer (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(300) NOT NULL DEFAULT '',
    last_name varchar(300) NOT NULL DEFAULT '',
    email varchar(300) NOT NULL DEFAULT '',
    status varchar(300) NOT NULL DEFAULT 'REGULAR',
    PRIMARY KEY (id)
);


CREATE TABLE customer_order (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    customer_id int(11) unsigned NOT NULL,
    item_name varchar(300) NOT NULL DEFAULT '',
    price int(11) NOT NULL DEFAULT '',
    currency varchar(300) NOT NULL DEFAULT 'USD',
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE student (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(300) NOT NULL DEFAULT '',
    last_name varchar(300) NOT NULL DEFAULT '',
    email varchar(300) NOT NULL DEFAULT '',
    payment_method varchar(300) not NULL,
    PRIMARY KEY (id)
);
CREATE TABLE user (
    id int(11) unsigned NOT NULL AUTO_INCREMENT,
    first_name varchar(300) NOT NULL DEFAULT '',
    last_name varchar(300) NOT NULL DEFAULT '',
    email varchar(300) NOT NULL DEFAULT '',
    age int(3) NOT NULL,
    address varchar(300) NOT NULL DEFAULT '',
    joining_date date NOT NULL,
    PRIMARY KEY (id)

);

CREATE TABLE question (
    id int(11) NOT NULL,
    question varchar(300) NOT NULL DEFAULT '',
    first_answer varchar(300) NOT NULL DEFAULT '',
    second_answer varchar(300) NOT NULL DEFAULT '',
    third_answer varchar(300) NOT NULL DEFAULT '',
    fourth_answer varchar(300) NOT NULL DEFAULT '',
    PRIMARY KEY (id)
);
CREATE TABLE answer (
question_id int(11) NOT NULL,
user_id int(11) NOT NULL,
answer_id int(11) NOT NULL,
CONSTRAINT user_answer PRIMARY KEY (question_id,user_id)
);

INSERT INTO question (id, question, first_answer, second_answer, third_answer, fourth_answer) VALUES (1,'Between the following, what do you most love to do?','Watch TV','Play the computer','Hanging out with friends','Travel the world');
INSERT INTO question (id, question, first_answer, second_answer, third_answer, fourth_answer) VALUES (2,'Where is your preferred place to travel?','USA','France','South America','Thailand');
INSERT INTO question (id, question, first_answer, second_answer, third_answer, fourth_answer) VALUES (3,'What kind of food do you prefer?','Pizza','Falafel','Sushi','Shawarma');

INSERT INTO answer (question_id,user_id,answer_id) VALUES (1,1,1);
INSERT INTO answer (question_id,user_id,answer_id) VALUES (2,1,1);
INSERT INTO answer (question_id,user_id,answer_id) VALUES (3,1,1);
INSERT INTO answer (question_id,user_id,answer_id) VALUES (1,2,1);
INSERT INTO answer (question_id,user_id,answer_id) VALUES (3,2,1);
INSERT INTO answer (question_id,user_id,answer_id) VALUES (1,3,3);
INSERT INTO answer (question_id,user_id,answer_id) VALUES (2,3,3);
INSERT INTO answer (question_id,user_id,answer_id) VALUES (3,3,2);
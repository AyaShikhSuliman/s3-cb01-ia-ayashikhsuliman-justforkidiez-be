CREATE table course
(
    id          int           NOT NULL auto_increment,
    image       varchar(1000) NOT NULL,
    title       varchar(50)   NOT NULL,
    description varchar(500)  NOT NULL,
    primary key (id),
    unique (title)
);

CREATE table lesson
(
    id          int           NOT NULL auto_increment,
    image       varchar(1000) NOT NULL,
    video       varchar(1000) NOT NULL,
    title       varchar(50)   NOT NULL,
    description varchar(500)  NOT NULL,
    course_id   int           NOT NULL,
    status      varchar(50)   NOT NULL,
    primary key (id),
    unique (title),
    FOREIGN KEY (course_id) REFERENCES course (id)
);

CREATE TABLE parent
(
    id            int         NOT NULL auto_increment,
    name          varchar(50) NOT NULL,
    last_name     varchar(50) NOT NULL,
    age           int         NOT NULL,
    phone_number  varchar(50) NOT NULL,
    email_address varchar(50) NOT NULL,
    country       varchar(50) NOT NULL,
    course_id     int,
    PRIMARY KEY (id),
    UNIQUE (name, phone_number, email_address),
    FOREIGN KEY (course_id) REFERENCES course (id)
);

CREATE TABLE coach
(
    id            int         NOT NULL auto_increment,
    name          varchar(50) NOT NULL,
    last_name     varchar(50) NOT NULL,
    age           int         NOT NULL,
    phone_number  varchar(50) NOT NULL,
    email_address varchar(50) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (name, phone_number, email_address)
);

CREATE TABLE user
(
    id        int          NOT NULL auto_increment,
    username  varchar(50)  NOT NULL,
    password  varchar(100) NOT NULL,
    parent_id int NULL,
    coach_id  int NULL,
    PRIMARY KEY (id),
    UNIQUE (username),
    FOREIGN KEY (parent_id) REFERENCES parent (id),
    FOREIGN KEY (coach_id) REFERENCES coach (id)
);

CREATE TABLE user_role
(
    id        int         NOT NULL auto_increment,
    user_id   int         NOT NULL,
    role_name varchar(50) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (user_id, role_name),
    FOREIGN KEY (user_id) REFERENCES user (id)
);
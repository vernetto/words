create user WORDS identified by WORDS;
grant create session to WORDS;
GRANT ALL PRIVILEGES to WORDS;


create table WORDS (ID number(10) not null, WORD VARCHAR2(100) not null);
create table SCANS (ID number(10) not null, FILENAME VARCHAR2(200) not null, SCANDATE  VARCHAR(14) not null) ;
ALTER TABLE WORDS ADD CONSTRAINT WORDS_PK1 PRIMARY KEY (ID);
ALTER TABLE SCANS ADD CONSTRAINT SCANS_PK1 PRIMARY KEY (ID);


create sequence hibernate_sequence START WITH     1000  INCREMENT BY   1   NOCACHE  NOCYCLE;

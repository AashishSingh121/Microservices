INSERT INTO USER_DETAILS(id, birth_date, name)
values (10001, current_date(), 'Range');

INSERT INTO USER_DETAILS(id, birth_date, name)
values (10003, current_date(), 'abe');

INSERT INTO USER_DETAILS(id, birth_date, name)
values (10004, current_date(), 'cape');

INSERT INTO USER_DETAILS(id, birth_date, name)
values (10005, current_date(), 'seb');

INSERT INTO POST(ID,DESCRIPTION,USER_ID)
VALUES(20001,'FSDGSDG',10001);

INSERT INTO POST(ID,DESCRIPTION,USER_ID)
VALUES(20002,'FSSDG',10003);

INSERT INTO POST(ID,DESCRIPTION,USER_ID)
VALUES(20003,'FGSDG',10003);
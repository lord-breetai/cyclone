
insert into country(countryid, name, createdate, version) values (1, 'Bolivia', CURRENT_TIMESTAMP, 1);
insert into country(countryid, name, createdate, version) values (2, 'Japon', CURRENT_TIMESTAMP, 1);

insert into degree(degreeid, name, createdate, version) values (1, 'Beginner', CURRENT_TIMESTAMP, 1);
insert into degree(degreeid, name, createdate, version) values (2, '6th Kyu', CURRENT_TIMESTAMP, 1);
insert into degree(degreeid, name, createdate, version) values (3, '5th Kyu', CURRENT_TIMESTAMP, 1);
insert into degree(degreeid, name, createdate, version) values (4, '4th Kyu', CURRENT_TIMESTAMP, 1);
insert into degree(degreeid, name, createdate, version) values (5, '3rd Kyu', CURRENT_TIMESTAMP, 1);
insert into degree(degreeid, name, createdate, version) values (6, '2nd Kyu', CURRENT_TIMESTAMP, 1);
insert into degree(degreeid, name, createdate, version) values (7, '1st Kyu', CURRENT_TIMESTAMP, 1);
insert into degree(degreeid, name, createdate, version) values (8, '1st Dan', CURRENT_TIMESTAMP, 1);
insert into degree(degreeid, name, createdate, version) values (9, '2nd Dan', CURRENT_TIMESTAMP, 1);
insert into degree(degreeid, name, createdate, version) values (10, '3rd Dan', CURRENT_TIMESTAMP, 1);
insert into degree(degreeid, name, createdate, version) values (11, '4th Dan', CURRENT_TIMESTAMP, 1);
insert into degree(degreeid, name, createdate, version) values (12, '5th Dan', CURRENT_TIMESTAMP, 1);
insert into degree(degreeid, name, createdate, version) values (13, '6th Dan', CURRENT_TIMESTAMP, 1);

insert into person(personid, firstname, lastname, birthcountryid, createdate, version) values (1, 'Ivan', 'Alban', 1, CURRENT_TIMESTAMP, 1);

-- pwd:12345678
insert into user(userid, username, password, personid, createdate, version) values (1, 'ivan', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1, CURRENT_TIMESTAMP, 1);

insert into sequence(tablename, pkvalue) values ('country', 20);
insert into sequence(tablename, pkvalue) values ('person', 10);
insert into sequence(tablename, pkvalue) values ('user', 10);
insert into sequence(tablename, pkvalue) values ('degree', 20);
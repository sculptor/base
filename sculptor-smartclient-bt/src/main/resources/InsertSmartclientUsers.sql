delete from USERS;
insert into USERS ( ID, USERNAME, PASSWORD, ENABLED, EXPIREAT, CREATEDDATE, CREATEDBY, LASTUPDATED, LASTUPDATEDBY, VERSION, SELECTEDLANGUAGE) values (1, 'user', 'a5700387a0b64f00ff5fe28ee22eb088c2f684a7ad9645d231bdac76b9456c7f', TRUE, {ts '2012-01-01 1:1:1'}, {ts '2009-01-01 1:1:1'}, 'system', {ts '2009-01-01 1:1:1'}, 'system', 0, 'en');
insert into USERS ( ID, USERNAME, PASSWORD, ENABLED, EXPIREAT, CREATEDDATE, CREATEDBY, LASTUPDATED, LASTUPDATEDBY, VERSION, SELECTEDLANGUAGE) values (2, 'admin', 'a4a88c0872bf652bb9ed803ece5fd6e82354838a9bf59ab4babb1dab322154e1', TRUE, {ts '2012-01-01 1:1:1'}, {ts '2009-01-01 1:1:1'}, 'system', {ts '2009-01-01 1:1:1'}, 'system', 0, 'en');

delete from ROLES;
insert into ROLES (ID, ROLENAME, CREATEDDATE, CREATEDBY, LASTUPDATED, LASTUPDATEDBY, VERSION) values (1, 'ROLE_USER', {ts '2009-01-01 1:1:1'}, 'system', {ts '2009-01-01 1:1:1'}, 'system', 0);
insert into ROLES (ID, ROLENAME, CREATEDDATE, CREATEDBY, LASTUPDATED, LASTUPDATEDBY, VERSION) values (2, 'ROLE_ADMIN', {ts '2009-01-01 1:1:1'}, 'system', {ts '2009-01-01 1:1:1'}, 'system', 0);

delete from ROLE_USERS;
-- Roles for user
insert into ROLE_USERS (USERS, ROLE) values (1, 1);
-- Roles for admin
insert into ROLE_USERS (USERS, ROLE) values (2, 1);
insert into ROLE_USERS (USERS, ROLE) values (2, 2);

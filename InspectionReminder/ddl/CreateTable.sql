--SET SCHEMA IR;

--DROP TABLE USER;
create table USER (
   ID                int(11)                not null AUTO_INCREMENT,
   USERID            VARCHAR(20)            not null UNIQUE,
   NAME              VARCHAR(60)            not null,
   PASSWORD          CHAR(60)               not null,
   ROLE_ID			 int(11)                not null,
   UPDATER           VARCHAR(20)            not null,
   UPDATETIME        TIMESTAMP        default CURRENT_TIMESTAMP,   
   constraint P_USER primary key (ID)
);




-- ====================================
-- 角色資料檔
-- ====================================
--DROP TABLE ROLE;
create table ROLE (
   ID                int(11)                not null AUTO_INCREMENT,
   ROLEID            VARCHAR(10)            not null UNIQUE,
   ROLENAME          VARCHAR(60)            not null,
   ROLELEVEL         INTEGER(1)             not null,   
   constraint P_ROLE primary key (ID)
);
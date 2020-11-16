/*==============================================================*/
/* DBMS name:      PostgreSQL 8                                 */
/* Created on:     15/11/2020 17:33:20                          */
/*==============================================================*/

create sequence SPNS_TICKET;

/*==============================================================*/
/* Table: SPNT_TICKETCATALOGUE                                  */
/*==============================================================*/
create table SPNT_TICKETCATALOGUE (
   REFERENCECODE        VARCHAR(6)           not null,
   NAME                 VARCHAR(50)          not null,
   STATUS               CHAR                 not null,
   TYPE                 VARCHAR(3)           null,
   constraint PK_SPNT_TICKETCATALOGUE primary key (REFERENCECODE)
);

/*==============================================================*/
/* Table: SPNT_TICKETS                                          */
/*==============================================================*/
create table SPNT_TICKETS (
   TICKETID             INT8                 not null,
   REFERENCECODE        VARCHAR(32)          not null,
   DESCRIPTION          VARCHAR(256)         not null,
   TICKETSTATE          VARCHAR(6)           null,
   USERID               VARCHAR(32)          null,
   TICKETPRIORITY       VARCHAR(6)           null,
   TICKETDEALTYPE       VARCHAR(6)           null,
   DUEDATE              TIMESTAMP            not null,
   STATUS               CHAR                 not null,
   constraint PK_SPNT_TICKETS primary key (TICKETID)
);

/*==============================================================*/
/* Table: SPNT_USER                                             */
/*==============================================================*/
create table SPNT_USER (
   USERID               VARCHAR(32)          not null,
   USERNAME             VARCHAR(64)          not null,
   MAIL                 VARCHAR(32)          not null,
   constraint PK_SPNT_USER primary key (USERID)
);

alter table SPNT_TICKETS
   add constraint FK_SPNT_TIC_REFERENCE_SPNT_USE foreign key (USERID)
      references SPNT_USER (USERID)
      on delete restrict on update restrict;

alter table SPNT_TICKETS
   add constraint SPNPK_TIC_FK_DEALTYPE foreign key (TICKETDEALTYPE)
      references SPNT_TICKETCATALOGUE (REFERENCECODE)
      on delete restrict on update restrict;

alter table SPNT_TICKETS
   add constraint SPNPK_TIC_FK_PRORITY foreign key (TICKETPRIORITY)
      references SPNT_TICKETCATALOGUE (REFERENCECODE)
      on delete restrict on update restrict;

alter table SPNT_TICKETS
   add constraint SPNPK_TIC_FK_STATE foreign key (TICKETSTATE)
      references SPNT_TICKETCATALOGUE (REFERENCECODE)
      on delete restrict on update restrict;


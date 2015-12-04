drop table if exists CATEGORIA_JOYA;

drop table if exists DATOS_PERSONALES;

drop table if exists JOYA;

drop table if exists MOVIMIENTO;

drop table if exists PUJA;

drop table if exists SUBASTA;

drop table if exists SUSCRIBCION_SUBASTA;

drop table if exists SUSCRIBCION_VENDEDOR;

drop table if exists USUARIO;

/*==============================================================*/
/* Table: CATEGORIA_JOYA                                        */
/*==============================================================*/
create table CATEGORIA_JOYA
(
   CATEGORIA_ID         int not null,
   NOMBRE               varchar(32),
   DESCRIPCION          varchar(1024),
   primary key (CATEGORIA_ID)
);

/*==============================================================*/
/* Table: DATOS_PERSONALES                                      */
/*==============================================================*/
create table DATOS_PERSONALES
(
   IDENTIFICADOR        varchar(15) not null,
   NICK                 char(10),
   RAZON_SOCIAL         varchar(64),
   SEXO                 varchar(1),
   DIRECCION            varchar(128),
   TELEFONO             varchar(10),
   FECHA_NACIMIENTO     date,
   EMAIL                varchar(128),
   primary key (IDENTIFICADOR)
);

/*==============================================================*/
/* Table: JOYA                                                  */
/*==============================================================*/
create table JOYA
(
   JOYA_ID              int not null,
   CATEGORIA_ID         int,
   NOMBRE               varchar(64),
   IMAGEN               varchar(128),
   DESCRIPCION          varchar(1024),
   primary key (JOYA_ID)
);

/*==============================================================*/
/* Table: MOVIMIENTO                                            */
/*==============================================================*/
create table MOVIMIENTO
(
   MOVIMIENTO_ID        int not null,
   NICK                 varchar(32),
   MONTO                decimal(8,2),
   SALDO                decimal(8,2),
   FECHA_MOVIMIENTO     datetime,
   primary key (MOVIMIENTO_ID)
);

/*==============================================================*/
/* Table: PUJA                                                  */
/*==============================================================*/
create table PUJA
(
   SUSCRUBCION_ID       int not null,
   MOVIMIENTO_ID        int,
   PUJA_ID              char(10),
   MONTO                decimal(8,2),
   FECHA                char(10),
   ORDEN_PUJA           int,
   primary key (SUSCRUBCION_ID)
);

/*==============================================================*/
/* Table: SUBASTA                                               */
/*==============================================================*/
create table SUBASTA
(
   SUBASTA_ID           int not null,
   SUSCRIBICION_VENDEDOR_ID int,
   JOYA_ID              int,
   MOVIMIENTO_ID        int,
   PRECIO_BASE          decimal(8,2),
   MONTO_FINAL          decimal(8,2),
   FECHA_INICIO         datetime,
   FECHA_FIN            datetime,
   CATEGORIA            varchar(1),
   TIEMPO               time,
   primary key (SUBASTA_ID)
);

/*==============================================================*/
/* Table: SUSCRIBCION_SUBASTA                                   */
/*==============================================================*/
create table SUSCRIBCION_SUBASTA
(
   SUSCRUBCION_ID       int not null,
   NICK                 varchar(32),
   SUBASTA_ID           int,
   primary key (SUSCRUBCION_ID)
);

/*==============================================================*/
/* Table: SUSCRIBCION_VENDEDOR                                  */
/*==============================================================*/
create table SUSCRIBCION_VENDEDOR
(
   SUSCRIBICION_VENDEDOR_ID int not null,
   NICK                 varchar(32),
   PRIVACIDAD           varchar(1),
   primary key (SUSCRIBICION_VENDEDOR_ID)
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO
(
   NICK                 varchar(32) not null,
   CLAVE                varchar(32),
   FECHA_CREACION       datetime,
   ULTIMA_VISITA        datetime,
   NUMERO_VISITAS       int,
   CREDITO              decimal(8,2),
   primary key (NICK)
);

alter table DATOS_PERSONALES add constraint FK_REFERENCE_9 foreign key (NICK)
      references USUARIO (NICK) on delete restrict on update restrict;

alter table JOYA add constraint FK_REFERENCE_23 foreign key (CATEGORIA_ID)
      references CATEGORIA_JOYA (CATEGORIA_ID) on delete restrict on update restrict;

alter table MOVIMIENTO add constraint FK_REFERENCE_16 foreign key (NICK)
      references USUARIO (NICK) on delete restrict on update restrict;

alter table PUJA add constraint FK_REFERENCE_12 foreign key (MOVIMIENTO_ID)
      references MOVIMIENTO (MOVIMIENTO_ID) on delete restrict on update restrict;

alter table PUJA add constraint FK_REFERENCE_7 foreign key (SUSCRUBCION_ID)
      references SUSCRIBCION_SUBASTA (SUSCRUBCION_ID) on delete restrict on update restrict;

alter table SUBASTA add constraint FK_REFERENCE_11 foreign key (MOVIMIENTO_ID)
      references MOVIMIENTO (MOVIMIENTO_ID) on delete restrict on update restrict;

alter table SUBASTA add constraint FK_REFERENCE_25 foreign key (SUSCRIBICION_VENDEDOR_ID)
      references SUSCRIBCION_VENDEDOR (SUSCRIBICION_VENDEDOR_ID) on delete restrict on update restrict;

alter table SUBASTA add constraint FK_REFERENCE_26 foreign key (JOYA_ID)
      references JOYA (JOYA_ID) on delete restrict on update restrict;

alter table SUSCRIBCION_SUBASTA add constraint FK_REFERENCE_27 foreign key (NICK)
      references USUARIO (NICK) on delete restrict on update restrict;

alter table SUSCRIBCION_SUBASTA add constraint FK_REFERENCE_28 foreign key (SUBASTA_ID)
      references SUBASTA (SUBASTA_ID) on delete restrict on update restrict;

alter table SUSCRIBCION_VENDEDOR add constraint FK_REFERENCE_15 foreign key (NICK)
      references USUARIO (NICK) on delete restrict on update restrict;

/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     27/4/2022 19:06:49                           */
/*==============================================================*/


drop table if exists CLIENTE;

drop table if exists LOTE;

drop table if exists MEDICAMENTO;

drop table if exists PEDIDO;

drop table if exists VARIEDAD;

drop table if exists VENDEDOR;

drop table if exists VENTA;

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE
(
   CI_CLI               char(8) not null,
   NOMBRE_CLI           char(256),
   PUNTOS               int,
   primary key (CI_CLI)
);

/*==============================================================*/
/* Table: LOTE                                                  */
/*==============================================================*/
create table LOTE
(
   MARCA                char(256),
   ID_PEDIDO            char(256),
   UNIDADES             int,
   FECHAVENC            date
);

/*==============================================================*/
/* Table: MEDICAMENTO                                           */
/*==============================================================*/
create table MEDICAMENTO
(
   NOMBREMED            char(256) not null,
   ID_VENTA             char(256),
   CONTENIDO            char(256) not null,
   primary key (NOMBREMED)
);

/*==============================================================*/
/* Table: PEDIDO                                                */
/*==============================================================*/
create table PEDIDO
(
   ID_PEDIDO            char(256) not null,
   FECHA_PEDIDO         date,
   PROVEEDOR            char(256),
   primary key (ID_PEDIDO)
);

/*==============================================================*/
/* Table: VARIEDAD                                              */
/*==============================================================*/
create table VARIEDAD
(
   MARCA                char(256) not null,
   NOMBREMED            char(256),
   PRECIO               float(8,2),
   primary key (MARCA)
);

/*==============================================================*/
/* Table: VENDEDOR                                              */
/*==============================================================*/
create table VENDEDOR
(
   CI_VEN               char(8) not null,
   NOMBRE_VEN           char(256),
   PUESTO               char(256),
   primary key (CI_VEN)
);

/*==============================================================*/
/* Table: VENTA                                                 */
/*==============================================================*/
create table VENTA
(
   ID_VENTA             char(256) not null,
   CI_VEN               char(8),
   CI_CLI               char(8),
   VEN_CI               char(8),
   CLI_CI               char(8),
   TOTAL                float(8,2),
   primary key (ID_VENTA)
);

alter table LOTE add constraint FK_RELATIONSHIP_6 foreign key (ID_PEDIDO)
      references PEDIDO (ID_PEDIDO) on delete restrict on update restrict;

alter table LOTE add constraint FK_VIENE_CON foreign key (MARCA)
      references VARIEDAD (MARCA) on delete restrict on update restrict;

alter table MEDICAMENTO add constraint FK_CONTIENE foreign key (ID_VENTA)
      references VENTA (ID_VENTA) on delete restrict on update restrict;

alter table VARIEDAD add constraint FK_TIENE foreign key (NOMBREMED)
      references MEDICAMENTO (NOMBREMED) on delete restrict on update restrict;

alter table VENTA add constraint FK_COMPRA foreign key (CI_CLI)
      references CLIENTE (CI_CLI) on delete restrict on update restrict;

alter table VENTA add constraint FK_VENDE foreign key (CI_VEN)
      references VENDEDOR (CI_VEN) on delete restrict on update restrict;


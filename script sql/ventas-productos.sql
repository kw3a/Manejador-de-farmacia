/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     29/4/2022 18:56:43                           */
/*==============================================================*/


drop table if exists CLIENTE;

drop table if exists CONTIENE;

drop table if exists DESECHADO;

drop table if exists MEDICAMENTO;

drop table if exists PEDIDO;

drop table if exists PROVEEDOR;

drop table if exists VENDEDOR;

drop table if exists VENTA;

/*==============================================================*/
/* Table: CLIENTE                                               */
/*==============================================================*/
create table CLIENTE
(
   CI_CLI               char(8) not null,
   NOMBRE_CLI           char(255),
   PUNTOS               int,
   primary key (CI_CLI)
);

/*==============================================================*/
/* Table: CONTIENE                                              */
/*==============================================================*/
create table CONTIENE
(
   ID_MEDICAMENTO       int not null,
   ID_VENTA             char(255) not null,
   primary key (ID_MEDICAMENTO, ID_VENTA)
);

/*==============================================================*/
/* Table: DESECHADO                                             */
/*==============================================================*/
create table DESECHADO
(
   ID_MEDICAMENTO       int,
   FECHA_DESECHO        date,
   CANTIDAD_DESECHADA   int,
   TOTAL_PERDIDO        float(8,2),
   MOTIVO_DESECHO       char(255)
);

/*==============================================================*/
/* Table: MEDICAMENTO                                           */
/*==============================================================*/
create table MEDICAMENTO
(
   ID_MEDICAMENTO       int not null,
   NOMBRE_MEDICAMENTO   char(255),
   CONTENIDO            int,
   UNIDADES_CONTENIDO   char(255),
   MARCA                char(255),
   PRECIO               float(8,0),
   STOCK                int,
   primary key (ID_MEDICAMENTO)
);

/*==============================================================*/
/* Table: PEDIDO                                                */
/*==============================================================*/
create table PEDIDO
(
   ID_PEDIDO            char(255) not null,
   ID_MEDICAMENTO       int,
   EMPRESA              char(255),
   FECHA_PEDIDO         date,
   CANTIDAD_COMPRADA    int,
   PRECIOUNITARIO       float(8,2),
   PRECIOTOTAL          float(8,2),
   FECHAVENCIMIENTO     date,
   primary key (ID_PEDIDO)
);

/*==============================================================*/
/* Table: PROVEEDOR                                             */
/*==============================================================*/
create table PROVEEDOR
(
   EMPRESA              char(255) not null,
   NOMBRE_REPRESENTANTE char(255),
   DOMICILIO            char(255),
   TELEFONO             char(8),
   primary key (EMPRESA)
);

/*==============================================================*/
/* Table: VENDEDOR                                              */
/*==============================================================*/
create table VENDEDOR
(
   CI_VEN               char(8) not null,
   NOMBRE_VEN           char(255),
   PUESTO               char(255),
   primary key (CI_VEN)
);

/*==============================================================*/
/* Table: VENTA                                                 */
/*==============================================================*/
create table VENTA
(
   ID_VENTA             char(255) not null,
   CI_VEN               char(8),
   CI_CLI               char(8),
   VEN_CI               char(8),
   CLI_CI               char(8),
   TOTAL                float(8,2),
   primary key (ID_VENTA)
);

alter table CONTIENE add constraint FK_CONTIENE foreign key (ID_MEDICAMENTO)
      references MEDICAMENTO (ID_MEDICAMENTO) on delete restrict on update restrict;

alter table CONTIENE add constraint FK_CONTIENE2 foreign key (ID_VENTA)
      references VENTA (ID_VENTA) on delete restrict on update restrict;

alter table DESECHADO add constraint FK_RELATIONSHIP_7 foreign key (ID_MEDICAMENTO)
      references MEDICAMENTO (ID_MEDICAMENTO) on delete restrict on update restrict;

alter table PEDIDO add constraint FK_RELATIONSHIP_5 foreign key (ID_MEDICAMENTO)
      references MEDICAMENTO (ID_MEDICAMENTO) on delete restrict on update restrict;

alter table PEDIDO add constraint FK_RELATIONSHIP_6 foreign key (EMPRESA)
      references PROVEEDOR (EMPRESA) on delete restrict on update restrict;

alter table VENTA add constraint FK_COMPRA foreign key (CI_CLI)
      references CLIENTE (CI_CLI) on delete restrict on update restrict;

alter table VENTA add constraint FK_VENDE foreign key (CI_VEN)
      references VENDEDOR (CI_VEN) on delete restrict on update restrict;


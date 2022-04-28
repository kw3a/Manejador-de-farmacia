/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     28/4/2022 19:14:30                           */
/*==============================================================*/


drop table if exists CLIENTE;

drop table if exists CONTIENE;

drop table if exists DESECHADO;

drop table if exists FACTURA_COMPRA;

drop table if exists LOTE;

drop table if exists MEDICAMENTO;

drop table if exists PEDIDO;

drop table if exists PROVEEDOR;

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
/* Table: CONTIENE                                              */
/*==============================================================*/
create table CONTIENE
(
   NOMBREMED            char(256) not null,
   ID_VENTA             char(256) not null,
   primary key (NOMBREMED, ID_VENTA)
);

/*==============================================================*/
/* Table: DESECHADO                                             */
/*==============================================================*/
create table DESECHADO
(
   MARCA                char(256),
   FECHA_DESECHO        date,
   CANTIDAD_DESECHADA   int,
   TOTAL_PERDIDO        float(8,2),
   MOTIVO_DESECHO       char(256)
);

/*==============================================================*/
/* Table: FACTURA_COMPRA                                        */
/*==============================================================*/
create table FACTURA_COMPRA
(
   ID_FACTURA           char(256) not null,
   ID_PEDIDO            char(256),
   EMPRESA              char(256),
   FECHA_FACTURA        date,
   primary key (ID_FACTURA)
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
   CONTENIDO            char(256) not null,
   primary key (NOMBREMED)
);

/*==============================================================*/
/* Table: PEDIDO                                                */
/*==============================================================*/
create table PEDIDO
(
   ID_PEDIDO            char(256) not null,
   ID_FACTURA           char(256),
   FECHA_PEDIDO         date,
   primary key (ID_PEDIDO)
);

/*==============================================================*/
/* Table: PROVEEDOR                                             */
/*==============================================================*/
create table PROVEEDOR
(
   EMPRESA              char(256) not null,
   NOMBRE_REPRESENTANTE char(256),
   DOMICILIO            char(256),
   TELEFONO             char(8),
   primary key (EMPRESA)
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

alter table CONTIENE add constraint FK_CONTIENE foreign key (NOMBREMED)
      references MEDICAMENTO (NOMBREMED) on delete restrict on update restrict;

alter table CONTIENE add constraint FK_CONTIENE2 foreign key (ID_VENTA)
      references VENTA (ID_VENTA) on delete restrict on update restrict;

alter table DESECHADO add constraint FK_RELATIONSHIP_10 foreign key (MARCA)
      references VARIEDAD (MARCA) on delete restrict on update restrict;

alter table FACTURA_COMPRA add constraint FK_RELATIONSHIP_8 foreign key (ID_PEDIDO)
      references PEDIDO (ID_PEDIDO) on delete restrict on update restrict;

alter table FACTURA_COMPRA add constraint FK_RELATIONSHIP_9 foreign key (EMPRESA)
      references PROVEEDOR (EMPRESA) on delete restrict on update restrict;

alter table LOTE add constraint FK_RELATIONSHIP_6 foreign key (ID_PEDIDO)
      references PEDIDO (ID_PEDIDO) on delete restrict on update restrict;

alter table LOTE add constraint FK_VIENE_CON foreign key (MARCA)
      references VARIEDAD (MARCA) on delete restrict on update restrict;

alter table PEDIDO add constraint FK_RELATIONSHIP_11 foreign key (ID_FACTURA)
      references FACTURA_COMPRA (ID_FACTURA) on delete restrict on update restrict;

alter table VARIEDAD add constraint FK_TIENE foreign key (NOMBREMED)
      references MEDICAMENTO (NOMBREMED) on delete restrict on update restrict;

alter table VENTA add constraint FK_COMPRA foreign key (CI_CLI)
      references CLIENTE (CI_CLI) on delete restrict on update restrict;

alter table VENTA add constraint FK_VENDE foreign key (CI_VEN)
      references VENDEDOR (CI_VEN) on delete restrict on update restrict;


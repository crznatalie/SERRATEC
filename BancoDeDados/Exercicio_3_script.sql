create database banco

CREATE TABLE "vendedor" (
  "ven_cd_id" serial not null,
  "ven_int_cod" integer,
  "ven_tx_nom" varchar(50) not null,
  "ven_tx_end" varchar(100) not null,
  "ven_nm_com" decimal,
  PRIMARY KEY ("ven_cd_id")
);

CREATE TABLE "cliente" (
  "cli_cd_id" serial not null,
  "cli_int_cod" integer,
  "cli_tx_nom" varchar(50) not null,
  "cli_tx_end" varchar(100) not null,
  "cli_nm_fanual" decimal,
  "cli_nm_lcred" decimal,
  "fk_ven_cd_id" int4,
  PRIMARY KEY ("cli_cd_id"),
  CONSTRAINT "FK_cliente.fk_ven_cd_id"
    FOREIGN KEY ("fk_ven_cd_id")
      REFERENCES "vendedor"("ven_cd_id")
);

CREATE TABLE "pedido" (
  "ped_cd_id" serial not null,
  "ped_int_cod" integer,
  "ped_int_num" integer,
  "ped_dt_data" timestamp,
  "fk_cli_cd_id" int4,
  PRIMARY KEY ("ped_cd_id"),
  constraint "FK_pedido.fk_cli_cd_id"
  	foreign key ("fk_cli_cd_id")
  		references "cliente"("cli_cd_id")
);

CREATE TABLE "item_pedido" (
  "iped_cd_id" serial not null,
  "iped_int_qtd" integer,
  "iped_nm_pcot" decimal,
  "fk_ped_cd_id" int4,
  PRIMARY KEY ("iped_cd_id"),
  CONSTRAINT "FK_item_pedido.fk_ped_cd_id"
    FOREIGN KEY ("fk_ped_cd_id")
      REFERENCES "pedido"("ped_cd_id")
);

CREATE TABLE "peca" (
  "pec_cd_id" serial not null,
  "pec_int_cod" integer,
  "pec_tx_des" varchar(250) not null,
  "pec_tx_end" decimal,
  "pec_int_qest" integer,
  "fk_iped_cd_id" int4,
  PRIMARY KEY ("pec_cd_id"),
  constraint "FK_peca.fk_iped_cd_id"
  	foreign key ("fk_iped_cd_id")
  		references "item_pedido"("iped_cd_id")
);

CREATE TABLE "armazem" (
  "arm_cd_id" serial not null,
  "arm_int_cod" integer,
  "arm_tx_end" varchar(100) not null,
  "fk_pec_cd_id" int4,
  PRIMARY KEY ("arm_cd_id"),
  constraint "FK_armazem.fk_pec_cd_id"
  	foreign key ("fk_pec_cd_id")
  		references "peca"("pec_cd_id")
);

select * from peca;
alter table peca 
alter column pec_tx_end type varchar(100);
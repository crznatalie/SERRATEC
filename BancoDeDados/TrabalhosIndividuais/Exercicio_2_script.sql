create database industria

CREATE TABLE "departamento" (
  "dept_cd_id" serial not null,
  "dept_int_num" integer,
  "dept_tx_setor" varchar(20) not null,
  PRIMARY KEY ("dept_cd_id")
);

CREATE TABLE "funcionario" (
  "fun_cd_id" serial not null,
  "fun_tx_nom" varchar(40) not null,
  "fun_nm_sal" decimal,
  "fun_int_tel" integer,
  "fk_dept_cd_id" int4,
  PRIMARY KEY ("fun_cd_id"),
  CONSTRAINT "FK_funcionario.fk_dept_cd_id"
    FOREIGN KEY ("fk_dept_cd_id")
      REFERENCES "departamento"("dept_cd_id")
);

CREATE TABLE "projeto" (
  "pro_cd_id" serial not null,
  "pro_int_num" integer,
  "pro_nm_orc" decimal,
  "fk_fun_cd_id" int4,
  PRIMARY KEY ("pro_cd_id"),
  CONSTRAINT "FK_projeto.fk_fun_cd_id"
    FOREIGN KEY ("fk_fun_cd_id")
      REFERENCES "funcionario"("fun_cd_id")
);

CREATE TABLE "fornecedor" (
  "forn_cd_id" serial not null,
  "forn_int_num" integer,
  "forn_tx_end" varchar(100) not null,
  "fk_pro_cd_id" int4,
  PRIMARY KEY ("forn_cd_id"),
  constraint "FK_fornecedor.fk_pro_cd_id"
  	foreign key ("fk_pro_cd_id")
  		references "projeto"("pro_cd_id")
);

CREATE TABLE "peca" (
  "pec_cd_id" serial not null,
  "pec_int_num" integer,
  "pec_tx_cor" varchar(20) not null,
  "pec_nm_peso" decimal,
  "fk_pro_cd_id" int4,
  "fk_forn_cd_id" int4,
  PRIMARY KEY ("pec_cd_id"),
  constraint "FK_peca.fk_pro_cd_id"
  	foreign key ("fk_pro_cd_id")
  		references "projeto"("pro_cd_id"),
  constraint "FK_peca.fk_forn_cd_id"
  	foreign key ("fk_forn_cd_id")
  		references "fornecedor"("forn_cd_id")
);

CREATE TABLE "deposito" (
  "dep_cd_id" serial not null,
  "dep_int_num" integer,
  "dep_tx_end" varchar(100) not null,
  "fk_pec_cd_id" int4,
  PRIMARY KEY ("dep_cd_id"),
  constraint "FK_deposito.fk_pec_cd_id"
  	foreign key ("fk_pec_cd_id")
  		references "peca"("pec_cd_id")
);
/*==============================================================*/
/* Nom de SGBD :  MySQL 5.0                                     */
/* Date de création :  21/02/2020 17:28:42                      */
/*==============================================================*/


drop table if exists BESOIN;

drop table if exists DEMANDE;

drop table if exists DEMANDER;

drop table if exists ELEMENT_DE_BESOIN;

drop table if exists FAIRE;

drop table if exists MESSAGE;

drop table if exists PERSONNE;

drop table if exists PLAINTE;

drop table if exists RELIER;

drop table if exists REPONDRE;

drop table if exists REPONSE;

drop table if exists SERVICE;

/*==============================================================*/
/* Table : BESOIN                                               */
/*==============================================================*/
create table BESOIN
(
   ID_BESOIN            int not null PRIMARY KEY AUTO_INCREMENT,
   LIBELLE varchar(255),
   DESCRIPTION varchar(255)
);


/*==============================================================*/
/* Table : SERVICE                                              */
/*==============================================================*/
create table SERVICE
(
   ID_SERVICE           int not null PRIMARY KEY AUTO_INCREMENT,
   LIBELLE           varchar(255),
   DESCRIPTION varchar(255),

   ID_BESOIN int,
   foreign key(ID_BESOIN) references BESOIN(ID_BESOIN)
   
);


/*==============================================================*/
/* Table : PERSONNE                                             */
/*==============================================================*/
create table PERSONNE
(
   ID_PERSONNE          int not null PRIMARY KEY AUTO_INCREMENT,
   ID_MESSAGE           int  null,
   NOM_PER              varchar(50),
   PRENOM               varchar(50),
   ADRESSE              varchar(50),
   ROLE                 varchar(50),
   EMAIL 		varchar(50)
);

/*==============================================================*/
/* Table : DEMANDE                                              */
/*==============================================================*/
create table DEMANDE
(
   ID_DEMANDE           int not null PRIMARY KEY AUTO_INCREMENT,
   ID_SERVICE           int null,
   ID_PERSONNE          int null,
   LIBELLE          varchar(255),
   DATE_DEMANDE	    date,
   foreign key(ID_SERVICE) references SERVICE(ID_SERVICE),
   foreign key(ID_PERSONNE) references PERSONNE(ID_PERSONNE)
);


/*==============================================================*/
/* Table : ELEMENT_DE_BESOIN                                    */
/*==============================================================*/
create table ELEMENT_DE_BESOIN
(
   ID_EL_BESOIN         int not null PRIMARY KEY AUTO_INCREMENT,
   ID_BESOIN int,
   LIBELLE varchar(255),
   VALEUR varchar(255),
   DESCRIPTION varchar(255),
   foreign key(ID_BESOIN) references BESOIN(ID_BESOIN)
);



/*==============================================================*/
/* Table : FAIRE DEMANDE                                                */
/*==============================================================*/
create table FAIRE_DEMANDE
(
   ID_PERSONNE          int not null,
   ID_DEMANDE           int not null,
   primary key (ID_PERSONNE, ID_DEMANDE),
   foreign key(ID_DEMANDE) references DEMANDE(ID_DEMANDE),
   foreign key(ID_PERSONNE) references PERSONNE(ID_PERSONNE)
);



/*==============================================================*/
/* Table : MESSAGE                                              */
/*==============================================================*/
create table MESSAGE
(
   ID_MESSAGE           int not null PRIMARY KEY AUTO_INCREMENT,
   CONTENU varchar(255),
ID_PERSONNE int,
foreign key(ID_PERSONNE) references PERSONNE(ID_PERSONNE)
  
);




/*==============================================================*/
/* Table : PLAINTE                                              */
/*==============================================================*/
create table PLAINTE
(
   ID_PLAINTE           int not null PRIMARY KEY AUTO_INCREMENT,
    CONTENU 		varchar(255),
ID_SERVICE int,
foreign key(ID_SERVICE) references SERVICE(ID_SERVICE)
);

/*==============================================================*/
/* Table : RELIER                                               */
/*==============================================================*/
create table RELIER
(
   ID_SERVICE           int not null,
   ID_BESOIN            int not null,
   primary key (ID_SERVICE, ID_BESOIN)
);

/*==============================================================*/
/* Table : REPONDRE                                             */
/*==============================================================*/
create table ELEMENT_BESOIN_DEMANDE
(
   ID_DEMANDE           int not null,
   ID_EL_BESOIN         int not null,
   primary key (ID_DEMANDE, ID_EL_BESOIN),
   foreign key(ID_DEMANDE) references DEMANDE(ID_DEMANDE),
   foreign key(ID_EL_BESOIN) references ELEMENT_DE_BESOIN(ID_EL_BESOIN)
);

/*==============================================================*/
/* Table : REPONSE                                              */
/*==============================================================*/
create table REPONSE
(
   ID_REPONSE           int not null PRIMARY KEY AUTO_INCREMENT,
   CONTENU varchar(255),
   ID_MESSAGE int,
   ID_PERSONNE int,
   foreign key(ID_PERSONNE) references PERSONNE(ID_PERSONNE),
   foreign key(ID_MESSAGE) references MESSAGE(ID_MESSAGE)
);


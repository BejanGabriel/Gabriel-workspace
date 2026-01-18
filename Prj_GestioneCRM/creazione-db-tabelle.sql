Create database gestione_crm;

use gestione_crm;

create table if not exists utente(
id_utente int auto_increment primary key,
nome_utente varchar(50) not null,
ruolo varchar(100),
email varchar(100) not null unique,
`password` varchar(100)not null,
data_registrazione date default (current_date));

Create table if not exists cliente (
id_cliente int auto_increment primary key,
nome_azienda varchar(100) not null,
referente_azienda varchar(50),
categoria_merceologica varchar(50),
tipologia_cliente varchar(100),
utente_associato int,
constraint fk_cliente_utente foreign key (utente_associato) references utente(id_utente)
on delete cascade); -- constraint per poter eliminare il cliente quando l'utente viene eliminato.

 
create table if not exists servizio_consulenza (
id_servizio int auto_increment primary key,
nome_servizio varchar(100) not null,
descrizione text,
prezzo decimal(10,2));

create table if not exists note_cliente (
id_nota int auto_increment primary key,
id_cliente int,
testo_nota text not null,
data_registrazione date default (current_date),
utente_registrante int,
constraint fk_note_cliente foreign key (id_cliente) references cliente(id_cliente)
on delete cascade, -- constraint su cliente, se elimino il cliente elimino anche la sua note
foreign key (utente_registrante) references utente(id_utente)
); 


create table if not exists appuntamento (
id_appuntamento int auto_increment primary key,
id_cliente int,
data_appuntamento date default (current_date),
descrizione text not null,
utente_associato int,
constraint appuntamento_ibfk_1 foreign key(utente_associato) references utente (id_utente),
constraint fk_appuntamento_cliente foreign key (id_cliente) references cliente(id_cliente)on delete cascade) ;

create table if not exists tag_cliente (
id_tag int auto_increment primary key,
nome_tag varchar(20) not null unique); -- unique garantisce univocità ai tag

create table if not exists cliente_tag (
id_cliente_tag int auto_increment primary key,
id_cliente int,
id_tag int,
constraint  cliente_tag_idfk_1 foreign key (id_cliente) references cliente(id_cliente),
foreign key (id_tag) references tag_cliente(id_tag));

create table if not exists servizio_cliente(
id_servizio_cliente int auto_increment primary key,
id_servizio int not null,
id_cliente int not null,
foreign key (id_servizio) references servizio_consulenza(id_servizio),
foreign key (id_cliente) references cliente(id_cliente) on delete cascade);

-- da eseguire in questo ordine per via delle 'costrizioni'

insert into utente (id_utente, nome_utente, ruolo, email, `password`, data_registrazione) values
	(1, 'admin', 'Amministratore', 'admin@example.com', 'password', '2024-04-01'),
    (2, 'user1', 'Registrato', 'user1@example.com', 'password', '2024-04-02'),
    (3, 'user2', 'Consulente', 'user2@example.com', 'password', '2024-04-03');

insert into cliente (id_cliente, nome_azienda, referente_azienda, categoria_merceologica, tipologia_cliente, utente_associato) values
    (1, 'ABC SRL', 'Mario Rossi', 'IT', 'Cliente Fidelizzato', 1),
    (2, 'DEF SPA', 'Luigi Bianchi', 'Logistica', 'Nuovo Cliente', 2),
    (3, 'GHI SNC', 'Giovanna Verdi', 'Alimentare', 'Prospect', 3);

insert into note_cliente (id_nota, id_cliente, testo_nota, data_registrazione, utente_registrante) values
    (1, 1, 'Cliente interessato a espandere i servizi IT', '2024-04-10', 1),
    (2, 2, 'Proposta commerciale inviata via email', '2024-04-11', 2),
    (3, 3, 'Richiesta di preventivo per servizi logistici', '2024-04-12', 3);
    
insert into appuntamento (id_appuntamento, id_cliente, data_appuntamento, descrizione, utente_associato) values
    (1, 1, '2024-04-15', 'Riunione in sede per discutere le opportunità', 1),
    (2, 2, '2024-04-16', 'Chiamata telefonica per seguire up sulla proposta', 2),
    (3, 3, '2024-04-17', 'Incontro presso il cliente per analisi dei requisiti', 3);

insert into servizio_consulenza (id_servizio, nome_servizio, descrizione, prezzo) values
    (1, 'Consulenza IT', 'Assistenza e supporto tecnico IT', 100.00),
    (2, 'Consulenza Logistica', 'Ottimizzazione dei processi logistici', 150.00),
    (3, 'Consulenza Alimentare', 'Analisi di mercato nel settore alimentare', 120.00);

insert into tag_cliente (id_tag, nome_tag) values
    (1, 'Premium'),
    (2, 'Potenziale'),
    (3, 'Nuovo Cliente');
    
insert into servizio_cliente (id_cliente, id_servizio) values
	(1,1),
	(1,2),
	(2,3);

insert into cliente_tag (id_cliente_tag, id_cliente, id_tag) values
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 3);
    

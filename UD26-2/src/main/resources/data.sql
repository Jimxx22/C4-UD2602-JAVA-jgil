drop table if exists asignado_a;
drop table if exists cientificos;
drop table if exists proyectos;

create table cientificos(
	dni varchar(8),
    nombre_apels varchar(255),
    primary key(dni)
);

create table proyectos(
	id char(4),
    nombre varchar(255),
    horas int,
    primary key(id)
);

create table asignado_a(
	id int auto_increment,
	dni_cientifico varchar(8) not null,
    id_proyecto char(4) not null,
    primary key(id),
    constraint fk_cientificos_asignado_a foreign key (dni_cientifico)
    references cientificos(dni) ON DELETE CASCADE ON UPDATE CASCADE,
	constraint fk_proyectos_asignado_a foreign key (id_proyecto)
    references proyectos(id) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into cientificos(dni,nombre_apels)values ('12345678','cientifico1'),('23456781','cientifico2'),('34567812','cientifico3'),('45678123','cientifico4'),('56781234','cientifico5');
insert into proyectos(id,nombre,horas)values ('p001','proyecto1',22),('p002','proyecto2',15),('p003','proyecto3',35),('p004','proyecto4',10),('p005','proyecto5',18);
insert into asignado_a(dni_cientifico,id_proyecto)values (12345678,'p002'),(23456781,'p003'),(34567812,'p002'),(45678123,'p001'),(12345678,'p004'),(56781234,'p005');
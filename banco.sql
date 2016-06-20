create table noticia (id serial, titulo text, texto text, primary key(id));
create table usuario (id serial, nome text, senha text, primary key(id));
drop table usuario
select*from noticia
select*from usuario
insert into usuario values (default, 'filipe', 123)
insert into noticia values (default, 'teste 1', 'teste teste teste teste teste teste ')
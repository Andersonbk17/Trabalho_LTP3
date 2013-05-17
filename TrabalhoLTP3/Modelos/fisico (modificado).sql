CREATE TABLE estoques(
	id int primary key auto_increment,
	quantidade int not null,
	ativo int

)Engine=InnoDB;

CREATE TABLE tipos_pagamento(
	id int primary key auto_increment,
	nome varchar(100) not null,
	ativo int	
)Engine=InnoDB;

CREATE TABLE produtos(
	id int primary key auto_increment,
	nome varchar(100) not null,
	descricao varchar(500),
	valor_uni_venda float,
	valor_uni_compra float,
	ativo int
)Engine=InnoDB;

CREATE TABLE pessoas(
	id int primary key auto_increment,
	nome varchar(100) not null,
	cpf varchar(100) not null,
	rg varchar(100) not null,
	data_nascimento Date,
	ativo int

)Engine=InnoDB;


CREATE TABLE emails(
	id int primary key auto_increment,
	endereco varchar(100),
	id_pessoa int,
	ativo int,
	foreign key (id_pessoa)references pessoas(id)
)Engine=InnoDB;

CREATE TABLE telefones(
	id int primary key auto_increment,
	ddd int,
	numero int,
	id_pessoa int,
	ativo int ,
	foreign key (id_pessoa)references pessoas(id)
)Engine=InnoDB;



CREATE TABLE enderecos(
	id_endereco int primary key auto_increment,
	rua varchar(100),
	cep varchar(100),
	bairro varchar(100),
	numero varchar(30),
	id_pessoa int,
	cidade varchar(100),
	estado varchar(100),
	ativo int ,
	foreign key (id_pessoa)references pessoas(id)
)Engine=InnoDB;



CREATE TABLE clientes(
	id int primary key auto_increment,
	id_pessoa int,
	ativo int,
	foreign key (id_pessoa)references pessoas(id)
)Engine=InnoDB;

CREATE TABLE usuarios_sistema(
	id int primary key auto_increment,
	usuario varchar(100) not null,	
	senha varchar(120) not null,	
	id_pessoa int,
	ativo int,
	foreign key (id_pessoa)references pessoas(id)
)Engine=InnoDB;


CREATE TABLE vendas(
	id int primary key auto_increment,
	horario datetime not null,
	id_usuario int not null,
	id_cliente int not null,
	id_tipo_pagamento int not null,
	ativo int,
	foreign key (id_usuario) references usuarios_sistema(id),
	foreign key (id_cliente) references clientes(id),
	foreign key (id_tipo_pagamento) references tipos_pagamento(id)
)Engine=InnoDB;


CREATE TABLE itens_venda(
	id int primary key auto_increment,
	quantidade int not null,
	id_venda int not null,
	id_produto int not null,
	ativo int,
	foreign key (id_venda) references vendas(id),
	foreign key (id_produto) references produtos(id)
	
)Engine=InnoDB;


INSERT INTO usuarios_sistema (usuario,senha) VALUES ("root","root");


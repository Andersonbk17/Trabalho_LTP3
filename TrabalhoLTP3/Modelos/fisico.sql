CREATE TABLE estoques(
	id int primary key auto_increment,
	quantidade int not null

)Engine=InnoDB;

CREATE TABLE tipos_pagamentos(
	id int primary key auto_increment,
	nome varchar(100) not null	
)Engine=InnoDB;

CREATE TABLE produtos(
	id int primary key auto_increment,
	nome varchar(100) not null,
	descricao varchar(500),
	valor_uni_venda float,
	valor_uni_compra float
)Engine=InnoDB;

CREATE TABLE emails(
	id int primary key auto_increment,
	endereco varchar(100),
	id_pessoa int,
	foreign key (id_pessoa)references pessoas(id)

)Engine=InnoDB;

CREATE TABLE telefones(
	id int primary key auto_increment,
	ddd int,
	numero int,
	id_pessoa int,
	foreign key (id_pessoa)references pessoas(id)
)Enginne=InnoDB;

CREATE TABLE enderecos(
	id int primary key auto_increment,
	rua varchar(100)
	cep int,
	bairro varchar(100),
	numero int,
	id_pessoa int,
	foreign key (id_pessoa)references pessoas(id)


)Engine=InnoDB;

CREATE TABLE Pessoas(
	id int primary key auto_increment,
	nome varchar(100) not null,
	cpf varchar(100) not null,
	rg varchar(100) not null,
	data_nascimento Date 

)Engine=InnoDB;


CREATE TABLE clientes(
	id int primary key auto_increment,
	id_pessoa int,
	foreign key (id_pessoa)references pessoas(id)

)Engine=InnoDB;

CREATE TABLE usuarios_sistema(
	id int primary key auto_increment,
	usuario varchar(100) not null,	
	senha varchar(120) not null,	
	id_pessoa int,
	foreign key (id_pessoa)references pessoas(id)


)Engine=InnoDB;

CREATE TABLE tipo_pagamento(
	id int primary key auto_increment,
	nome varchar(100)
)Engine=InnoDB;

CREATE TABLE vendas(
	id int primary key auto_increment,
	horario datetime not null,
	id_usuario int not null,
	id_cliente int not null,
	id_tipo_pagamento not null,
	foreign key (id_usuario) references usuarios_sistema(id),
	foreign key (id_cliente) references clientes(id),
	foreign key (id_tipo_pagamento) references tipo_pagamento(id)
)Engine=InnoDB;


CREATE TABLE itens_venda(
	id int primary key auto_increment,
	quantidade int not null,
	id_venda int not null,
	id_produto int not null,
	foreign key (id_venda) references vendas(id),
	foreign key (id_produto) references produtos(id)
)Engine=InnoDB;


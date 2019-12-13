CREATE TABLE Clientes(
CodCliente integer PRIMARY KEY,
Nome varchar(50)
);

                         

drop table Comanda CASCADE
CREATE TABLE Produto(
CodProduto integer PRIMARY KEY,
Nome varchar(50),
Descricao varchar(150),
Custo numeric(11,2),
Preco numeric(11,2),
Lucro numeric(11,2)
);

CREATE TABLE Item_Venda(
CodProduto integer REFERENCES Produto(CodProduto),
NumComanda integer REFERENCES Comanda(NumComanda),
ValorUnitario numeric(11,2),
Qtd integer
);
drop table Item_Venda CASCADE


select *from Clientes;
select *from Comanda;
select *from Produto;
select *from Item_Venda;

delete from Clientes;
delete from Comanda;
delete from Produto;
delete from Item_Venda;
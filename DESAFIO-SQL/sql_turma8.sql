CREATE TABLE fornecedor( 
	id number primary key, 
	nome varchar(40) not null, 
	ie varchar(14) not null
);

CREATE TABLE material( 
	id number primary key, 
	nome varchar(40) NOT null
);

CREATE TABLE ordem_compra( 
	id number primary key, 
	data date not null, 	
    fornecedor_id int,
	CONSTRAINT fk_fornecedor FOREIGN KEY (fornecedor_id) REFERENCES fornecedor (id)
);

CREATE TABLE item_ordem_compra( 
	ordem_compra_id number,
    material_id number,
    valor number(6,2),
    quantidade number,
	CONSTRAINT fk_ordem_compra FOREIGN KEY (ordem_compra_id) REFERENCES ordem_compra (id),
    CONSTRAINT fk_material FOREIGN KEY (material_id) REFERENCES material (id),
    CONSTRAINT pk_item_ordem_compra PRIMARY KEY (ordem_compra_id, material_id)
);

INSERT INTO fornecedor (id, nome, ie) VALUES (1, 'Coelho Pai', '17568');
INSERT INTO fornecedor (id, nome, ie) VALUES (2, 'Coelho Filho', '26768');
INSERT INTO fornecedor (id, nome, ie) VALUES (3, 'Coelho Neto', '76859');
INSERT INTO fornecedor (id, nome, ie) VALUES (4, 'Balança mas não cai', '12345');
INSERT INTO fornecedor (id, nome, ie) VALUES (5, 'Torre de Babel', '66668');
INSERT INTO fornecedor (id, nome, ie) VALUES (6, 'Construindo o mundo', '54213');
INSERT INTO fornecedor (id, nome, ie) VALUES (7, 'Outra brecha', '10011');
INSERT INTO fornecedor (id, nome, ie) VALUES (8, 'Tudo para construção', '90012');
INSERT INTO fornecedor (id, nome, ie) VALUES (9, 'Building the world', '80654');
INSERT INTO fornecedor (id, nome, ie) VALUES (10, 'Novos empreendimentos', '12068');

INSERT INTO material (id, nome) VALUES (1, 'martelo');
INSERT INTO material (id, nome) VALUES (2, 'prego');
INSERT INTO material (id, nome) VALUES (3, 'cimento');
INSERT INTO material (id, nome) VALUES (4, 'ferragem');
INSERT INTO material (id, nome) VALUES (5, 'argamassa');
INSERT INTO material (id, nome) VALUES (6, 'parafuso');
INSERT INTO material (id, nome) VALUES (7, 'fiação');
INSERT INTO material (id, nome) VALUES (8, 'cal');
INSERT INTO material (id, nome) VALUES (9, 'areia');
INSERT INTO material (id, nome) VALUES (10, 'metais');
INSERT INTO material (id, nome) VALUES (11, 'louças');
INSERT INTO material (id, nome) VALUES (12, 'tijolo');
INSERT INTO material (id, nome) VALUES (13, 'telha');
INSERT INTO material (id, nome) VALUES (14, 'madeira');
INSERT INTO material (id, nome) VALUES (15, 'porta');
INSERT INTO material (id, nome) VALUES (16, 'janela');

INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(1, to_date('10/05/2022', 'dd/mm/yyyy'), 1);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(2, to_date('10/05/2022', 'dd/mm/yyyy'), 3);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(3, to_date('10/05/2022', 'dd/mm/yyyy'), 6);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(4, to_date('11/05/2022', 'dd/mm/yyyy'), 4);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(5, to_date('12/05/2022', 'dd/mm/yyyy'), 5);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(6, to_date('12/05/2022', 'dd/mm/yyyy'), 2);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(7, to_date('13/05/2022', 'dd/mm/yyyy'), 8);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(8, to_date('14/05/2022', 'dd/mm/yyyy'), 7);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(9, to_date('15/05/2022', 'dd/mm/yyyy'), 5);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(10, to_date('15/05/2022', 'dd/mm/yyyy'), 4);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(11, to_date('15/05/2022', 'dd/mm/yyyy'), 10);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(12, to_date('17/05/2022', 'dd/mm/yyyy'), 1);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(13, to_date('17/05/2022', 'dd/mm/yyyy'), 2);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(14, to_date('18/05/2022', 'dd/mm/yyyy'), 3);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(15, to_date('18/05/2022', 'dd/mm/yyyy'), 9);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(16, to_date('18/05/2022', 'dd/mm/yyyy'), 7);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(17, to_date('19/05/2022', 'dd/mm/yyyy'), 4);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(18, to_date('19/05/2022', 'dd/mm/yyyy'), 2);
INSERT INTO ordem_compra (id, data, fornecedor_id)
	VALUES(19, to_date('19/05/2022', 'dd/mm/yyyy'), 3);
INSERT INTO ordem_compra (id, data, fornecedor_id) 
	VALUES(20, to_date('19/05/2022', 'dd/mm/yyyy'), 10);

INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (1, 7, 5, 7.2);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (1, 1, 1, 12);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (1, 6, 15, 1.5);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (2, 2, 100, 0.29);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (2, 1, 1, 12);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (2, 3, 5, 35.9);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (2, 8, 5, 28);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (3, 3, 10, 40);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (3, 8, 7, 28);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (4, 3, 12, 40);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (4, 4, 40, 40);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (4, 9, 100, 30);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (4, 8, 8, 28);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (4, 12, 1000, 5.5);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (5, 11, 14, 70);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (6, 13, 500, 1.75);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (6, 14, 20, 50);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (6, 15, 8, 350);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (6, 16, 8, 28);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (7, 2, 100, 0.25);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (7, 6, 40, 0.35);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (7, 7, 50, 18.5);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (8, 10, 4, 40);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (8, 11, 6, 250);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (8, 15, 2, 0.25);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (8, 16, 3, 65);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (9, 3, 6, 0.35);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (9, 9, 100, 30);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (10, 3, 10, 40);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (10, 4, 5, 40);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (10, 8, 5, 28);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (10, 9, 200, 30);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (10, 12, 700, 5.97);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (11, 5, 10, 28);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (12, 1, 3, 12.2);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (12, 2, 500, 0.25);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (12, 6, 200, 0.35);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (12, 14, 20, 50);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (13, 6, 15, 0.35);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (13, 15, 5, 350);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (14, 6, 18, 0.35);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (14, 15, 6, 250);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (14, 16, 1, 65);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (15, 5, 30, 28);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (15, 9, 10, 30);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (16, 2, 100, 0.25);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (16, 3, 30, 40);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (16, 4, 6, 39);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (16, 8, 15, 32);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (16, 9, 20, 30);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (17, 5, 15, 28);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (17, 6, 15, 0.35);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (17, 10, 5, 97.3);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (17, 11, 6, 70);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (17, 16, 2, 65);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (18, 11, 5, 70);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (18, 13, 300, 1.75);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (19, 2, 200, 0.29);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (19, 13, 500, 1.75);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (19, 14, 27, 50);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (19, 6, 150, 0.35);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (20, 5, 15, 28);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (20, 10, 5, 97.3);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (20, 11, 10, 70);
INSERT INTO item_ordem_compra (ordem_compra_id, material_id, quantidade, valor) values (20, 15, 3, 450);

-------------------------------------------------------------------

SELECT * from fornecedor;

SELECT nome FROM fornecedor;

SELECT oc.id, oc.data, f.nome, f.ie
FROM fornecedor as f, ordem_compra as oc;

SELECT oc.id, oc.data, f.nome, f.ie 
FROM fornecedor as f, ordem_compra as oc 
WHERE oc.fornecedor_id = f.id;

SELECT oc.id, oc.data, f.nome, f.ie 
FROM fornecedor as f, ordem_compra as oc 
WHERE oc.fornecedor_id = f.id 
ORDER BY f.ie;

SELECT oc.id, oc.data, f.nome, f.ie 
FROM fornecedor as f, ordem_compra as oc 
WHERE oc.fornecedor_id = f.id 
ORDER BY f.ie DESC;

SELECT ioc.ordem_compra_id, ioc.material_id, m.nome 
FROM item_ordem_compra AS ioc, material AS m 
WHERE ioc.material_id = m.id 
ORDER BY ioc.ordem_compra_id;

-------------------------------------------------------------------
--1. Exiba os dados da compra (item_ordem_compra) de todos os materiais cujo quantidade seja maior que 10.
--2. Exiba os dados da compra (item_ordem_compra) de todos os materiais cujo valor seja menor que 50.

SELECT * 
FROM item_ordem_compra 
WHERE quantidade > 10 AND valor < 50
-------------------------------------------------------------------

--3. Exibir os dados da compra de todos os materiais cuja quantidade seja maior que 100 e o valor seja menor que 50, contendo o nome do material e o nome do fornecedor.

SELECT *, quantidade*valor as subtotal 
FROM item_ordem_compra
-------------------------------------------------------------------

-- 4. Exiba o subtotal de cada material  vendido, o nome do material e o nome do fornecedor, para cada item_ordem_compra.

SELECT ordem_compra_id, SUM(quantidade * valor) as total_compra 
FROM item_ordem_compra 
GROUP BY ordem_compra_id

SELECT ordem_compra_id, SUM(valor * quantidade) as total_compra 
FROM item_ordem_compra
GROUP by ordem_compra_id 
HAVING total_compra > 5000
-------------------------------------------------------------------

-- 5. O nome do fornecedor da ordem de compra, a ordem de compra e o total pago pela ordem de compra.
-- 6. O nome do fornecedor da ordem de compra, a data da ordem de compra, o total pago pela ordem de compra, num determinado intervalo de datas.

SELECT f.nome, oc.data, sum(valor * quantidade) as total 
FROM ordem_compra as oc, item_ordem_compra as ioc, fornecedor as f 
where f.id = oc.fornecedor_id 
	AND oc.id = ioc.ordem_compra_id 
	AND oc.data BETWEEN '2022-05-15' AND '2022-05-20' 
GROUP by ioc.ordem_compra_id

-------------------------------------------------------------------

-- listar o nome de cada material e o valor médio desse material

select m.nome, ioc.valor
from material as m, item_ordem_compra as ioc
where m.id = ioc.material_id;

-- listar o nome de cada material e o valor médio desse material entre os dias 10/05/2022 e 13/05/2022

select 
m.id, m.nome, AVG(ioc.valor) as valor_medio
from item_ordem_compra as ioc, material as m, ordem_compra as oc
where ioc.material_id = m.id 
and ioc.ordem_compra_id = oc.id
and oc.data between '2022-05-10' and '2022-05-13' -- (10/05/2022 e 13/05/2022)

-- qual é o produto que mais aparece nas compras?

select 
m.id, m.nome as nome_produto, f.nome as nome_fornecedor, COUNT(ioc.material_id) as contagem
from item_ordem_compra as ioc, material as m, fornecedor as f, ordem_compra as oc
where ioc.material_id = m.id 
and ioc.ordem_compra_id = oc.id
and oc.fornecedor_id = f.id

-- CRUD (insert, select, update, delete)

insert into fornecedor (id, nome, ie) values (6, 'Construindo o mundo', '54213');
select * from fornecedor;
update fornecedor set nome = 'Destruindo o mundo' where id = 6;
delete from fornecedor where id = 6;
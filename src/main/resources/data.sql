INSERT INTO CLIENTES (NOME, EMAIL, TELEFONE) VALUES 
('Beatriz Camargo', 'bia@example.com', '(11) 99999-0000'),
('João Silva', 'joao@example.com', '(11) 98888-1111'),
('Maria Oliveira', 'maria@example.com', '(11) 97777-2222');

INSERT INTO FILMES (TITULO, DIRETOR, ANO_LANCAMENTO, DISPONIVEL) VALUES 
('Matrix', 'Lana Wachowski', 1999, TRUE),
('Interestelar', 'Christopher Nolan', 2014, TRUE),
('O Poderoso Chefão', 'Francis Ford Coppola', 1972, TRUE);

INSERT INTO LOCACOES (DATA_RETIRADA, DATA_DEVOLUCAO, CLIENTE_ID) VALUES 
(CURRENT_DATE, DATEADD('DAY', 7, CURRENT_DATE), 1),
(CURRENT_DATE, DATEADD('DAY', 5, CURRENT_DATE), 2);

INSERT INTO LOCACOES_FILME (LOCACAO_ID, FILME_ID, QUANTIDADE) VALUES 
(1, 1, 1),
(1, 2, 2), 
(2, 3, 1); 

/*
 __   __   __   ___  __           __   __   __           __   __   __       
|__) /  \ |  \ |__  / _`  /\     |__) /  \ |__)  /\     |__) /  \ |__)  /\  
|__) \__/ |__/ |___ \__> /~~\    |__) \__/ |  \ /~~\    |__) \__/ |  \ /~~\ 

 */

-- -----------------------------------------------------
-- Table `bd_borabora`.`brand_product`
-- -----------------------------------------------------
INSERT INTO brand_product (cod_brand_product, brand_product) VALUES
    ('1', 'Primor'), 
    ('2', 'Gloria'), 
    ('3', 'Inca Kola'),
    ('4', 'Pilsen Callao'), 
    ('5', 'Mistura'), 
    ('6', 'San Fernando'); 
    
    
-- -----------------------------------------------------
-- Table `bd_borabora`.`card_type`
-- -----------------------------------------------------
INSERT INTO card_type (cod_card_type,type)
VALUES (1, 'C'),
       (2, 'D');


-- -----------------------------------------------------
-- Table `bd_borabora`.`category`
-- -----------------------------------------------------
INSERT INTO category (id_category, image, name) VALUES
(1, 'https://personaconsumidora.elika.eus/wp-content/uploads/2015/10/Botellas-aceite-e1563367522788.jpg', 'Aceites'),
(2, 'https://cdn.segodnya.ua/i/image_1080x/media/image/5e9/6f9/533/5e96f95335ca8.jpg.webp', 'Granos y cereales'),
(3, 'https://elcomercio.pe/resizer/hv_E5i00YTjL0hFj2gM4Eie9YrE=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/AVGFN7LZKVCXTFYA4P46SD365E.jpg', 'Menestras'),
(4, 'https://images.ecestaticos.com/3YjwKhocGC8HGAqWgwInFDIIy9Y=/42x19:661x483/557x418/filters:fill(white):format(jpg)/f.elconfidencial.com%2Foriginal%2F773%2F094%2F19d%2F77309419d4585c2d4a3590623d2e9170.jpg', 'Lacteos'),
(5, 'https://www.licoresalis.com/web/image/4715-07c93907/Imagen-1.jpg', 'Licores'),
(6, 'https://elmundoalinstante.com/wp-content/uploads/2017/07/imagen-sin-titulo-1.jpg', 'Enlatados');


-- -----------------------------------------------------
-- Table `bd_borabora`.`type_order`
-- -----------------------------------------------------
INSERT INTO type_order (type_order_id, type)
VALUES (1, 'D1231'),
       (2, 'R1231'),
       (3, 'D2594'),
       (4, 'R4451');   
       

-- -----------------------------------------------------
-- Table `bd_borabora`.`district`
-- -----------------------------------------------------
INSERT INTO district (cod_district, district)
VALUES (1, 'Asia'),                        
       (2, 'Calango'),                     
       (3, 'Cerro Azul'),               
       (4, 'Chilca'),                      
       (5, 'Coayllo'),                      
       (6, 'Imperial'),                     
       (7, 'Lunahuaná'),                
       (8, 'Mala'),                       
       (9, 'Nuevo Imperial'),              
       (10, 'Pacarán'),                  
       (11, 'Quilmaná'),                
       (12, 'San Antonio'),             
       (13, 'San Luis'),                  
       (14, 'San Vicente de Cañete'),      
       (15, 'Santa Cruz de Flores'),        
       (16, 'Zúñiga');


-- -----------------------------------------------------
-- Table `bd_borabora`.`delivery`
-- -----------------------------------------------------
INSERT INTO delivery (address, date, department, province, ubigeo, type_order_id, cod_district)
VALUES ('Suite 80', '2023-12-24', 'Lima', 'Cañete', 144206, 1, 1),
       ('19th Floor', '2023-12-25', 'Lima', 'Cañete', 142560, 2, 2),
       ('Suite 55', '2023-12-26', 'Lima', 'Cañete', 149274, 3, 3),
       ('Room 1959', '2023-12-27', 'Lima', 'Cañete', 144232, 4, 4);
       

-- -----------------------------------------------------
-- Table `bd_borabora`.`headquarter`
-- -----------------------------------------------------
INSERT INTO headquarter (cod_headquarter, headquarter)
VALUES (1, 'Bora Bora - Asia'),
       (2, 'Bora Bora - Cerro Azul'),
       (3, 'Bora Bora - Lunahuaná');


-- -----------------------------------------------------
-- Table `bd_borabora`.`status`
-- -----------------------------------------------------
INSERT INTO status (codigo_status, status)
VALUES (1, 'Success'),
       (2, 'Failure');
       

-- -----------------------------------------------------
-- Table `bd_borabora`.`payment_gateway`
-- -----------------------------------------------------
INSERT INTO payment_gateway (payment_id, amount, card, currency, quota_number, trace_number, transaction_date, cod_card_type, codigo_status)
VALUES (123456789, 120.50, '1234 5678 9012 3456', 'SOL', '1', '1234567890', '3/12/2024', 1, 1),
	   (789123456, 200.00, '3456 7890 1234 5678', 'SOL', '3', '7891234560', '3/12/2024', 2, 2);   

      
-- -----------------------------------------------------
-- Table `bd_borabora`.`pick_up`
-- -----------------------------------------------------
INSERT INTO pick_up (type_order_id, date, cod_headquarter)
VALUES (1, '16/08/2022', 1),
       (2, '4/10/2022', 2),
       (3, '21/05/2022', 3);  


-- -----------------------------------------------------
-- Table `bd_borabora`.`product`
-- -----------------------------------------------------
-- Granos y cereales
INSERT INTO product (id_product, description, expiration_date, image, name, price, stock, cod_brand_product, id_category) VALUES
(1, 'Arroz Extra Faraón de 5 Kg', '2023-12-24', 'https://mundoabarrotes.com/wp-content/uploads/2019/09/Arroz-Faraon-Naranja-50-kg-ver2.webp', 'Arroz', 25.20, 2, 1, 2),
(2, 'Avena Hojuelas Gruesas Grano de Oro 900 g', '2025-01-15', 'https://quaker.lat/app/uploads/sites/18/2021/06/QUAKER-HOJUELONES-2.png', 'Avena', 17.20, 2, 1, 2),
(3, 'Avena Tradicional Quaker de 900 g', '2024-02-12', 'https://quaker.lat/app/uploads/sites/5/2020/02/Imagen1-720x840.png', 'Avena', 15.70, 2, 1, 2);
-- Menestras
INSERT INTO product (id_product, description, expiration_date, image, name, price, stock, cod_brand_product, id_category) VALUES
(4, 'Frijol Panamito de 500g', '2023-12-24', 'https://lapradera.ec/199-large_default/frejol-panamito-500g.jpg', 'Frijoles', 6.40, 25, 2, 3),
(5, 'Lenteja bebé tesoro del campo 500g', '2025-01-15', 'https://metroio.vtexassets.com/arquivos/ids/237935-800-auto?v=638173814831100000&width=800&height=auto&aspect=true', 'Lenteja', 6.30, 30, 2, 3),
(6, 'Garbanzo VALLENORTE Bolsa 500g', '2024-02-12', 'https://plazavea.vteximg.com.br/arquivos/ids/561742-450-450/20192034.jpg?v=637427442451830000', 'Garbanzo', 7.50, 40, 2, 3);
-- Aceites
INSERT INTO product (id_product, description, expiration_date, image, name, price, stock, cod_brand_product, id_category) VALUES
(7, 'Aceite Oliva extra virgen 200 ML', '2023-12-24', 'https://oechsle.vteximg.com.br/arquivos/ids/11031767-1000-1000/image-234545d1b4ed4495889f68e366d95bf1.jpg?v=637975716433530000', 'Aceite de Oliva', 18.90, 20, 3, 1),
(8, 'Aceite vegetal Primor de 900 mL', '2025-01-15', 'https://plazavea.vteximg.com.br/arquivos/ids/26739950-512-512/K0000007872.jpg', 'Aceite vegetal', 11.80, 22, 3, 1),
(9, 'Aceite Vegetal de Soya Sao en Botella de 900 mL', '2024-02-12', 'https://plazavea.vteximg.com.br/arquivos/ids/414889-450-450/20146399.jpg?v=637370972884270000', 'Aceite vegetal', 9.20, 23, 3, 1);
-- Lacteos
INSERT INTO product (id_product, description, expiration_date, image, name, price, stock, cod_brand_product, id_category) VALUES
(10, 'Queso crema Philadelphia Brick 180 g', '2023-12-24', 'https://plazavea.vteximg.com.br/arquivos/ids/2175579-162-162/20236774.jpg?v=637629478838830000', 'Queso crema', 12.50, 55, 4, 4),
(11, 'Queso fundido LAIVE X 12 TAJADAS', '2025-01-15', 'https://storage.googleapis.com/web-laive-storage/Media/pages/6.1.%20Laive%20Queso%20Fundido%2090g.jpg', 'Queso', 11.30, 20, 4, 4),
(12, 'Mantequilla Gloria de 90 g', '2024-02-12', 'https://wongfood.vtexassets.com/arquivos/ids/606790/Mantequilla-con-Sal-Gloria-90g-1-351640701.jpg?v=638074246405000000', 'Mantequilla', 6.20, 15, 4, 4);
-- Licores
INSERT INTO product (id_product, description, expiration_date, image, name, price, stock, cod_brand_product, id_category) VALUES
(13, 'Vino Cabernet Franc El Enemigo 750 mL', '2023-12-24', 'https://wongfood.vtexassets.com/arquivos/ids/380082/492072-01-8646.jpg?v=637356601892930000', 'Vino', 109.90, 10, 5, 5),
(14, 'Beefeater Gin de 700 mL', '2025-01-15', 'https://falabella.scene7.com/is/image/FalabellaPE/17532540_1?wid=800&hei=800&qlt=70', 'Ginebra', 84.90, 12, 5, 5),
(15, 'Vino joven de 750 mL', '2024-02-12', 'https://s7d2.scene7.com/is/image/TottusPE/40688931_1?wid=800&hei=800&qlt=70', 'Vino', 34.90, 22, 5, 5);
-- Enlatados
INSERT INTO product (id_product, description, expiration_date, image, name, price, stock, cod_brand_product, id_category) VALUES
(16, 'Filete de atún Florida en agua - 12 unidades', '2023-12-24', 'https://plazavea.vteximg.com.br/arquivos/ids/5888358-512-512/20214125.jpg', 'Atun', 69.90, 200, 6, 6),
(17, 'Choclo Dulce Desgran VALLE FERTILX432GR', '2025-01-15', 'https://vivanda.vtexassets.com/arquivos/ids/236932-800-450?v=637426588631600000&width=800&height=450&aspect=true', 'Choclo', 8.90, 20, 6, 6),
(18, 'Filete de atún artesanal Campomar de 100 g', '2024-02-12', 'https://www.campomar.com.pe/img/produts/pro-2.png', 'Atun', 7.50, 21, 6, 6);


-- -----------------------------------------------------
-- Table `bd_borabora`.`user`
-- -----------------------------------------------------
INSERT INTO user (identity_doc, cellphone, email, lastname, name, password, username) VALUES
	(12345678,983456789,'jhon@gmail.com','Flores','Jhon','$2a$10$PF4v.aGrNkW5XsnhmAQUKufrPCfEA1iEEhQ/1B23UJJmaqfqjObOW','JhonFlores'),              -- USER
    (76236537,933249483,'carlos@gmail.com','Acosta','Carlos','$2a$10$PF4v.aGrNkW5XsnhmAQUKufrPCfEA1iEEhQ/1B23UJJmaqfqjObOW','CarlosAcosta'),        -- USER
    (65283765,927392746,'brigitte@gmail.com','Prieto','Brigitte','$2a$10$PF4v.aGrNkW5XsnhmAQUKufrPCfEA1iEEhQ/1B23UJJmaqfqjObOW','BrigittePrieto'),  -- ADMIN_FULL
    (52673894,923927485,'jefferson@gmail.com','Ferre','Jefferson','$2a$10$PF4v.aGrNkW5XsnhmAQUKufrPCfEA1iEEhQ/1B23UJJmaqfqjObOW','JeffersonFerre'); -- ADMIN_BASIC


-- -----------------------------------------------------
-- Table `bd_borabora`.`purchase`
-- -----------------------------------------------------
INSERT INTO purchase (purchase_id,igv,purchase_date,subtotal,total,type_order_id,payment_id,identity_doc)
VALUES (1, 0, '2022-01-01', 0, 0, 1, 123456789, 12345678),
	   (2, 0, '2022-05-05', 0, 0, 2, 789123456, 12345678);       


-- -----------------------------------------------------
-- Table `bd_borabora`.`purchase_product`
-- -----------------------------------------------------
INSERT INTO purchase_product (purchase_product_id,quantity,id_product,purchase_id)
VALUES (1, 2, 1, 1),
       (2, 1, 2, 2),
       (3, 3, 3, 1),
       (4, 1, 4, 1),
       (5, 2, 5, 2),
       (6, 1, 6, 2),
       (7, 4, 7, 2),
       (8, 2, 8, 2),
       (9, 3, 9, 2),
       (10, 1, 10, 1),
       (11, 2, 11, 1),
       (12, 1, 12, 1),
       (13, 3, 13, 2),
       (14, 1, 14, 2),
       (15, 2, 15, 2),
       (16, 1, 16, 1),
       (17, 2, 17, 1),
       (18, 1, 18, 1);


-- -----------------------------------------------------
-- Table `bd_borabora`.`role`
-- -----------------------------------------------------       
INSERT INTO role (role_id, name)
VALUES (1, 'ADMIN_FULL'),
	   (2, 'ADMIN_BASIC'),
       (3, 'USER');
 
 
 -- -----------------------------------------------------
-- Table `bd_borabora`.`user_roles`
-- -----------------------------------------------------
INSERT INTO user_roles (identity_doc,role_id)
VALUES (12345678, 3),
       (76236537, 3),
       (65283765, 2),
       (52673894, 1);

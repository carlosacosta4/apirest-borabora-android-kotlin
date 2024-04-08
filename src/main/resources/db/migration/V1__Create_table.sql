/*
 __   __   __   ___  __           __   __   __           __   __   __       
|__) /  \ |  \ |__  / _`  /\     |__) /  \ |__)  /\     |__) /  \ |__)  /\  
|__) \__/ |__/ |___ \__> /~~\    |__) \__/ |  \ /~~\    |__) \__/ |  \ /~~\ 

 */
 
 -- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bd_borabora
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bd_borabora
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bd_borabora` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `bd_borabora` ;

-- -----------------------------------------------------
-- Table `bd_borabora`.`brand_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_borabora`.`brand_product` (
  `cod_brand_product` INT NOT NULL AUTO_INCREMENT,
  `brand_product` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`cod_brand_product`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_borabora`.`card_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_borabora`.`card_type` (
  `cod_card_type` INT NOT NULL AUTO_INCREMENT,
  `type` CHAR(1) NOT NULL,
  PRIMARY KEY (`cod_card_type`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_borabora`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_borabora`.`category` (
  `id_category` INT NOT NULL AUTO_INCREMENT,
  `image` VARCHAR(255) NULL DEFAULT NULL,
  `name` VARCHAR(180) NULL DEFAULT NULL,
  PRIMARY KEY (`id_category`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_borabora`.`type_order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_borabora`.`type_order` (
  `type` VARCHAR(31) NOT NULL,
  `type_order_id` INT NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`type_order_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_borabora`.`district`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_borabora`.`district` (
  `cod_district` INT NOT NULL AUTO_INCREMENT,
  `district` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`cod_district`))
ENGINE = InnoDB
AUTO_INCREMENT = 17
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_borabora`.`delivery`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_borabora`.`delivery` (
  `address` VARCHAR(200) NULL DEFAULT NULL,
  `date` VARCHAR(255) NULL DEFAULT NULL,
  `department` VARCHAR(100) NULL DEFAULT NULL,
  `province` VARCHAR(100) NULL DEFAULT NULL,
  `ubigeo` INT NULL DEFAULT NULL,
  `type_order_id` INT NOT NULL,
  `cod_district` INT NOT NULL,
  PRIMARY KEY (`type_order_id`),
  INDEX `FK3i30fyn44cb2rknqf624v0ylx` (`cod_district` ASC) VISIBLE,
  CONSTRAINT `FK39uw068s3yte9jkogu0ay5404`
    FOREIGN KEY (`type_order_id`)
    REFERENCES `bd_borabora`.`type_order` (`type_order_id`),
  CONSTRAINT `FK3i30fyn44cb2rknqf624v0ylx`
    FOREIGN KEY (`cod_district`)
    REFERENCES `bd_borabora`.`district` (`cod_district`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_borabora`.`headquarter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_borabora`.`headquarter` (
  `cod_headquarter` INT NOT NULL AUTO_INCREMENT,
  `headquarter` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`cod_headquarter`),
  UNIQUE INDEX `UK_djy0xsfmqvs9acv7i76wd31h1` (`headquarter` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_borabora`.`status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_borabora`.`status` (
  `codigo_status` INT NOT NULL AUTO_INCREMENT,
  `status` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`codigo_status`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_borabora`.`payment_gateway`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_borabora`.`payment_gateway` (
  `payment_id` INT NOT NULL AUTO_INCREMENT,
  `amount` DOUBLE NULL DEFAULT NULL,
  `card` VARCHAR(255) NULL DEFAULT NULL,
  `currency` VARCHAR(255) NULL DEFAULT NULL,
  `quota_number` VARCHAR(255) NULL DEFAULT NULL,
  `trace_number` VARCHAR(255) NULL DEFAULT NULL,
  `transaction_date` VARCHAR(255) NULL DEFAULT NULL,
  `cod_card_type` INT NOT NULL,
  `codigo_status` INT NOT NULL,
  PRIMARY KEY (`payment_id`),
  INDEX `FK3w3m25lntorftjbtxjvvlpurt` (`cod_card_type` ASC) VISIBLE,
  INDEX `FK1svk24dtthkvq1teu62vigkte` (`codigo_status` ASC) VISIBLE,
  CONSTRAINT `FK1svk24dtthkvq1teu62vigkte`
    FOREIGN KEY (`codigo_status`)
    REFERENCES `bd_borabora`.`status` (`codigo_status`),
  CONSTRAINT `FK3w3m25lntorftjbtxjvvlpurt`
    FOREIGN KEY (`cod_card_type`)
    REFERENCES `bd_borabora`.`card_type` (`cod_card_type`))
ENGINE = InnoDB
AUTO_INCREMENT = 789123457
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_borabora`.`pick_up`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_borabora`.`pick_up` (
  `date` VARCHAR(255) NULL DEFAULT NULL,
  `type_order_id` INT NOT NULL,
  `cod_headquarter` INT NOT NULL,
  PRIMARY KEY (`type_order_id`),
  INDEX `FK5n1p7sghstbc7uv1mkudrre1j` (`cod_headquarter` ASC) VISIBLE,
  CONSTRAINT `FK5n1p7sghstbc7uv1mkudrre1j`
    FOREIGN KEY (`cod_headquarter`)
    REFERENCES `bd_borabora`.`headquarter` (`cod_headquarter`),
  CONSTRAINT `FKbgv7u01qy2e2gnocg0mkv2fc2`
    FOREIGN KEY (`type_order_id`)
    REFERENCES `bd_borabora`.`type_order` (`type_order_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_borabora`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_borabora`.`product` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(255) NULL DEFAULT NULL,
  `expiration_date` DATE NULL DEFAULT NULL,
  `image` LONGTEXT NULL DEFAULT NULL,  -- Modificado aquí
  `name` VARCHAR(180) NULL DEFAULT NULL,
  `price` DOUBLE NULL DEFAULT NULL,
  `stock` INT NULL DEFAULT NULL,
  `cod_brand_product` INT NOT NULL,
  `id_category` INT NOT NULL,
  PRIMARY KEY (`id_product`),
  INDEX `FKt5p44087wjsrd9pdhpccwjk18` (`cod_brand_product` ASC) VISIBLE,
  INDEX `FK5cxv31vuhc7v32omftlxa8k3c` (`id_category` ASC) VISIBLE,
  CONSTRAINT `FK5cxv31vuhc7v32omftlxa8k3c`
    FOREIGN KEY (`id_category`)
    REFERENCES `bd_borabora`.`category` (`id_category`),
  CONSTRAINT `FKt5p44087wjsrd9pdhpccwjk18`
    FOREIGN KEY (`cod_brand_product`)
    REFERENCES `bd_borabora`.`brand_product` (`cod_brand_product`))
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

-- aumento de campo deleted - en false ya que pasara en true cuando se elimine(deje de usar) un producto
ALTER TABLE `bd_borabora`.`product`
ADD COLUMN `deleted` BOOLEAN NOT NULL DEFAULT FALSE;
-- -----------------------------------------------------
-- Table `bd_borabora`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_borabora`.`user` (
  `identity_doc` INT NOT NULL,
  `cellphone` INT NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `lastname` VARCHAR(80) NOT NULL,
  `name` VARCHAR(80) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `username` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`identity_doc`),
  UNIQUE INDEX `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_borabora`.`purchase`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_borabora`.`purchase` (
  `purchase_id` INT NOT NULL AUTO_INCREMENT,
  `igv` DOUBLE NULL DEFAULT NULL,
  `purchase_date` DATE NULL DEFAULT NULL,
  `subtotal` DOUBLE NULL DEFAULT NULL,
  `total` DOUBLE NULL DEFAULT NULL,
  `type_order_id` INT NULL DEFAULT NULL,
  `payment_id` INT NOT NULL,
  `identity_doc` INT NOT NULL,
  PRIMARY KEY (`purchase_id`),
  UNIQUE INDEX `UK_qaloct5tpu0nc5xtpkx5vg2i7` (`payment_id` ASC) VISIBLE,
  INDEX `FKasywrquudycgkvq4ri123lhc7` (`type_order_id` ASC) VISIBLE,
  INDEX `FKf96nfiede5nv7mxari038k4jy` (`identity_doc` ASC) VISIBLE,
  CONSTRAINT `FKasywrquudycgkvq4ri123lhc7`
    FOREIGN KEY (`type_order_id`)
    REFERENCES `bd_borabora`.`type_order` (`type_order_id`),
  CONSTRAINT `FKf96nfiede5nv7mxari038k4jy`
    FOREIGN KEY (`identity_doc`)
    REFERENCES `bd_borabora`.`user` (`identity_doc`),
  CONSTRAINT `FKq30nqstnijtyd86emwsjsesja`
    FOREIGN KEY (`payment_id`)
    REFERENCES `bd_borabora`.`payment_gateway` (`payment_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_borabora`.`purchase_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_borabora`.`purchase_product` (
  `purchase_product_id` INT NOT NULL AUTO_INCREMENT,
  `quantity` INT NULL DEFAULT NULL,
  `id_product` INT NOT NULL,
  `purchase_id` INT NOT NULL,
  PRIMARY KEY (`purchase_product_id`),
  INDEX `FKg5yytysw8njnead9m9xguuf7f` (`id_product` ASC) VISIBLE,
  INDEX `FK1te3j5efipmc5c19wve8c90qd` (`purchase_id` ASC) VISIBLE,
  CONSTRAINT `FK1te3j5efipmc5c19wve8c90qd`
    FOREIGN KEY (`purchase_id`)
    REFERENCES `bd_borabora`.`purchase` (`purchase_id`),
  CONSTRAINT `FKg5yytysw8njnead9m9xguuf7f`
    FOREIGN KEY (`id_product`)
    REFERENCES `bd_borabora`.`product` (`id_product`))
ENGINE = InnoDB
AUTO_INCREMENT = 19
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_borabora`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_borabora`.`role` (
  `role_id` INT NOT NULL AUTO_INCREMENT,
  `name` ENUM('ADMIN_BASIC', 'ADMIN_FULL', 'USER') NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `bd_borabora`.`user_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bd_borabora`.`user_roles` (
  `identity_doc` INT NOT NULL,
  `role_id` INT NOT NULL,
  PRIMARY KEY (`identity_doc`, `role_id`),
  INDEX `FKrhfovtciq1l558cw6udg0h0d3` (`role_id` ASC) VISIBLE,
  CONSTRAINT `FKn0rol8ueqtpkil9o5h58jpo7a`
    FOREIGN KEY (`identity_doc`)
    REFERENCES `bd_borabora`.`user` (`identity_doc`),
  CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3`
    FOREIGN KEY (`role_id`)
    REFERENCES `bd_borabora`.`role` (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

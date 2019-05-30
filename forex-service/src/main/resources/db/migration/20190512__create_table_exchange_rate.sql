CREATE TABLE `exchange_rate` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `currency_from` VARCHAR(45) NULL,
  `currency_to` VARCHAR(45) NULL,
  `conversion_multiple` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
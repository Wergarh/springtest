CREATE TABLE `spring`.`cars` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `model` VARCHAR(45) NULL,
  `user` VARCHAR(45) NULL,
  `color` VARCHAR(45) NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `id_UNIQUE` (`userId` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `spring`.`user` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `cars` VARCHAR(45) NULL,
  `age` VARCHAR(45) NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `id_UNIQUE` (`userId` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

INSERT INTO `spring`.`user` (`userId`, `age`, `name`) VALUES ('1', '99', 'Alex');
INSERT INTO `spring`.`cars` (`userId`, `color`, `model`, `user`) VALUES ('1', 'Red', 'Ferrari', '1');

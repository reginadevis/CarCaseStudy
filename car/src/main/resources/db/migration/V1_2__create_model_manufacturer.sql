alter table car add column manufacturer_id int not null after manufacturer;

alter table car add column model_id int not null after model;

alter table car drop column manufacturer;

alter table car drop column model;

CREATE TABLE IF NOT EXISTS `manufacturer` (
    `manufacturer_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `manufacturer` varchar(50)
);

ALTER TABLE car ADD CONSTRAINT fk_manufacturer FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(manufacturer_id);

CREATE TABLE IF NOT EXISTS `model` (
    `model_id` int NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `model` varchar(50),
    `manufacturer_id` int not null
);

ALTER TABLE model ADD CONSTRAINT fk_makemodel FOREIGN KEY (manufacturer_id) REFERENCES manufacturer(manufacturer_id);

ALTER TABLE car ADD CONSTRAINT fk_model FOREIGN KEY (model_id) REFERENCES model(model_id);
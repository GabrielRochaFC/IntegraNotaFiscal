CREATE TABLE IF NOT EXISTS `address`
(
    `id`           INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `street`       VARCHAR(255),
    `number`       INT,
    `neighborhood` VARCHAR(255),
    `state`        VARCHAR(255),
    `city`         VARCHAR(255),
    `cep`          VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS `company_details`
(
    `id`                 INT                                                               NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `cnpj`               VARCHAR(255)                                                      NOT NULL UNIQUE,
    `company_name`       VARCHAR(255)                                                      NOT NULL,
    `trade_name`         VARCHAR(255)                                                      NOT NULL,
    `state_registration` VARCHAR(255)                                                      NOT NULL,
    `tax_regime`         ENUM ('MEI', 'SIMPLES_NACIONAL', 'LUCRO_REAL', 'LUCRO_PRESUMIDO') NOT NULL,
    `address_id`         INT,
    `user_id`            INT,
    FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE SET NULL,
    FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS `client_details`
(
    `id`                 INT                  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`               VARCHAR(255)         NOT NULL,
    `company_name`       VARCHAR(255)         NOT NULL,
    `cpf_cnpj`           VARCHAR(255)         NOT NULL,
    `state_registration` VARCHAR(255),
    `address_id`         INT,
    `tipo_pessoa`        ENUM ('CPF', 'CNPJ') NOT NULL,
    `user_id`            INT,
    FOREIGN KEY (`address_id`) REFERENCES `address` (`id`) ON DELETE SET NULL,
    FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS `invoice`
(
    `id`                 INT            NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `date`               DATETIME       NOT NULL,
    `total_value`        DECIMAL(10, 2) NOT NULL,
    `tax_value`          DECIMAL(10, 2) NOT NULL,
    `description`        TEXT,
    `client_details_id`  INT,
    `company_details_id` INT,
    `subscriptions_id`   INT,
    FOREIGN KEY (`client_details_id`) REFERENCES `client_details` (`id`) ON DELETE SET NULL,
    FOREIGN KEY (`company_details_id`) REFERENCES `company_details` (`id`) ON DELETE SET NULL,
    FOREIGN KEY (`subscriptions_id`) REFERENCES `subscriptions` (`id`) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS `invoice_settings`
(
    `id`               INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id`          INT          NOT NULL,
    `invoice_model`    VARCHAR(255) NOT NULL,
    `issue_on`         ENUM ('VENDA', 'PAGAMENTO', 'APROVADO'),
    `send_by_email`    BOOLEAN DEFAULT 0,
    `cancel_on_refund` BOOLEAN DEFAULT 0,
    FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
);

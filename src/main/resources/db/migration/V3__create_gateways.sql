CREATE TABLE IF NOT EXISTS `gateways`
(
    `id`          INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`        VARCHAR(255) NOT NULL UNIQUE,
    `description` TEXT
);

CREATE TABLE IF NOT EXISTS `users_gateways`
(
    `id`                     INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `user_id`                INT          NOT NULL,
    `gateway_id`             INT          NOT NULL,
    `api_key_public`         VARCHAR(255) NOT NULL,
    `api_key_secret`         VARCHAR(255),
    `webhook_url`            VARCHAR(255) NOT NULL,
    `webhook_token`          VARCHAR(255),
    `integration_start_date` DATE         NOT NULL,
    `guarantee_days`         INT,
    `status`                 BOOLEAN,
    FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE,
    FOREIGN KEY (`gateway_id`) REFERENCES `gateways` (`id`) ON DELETE RESTRICT
);
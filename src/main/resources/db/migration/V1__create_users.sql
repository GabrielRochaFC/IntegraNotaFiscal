CREATE TABLE IF NOT EXISTS `users_type`
(
    `id`          INT                                  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `type`        ENUM ('ADMIN', 'USER', 'SUBSCRIBER') NOT NULL,
    `description` TEXT
);

CREATE TABLE IF NOT EXISTS `users`
(
    `id`            INT                 NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `name`          VARCHAR(255)        NOT NULL,
    `email`         VARCHAR(255) UNIQUE NOT NULL,
    `password`      VARCHAR(255)        NOT NULL,
    `created_at`    DATETIME            NOT NULL,
    `users_type_id` INT                 NOT NULL,
    FOREIGN KEY (`users_type_id`) REFERENCES `users_type` (`id`) ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS `subscriptions_type`
(
    `id`      INT            NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `type`    VARCHAR(255)   NOT NULL,
    `value`   DECIMAL(10, 2) NOT NULL,
    `enabled` BOOLEAN
);

CREATE TABLE IF NOT EXISTS `subscriptions`
(
    `id`                    INT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `date_subscription`     DATE NOT NULL,
    `notes_printed`         INT  NOT NULL,
    `subscriptions_type_id` INT,
    `users_id`              INT,
    FOREIGN KEY (`subscriptions_type_id`) REFERENCES `subscriptions_type` (`id`) ON DELETE SET NULL,
    FOREIGN KEY (`users_id`) REFERENCES `users` (`id`) ON DELETE CASCADE
);
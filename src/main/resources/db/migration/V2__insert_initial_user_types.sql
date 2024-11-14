-- V2__insert_initial_user_types.sql

-- Adicionar restrição de unicidade no campo 'type'
ALTER TABLE `users_type`
    ADD CONSTRAINT `unique_user_type` UNIQUE (`type`);

-- Inserir registros iniciais na tabela 'users_type'
INSERT INTO `users_type` (`type`, `description`)
VALUES ('ADMIN', 'Administrator with full access'),
       ('USER', 'Regular user with standard permissions'),
       ('SUBSCRIBER', 'User with subscription-based access');
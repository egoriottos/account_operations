CREATE TABLE balance
(
    id            UUID PRIMARY KEY,
    balance       DECIMAL(19, 4) NOT NULL,
    name          VARCHAR(255)   NOT NULL,
    currency_type VARCHAR(50) DEFAULT 'USD',
    created_at    TIMESTAMP   DEFAULT CURRENT_TIMESTAMP
);

ALTER TABLE balance
    ADD CONSTRAINT uk_balance_name UNIQUE (name);

CREATE TABLE transaction
(
    id           UUID PRIMARY KEY,
    type         VARCHAR(50)    NOT NULL,
    amount       DECIMAL(19, 4) NOT NULL,
    balance_id   UUID   NOT NULL,
    created_at   TIMESTAMP      NOT NULL,
    CONSTRAINT fk_transaction_balance FOREIGN KEY (balance_id) REFERENCES balance (id)
);
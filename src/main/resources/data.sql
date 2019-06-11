DROP TABLE IF EXISTS account;

CREATE TABLE account (
  accountNumber VARCHAR(20) NOT NULL,
  accountName VARCHAR(100) NOT NULL,
  type VARCHAR(100) NOT NULL,
  currency VARCHAR(10) NOT NULL,
  balance DECIMAL(100) NOT NULL,
  balanceDate DATETIME NOT NULL,
);

DROP TABLE IF EXISTS accountTransaction;

CREATE TABLE accountTransaction(
    accountName VARCHAR(100) NOT NULL,
    accountNumber VARCHAR(20) NOT NULL,
    currency VARCHAR(10) NOT NULL,
    debitAmount DECIMAL(100) ,
    creditAmount DECIMAL(100) ,
    type VARCHAR(10) NOT NULL
);

INSERT INTO account (accountNumber, accountName, type, currency, balance, balanceDate)
values ('12345','chan','savings','AUD','1000.00','2018-01-09'),
('12345786','john','current','AUD','6565.00','2018-05-06'),
('765675','paul','savings','AUD','89787.00','2018-01-02'),
('98798798','cath','savings','AUD','98987.00','2019-01-09');


INSERT INTO accountTransaction (accountName, accountNumber, currency, debitAmount, creditAmount, type)
values('Current','12345','AUD',null,'200.00','credit'),
('Current','12345','AUD','100.00',null,'debit'),
('Current','12345','AUD',null,'600.00','credit'),
('Savings','12345','AUD',null,'100.00','credit'),
('Current','12345','AUD','50.00',null,'debit'),
('Current','98798798','AUD','50.00',null,'debit'),
('Savings','98798798','AUD','50.00',null,'debit'),
('Savings','98798798','AUD','350.00',null,'debit'),
('Current','98798798','AUD','50.00',null,'debit'),
('Current','98798798','AUD','750.00',null,'debit'),
('Savings','98798798','AUD','150.00',null,'debit'),
('Current','12345786','AUD',null,'342.00','credit'),
('Current','12345786','AUD','50.00',null,'debit'),
('Current','12345786','AUD',null,'350.00','credit'),
('Current','12345786','AUD','50.00',null,'debit'),
('Current','12345786','AUD',null,'750.00','credit'),
('Savings','12345786','AUD','150.00',null,'debit'),
('Current','765675','AUD',null,'342.00','credit'),
('Current','765675','AUD','50.00',null,'debit'),
('Current','765675','AUD',null,'350.00','credit'),
('Savings','765675','AUD','50.00',null,'debit'),
('Current','765675','AUD',null,'750.00','credit'),
('Current','765675','AUD','150.00',null,'debit');
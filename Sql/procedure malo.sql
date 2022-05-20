use user;
#-----------------------------------------------------------------------
drop database user;
#-----------------------------------------------------------------------
DELIMITER $
CREATE PROCEDURE setBalance( balance DOUBLE, typ BOOLEAN)

IF (typ=0) THEN 

UPDATE balance from user_coin INNER JOIN transaction ON user_coin.id_coin=transaction.id_coin 
AND user_coin.id_user=transaction.id_user 
SET user_coin.balance = user_coin.balance + transanction.balance;

ELSEIF (typ=1) THEN
UPDATE user_coin INNER JOIN tran ON user_coin.id_coin=transaction.id_coin 
AND user_coin.id_user=transaction.id_user 
SET user_coin.balance = user_coin.balance - transaction.balance;

END IF ;

DELIMITER $;
#-----------------------------------------------------------------------
UPDATE user_coin INNER JOIN transaction  ON user_coin.id_account =transaction.id_coin 
AND user_coin.id_user=transaction.id_user 
SET user_coin.balance = user_coin.balance + transaction.balance;
#-----------------------------------------------------------------------
UPDATE user_coin
        INNER JOIN transaction ON user_coin.id_coin=transaction.id_coin
        INNER JOIN user_coin ON user_coin.id_user=transaction.id_user
        SET user_coin.balance = user_coin.balance + transanction.balance;
#--------------------------------------------------------------------------

UPDATE user_coin
    SET user_coin.balance = user_coin.balance + transanction.balance
        INNER JOIN transaction ON coin.id_coin=transaction.id_coin
        WHERE user_coin.id_user=1 AND user_coin.id_coin = 1;
#--------------------------------------------------------------------------

DELIMITER $
CREATE PROCEDURE setBalance( balance DOUBLE, typ BOOLEAN)

IF (typ=0) THEN 

UPDATE FROM user_coin uc INNER JOIN transaction t ON uc.id_coin=t.id_coin 
AND uc.id_user=t.id_user 
SET uc.balance = uc.balance + t.balance;

ELSE IF (typ=1) THEN

UPDATE FROM user_coin uc INNER JOIN transaction t ON uc.id_coin=t.id_coin 
AND uc.id_user=t.id_user 
SET uc.balance = uc.balance - t.balance;

END IF;

DELIMITER $;.


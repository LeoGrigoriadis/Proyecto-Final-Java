use user;

DELIMITER $
    drop trigger if exists cancel_transaction $
    CREATE TRIGGER cancel_transaction 
    BEFORE UPDATE ON user_coin
    FOR EACH ROW 
    BEGIN 
    
    IF NEW.balance < 0 THEN
    SIGNAL SQLSTATE '42927'
    SET MESSAGE_TEXT = 'Algo salió mal.';
    END IF;
    END $
DELIMITER ;

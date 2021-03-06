
CREATE TABLE transfer_log(
    acc_no_1 NUMBER(8),
    acc_no_2 NUMBER(8),
    amt NUMBER(7),
    date_of_transfer DATE
);

CREATE OR REPLACE PROCEDURE transfer (acc_1 Account.acc_no%Type, acc_2 Account.acc_no%Type, amt NUMBER, sf IN OUT NUMBER) AS

    bal account.balance%TYPE;
    insufficientBalanceException EXCEPTION;

BEGIN
    SELECT balance INTO bal FROM account WHERE acc_no = acc_1;
    bal := bal - amt;

    IF bal < 0 THEN
        RAISE insufficientBalanceException;
    ELSE
        COMMIT;
        UPDATE account SET balance = bal WHERE acc_no = acc_1;
        UPDATE account SET balance = balance + amt WHERE acc_no = acc_2;
        COMMIT;
        INSERT INTO transfer_log VALUES (acc_1, acc_2, amt, CURRENT_DATE);
        sf := 0;
    END IF;

    EXCEPTION
        WHEN insufficientBalanceException THEN
        DBMS_OUTPUT.PUT_LINE('Not enough balance');
        sf := 1;

END;
/


CREATE OR REPLACE PROCEDURE withdrawal(amnt number,accno account.acc_no%TYPE, sf IN OUT NUMBER) AS

    CantWithDraw EXCEPTION;
    current_amnt account.balance%TYPE;

BEGIN

    SELECT balance into current_amnt FROM account WHERE acc_no = accno;

    IF amnt > current_amnt THEN
        RAISE CantWithDraw;
    ELSE
        UPDATE account SET balance = balance - amnt WHERE acc_no = accno;
        COMMIT;
        sf := 0;
    END IF;

    EXCEPTION
        WHEN CantWithDraw THEN
        DBMS_OUTPUT.PUT_LINE('Can not Withdraw');
        sf := 1;

END;
/


CREATE TABLE log_account
(
    acc_no NUMBER(8),
    balance NUMBER(10),
    acc_type VARCHAR(8),
    action_done VARCHAR(10) CHECK(action_done IN('inserted','deleted'))
);


CREATE OR REPLACE TRIGGER change_acc
AFTER INSERT OR DELETE ON account
FOR EACH ROW
BEGIN
    CASE
        WHEN INSERTING THEN
            INSERT INTO log_account VALUES(:NEW.acc_no,:NEW.balance,:NEW.acc_type,'inserted');
        WHEN DELETING THEN
            INSERT INTO log_account VALUES(:OLD.acc_no,:OLD.balance,:OLD.acc_type,'deleted');
    END CASE;
END;
/

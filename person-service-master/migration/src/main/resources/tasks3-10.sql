-- Task 3
SELECT * FROM medical_schema.address
LEFT JOIN medical_schema.contact ON  medical_schema.address.contact_id = medical_schema.contact.id;

-- Task 4
DELETE FROM medical_schema.contact as contactA
WHERE contactA.email <> (SELECT min(contactB.email)
                  FROM   medical_schema.contact as contactB
                  WHERE  contactA.id = contactB.id)
  AND contactA.phone_number <> (SELECT min(contactB.phone_number)
                         FROM   medical_schema.phone_number contactB
                         WHERE  contactA.id = contactB.id)
  AND contactA.profile_link <> (SELECT min(contactB.profile_link)
                         FROM   medical_schema.profile_link contactB
                         WHERE  contactA.id = contactB.id);

--Task 5
SELECT * FROM medical_schema.contact  as contact
ORDER BY contact.id ASC
    LIMIT (SELECT count(*)/2 FROM medical_schema.contact);

--Task 6
SELECT parent.first_name, child.first_name, m.med_status FROM medical_schema.person_data  as parent
RIGHT JOIN medical_schema.person_data as child ON parent.parent_id = child.id
LEFT JOIN medical_schema.medical_card as m ON parent.medical_card_id = m.id
WHERE m.med_status IS NULL;

--Task 7
CREATE VIEW med_view AS
(
    SELECT a.*, c.phone_number, c.email, c.profile_link FROM medical_schema.person_data as a
    JOIN medical_schema.contact as c ON a.contact_id = c.id
);


--Task 8
CREATE OR REPLACE function display_contact()
returns table(id bigint, p_n varchar, e varchar, p_l text)
AS $$
BEGIN
RETURN QUERY SELECT contact.id, contact.phone_number, contact.email, contact.profile_link FROM medical_schema.contact as contact;
END;
$$ LANGUAGE plpgsql

--Task 9
CREATE OR REPLACE PROCEDURE change_medical_status(ide bigint, status char)
AS $$
BEGIN
UPDATE medical_schema.medical_card as m_c
SET med_status = status
WHERE id = ide;
END;
$$ LANGUAGE plpgsql

--Task 10

CREATE TRIGGER med_status_trigger
    BEFORE insert
    ON medical_schema.medical_card
    FOR EACH ROW
    EXECUTE PROCEDURE change_client_status();

CREATE OR REPLACE FUNCTION change_client_status()
returns TRIGGER
AS $$
BEGIN
UPDATE medical_schema.medical_card as m_c
SET client_status = 'd'
WHERE id = 1;
END;
$$ LANGUAGE plpgsql

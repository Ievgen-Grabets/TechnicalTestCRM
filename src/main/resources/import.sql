INSERT INTO activity_types (name)
SELECT * FROM (SELECT 'Call') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM activity_types WHERE name = 'Call'
) LIMIT 1;

INSERT INTO activity_types (name)
SELECT * FROM (SELECT 'Email') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM activity_types WHERE name = 'Email'
) LIMIT 1;

INSERT INTO activity_types (name)
SELECT * FROM (SELECT 'Meeting') AS tmp
WHERE NOT EXISTS (
    SELECT name FROM activity_types WHERE name = 'Meeting'
) LIMIT 1;
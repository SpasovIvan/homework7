--drop table if exists discipline cascade;
drop table if exists students cascade;
--drop table if exists students_marks cascade;

CREATE TABLE students (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(100),
                          subject VARCHAR(100),
                          grade INT);

INSERT INTO students (name, subject, grade) VALUES
                                                ('Иван', 'Математика', 95),
                                                ('Петр', 'Физика', 85),
                                                ('Мария', 'Математика', 95),
                                                ('Анна', 'Физика', 75),
                                                ('Сергей', 'Математика', 85),
                                                ('Елена', 'Физика', 75),
                                                ('Алексей', 'Математика', 85),
                                                ('Наталья', 'Физика', 75),
                                                ('Дмитрий', 'Математика', 75),
                                                ('Ольга', 'Физика', 95);

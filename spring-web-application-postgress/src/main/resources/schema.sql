-- -- INSERT EMPLOYEE

-- INSERT INTO employee (employee_id, first_name, last_name, email) VALUES (100, 'Joe', 'Doe', 'joe@doe.com');
-- INSERT INTO employee (employee_id, first_name, last_name, email) VALUES (101, 'Jane', 'Alyx', 'jane@alyx.com');
-- INSERT INTO employee (employee_id, first_name, last_name, email) VALUES (102, 'Adam', 'Yosemi', 'adam@yosemi.com');
-- INSERT INTO employee (employee_id, first_name, last_name, email) VALUES (103, 'Sam', 'John', 'sam@john.com');
-- INSERT INTO employee (employee_id, first_name, last_name, email) VALUES (104, 'Keith', 'Yim', 'keith@yim.com');
-- INSERT INTO employee (employee_id, first_name, last_name, email) VALUES (105, 'Kubilay', 'Cakmak', 'kubilay@cakmak.com');

-- -- INSERT PROJECT

-- INSERT INTO project (project_id, project_name, project_stage, project_description) VALUES (1, 'Project 1', 'IN-PROGRESS', 'test');
-- INSERT INTO project (project_id, project_name, project_stage, project_description) VALUES (2, 'Project 2', 'IN-PROGRESS', 'test');
-- INSERT INTO project (project_id, project_name, project_stage, project_description) VALUES (3, 'Project 3', 'COMPLETED', 'test');
-- INSERT INTO project (project_id, project_name, project_stage, project_description) VALUES (4, 'Project 4', 'COMPLETED', 'test');
-- INSERT INTO project (project_id, project_name, project_stage, project_description) VALUES (5, 'Project 5', 'COMPLETED', 'test');
-- INSERT INTO project (project_id, project_name, project_stage, project_description) VALUES (6, 'Project 6', 'CANCELED', 'test');

-- -- COMPLETED, CANCELED, IN-PROGRESS
-- -- INSERT PROJECT_EMPLOYEE

-- INSERT INTO project_employee (project_id, employee_id) VALUES (1, 100);
-- INSERT INTO project_employee (project_id, employee_id) VALUES (2, 100);
-- INSERT INTO project_employee (project_id, employee_id) VALUES (3, 100);
-- INSERT INTO project_employee (project_id, employee_id) VALUES (3, 101);
-- INSERT INTO project_employee (project_id, employee_id) VALUES (3, 102);
-- INSERT INTO project_employee (project_id, employee_id) VALUES (4, 104);
-- INSERT INTO project_employee (project_id, employee_id) VALUES (4, 103);
-- INSERT INTO project_employee (project_id, employee_id) VALUES (4, 102);
-- INSERT INTO project_employee (project_id, employee_id) VALUES (5, 104);
-- INSERT INTO project_employee (project_id, employee_id) VALUES (6, 103);

-- -- SELECT e.first_name, e.last_name
-- -- FROM employee e
-- -- LEFT JOIN project_employee pe
-- -- ON e.employee_id = pe.employee_id;
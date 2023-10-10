-- @Id
-- @GeneratedValue(strategy = GenerationType.IDENTITY)
-- Long id;

-- @NotBlank
-- String nome;

-- @NotBlank @Email
-- String email;

-- @Past
-- Calendar dataNascimento;

INSERT INTO STUDENTS (id, nome, email, status) VALUES (1, 'João', 'joao@email.com', 1);
INSERT INTO STUDENTS (id, nome, email, status) VALUES (2, 'Maria', 'maria@email.com', 0);
INSERT INTO STUDENTS (id, nome, email, status) VALUES (3, 'Pedro', 'pedro@email.com', 1);

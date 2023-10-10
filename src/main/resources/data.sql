-- @Id
-- @GeneratedValue(strategy = GenerationType.IDENTITY)
-- Long id;

-- @NotBlank
-- String nome;

-- @NotBlank @Email
-- String email;

-- @Past
-- Calendar dataNascimento;

INSERT INTO STUDENTS (nome, email, status) VALUES ('João', 'joao@email.com', 1);
INSERT INTO STUDENTS (nome, email, status) VALUES ('Maria', 'maria@email.com', 0);
INSERT INTO STUDENTS (nome, email) VALUES ('Pedro', 'pedro@email.com');

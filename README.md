projeto-biblioteca/
├─ biblioteca-api/ # Backend (Spring Boot)
├─ frontend-biblioteca/ # Frontend (React)
├─ pom.xml
└─ README.md


---

## 🚀 Como rodar o projeto

### Backend
1. Configure o banco de dados MySQL e atualize `application.properties` com suas credenciais.
2. No terminal, entre na pasta `biblioteca-api`:
```bash
cd C:\demo\projeto-biblioteca\biblioteca-api
mvn clean install
mvn spring-boot:run


O backend rodará na porta 8080 por padrão.

Frontend

No terminal, entre na pasta frontend-biblioteca:

cd C:\demo\projeto-biblioteca\frontend-biblioteca
npm install
npm start


O frontend rodará na porta 3000 por padrão.

Abra http://localhost:3000 no navegador.

📌 Funcionalidades

Cadastrar livros (título e autor)

Listar todos os livros cadastrados

Layout moderno com cores, ícones e animações

Tratamento de erros e carregamento

🔗 API

GET /livros → Lista todos os livros

POST /livros → Cadastra um livro (JSON com titulo e autor)

🎨 Frontend

Componentes:

Home.js: página principal

LivroForm.js: formulário de cadastro

LivroList.js: lista de livros com animação

Estilizado com CSS moderno e ícones (react-icons)

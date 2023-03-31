# :card_index_dividers:Indice

- [Sobre o projeto](#sobre-o-projeto)
- [Tecnologias utilizadas](#tecnologias-utilizadas)
- [Como baixar o projeto](#como-baixar-o-projeto)
- [Fotos do projeto](#fotos-do-projeto)

# Sobre o projeto 
O projeto Voce Mais Tech foi desenvolvido para prática de vários conceitos de programação, mas tendo como objetivo ser um projeto com possibilidade de escalonamento, podendo em breve se tornar um portal de conteúdo sobre programação, facilitando o aprendizado de novos programadores com conteúdos compartilhados gratuitamente. 

Projeto pode ser acessado através do link: www.vocemaistech.com.br

# Tecnologias utilizadas:
- Java 17;
- SpringBoot 3.0;
- SpringSecurity;
- Spring Jpa;
- Lombok;
- H2 Database;
- PostgreSQL;
- Postman;
- Eclipse;
- Visual Studio Code;
- Angular 15.0.4;
- AWS;

# Como baixar o projeto
```bash
# Clone o repositório com o comando abaixo
$ git clone https://github.com/AbnerLuan/vocemaistech

# Utilize preferencialmente a IDE eclipse (foi a IDE utilizada no desenvolvimento)
$ 

# Inicie o projeto localmente e acesso-o pelo endereco `http://localhost:8080/`.
$ 
```

# Principais Funcionalidades
- Cadastro de usuário;
- Login de usuário com retorno de token JWT;
- Visualização e edição dos dados do usuário logado;
- Cadastramento de permissões de usuário por roles;
- Para usuário com permissão, poderá criar postagem que aparecerá na sessão "Blog";
- Carregamento de imagem na postagem do blog, salvando a imagem na AWS S3 e o link da imagem no banco de dados;
- Área de administrador (só pode acessar quem tem a ROLE_ADMIN);
- Admin poderá listar, editar ou excluir qualquer usuário do sistema;
- Admin poderá editar ou excluir qualquer postagem feita no Blog;
- Entre outros.

# Fotos do Projeto

## Login/Cadastro:closed_lock_with_key: 
<img src="https://ik.imagekit.io/uuvdtlvst/Captura_de_tela_2023-03-31_121041.png?updatedAt=1680275466610">

## Minha Conta:technologist:
<img src="https://ik.imagekit.io/uuvdtlvst/Captura_de_tela_2023-03-31_122108.png?updatedAt=1680276648052">

## Criar Postagem Blog (obs: Apenas usuários com permissão):customs:
<img src="https://ik.imagekit.io/uuvdtlvst/Captura_de_tela_2023-03-31_121215.png?updatedAt=1680276647998">

## Página exibição das postagens:customs:
<img src="https://ik.imagekit.io/uuvdtlvst/Captura_de_tela_2023-03-31_121236.png?updatedAt=1680276648701">

## Página de Admin - Lista todos usuários:scroll:
<img src="https://ik.imagekit.io/uuvdtlvst/Captura_de_tela_2023-03-31_122057.png?updatedAt=1680276648027">

## Página de Admin - Editando usuarios e permissões:scroll:
<img src="https://ik.imagekit.io/uuvdtlvst/Captura_de_tela_2023-03-31_122400.png?updatedAt=1680276648077">

## Página de Admin - Listando as postagens do Blog:scroll:
<img src="https://ik.imagekit.io/uuvdtlvst/Captura_de_tela_2023-03-31_122411.png?updatedAt=1680276648487">

## Página de Admin - Editando uma postagem do Blog:scroll:
<img src="https://ik.imagekit.io/uuvdtlvst/Captura_de_tela_2023-03-31_122439.png?updatedAt=1680276648294">

## Página de Admin - Alterando a imagem principal da postagem:scroll:
<img src="https://ik.imagekit.io/uuvdtlvst/Captura_de_tela_2023-03-31_122458.png?updatedAt=1680276648192">






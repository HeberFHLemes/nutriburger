<div align='center'>

# NutriBurger

![Angular](https://img.shields.io/badge/angular-%23DD0031.svg?style=for-the-badge&logo=angular&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) 
![Java](https://img.shields.io/badge/java-white.svg?style=for-the-badge&logo=openjdk&logoColor=black) ![TypeScript](https://img.shields.io/badge/typescript-%23007ACC.svg?style=for-the-badge&logo=typescript&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white) ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

</div>

## Website para o cardápio digital de uma hamburgueria

NutriBurger é uma aplicação que permite a visualização do cardápio completo de produtos, além de seus dados nutricionais, e as informações de contato e endereço da hamburgueria/restaurante.

> Todas as informações apresentadas são exemplos.

---
### 🛠️ Requisitos
**Com Docker:** apenas o `Docker`.

**Sem Docker:** será necessário ter instalado:
  - [Node.js + npm](https://nodejs.org/) (para o frontend Angular)  
  - [JDK 21+](https://www.oracle.com/java/technologies/downloads/) (para o backend Spring)  
  - [Maven](https://maven.apache.org/) (para build/empacotamento do backend)
     
💡 Muitas IDEs já trazem suporte embutido a estes requisitos.

---

### 💻 Preparando o ambiente

De acordo com os arquivos de ambiente/configuração que possuem "-example", crie um arquivo na mesma pasta sem este sufixo, com a configuração/propriedade desejada, para garantir o funcionamento.

Arquivos que necessitam ser criados e seus diretórios:
- `.env`
  - `/`
  - `/nutriburger-backend/`
- `application.properties` (ou `application.yml`)
  - `/nutriburger-backend/src/main/resources/`

Além disso, confira se `/nutriburger-frontend/src/environments/environment.ts` apresenta a URL do backend corretamente.

---

### 🐋 Iniciando a aplicação com Docker

Em um terminal:
```bash
# Navegue até a pasta raiz do projeto
cd nutriburger

# Suba os contêineres com o uso do docker-compose.yml
docker-compose -f docker-compose.yml up

# Caso esteja desenvolvendo, há o docker-compose.override.yml para facilitar
docker-compose up
```

O Backend rodará em `localhost:8080` e o Frontend em `localhost:4200`. Além disso, a imagem do Postgres criada também estará rodando.

Para desenvolvimento em apenas backend OU frontend, pode ser realizado o `docker-compose up db`, subindo apenas o contêiner do Postgres, e então o projeto poderá ser inicializado dentro da IDE escolhida.
> Com o Docker, nenhum requisito além dele é exigido, porém, caso seja o caso de rodar/desenvolver localmente sem ele, confira a seção de requisitos.

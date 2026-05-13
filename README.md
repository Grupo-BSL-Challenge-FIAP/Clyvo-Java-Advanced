# 🐾 PetGuardian API - Account Management
Este módulo é responsável pelo gerenciamento de contas de acesso ao sistema PetGuardian, permitindo o controle de usuários com diferentes níveis de acesso (Tutor, Veterinário e Administrador).


# 🧪 Testando a API (Endpoints)
Você pode testar os endpoints usando o Insomnia (como na sua imagem) ou o Swagger.

### 1. Criar uma Conta (POST)
URL: http://localhost:8080/accounts

Payload:

JSON
{
  "email": "vet@petguardian.com",
  "password": "senhaSegura123",
  "role": "VETERINARIAN",
  "active": true
}

### 2. Listar Contas com Paginação (GET)
URL: http://localhost:8080/accounts?page=0&size=5

Nota: O retorno será paginado, os dados estarão dentro da chave "content".

### 3. Buscar por ID (GET)
URL: http://localhost:8080/accounts/{id}

### 4. Atualizar Conta (PUT)
URL: http://localhost:8080/accounts/{id}

Payload:

JSON
{
  "email": "novoemail@petguardian.com",
  "password": "novaSenha123",
  "role": "ADMIN",
  "active": true
}

### 5. Deletar Conta (DELETE)
URL: http://localhost:8080/accounts/{id}

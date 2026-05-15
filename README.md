# 🐾 PetGuardian API

O PetGuardian é uma plataforma de monitoramento inteligente para animais de estimação, integrando tutores, veterinários e dispositivos IoT para garantir a saúde e o bem-estar animal.

---

# 🚀 Swagger UI

Acesse a documentação interativa e realize testes diretamente pelo navegador:

```bash
http://localhost:8080/swagger-ui/index.html
```

---

# 🔑 1. Accounts 

Módulo base para autenticação e controle de perfis (`TUTOR`, `VETERINARIAN`, `ADMIN`).

| Método | Endpoint | Descrição |
|--------|----------|------------|
| POST | `/accounts` | Cria uma nova conta de acesso |
| GET | `/accounts` | Lista todas as contas (Paginado) |
| GET | `/accounts/{id}` | Busca detalhes de uma conta específica |
| PUT | `/accounts/{id}` | Atualiza e-mail, senha ou status |
| DELETE | `/accounts/{id}` | Remove uma conta do sistema |

## Exemplo de Cadastro (POST)

### JSON

```json
{
  "email": "contato@petguardian.com",
  "password": "SenhaSegura123",
  "role": "VETERINARIAN",
  "active": true
}
```

---

# 👨‍⚕️ 2. Veterinarians

Gerenciamento de profissionais e registros CRMV.

| Método | Endpoint | Descrição |
|--------|----------|------------|
| POST | `/veterinarians` | Cadastra um veterinário vinculado a uma Account |
| GET | `/veterinarians` | Lista profissionais e especialidades |
| PUT | `/veterinarians/{id}` | Atualiza dados profissionais ou especialidade |
| DELETE | `/veterinarians/{id}` | Remove o registro do veterinário |

## Exemplo de Cadastro (POST)

### JSON

```json
{
  "fullName": "Dr. Ricardo Santos",
  "cpf": "123.456.789-00",
  "crmv": "CRMV-SP 12345",
  "speciality": "Cardiologia",
  "accountId": 1
}
```

---

# 🏠 3. Responsibles 

Informações de contato e localização dos donos dos pets.

| Método | Endpoint | Descrição |
|--------|----------|------------|
| POST | `/responsibles` | Cadastra um novo tutor responsável |
| GET | `/responsibles` | Lista todos os responsáveis cadastrados |
| PUT | `/responsibles/{id}` | Atualiza endereço ou telefone de contato |
| DELETE | `/responsibles/{id}` | Remove o registro do responsável |

## Exemplo de Cadastro (POST)

### JSON

```json
{
  "fullName": "Manuela de Lacerda Soares",
  "cpf": "987.654.321-11",
  "dateOfBirth": "1995-05-15",
  "phoneNumber": "(11) 98765-4321",
  "address": "Rua das Flores, 123 - São Paulo",
  "accountId": 2
}
```

---

# 🐶 4. Pets

O coração do sistema, vinculando o animal ao seu tutor e médico responsável.

| Método | Endpoint | Descrição |
|--------|----------|------------|
| POST | `/pets` | Cadastra um pet e define seu status inicial |
| GET | `/pets` | Lista todos os pets e seus estados de saúde |
| GET | `/pets/{id}` | Detalhes biométricos de um pet específico |
| PUT | `/pets/{id}` | Atualiza peso, status ou dados do animal |

## Exemplo de Cadastro (POST)

### JSON

```json
{
  "name": "Thor",
  "species": "Cão",
  "breed": "Golden Retriever",
  "gender": "Macho",
  "birthDate": "2021-03-10",
  "weight": 32.5,
  "currentStatus": "NORMAL",
  "responsibleId": 1,
  "veterinarianId": 1
}
```

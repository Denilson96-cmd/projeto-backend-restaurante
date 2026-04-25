# DER - Diagrama Entidade-Relacionamento

Este diagrama representa a estrutura do banco de dados da API.

---

## 🧱 Entidades

### Usuário
- id
- nome
- email
- senha

### Pedido
- id
- canalPedido
- status
- criadoEm
- usuario_id

### ItemPedido
- id
- produtoNome
- quantidade
- precoUnitario
- pedido_id

### Pagamento
- id
- status
- criadoEm
- pedido_id

---

## 🔗 Relacionamentos

- Um **Usuário** pode ter vários **Pedidos**
- Um **Pedido** pertence a um **Usuário**

- Um **Pedido** pode ter vários **Itens**
- Um **ItemPedido** pertence a um **Pedido**

- Um **Pedido** possui um **Pagamento**
- Um **Pagamento** pertence a um **Pedido**

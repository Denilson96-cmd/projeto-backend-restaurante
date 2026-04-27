# DER - Diagrama Entidade-Relacionamento

Este diagrama representa a estrutura do banco de dados da API.

---

## 🧱 Entidades

### Usuário
- idd
- nome
- email
- senha

### Pedido
- idd
- canalPedido
- status
- criadoEm
- usuario_id

### ItemPedido
- idd
- produtoNome
- quantidade
- precoUnitario
- pedido_id

### Pagamento
- idd
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

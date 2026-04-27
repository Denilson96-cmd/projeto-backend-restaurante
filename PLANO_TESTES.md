# Plano de Testes - API Restaurante

Este documento apresenta os cenários de testes executados na API, incluindo testes positivos e negativos.

## Testes Positivos

1. Criar usuário com dados válidos  
Resultado esperado: usuário criado com sucesso.

2. Realizar login com usuário válido  
Resultado esperado: token gerado com sucesso.

3. Acessar rota protegida com token válido  
Resultado esperado: acesso autorizado.

4. Listar usuários cadastrados  
Resultado esperado: retorno da lista de usuários.

5. Criar pedido com dados válidos  
Resultado esperado: pedido criado com sucesso.

6. Consultar pedido existente  
Resultado esperado: retorno dos dados do pedido.

## Testes Negativos

7. Realizar login com senha inválida  
Resultado esperado: erro de autenticação.

8. Acessar rota protegida sem token  
Resultado esperado: acesso negado.

9. Criar usuário sem senha  
Resultado esperado: erro ou rejeição da requisição.

10. Criar pedido com dados inválidos  
Resultado esperado: erro ou rejeição da requisição.

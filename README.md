# Desafio API - Petshop

Esse projeto constitui de um cadastro de uma API de cadastro de um petshop, feito com o Spring.
Link de acesso para o swagger: http://localhost:8080/swagger-ui/index.html

Endpoints (roda na porta padrão 8080):

* Atendimento

/atendimentos (retorna todos os atendimentos)
/atendimentos/{id} (retorna um único atendimento)
/atendimentos/novo (cadastra um atendimento)
/atendimentos/novo/popular-banco (cadastra um atendimento com dados mockados)
/atendimentos/atualizar/{id} (altera um atendimento)
/atendimentos/excluir/{id} (exclui um atendimento)

* Cachorro

/cachorros (retorna todos os cachorros)
/cachorros/{id} (retorna um único cachorro)
/cachorros/novo (cadastra um cachorro)
/cachorros/novo/popular-banco (cadastra um cachorro com dados mockados)
/cachorros/atualizar/{id} (altera um cachorro)
/cachorros/excluir/{id} (exclui um cachorro)

* Cliente

/clientes (retorna todos os clientes)
/clientes/{id} (retorna um único cliente)
/clientes/novo (cadastra um cliente)
/clientes/novo/popular-banco (cadastra um cliente com dados mockados)
/clientes/atualizar/{id} (altera um cliente)
/clientes/excluir/{id} (exclui um cliente)

* Endereço
/enderecos (retorna todos os endereços)
/enderecos/{id} (retorna um único endereço)
/enderecos/novo (cadastra um endereço)
/enderecos/novo/popular-banco (cadastra um endereço com dados mockados)
/enderecos/atualizar/{id} (altera um endereço)
/enderecos/excluir/{id} (exclui um endereço)

* médicos veterinário
/medicos (retorna todos os medicos)
/medicos/{id} (retorna um único medico)
/medicos/novo (cadastra um medico)
/medicos/novo/popular-banco (cadastra um medico com dados mockados)
/medicos/atualizar/{id} (altera um medico)
/medicos/excluir/{id} (exclui um medico)

* usuário
/usuarios/novo (cadastrar um novo usuário)
/usuários/auth (autenticação)
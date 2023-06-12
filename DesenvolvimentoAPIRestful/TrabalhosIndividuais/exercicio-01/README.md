# Exercicio 1
Para o primeiro exercício, foi desenvolvida uma pequena aplicação que visa automatizar o estoque de uma loja de roupas. A aplicação ainda está em sua primeira versão, sendo utilizada uma lista de dados mockada para a realização das requisições. 
<br>
<ul>
  <li>Testes feitos através do Postman:</li>
  <ul>
  <li><b>GET</b> - Listar estoque completo</li>
  <li><b>GET</b> - Listar item específico</li>
  <li><b>POST</b> - Cadastrar item com mesmo id de item já existente (erro proposital)</li>
  <li><b>POST</b> - Cadastrar item corretamente</li>
  <li><b>GET</b> - Listar novo item</li>
  <li><b>PUT</b> - Alterar descrição de item</li>
  <li><b>DEL</b> - Delete lógico, alterando a condição "emEstoque" para false e quantidade para 0</li>
  <li><b>PUT</b> - Alterar quantidade zerada de item já deletado, indicando uma reposição de estoque. Altera a condição "emEstoque" para true caso a quantidade seja diferente de 0.</li>
  </ul>

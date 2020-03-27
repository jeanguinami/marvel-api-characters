 Recriação do endpoint **Characters** da Marvel API
 
## Instruções para execução
- Para começar, é necessário que o usuário tenha um banco MySQL instalado em sua máquina e nele importar o arquivo **marvel-api-characters.sql** que está presente na raiz desse repositório.

- Após isso, o usuário precisa editar a **linha 6** do arquivo [application.properties](https://github.com/jeanguinami/marvel-api-characters/blob/master/characters/src/main/resources/application.properties), para que a aplicação aponte para o novo banco importado.

- Por fim, basta iniciar a aplicação através da sua IDE e testar as chamadas via Postman.
	> Para facilitar, [aqui](https://www.getpostman.com/collections/87c764421727a0ff9905) está uma chamada pronta.


## Esclarecimentos
Tive alguns problemas para finalizar alguns passos do processo todo. Testei tudo manualmente e ao que tudo indica, está funcional. Acabei perdendo um pouco de tempo por um erro de mapeamento que descobri com certo atraso e tive que rever alguns conceitos e reescrever algumas classes e métodos para que o problema fosse corrigido.


## Pontos de melhoria
- Acredito que a classe [CharactersServiceImpl](https://github.com/jeanguinami/marvel-api-characters/blob/master/characters/src/main/java/io/jeanfrias/characters/service/imp/CharactersServiceImp.java) tenha ficado com uns poucos códigos repetidos;
	> O que poderia ser corrigido com uma análise mais aprofundada dos objetos e algumas reestruturações.

- Devido ao ponto levantado nos **Esclarecimentos**, acabei não conseguindo desenvolver os testes unitários para as classes com lógica do projeto.


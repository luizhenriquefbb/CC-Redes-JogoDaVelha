# CC-Redes-JogoDaVelha
Atividade final da disciplina de Redes UFPB Programacao com Sockets

VER PDF EXPLICANDO PROJETO


## grupo 1.2
- Alisson
- Caio
- Luiz henrique


## Especificações
**Onde vai ser executado?**
A central estará no computador que rodará a classe Server.

**Como os clientes sabem onde está?**
O IP deve ser combinado previamente.

**Como registrar?**
O cliente manda um pacote informando que ele quer se registrar e o servidor cria um novo cliente e o adiciona em uma lista de clientes online.

Um nome é um ID único.

4 jogadores por ip no máximo.




**Como sincronizar o jogo e as jogadas?**
Verifica se quem mandou a jogada está na vez



Perguntas relacionadas ao jogo:

**São dois jogadores que não se conhecem. Como um jogador obtém a referência do outro?**
Os jogadores podem pedir uma listagem dos outros jogadores conectados ao server. Eles se conhecem apenas por nome que o servidor retorna quando pedido. ( o nome é um id único)

**Depois de obter a referência, como os dois jogadores tornam-se disponíveis para jogar, e combinam quem começa primeiro?**
Após um jogador aceitar o convite de partida, a vez é concedida automaticamente a quem convidou para jogar.

Presente em: método handleAcceptRequest da classe Server

**Como as mensagens contendo as jogadas são representadas e manipuladas?**
Método handlePlay da classe Server

Pela string : play <célula>. Onde play é o comando de jogar e <célula> é a posição onde o jogador gostaria de marcar. (o tabuleiro é composto por uma matriz 3 por 3)
Quando um pacote com o comando play é reconhecido, vários passos de validação de jogada, como se é o turno do jogador e se é uma posição válida, são executados. Após essa validação o servidor, a jogada e efetuada e uma nova fase de análise começa para decidir se a jogada acabou com a partida ou ela deve continuar. Se a partida continua, o servidor manda o próximo jogador jogar e assim continua.

**Como terminar o jogo? Isto é: como terminar o jogo, decidir quem ganhou, notificar serem notificados e, finalmente liberar os recursos (socket,memória, etc.)?**
A cada jogada é verificada a condição de vitória e empate, se nenhuma das duas ocorrer o jogo continua. Se houver uma vitória, um pacote é enviado para cada jogador com o resultado da partida.

método handlePlay da classe Server

**Um jogo pode ser interrompido no meio e depois reiniciado? E como ele recomeçará?**
Não. não pode

**O jogo possui requisitos de segurança contra trapaças? Por exemplo, um jogador consegue fazer duas jogadas seguidas antes do adversário fazer a**sua?

Não explicitamente, mas possui um mapeamento de comandos específicos (e suas expressões regulares)   e de onde essa mensagem é oriunda.

**O que acontece se um jogador demorar muito na sua jogada?**
Espera indefinidamente


## Como rodar

- execute primeiro o servidor
```
$ java -jar Server.jar <server-port>
```


- Execute quantos clientes quiser
```
$ java -jar Client.jar <server-ip> <server-port>
```


Comandos do cliente:
================

`login <username>` : logar na aplicação

`ls` : listar jogadores

`convidar <username>` : enviar um convite para uma pessoa

`aceitar <username>` : aceitar convite

`negar <username>` : negar convite

`play <cellNo>` : fazer uma jogada na casa especificada

`logout` : sair da aplicação

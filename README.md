# CC-Redes-JogoDaVelha
Atividade final da disciplina de Redes UFPB Programacao com Sockets

VER PDF EXPLICANDO PROJETO


## grupo 1.2
- Alisson
- Caio
- Luiz henrique


## Especificações
Onde vai ser executado? Como os clientes sabem onde está?
    servidor dns ou ip fixo (decidir)
Como registrar e como sincronizar o jogo e as jogadas?
    O servidor tem uma lista de usuários (não visível para os usuários) e salas (visível). Envio de mensagens

**São dois jogadores que não se conhecem. Como um jogador obtém a referência do outro?**
    Terá uma tela mostrando jogadores online. Um pode convidar o outro


**Depois de obter a referência, como os dois jogadores tornam-se disponíveis para jogar, e combinam quem começa primeiro?**
    Um convida e o outro pode aceitar.
    A cada rodada, há uma jogada de moeda

**Como as mensagens contendo as jogadas são representadas e manipuladas?**
    Ama janela de log ao lado da partida


**Como terminar o jogo? Isto é: como terminar o jogo, decidir quem ganhou, notificar serem notificados e, finalmente liberar os recursos (socket, memória, etc.)?**
    Cliente manda mensagem informando a "casa" que ele quer marcar e o servidor faz broadcast atualizando os tabuleiros



**Um jogo pode ser interrompido no meio e depois reiniciado? E como ele recomeçará?**
    Não. Derrota automática para quem sair antes
    
**O jogo possui requisitos de segurança contra trapaças? Por exemplo, um jogador consegue fazer duas jogadas seguidas antes do adversário fazer a sua?**
    O servidor que processará tudo. Assim terá mais segrança quando se trata de trapaças.
    Um jogador não conseguirá jogar duas vezes. Mais uma vez, o servidor que processará
    
**O que acontece se um jogador demorar muito na sua jogada?**
    Ele receberá algumas mensagens para que ele jogue na Xª declara como perdedor da rodada
    Oferece para o oponente declarar o outro como ausente.
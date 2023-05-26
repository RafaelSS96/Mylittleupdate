# Mylittleupdate
Projeto criado em kotlin para ajudar no ensino escolar

0.1.0 = Primeira versão criada, projeto base criado junto de uma tela inicial e de login basica.

0.1.1 = Primeira pequena mudança, direcionamento para a tela principal, começo do projeto da mesma.

0.2.0 =  Criamos aqui a primeira mudança grande. Foi criada a tela de recepção de usuario e uma tela onde, a partir de uma chave aleatoria em um mapa, pode-se criar perguntas aleatorias e adicionar respostas aleatorias. Proximo grande passo é criar mais perguntas, respostas e preparar um laço when que deve ser mudado depois.

0.2.1 = Foi criado o sistema de repetição de perguntas: Agora alem de novas perguntas, foi adicionado um sistema onde o usuario ao responder uma pergunta gera uma nova, sua pontuação e a passagem de questões é adicionado. Resumindo o que tentei escrever formalmente, agora o app faz mais de uma pergunta e julga as respostas como certas e erradas.

0.3.0 = Aqui foi criado o projeto da tela de configurações. Nesta tela o usuario vai limitar a quantia de questões que ele receberá na tela de questões. A numeração ja esta sendo passada de volta para a main. Nos commits anteriores não reparei que não tinha iniciado a toolbar da main, como resultado não estava alcançando a tela de configurações como desejado, porem agora ja é possivel. No fim das contas consegui criar o sistema de repetição sem a necessidade de um laço when proprio.

0.3.1 = Depois das dificuldades encontradas anteriormente, um pequeno avanço: Foi criado um contador de pontos do usuario e contador de perguntas, que o permite saber sempre quantas perguntas ja fez e quanto ja acertou alem dos toasts que anunciam pra ele. Acredito que estamos prontos para preparar a tela de resultados do usuario.

0.3.2 = Correção de um bug onde a função umdetres estava sendo lida como parte da expressão gerar pergunta

0.4.0 = Agora foi criada a tela de resultados, que agora mostra os resultados de uma forma mais clara para o usuario. Também foram feitas diversas mudanças de desind dentro da app, entre elas cores de botões e afins.

0.4.1 =  Alem de pequenas correções de bugs, foi preparada a passagem de informação entre a tela de resultados, a tela de historico e a tela principal. A quantia de perguntas respondida anteriormente agora é armazenada temporariamente.

0.4.2 = Infelizmente a primeira remoção grande do projeto. Após varias tentativas de executar corretamente o recycledview com o intent da pagina de resultados, infelizmente não consegui passar seu conteudo para a pagina de historico então removi o caminho para ela. O codigo para esta pagina ainda está presente porem comentado na pagina de resultados, alem do codigo em si da tela de historico e seu backend. Tentativas para a fazer funcionar ficarão guardadas para o futuro.

1.0.0 = Acredito que finalmente estou na versão final deste projeto antes da entrega. Depois de fazer checagem de bugs, confesso que encontrei um que me incomodou, onde a informação de quantas atividades foram feitas anteriormente quando se muda de atividade para a atividade config, porem deixarei como está. 

Fiz as remoções de conteudo que acredito serem descenessarios na app, assim como comentei todo seu codigo. Acredito estar satisfeito com meu resultado.
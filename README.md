# Oluap
Simple text based RPG game made in Java

1. Introdução

	O projeto denominado ‘Oluap’, apresenta uma pequena aventura em texto. Ambientado em um mundo fictício, abordou-se a criação de um jogo estilo RPG, que busca implementar conceitos de programação orientada a objeto ao mesmo tempo que cria uma pequena história com personagens criados pelo jogador.
	O sistema funciona de maneira simples, com três classes diferentes a serem selecionadas pelo jogador e passagem de ‘fases’, onde eventos específicos acontecem e o jogador deve decidir como agir, sendo os resultados influenciados pelos atributos do personagem e classe escolhidas pelo jogador. A história e seus eventos são curtos mas buscam ser variados em suas soluções, aplicando da melhor forma conceitos básicos de POO.

2. Modelagem do Problema

	No âmbito do desenvolvimento, partiu-se do princípio da criação de uma interface que definiria as ações possíveis de serem executadas, tanto para os personagens criados pelo usuário, quanto pelos inimigos que ele encontraria pelo caminho, dentro de tal interface foram definidas ações tais quais atacar, curar e um verificador quanto a situação de vida do indivíduo (vivo ou morto).
	A partir de tal interface foram então geradas duas classes que herdariam seus métodos, Builds e Creatures, responsáveis por serem as superclasses que definiriam construtores, atributos e métodos para os personagens gerados pelo jogador e monstros, respectivamente. 
	A classe Builds, responsável pela herança do tipo de herói gerado pelo jogador, especifica os atributos que posteriormente serão usados nos eventos e combates dentro do sistema, além disso, por ela é gerado o construtor que será padrão para qualquer uma das classes, variando somente em seus valores atribuídos. Por fim, são criados métodos abstratos e não abstratos que serão responsáveis pelas ações possíveis do jogador durante determinados eventos.
	Por outro lado, a classe Creatures é o paralelo a Builds e entrega construtor, atributos e métodos específicos aos inimigos que serão encontrados durante a aventura. Sua maior diferença está em que por tratar de personagens que aparecem somente em momentos específicos, a classe possui atributos e métodos mais simples, além de um construtor com menos entradas, gerando objetos consequentemente mais simples.
	Na base desse sistema, estão as subclasses específicas para cada um dos possíveis heróis e também para cada um dos monstros, tais classes herdando construtores e métodos de suas respectivas superclasses.
	Classes específicas para os personagens criados pelo jogador se mostram mais complexas, possuindo diversos atributos e métodos específicos para utilização em batalha, tais como o uso de habilidades que variam de classe para classe, porém, como dito acima, essas classes herdam de uma superclasse comum, métodos tais como atacar e curar, que sofrem um polimorfismo e variam em relação a forma como são aplicados. Tratando de conceitos de POO, essa é também uma aplicação clara de abstração, onde dados irrelevantes para o desenvolvimento do programa são ignorados, e as classes são geradas somente com as informações essenciais para o desenvolvimento do sistema.
	Por fim, a classe que possui o código Main e os eventos da aventura foi nomeada de Game, nela são aplicadas todas as outras criadas anteriormente, de modo que foram criados métodos específicos para a geração de um personagem pelo jogador, menu, game over e cada um dos eventos possíveis dentro da história. Buscando um código mais limpo e fácil de aplicar alterações, buscou-se ao máximo a chamada de métodos já criados, sendo por exemplo, criado o método específico para combate, já que o mesmo seria invocado várias vezes durante o desenrolar da história.


3. Ferramentas Utilizadas

	Para o desenvolvimento do projeto a IDE escolhida foi a Eclipse, por acreditar-se que a mesma possui uma boa interface e funções que facilitariam as etapas do desenvolvimento.
	O projeto foi dividido em pasta principal e dois packages distintos, um chamado de gameResources para armazenamento da interface e classes dos personagens e monstros, e outro intitulado somente de game para armazenamento da classe principal do sistema.

4. Resultados e Considerações Finais

	O projeto apresentou ser um desafio quanto a aplicação dos conceitos aprendidos sobre POO, sendo encontrados desafios na elaboração de um sistema funcional de interfaces e classes que permitisse a maior reutilização de código possível. Um dos maiores problemas foi aplicar todas as funcionalidades desejadas, sendo por exemplo, bastante complexa a solução para a criação de um sistema de combate que pudesse ser reutilizado para todos os inimigos e quaisquer personagens gerados pelo usuário.
	Mas o projeto também se mostrou bastante produtivo, infelizmente não foi possível implementar todas as funcionalidades idealizadas por seu desenvolvedor, principalmente em virtude do tempo, mas todas as implementadas satisfazem um grau mínimo de qualidade, que por fim, reproduzem a experiência esperada.
	Sobre o aprendizado de POO e sua aplicação, todos os conceitos se mostraram bem claros durante  o desenvolvimento, sendo feita também a procura por sua correta aplicação no que diz respeito a produção aqui citada.

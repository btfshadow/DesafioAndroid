package br.com.concretesolutions.repository.request

class RequestMocks {

    object MovieMocks {

        val popular_200 = "{\n" +
            "  \"page\": 1,\n" +
                    "  \"total_results\": 19612,\n" +
                    "  \"total_pages\": 981,\n" +
                    "  \"results\": [\n" +
                    "    {\n" +
                    "      \"vote_count\": 922,\n" +
                    "      \"id\": 166426,\n" +
                    "      \"video\": false,\n" +
                    "      \"vote_average\": 6.5,\n" +
                    "      \"title\": \"Piratas do Caribe: A Vingança de Salazar\",\n" +
                    "      \"popularity\": 177.972203,\n" +
                    "      \"poster_path\": \"/xHGwFcaWy6Ng6MagII45P3w0wOw.jpg\",\n" +
                    "      \"original_language\": \"en\",\n" +
                    "      \"original_title\": \"Pirates of the Caribbean: Dead Men Tell No Tales\",\n" +
                    "      \"genre_ids\": [\n" +
                    "        28,\n" +
                    "        12,\n" +
                    "        35,\n" +
                    "        14\n" +
                    "      ],\n" +
                    "      \"backdrop_path\": \"/3DVKG54lqYbdh8RNylXeCf4MBPw.jpg\",\n" +
                    "      \"adult\": false,\n" +
                    "      \"overview\": \"O Capitão Jack, que anda passando por uma onda de azar, sente os ventos da má sorte soprando com muita força quando os marinheiros fantasmas assassinos, liderados pelo aterrorizante Capitão Salazar (Javier Bardem), escapam do triângulo do diabo decididos a matar todos os piratas em seu caminho, especialmente Jack.\",\n" +
                    "      \"release_date\": \"2017-05-25\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"vote_count\": 620,\n" +
                    "      \"id\": 297762,\n" +
                    "      \"video\": false,\n" +
                    "      \"vote_average\": 7.1,\n" +
                    "      \"title\": \"Mulher-Maravilha\",\n" +
                    "      \"popularity\": 115.700275,\n" +
                    "      \"poster_path\": \"/ujQthWB6c0ojlARk28NSTmqidbF.jpg\",\n" +
                    "      \"original_language\": \"en\",\n" +
                    "      \"original_title\": \"Wonder Woman\",\n" +
                    "      \"genre_ids\": [\n" +
                    "        28,\n" +
                    "        12,\n" +
                    "        14,\n" +
                    "        878\n" +
                    "      ],\n" +
                    "      \"backdrop_path\": \"/hA5oCgvgCxj5MEWcLpjXXTwEANF.jpg\",\n" +
                    "      \"adult\": false,\n" +
                    "      \"overview\": \"Antes de ser Mulher-Maravilha, ela era Diana, princesa das Amazonas, treinada para ser uma guerreira imbatível. Criada numa ilha paraíso protegida e escondida, tudo muda quando um piloto americano chega em seu território e avisa sobre um grande conflito tomando forma no mundo. Diana deixa seu lar convencida de que pode impedir a ameaça crescente. Lutando ao lado dos homens em uma guerra para dar fim a todas as outras, Diana descobre seus poderes… e seu destino.\",\n" +
                    "      \"release_date\": \"2017-06-01\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"vote_count\": 3020,\n" +
                    "      \"id\": 321612,\n" +
                    "      \"video\": false,\n" +
                    "      \"vote_average\": 6.8,\n" +
                    "      \"title\": \"A Bela e a Fera\",\n" +
                    "      \"popularity\": 77.168288,\n" +
                    "      \"poster_path\": \"/9V4wl4rnUcLfGuTe4J5NjOFbDil.jpg\",\n" +
                    "      \"original_language\": \"en\",\n" +
                    "      \"original_title\": \"Beauty and the Beast\",\n" +
                    "      \"genre_ids\": [\n" +
                    "        10402,\n" +
                    "        10751,\n" +
                    "        14,\n" +
                    "        10749\n" +
                    "      ],\n" +
                    "      \"backdrop_path\": \"/7QshG75xKCmClghQDU1ta2BTaja.jpg\",\n" +
                    "      \"adult\": false,\n" +
                    "      \"overview\": \"Moradora de uma pequena aldeia francesa, Bela (Emma Watson) tem o pai capturado pela Fera e decide entregar sua vida ao estranho ser em troca da liberdade do progenitor. No castelo ela conhece objetos mágicos e descobre que a Fera é na verdade um príncipe que precisa de amor para voltar à forma humana.\",\n" +
                    "      \"release_date\": \"2017-03-16\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"vote_count\": 3731,\n" +
                    "      \"id\": 263115,\n" +
                    "      \"video\": false,\n" +
                    "      \"vote_average\": 7.5,\n" +
                    "      \"title\": \"Logan\",\n" +
                    "      \"popularity\": 64.873575,\n" +
                    "      \"poster_path\": \"/9EXnebqbb7dOhONLPV9Tg2oh2KD.jpg\",\n" +
                    "      \"original_language\": \"en\",\n" +
                    "      \"original_title\": \"Logan\",\n" +
                    "      \"genre_ids\": [\n" +
                    "        28,\n" +
                    "        18,\n" +
                    "        878\n" +
                    "      ],\n" +
                    "      \"backdrop_path\": \"/miqmTwqvnYiPEdolZv0biI7vFw2.jpg\",\n" +
                    "      \"adult\": false,\n" +
                    "      \"overview\": \"Em 2029, Logan (Hugh Jackman) ganha a vida como chofer de limousine para cuidar do nonagenário Charles Xavier (Patrick Stewart). Debilitado fisicamente e esgotado emocionalmente, ele é procurado por Gabriela (Elizabeth Rodriguez), uma mexicana que precisa da ajuda do ex-X-Men para defender a pequena Laura Kinney / X-23 (Dafne Keen). Ao mesmo tempo em que se recusa a voltar à ativa, Logan é perseguido pelo mercenário Donald Pierce (Boyd Holbrook), interessado na menina.\",\n" +
                    "      \"release_date\": \"2017-03-02\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"vote_count\": 5716,\n" +
                    "      \"id\": 22,\n" +
                    "      \"video\": false,\n" +
                    "      \"vote_average\": 7.4,\n" +
                    "      \"title\": \"Piratas do Caribe: A Maldição do Pérola Negra\",\n" +
                    "      \"popularity\": 59.01884,\n" +
                    "      \"poster_path\": \"/bSzff9RqSJNU8GKtaBbIRqaxGrU.jpg\",\n" +
                    "      \"original_language\": \"en\",\n" +
                    "      \"original_title\": \"Pirates of the Caribbean: The Curse of the Black Pearl\",\n" +
                    "      \"genre_ids\": [\n" +
                    "        12,\n" +
                    "        14,\n" +
                    "        28\n" +
                    "      ],\n" +
                    "      \"backdrop_path\": \"/fQZQYW9Hrg8TpYZH4KgbRptkcCN.jpg\",\n" +
                    "      \"adult\": false,\n" +
                    "      \"overview\": \"Em pleno século XVII, o pirata Jack Sparrow (Johnny Depp) tem seu navio saqueado e roubado pelo capitão Barbossa (Geoffrey Rush) e sua tripulação. Com o navio de Sparrow, Barbossa invade e saqueia a cidade de Port Royal, levando consigo Elizabeth Swann (Keira Knightley), a filha do governador (Jonathan Pryce). Decidido a recuperar sua embarcação, Sparrow recebe a ajuda de Will Turner (Orlando Bloom), um grande amigo de Elizabeth que parte em seu encalço. Porém, o que ambos não sabem é que o Pérola Negra, navio de Barbossa, foi atingido por uma terrível maldição que faz com que eles naveguem eternamente pelos oceanos e se transformem em esqueletos à noite.\",\n" +
                    "      \"release_date\": \"2003-08-29\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"vote_count\": 2188,\n" +
                    "      \"id\": 283995,\n" +
                    "      \"video\": false,\n" +
                    "      \"vote_average\": 7.6,\n" +
                    "      \"title\": \"Guardiões da Galáxia Vol. 2\",\n" +
                    "      \"popularity\": 40.391207,\n" +
                    "      \"poster_path\": \"/ezSpIN2bUnVnhqZDTk5RTQA33VR.jpg\",\n" +
                    "      \"original_language\": \"en\",\n" +
                    "      \"original_title\": \"Guardians of the Galaxy Vol. 2\",\n" +
                    "      \"genre_ids\": [\n" +
                    "        28,\n" +
                    "        12,\n" +
                    "        35,\n" +
                    "        878\n" +
                    "      ],\n" +
                    "      \"backdrop_path\": \"/aJn9XeesqsrSLKcHfHP4u5985hn.jpg\",\n" +
                    "      \"adult\": false,\n" +
                    "      \"overview\": \"Os Guardiões precisam lutar para manter sua recém descoberta família unida, enquanto descobrem os mistérios sobre o verdadeiro pai de Peter Quill. Antigos inimigos se tornam aliados e personagens conhecidos e amados dos quadrinhos virão ao auxílio dos nossos heróis, enquanto o Universo Cinematográfico da Marvel continua se expandindo.\",\n" +
                    "      \"release_date\": \"2017-04-27\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"vote_count\": 1672,\n" +
                    "      \"id\": 335797,\n" +
                    "      \"video\": false,\n" +
                    "      \"vote_average\": 6.8,\n" +
                    "      \"title\": \"Sing - Quem Canta Seus Males Espanta\",\n" +
                    "      \"popularity\": 33.481291,\n" +
                    "      \"poster_path\": \"/1LEeSindznWQnXIglb7Ica9MITe.jpg\",\n" +
                    "      \"original_language\": \"en\",\n" +
                    "      \"original_title\": \"Sing\",\n" +
                    "      \"genre_ids\": [\n" +
                    "        16,\n" +
                    "        35,\n" +
                    "        18,\n" +
                    "        10751,\n" +
                    "        10402\n" +
                    "      ],\n" +
                    "      \"backdrop_path\": \"/usJKCEMXV3tECgIJj8ZTEndmY2E.jpg\",\n" +
                    "      \"adult\": false,\n" +
                    "      \"overview\": \"Um empolgado coala chamado Buster decide criar uma competição de canto para aumentar os rendimentos de seu antigo teatro. A disputa movimenta o mundo animal e promove a revelação de diversos talentos da cidade, todos de olho nos 15 minutos de fama e US$ 100 mil dólares de prêmio.\",\n" +
                    "      \"release_date\": \"2017-12-22\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"vote_count\": 960,\n" +
                    "      \"id\": 126889,\n" +
                    "      \"video\": false,\n" +
                    "      \"vote_average\": 6,\n" +
                    "      \"title\": \"Alien: Covenant\",\n" +
                    "      \"popularity\": 32.696445,\n" +
                    "      \"poster_path\": \"/ewVHnq4lUiovxBCu64qxq5bT2lu.jpg\",\n" +
                    "      \"original_language\": \"en\",\n" +
                    "      \"original_title\": \"Alien: Covenant\",\n" +
                    "      \"genre_ids\": [\n" +
                    "        27,\n" +
                    "        878,\n" +
                    "        53\n" +
                    "      ],\n" +
                    "      \"backdrop_path\": \"/kMU8trT43p5LFoJ4plIySMOsZ1T.jpg\",\n" +
                    "      \"adult\": false,\n" +
                    "      \"overview\": \"Ridley Scott retorna ao universo que criou com ALIEN: COVENANT, um novo capítulo em sua inovadora franquia ALIEN. A tripulação do navio-colônia Covenant, ligada a um remoto planeta no lado distante da galáxia, descobre o que eles acham que é um paraíso inexplorado, mas na verdade é um mundo escuro e perigoso. Quando descobrem uma ameaça além de sua imaginação, devem tentar uma fuga angustiante.\",\n" +
                    "      \"release_date\": \"2017-05-11\"\n" +
                    "    },\n" +
                    "    {\n" +
                    "      \"vote_count\": 1618,\n" +
                    "      \"id\": 324552,\n" +
                    "      \"video\": false,\n" +
                    "      \"vote_average\": 6.5,\n" +
                    "      \"title\": \"John Wick: Um Novo Dia Para Matar\",\n" +
                    "      \"popularity\": 32.380912,\n" +
                    "      \"poster_path\": \"/pkRLUQQdlve7H7LjhyNODF7F5mK.jpg\",\n" +
                    "      \"original_language\": \"en\",\n" +
                    "      \"original_title\": \"John Wick: Chapter 2\",\n" +
                    "      \"genre_ids\": [\n" +
                    "        53,\n" +
                    "        28,\n" +
                    "        80\n" +
                    "      ],\n" +
                    "      \"backdrop_path\": \"/dQ6s3Ud2KoOs3LKw6xgZr1cw7Yq.jpg\",\n" +
                    "      \"adult\": false,\n" +
                    "      \"overview\": \"Após recuperar seu carro, John Wick (Keanu Reeves) acredita que enfim poderá se aposentar. Entretanto, a reaparição de Santino D'Antonio (Riccardo Scarmacio) atrapalha seus planos. Dono de uma promissória em nome de Wick, por ele usada para deixar o posto de assassino profissional da Alta Cúpula, Santino cobra a dívida existente e insiste para que ele mate sua própria irmã, Gianna (Claudia Gerini).\",\n" +
                    "      \"release_date\": \"2017-02-16\"\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}";

        val nowPlaying_200 = "{\n" +
                "  \"results\": [\n" +
                "    {\n" +
                "      \"vote_count\": 863,\n" +
                "      \"id\": 166426,\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.6,\n" +
                "      \"title\": \"Piratas do Caribe: A Vingança de Salazar\",\n" +
                "      \"popularity\": 213.468872,\n" +
                "      \"poster_path\": \"/xHGwFcaWy6Ng6MagII45P3w0wOw.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Pirates of the Caribbean: Dead Men Tell No Tales\",\n" +
                "      \"genre_ids\": [\n" +
                "        28,\n" +
                "        12,\n" +
                "        35,\n" +
                "        14\n" +
                "      ],\n" +
                "      \"backdrop_path\": \"/3DVKG54lqYbdh8RNylXeCf4MBPw.jpg\",\n" +
                "      \"adult\": false,\n" +
                "      \"overview\": \"O Capitão Jack, que anda passando por uma onda de azar, sente os ventos da má sorte soprando com muita força quando os marinheiros fantasmas assassinos, liderados pelo aterrorizante Capitão Salazar (Javier Bardem), escapam do triângulo do diabo decididos a matar todos os piratas em seu caminho, especialmente Jack.\",\n" +
                "      \"release_date\": \"2017-05-25\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"vote_count\": 524,\n" +
                "      \"id\": 297762,\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.2,\n" +
                "      \"title\": \"Mulher-Maravilha\",\n" +
                "      \"popularity\": 111.897609,\n" +
                "      \"poster_path\": \"/ujQthWB6c0ojlARk28NSTmqidbF.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Wonder Woman\",\n" +
                "      \"genre_ids\": [\n" +
                "        28,\n" +
                "        12,\n" +
                "        14,\n" +
                "        878\n" +
                "      ],\n" +
                "      \"backdrop_path\": \"/hA5oCgvgCxj5MEWcLpjXXTwEANF.jpg\",\n" +
                "      \"adult\": false,\n" +
                "      \"overview\": \"Antes de ser Mulher-Maravilha, ela era Diana, princesa das Amazonas, treinada para ser uma guerreira imbatível. Criada numa ilha paraíso protegida e escondida, tudo muda quando um piloto americano chega em seu território e avisa sobre um grande conflito tomando forma no mundo. Diana deixa seu lar convencida de que pode impedir a ameaça crescente. Lutando ao lado dos homens em uma guerra para dar fim a todas as outras, Diana descobre seus poderes… e seu destino.\",\n" +
                "      \"release_date\": \"2017-06-01\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"vote_count\": 925,\n" +
                "      \"id\": 126889,\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6,\n" +
                "      \"title\": \"Alien: Covenant\",\n" +
                "      \"popularity\": 32.852538,\n" +
                "      \"poster_path\": \"/ewVHnq4lUiovxBCu64qxq5bT2lu.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Alien: Covenant\",\n" +
                "      \"genre_ids\": [\n" +
                "        27,\n" +
                "        878,\n" +
                "        53\n" +
                "      ],\n" +
                "      \"backdrop_path\": \"/kMU8trT43p5LFoJ4plIySMOsZ1T.jpg\",\n" +
                "      \"adult\": false,\n" +
                "      \"overview\": \"Ridley Scott retorna ao universo que criou com ALIEN: COVENANT, um novo capítulo em sua inovadora franquia ALIEN. A tripulação do navio-colônia Covenant, ligada a um remoto planeta no lado distante da galáxia, descobre o que eles acham que é um paraíso inexplorado, mas na verdade é um mundo escuro e perigoso. Quando descobrem uma ameaça além de sua imaginação, devem tentar uma fuga angustiante.\",\n" +
                "      \"release_date\": \"2017-05-11\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"vote_count\": 1563,\n" +
                "      \"id\": 419430,\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 7.1,\n" +
                "      \"title\": \"Corra!\",\n" +
                "      \"popularity\": 24.643057,\n" +
                "      \"poster_path\": \"/A0RoSZh8PEYJgDMgM2EV7Ycz3dR.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Get Out\",\n" +
                "      \"genre_ids\": [\n" +
                "        9648,\n" +
                "        53,\n" +
                "        27\n" +
                "      ],\n" +
                "      \"backdrop_path\": \"/Ae58bf7Yj6OPzwKerPgXSnxCJdh.jpg\",\n" +
                "      \"adult\": false,\n" +
                "      \"overview\": \"Agora que Chris e sua namorada, Rose, chegaram à fase de conhecer os pais no namoro, ela o convida para um fim de semana no interior com Missy e Dean. A princípio, Chris acha que o comportamento excessivamente agradável dos dois como tentativas nervosas de lidar com o relacionamento inter-racial da filha, mas, conforme o fim de semana avança, uma série de descobertas cada vez mais perturbadoras o levam a uma verdade que ele jamais poderia ter imaginado.\",\n" +
                "      \"release_date\": \"2017-05-18\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"vote_count\": 42,\n" +
                "      \"id\": 282035,\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 5.1,\n" +
                "      \"title\": \"A Múmia\",\n" +
                "      \"popularity\": 17.82816,\n" +
                "      \"poster_path\": \"/vH9Hd7njePEe6xnRrYYaDmF2yqX.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Mummy\",\n" +
                "      \"genre_ids\": [\n" +
                "        28,\n" +
                "        12,\n" +
                "        14,\n" +
                "        27,\n" +
                "        53\n" +
                "      ],\n" +
                "      \"backdrop_path\": \"/qedJJ2z9oBYKxxO4Pp8qAkfgPst.jpg\",\n" +
                "      \"adult\": false,\n" +
                "      \"overview\": \"Nas profundezas do deserto, uma antiga rainha (Sofia Boutella) cujo destino foi injustamente tirado está mumificada. Apesar de estar sepultada em sua cripta, ela desperta nos dias atuais. Com uma maldade acumulada ao longo dos anos, ela espelha terror desde as areais do Oriente Médio até os becos de Londres.\",\n" +
                "      \"release_date\": \"2017-06-08\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"vote_count\": 332,\n" +
                "      \"id\": 274857,\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.4,\n" +
                "      \"title\": \"Rei Arthur: A Lenda da Espada\",\n" +
                "      \"popularity\": 11.654765,\n" +
                "      \"poster_path\": \"/4tGAP9Q00sqI9iF7GXnEOtkvonk.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"King Arthur: Legend of the Sword\",\n" +
                "      \"genre_ids\": [\n" +
                "        28,\n" +
                "        18,\n" +
                "        14\n" +
                "      ],\n" +
                "      \"backdrop_path\": \"/22eFfWlar6MtXO5qG25TkjLphoj.jpg\",\n" +
                "      \"adult\": false,\n" +
                "      \"overview\": \"Arthur (Charlie Hunnam) é um jovem das ruas que controla os becos de Londonium e desconhece sua predestinação até o momento em que entra em contato pela primeira vez com a Excalibur. Desafiado pela espada, ele precisa tomar difíceis decisões, enfrentar seus demônios e aprender a dominar o poder que possui para conseguir, enfim, unir seu povo e partir para a luta contra o tirano Vortigern, que destruiu sua família.\",\n" +
                "      \"release_date\": \"2017-05-18\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"vote_count\": 152,\n" +
                "      \"id\": 397837,\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.2,\n" +
                "      \"title\": \"Antes Que Eu Vá\",\n" +
                "      \"popularity\": 7.665302,\n" +
                "      \"poster_path\": \"/oMZ2ROBxbWsuDJO1PZHfXayiNbz.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Before I Fall\",\n" +
                "      \"genre_ids\": [\n" +
                "        18,\n" +
                "        9648,\n" +
                "        53\n" +
                "      ],\n" +
                "      \"backdrop_path\": \"/l0KTMyzgXGKYd7xR8YgFCxlA5pU.jpg\",\n" +
                "      \"adult\": false,\n" +
                "      \"overview\": \"Samantha Kingston (Zoey Deutch) é uma jovem que tem tudo o que uma jovem pode desejar da vida.. No entanto, essa vida perfeita chega a um final abrupto e repentino no dia 12 de fevereiro, um dia que seria um dia como outro qualquer se não fosse o dia de sua morte. Porém, segundos antes de realmente morrer, ela terá a oportunidade de mudar a sua última semana e, talvez, o seu destino.\",\n" +
                "      \"release_date\": \"2017-05-25\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"vote_count\": 461,\n" +
                "      \"id\": 397243,\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.4,\n" +
                "      \"title\": \"A Autópsia\",\n" +
                "      \"popularity\": 5.693122,\n" +
                "      \"poster_path\": \"/xjxUdayo11X2XaTNUZLtilWahKq.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"The Autopsy of Jane Doe\",\n" +
                "      \"genre_ids\": [\n" +
                "        27,\n" +
                "        9648\n" +
                "      ],\n" +
                "      \"backdrop_path\": \"/m4LtS8NoVvbl57mej9KBg9QT4fg.jpg\",\n" +
                "      \"adult\": false,\n" +
                "      \"overview\": \"Tommy Tilden (Brian Cox) e Austin Tilden (Emile Hirsch), seu filho, são os reponsáveis por comandar o necrotério de uma pequena cidade do interior dos Estados Unidos. Os trabalhos que recebem costumam ser muito tranquilos por causa da natureza pacata da cidade, mas, certo dia, o xerife local (Michael McElhatton) traz um caso complicado: uma mulher desconhecida foi encontrada morta nos arredores da cidade - \\\"Jane Doe\\\", no jargão americano. Conforme pai e filho tentam descobrir a identidade da mulher morta, coisas estranhas e perigosas começam a ocorrer, colocando a vida dos dois em perigo.\",\n" +
                "      \"release_date\": \"2017-05-04\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"vote_count\": 125,\n" +
                "      \"id\": 339967,\n" +
                "      \"video\": false,\n" +
                "      \"vote_average\": 6.4,\n" +
                "      \"title\": \"Colossal\",\n" +
                "      \"popularity\": 5.093404,\n" +
                "      \"poster_path\": \"/4VOyofBd1pexblxtDZYtYIk7NI4.jpg\",\n" +
                "      \"original_language\": \"en\",\n" +
                "      \"original_title\": \"Colossal\",\n" +
                "      \"genre_ids\": [\n" +
                "        28,\n" +
                "        35,\n" +
                "        18,\n" +
                "        14,\n" +
                "        878\n" +
                "      ],\n" +
                "      \"backdrop_path\": \"/y5qDjStKZ6y4IHQDhJGMlfZwH92.jpg\",\n" +
                "      \"adult\": false,\n" +
                "      \"overview\": \"Gloria (Anne Hathaway) deixa Nova York e volta para sua cidade natal após perder o emprego e o noivo. Ao acompanhar as notícias sobre o ataque de um lagarto gigante a Seul, ela descobre que está misteriosamente conectada mentalmente ao evento. Para evitar novos casos parecidos e uma eventual destruição total do planeta, Gloria precisa controlar os poderes de sua mente e entender por que sua existência aparentemente insignificante tem tamanha responsabilidade no destino do mundo.\",\n" +
                "      \"release_date\": \"2017-05-11\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"page\": 1,\n" +
                "  \"total_results\": 50,\n" +
                "  \"dates\": {\n" +
                "    \"maximum\": \"2017-06-14\",\n" +
                "    \"minimum\": \"2017-05-03\"\n" +
                "  },\n" +
                "  \"total_pages\": 3\n" +
                "}"
    }
}

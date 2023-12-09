# AgendaRoom
Projeto desenvolvido para a disciplina Persistência de Dados (PDD) do curso de Pós-Graduação Lato Sensu em Desenvolvimento de Sistemas para Dispositivos Móveis do IFSP São Carlos.

![image](https://github.com/pdalbem/AgendaRoom/assets/7870280/3d03080c-e0b6-4b2e-bf42-cb0e19b02ae4)

## Arquitetura do aplicativo
O aplicativo AgendaRoom foi desenvolvido utilizando alguns dos [Componentes de Arquitetura do Android](https://developer.android.com/topic/libraries/architecture?hl=pt-br#:~:text=Componentes%20da%20arquitetura%20do%20Android%20%C3%A9%20um%20conjunto%20de%20bibliotecas,com%20a%20persist%C3%AAncia%20de%20dados.)

![image](https://github.com/pdalbem/AgendaRoom/assets/7870280/ffeb5421-9f27-4033-8e0b-8ad613b9cf6d)

[Room](https://developer.android.com/topic/libraries/architecture/room?hl=pt-br): biblioteca que fornece uma camada de abstração sobre o SQLite para permitir um acesso mais robusto ao banco de dados.

[LIveData](https://developer.android.com/topic/libraries/architecture/livedata?hl=pt-br): classe armazenadora de dados observáveis que respeita o ciclo de vida de outros componentes do app (activity, fragment, service etc).

[ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel?hl=pt-br): classe projetada para armazenar e gerenciar dados relacionados à interface do usuário de uma maneira consciente do ciclo de vida. A classe ViewModel permite que os dados sobrevivam a alterações de configuração, como rotações de tela.

[Repository](https://developer.android.com/topic/architecture/data-layer?hl=pt-br#architecture): responsável por isoloar a camada de dados do restante do app, bem como gerenciar diversas fontes de dados.

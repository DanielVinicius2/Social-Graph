# Grafo Social Interativo – Estrutura de Dados (Java)
## 📌 Descrição do Projeto

Este projeto implementa um Grafo Social interativo usando Java.
Cada pessoa é um vértice, e cada relacionamento (amizade/conexão social) é uma aresta.

### O usuário pode:

  - ✔ Escolher quantas pessoas deseja cadastrar
  - ✔ Informar os nomes das pessoas
  - ✔ Definir com quais pessoas já cadastradas cada uma se relaciona
  - ✔ Visualizar toda a rede social criada
  - ✔ Executar BFS (proximidade social)
  - ✔ Executar DFS (exploração profunda dos círculos sociais)

O objetivo do projeto é demonstrar como grafos podem representar ciclos sociais, funcionando como uma pequena simulação de redes sociais reais, como Facebook, LinkedIn ou redes de contatos.

## 🧰 Tecnologias Utilizadas

  - Java 8+
  - Estruturas internas:
  - HashMap (para mapa de adjacência)
  - ArrayList (armazenar conexões)
  - Queue (para BFS)
  - Recursão (para DFS)
  - Terminal/Console para interação com o usuário

## 📂 Estrutura do Projeto
  ````
  - /src
 └── GrafoSocial.java
README.md
  ````

## ✔️ Funcionalidades Implementadas
### 📌 Requisitos mínimos

  - Representação de grafo usando lista de adjacência
  - Adicionar vértice (pessoa)
  - Adicionar aresta (relacionamento)
  - Remover pessoa (caso desejado)
  - Remover relacionamento (caso desejado)
  - Exibir grafo de forma clara
  - Caso de uso prático (Rede Social Interativa)

### 📌 Funcionalidades avançadas

 - ✔ BFS (Busca em Largura)
    - Mostra ordem de proximidade social, útil para encontrar amigos de amigos.

 - ✔ DFS (Busca em Profundidade)
    - Explora círculos sociais em profundidade.

##🧪 Demonstração do Funcionamento
### 1️⃣ Usuário define número de pessoas
  ````
Quantas pessoas deseja inserir? 4
  ````
### 2️⃣ Usuário insere os nomes
````
Digite o nome da pessoa 1: X
Digite o nome da pessoa 2: Y
Digite o nome da pessoa 3: W
Digite o nome da pessoa 4: Z
````
### 3️⃣ Para cada pessoa, o usuário define os relacionamentos
````
Com quais dessas pessoas Z se relaciona?
[X, Y, W]
Digite os nomes separados por vírgula: Y, W
````
### 4️⃣ Rede social gerada
````
==== REDE SOCIAL GERADA ====
X conhece → [Y]
Y conhece → [X, W, Z]
W conhece → [Y, Z]
Z conhece → [Y, W]
````

### 5️⃣ BFS e DFS
````
BFS → [X, Y, W, Z]
DFS → [X, Y, W, Z]
````
## ▶️ Como Executar o Projeto

### 1. Clonar o repositório
````
git clone https://github.com/seu-usuario/grafo-social-interativo.git

````
### 2. Entrar na pasta do projeto
````
cd grafo-social-interativo

````
### 3. Compilar
````
javac src/GrafoSocial.java

````
### 4. Executar
````
java src.GrafoSocial

````

## 🧠 Conceitos de Grafos Aplicados
- ✔ Vértices

Pessoas cadastradas

- ✔ Arestas

Relacionamentos criados pelo usuário

- ✔ Grafo não direcionado

   Se A conhece B, então B automaticamente conhece A

- ✔ BFS

 Calcula nível de proximidade (quem está mais perto na rede)

- ✔ DFS

  Percorre círculos sociais de forma profunda

#### Este projeto demonstra na prática como grafo é uma estrutura essencial para modelar redes humanas, conexões profissionais, sistemas sociais e muito mais.

# Video Explicando o Trabalho:

https://www.loom.com/share/734e0799aec14f8490041d07f7ad00ab

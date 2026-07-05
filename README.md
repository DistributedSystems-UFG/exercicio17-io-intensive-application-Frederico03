[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/sMLHUOxM)
# IO-Intensive-Application-Benchmark

---

# Solução da Tarefa

Como explicado na **Questão 22** da lista de exercícios:
> *"A técnica básica de desempenho para aplicações IO-intensive é a concorrência. Como aplicações I/O-bound gastam a maior parte do tempo aguardando recursos externos (disco, banco de dados, rede), a CPU pode ser aproveitada para executar outras tarefas concorrentemente em vez de ficar ociosa."*

Implementamos um programa de benchmark em **Java** (`IoIntensiveApp.java`) e em **Python** (`main.py`) que realiza 50 tarefas de I/O simuladas (cada uma com duração de 100ms de latência via sleep). O benchmark compara:
1. **Execução Sequencial**: Cada tarefa roda uma após a outra (tempo total esperado: 50 * 100ms = ~5 segundos).
2. **Execução Concorrente**: As tarefas rodam concorrentemente utilizando um Pool de 10 threads (tempo total esperado: ~0.5 segundos).

## Resultados Obtidos
Nas execuções, o uso de concorrência com 10 threads trouxe um ganho de desempenho drástico de aproximadamente **9.6x a 9.8x mais rápido** em ambas as linguagens:

*   **Java (`IoIntensiveApp.java`)**:
    *   Execução Sequencial: ~5400 ms
    *   Execução Concorrente: ~550 ms
    *   **Ganho de velocidade: ~9.8x**
*   **Python (`main.py`)**:
    *   Execução Sequencial: ~5000 ms
    *   Execução Concorrente: ~520 ms
    *   **Ganho de velocidade: ~9.6x**

## Como Executar

### 1) Java
```bash
javac IoIntensiveApp.java
java IoIntensiveApp
```

### 2) Python
```bash
python main.py
```

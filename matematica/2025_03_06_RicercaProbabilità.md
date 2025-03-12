<link rel="stylesheet" href="../style.css">

<label style="position:static;" for="tema-scuro">Tema scuro
<input type="checkbox" id="tema-scuro"></input>
</label>


## Probabilità "classica" (o laplaciana)

Definisce la probabilità come il rapporto tra il numero di casi favorevoli e il numero di casi possibili, supponendo che tutti siano ugualmente probabili.  

Formalmente, se un evento \( A \) può verificarsi in \( m \) modi su un totale di \( n \) casi possibili, la probabilità di \( A \) è:

\[
P(A) = \frac{m}{n}
\]

Questo approccio è applicabile solo in situazioni in cui gli esiti sono **equiprobabili**, come nel lancio di un dado o nella pesca di una carta da un mazzo ben mescolato.

---

## Probabilità frequentista

Definisce la probabilità di un evento come il **limite della frequenza relativa** con cui si verifica l'evento dopo un numero molto elevato di ripetizioni dell'esperimento.  

Se un evento \( A \) si verifica \( m \) volte su \( n \) prove, allora la sua probabilità è:

\[
P(A) = \lim_{n \to \infty} \frac{m}{n}
\]

Questo approccio è usato nelle **scienze sperimentali** e nella **statistica inferenziale**.

---

## Probabilità soggettiva

Interpreta la probabilità come il **grado di fiducia o credenza personale** che un individuo assegna al verificarsi di un evento, basandosi sulle informazioni disponibili.  

Questo approccio è tipico della **teoria bayesiana**, dove la probabilità può essere aggiornata con l'acquisizione di nuove informazioni.

---

## Probabilità assiomatica

Basata sugli **assiomi di Kolmogorov**, fornisce una definizione matematica rigorosa della probabilità come una funzione \( P \) che associa a ogni evento \( A \) un valore reale tra 0 e 1, soddisfacendo i seguenti assiomi:

1. **Non negatività:**  
   \[
   P(A) \geq 0
   \]
   per ogni evento \( A \).

2. **Normalizzazione:**  
   \[
   P(\Omega) = 1
   \]
   dove \( \Omega \) è lo spazio degli esiti possibili.

3. **Additività:**  
   Se \( A \) e \( B \) sono eventi **disgiunti**, allora:  
   \[
   P(A \cup B) = P(A) + P(B)
   \]

Questo approccio è il più generale e viene usato nella **teoria moderna della probabilità**.



<!--
---
---
---


## Probabilità "classica" (o laplaciana)

Definisce la probabilità come il rapporto tra il numero di casi favorevoli e il numero di casi possibili, supponendo che tutti siano ugualmente probabili.  

Formalmente, se un evento $A$ può verificarsi in $m$ modi su un totale di $n$ casi possibili, la probabilità di $A$ è:

$P(A) = \frac{m}{n}$

Questo approccio è applicabile solo in situazioni in cui gli esiti sono **equiprobabili**, come nel lancio di un dado o nella pesca di una carta da un mazzo ben mescolato.

---

## Probabilità frequentista

Definisce la probabilità di un evento come il **limite della frequenza relativa** con cui si verifica l'evento dopo un numero molto elevato di ripetizioni dell'esperimento.  

Se un evento $A$ si verifica $m$ volte su $n$ prove, allora la sua probabilità è:

$P(A) = \lim_{n \to \infty} \frac{m}{n}$

Questo approccio è usato nelle **scienze sperimentali** e nella **statistica inferenziale**.

---

## Probabilità soggettiva

Interpreta la probabilità come il **grado di fiducia o credenza personale** che un individuo assegna al verificarsi di un evento, basandosi sulle informazioni disponibili.  

Questo approccio è tipico della **teoria bayesiana**, dove la probabilità può essere aggiornata con l'acquisizione di nuove informazioni.

---

## Probabilità assiomatica

Basata sugli **assiomi di Kolmogorov**, fornisce una definizione matematica rigorosa della probabilità come una funzione $P$ che associa a ogni evento $A$ un valore reale tra 0 e 1, soddisfacendo i seguenti assiomi:

1. **Non negatività:**  
   $P(A) \geq 0$
   per ogni evento $A$.

2. **Normalizzazione:**  
   $P(\Omega) = 1$
   dove $\Omega$ è lo spazio degli esiti possibili.

3. **Additività:**  
   Se $A$ e $B$ sono eventi **disgiunti**, allora:  
   $P(A \cup B) = P(A) + P(B)$

Questo approccio è il più generale e viene usato nella **teoria moderna della probabilità**.
-->

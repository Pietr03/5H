<link rel="stylesheet" href="../style.css">

<label style="" for="tema-scuro">Tema scuro
    <input type="checkbox" id="tema-scuro"></input>
</label>
# Calcolo dell'integrale definito con il metodo Montecarlo

## 1. Definizione di integrale definito

L'integrale definito di una funzione $f(x)$ su un intervallo $[a, b]$ rappresenta l'area sotto la curva di $f(x)$ (dove $x$ è compreso tra $a$ e $b$) e l'asse delle x:

$[
int*a^b f(x), dx = \lim*{n \to \infty} \sum_{i=1}^n f(x_i) \Delta x
]$

Dove:

-   $\Delta x = \frac{b-a}{n}$ è la larghezza degli intervalli.
-   $x_i$ è un punto preso in ogni intervallo.

Quando il calcolo analitico è difficile, si può usare il **metodo Montecarlo** per approssimarlo.

---

## 2. Media integrale

L'integrale definito può essere riscritto usando la media della funzione $f(x)$ sull'intervallo $[a, b]$:

$\int_a^b f(x) \, dx = (b-a) \cdot \text{Media di } f(x)
$

$\text{Media integrale} = \frac{1}{b-a} \int_a^b f(x) \, dx$

---

## 3. Metodo Montecarlo

Il metodo Montecarlo calcola l'integrale stimando la **media empirica** di $f(x)$ su punti casuali $x_i$ generati nell'intervallo $[a, b]$:

1. **Generazione dei punti casuali**:  
   Genera $ N $ numeri casuali $ x_i $ tra $ a $ e $ b $.

2. **Calcolo della media empirica**:  
   $
   \text{Media empirica} = \frac{1}{N} \sum{i=1}^N f(x_i)
   $

3. **Stima dell'integrale**:  
   $
   \int_a^b f(x) \, dx \approx (b-a) \cdot \text{Media empirica}
   $

---

## Esempio

Calcoliamo:  
$
\int_0^1 x^2 \, dx
$

1. Genera $ N = 1000 $ punti $ x_i $ tra 0 e 1.
2. Calcola la media empirica di $ f(x) = x^2 $:  
   $
   \text{Media empirica} = \frac{1}{1000} \sum\_{i=1}^{1000} x_i^2
   $
3. Approssima l'integrale:  
   $
   \int_0^1 x^2 \, dx \approx \text{Media empirica}
   $

Con $ N $ sufficientemente grande, il risultato si avvicina a $ \frac{1}{3} $, il valore analitico dell'integrale.

---

## Vantaggi e limiti

-   **Vantaggi**: Utile per integrali complessi e multidimensionali.
-   **Limiti**: La precisione dipende dal numero di campioni $ N $ e dalla qualità del generatore di numeri casuali.

---

$
\int_0^\pi sin(t) \, dt = \\ = [- cos(x)]_0^\pi = \\ = -cos(\pi) - [- cos(0)] = \\ = -1-(-1)-(-1) = \\ = 1+1 = \\ = 2
$

Questo calcolo riguarda il **calcolo dell'integrale definito** della funzione $sin(t)$ sull'intervallo $[0,\pi]$.

L'obiettivo è quello di calcolare l'**area al di sotto della curva** dell'integrale definito $sin(t)$ tra i limiti $(t = 0)$ e $(t = \pi)$, quindi $\int_0^\pi sin(t) \, dt $.

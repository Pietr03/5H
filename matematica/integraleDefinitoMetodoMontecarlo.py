import numpy as np
import matplotlib.pyplot as plt

# Numero di campioni da generare
n = 50000

# Definizione della funzione, la quale si intende integrare
f = lambda t: np.sin(t)

# Definizione dell'intervallo di integrazione: da 0 a pi, con n. numeri di campioni
x = np.linspace(0, np.pi, n)

# Generazione dei campioni, np.random.rand(n) fa un vettore di n numeri casuali tra 0 e 1, 
# il parametro n è il numero di campioni, dunque questo genera un vettore di n numeri casuali tra 0 e 1
xt = np.random.rand(n) * np.pi 

# Calcolo dei valori della funzione
yt = f(xt)

media = np.mean(yt) # Media dei campioni

print('Numero campioni: ', n ,' \nIl valore integrale è:\n', media*np.pi)

plt.plot(x, f(x)) # Plot della funzione, ovvero il grafico dell'intervallo di integrazione
plt.scatter(xt, yt) # Plot dei campioni, ovvero i punti generati posti sul grafico
plt.show() # Mostra il grafico



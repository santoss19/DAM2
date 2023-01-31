import math

msgEx1 = "¡hola, estoy estudiando desarrollo de aplicaciones multiplataforma!"
msgEx2 = ""

def ex1():
    print(msgEx1)
ex1()

def ex2():
    msgEx2 = "Ejercicio 2 almacenó la cadena"
    print(msgEx2)
ex2()

def ex3():
    nombre = input("¿ Cual es tu nombre ? : ")
    print(nombre)
ex3()

def ex4():
    nombre = input("¿ Cual es tu nombre ? : ")
    i = int(input("Un número: "))
    for k in range(i):
        print(nombre)
ex4()

def ex5():
    nombre = input("¿ Cual es tu nombre ? : ")
    print(nombre.upper(), "tiene", len(nombre), "letras", sep=" ")
ex5()

def ex6():
    print(((3 + 2) / 2.5) ** 2)
ex6()

def ex7():
    horas = float(input("¿ Cuantas horas has trabajado ? : "))
    cHora = float(input("¿ Y a cuanto te pagan la hora trabajada ? : "))
    print("Te corresponde una paga de", horas * cHora, sep=" ")
ex7()

def ex8():
    est = float(input("¿ Cual es tu estatura (en M) ? : "))
    ps = float(input("¿ Cual es tu peso (en KG) ? : "))
    division = ps / est ** 2
    print("Tu índice de IMC es de ", "{0:.2f}".format(division))
ex8()

def ex9():
    pP = float(input("Dame precio producto : "))
    ent = math.trunc(pP)
    dec = round((pP - ent) * 100)
    print(ent, "euros y", dec, "centimos", sep=" ")
ex9()

def ex10():
    nV = int(input("¿ Barras de pan no vendidas ? : "))
    cuenta = 3.49 - (3.49 * 0.6)
    print("No se vendieron", nV, "barras de pan" , sep=" ")
    print(" Precio normal de una barra : 3.49€ \n", 
        "Descuento por no ser del día : ", 3.49 * 0.6, "\n",
        "Precio final : ", "{0:.2f}".format(cuenta)
    )
ex10()
def ex1():
    edad = int(input("Cual es tu edad ? : "))
    if edad >= 18 :
        print("Eres MAYOR de edad")
    else : 
        print("Eres MENOR de edad")
#ex1()

def ex2():
    passw = "abc123."
    usrPassw = str(input("Escriba la contraseña : "))
    if usrPassw == passw :
        print("Contaseña correcta")
    else :
        print("Contraseña incorrecta")
#ex2()

def ex3():
    nombre = input("Dame tu nombre : ")
    sexo = input("Dame tu sexo H (Hombre) M (Mujer) : ")

    if nombre < 'M' :
        if sexo == 'M' :
            print("Pertenece al grupo A")
        else :
            print("Pertenece al grupo B")
    else:
        if nombre > "N" :
            if sexo == 'H' :
                print("Pertenece al grupo A")
            else :
                print("Pertenece al grupo B") 
#ex3()

def ex4():
    puntuacion = float(input("Dame puntuación empleado : "))
    sBase = 2400

    if puntuacion > 0.0 and puntuacion < 1.0:
        if puntuacion >= 0.0 and puntuacion <= 0.2:
            print("Su nivel ha sido Inaceptable y su sueldo sera de ", sBase * puntuacion)
        else:
            if puntuacion >= 0.2 and puntuacion <= 0.4:
                print("Su nivel ha sido Aceptable y su sueldo sera de ", sBase * puntuacion)
            else :
                if puntuacion >= 0.4 and puntuacion <= 0.6 or puntuacion > 0.6 :
                    print("Su nivel ha sido Aceptable y su sueldo sera de ", sBase * puntuacion)
    else :
        print("Introduzca una puntuación válida")
#ex4()

def ex5():
    veg = ['Pimiento', 'Tofu']
    no_veg = ['Peperoni', 'Jamon', 'Salmón']

    bol = input('Pizza vegetariana o no ?(S/N)')
    if bol == 'S' :
        print('Ingredientes vegetarianos: ')
        for idx in range(0, len(veg)):
            print(veg[idx])
        selec = int(input('Seleccione uno: (0,1)'))
        print('Su pizza vegetariana consta de los siguientes ingredientes : Mozzarella, Tomate y ' + veg[selec])
    else :
        print('Ingredientes no vegetarianos :')
        for idx in range(0, len(no_veg)) :
            print(no_veg[idx])
        selec = int(input('Seleccione uno: (0,1,2)'))
        print('Su pizza no vegetariana consta de los siguientes ingredientes : Mozzarella, Tomate y ' + no_veg[selec])
#ex5()

def ex6():
    word = input('Dame una palabra: ')
    for id in range(0, 10):
        print(word)
#ex6()

def ex7():
    n = abs(int(input('Dame un número positivo: ')))
    for idx in range(1, n + 1):
        if(idx == n):
            print(idx, '.', sep='', end='')
        else :
            print(idx, ', ', sep='', end='')  
#ex7()

def ex8():
    num = int(input("Introduce un numero: "))
    for i in range(num + 1):
        for j in range(i,0,-2):
            if(i%2 != 0):
                print(j, end=" ")
        print("")
#ex8()


def ex9():
    frase = input('Dame una frase: ')
    letra = input('Dame una letra: ')
    cont = 0

    for idx in range(len(frase)):
        if frase[idx] == letra :
            cont = cont + 1
    
    print("En la frase se repita la letra proporcionada", cont, "veces")
#ex9()

def ex10():
    palabra = input('Dame una frase: ')
    while palabra != 'salir':
        print(palabra)
        palabra = input('Dame una frase: ')
#ex10()
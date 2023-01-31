def ex1():

    asignaturas = ['DI', 'AD', 'PSP', 'SXE', 'EIE', 'PMDM']

    for idx in range(0,len(asignaturas)):
        print(asignaturas[idx])

#ex1()

def ex2():

    asignaturas = ['DI', 'AD', 'PSP', 'SXE', 'EIE', 'PMDM']
    notas = ['', '', '', '', '', '']

    for idx in range(0,len(asignaturas)):
        notas[idx] = input('Que nota sacastes en ' + asignaturas[idx] + ' ? ')

    for idx in range(0, len(asignaturas)):
        print("En " + asignaturas[idx] + " has sacado " + notas[idx])

#ex2()

def ex3():

    nums = ['', '', '', '', '', '', '', '']

    for idx in range(0, 8):
        nums[idx] = int(input('Número '+ str(idx) + ' ganador de la primitiva ?: '))
    
    print('Número ganador de la primitiva : ', end=' ')
    
    nums.sort()

    for idx in range(0, len(nums)):
        print(nums[idx], end=" ")

#ex3()

def ex4():

    nums = [1,2,3,4,5,6,7,8,9,10]

    nums.sort(reverse=True)

    for idx in range(0,len(nums)):
        if(idx == 9) :
            print(nums[idx], end='.')
        else :
            print(nums[idx], end=', ')
#ex4()

def ex5():

    asignaturas = ['DI', 'AD', 'SXE', 'PMDM']
    notas = []

    for idx in range(len(asignaturas)):
        nota = int(input('Dame la nota que has sacado en ' + asignaturas[idx] + ' : '))
        notas.append(nota)

    for idx in range((len(notas)-1), -1, -1):
        if notas[idx] >= 5:
            asignaturas.pop(idx)
            notas.pop(idx)
    
    for idx in range(len(asignaturas)):
        print('Debes repetir ', asignaturas[idx])

#ex5()

def ex6():
    abc = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z']
    for idx in range(len(abc)-1, 0, -3):
        abc.pop(idx)
    print(abc)
#ex6()

def ex7():

    a = 0
    e = 0
    i = 0
    o = 0
    u = 0

    frase = str(input('Dame una frase: '))

    for idx in range(len(frase)):
        if frase[idx] == 'a':
            a = a + 1
        elif frase[idx] == 'e':
            e = e + 1
        elif frase[idx] == 'i':
            i = i + 1
        elif frase[idx] == 'o':
            o = o + 1
        elif frase[idx] == 'u':
            u = u + 1

    print('Contiene', a, 'a')
    print('Contiene', e, 'e')
    print('Contiene', i, 'i')
    print('Contiene', o, 'o')
    print('Contiene', u, 'u')

#ex7()

def ex8():

    precios = [50, 75, 46, 22, 80, 65, 8]

    print("El precio máximo es :", max(precios))
    print("El precio mínimo es :", min(precios))

#ex8()

def ex9():

    vector1 = list([1,2,3])
    vector2 = list([-1,0,2])

    sum = (vector1[0] * vector2[0]) + (vector1[1] * vector2[1]) + (vector1[2] * vector2[2])

    print("El producto escalar es: " + str(sum))

#ex9()

def ex10():

    tupla = tuple([1,2,3,4,5,6,7,8,9,10])
    i = int(input("Dame índice a mostrar: "))
    print(tupla[i])

#ex10()


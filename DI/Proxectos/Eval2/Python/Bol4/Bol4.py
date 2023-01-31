def ex1(cantidad, iva=21):

    correcto = False
    while correcto == False :
        try:
            importe = float(input("Dame importe de la factura: "))
            correcto = True
        except:
            print("Introduce un valor")
        
    try :
        iva = int(input("Dame porcentaje de IVA: "))
    except : 
        ex1(cantidad)


    importeTotal = importe + (importe * (iva / 100))
    print("El importe total con iva es de:", importeTotal)

#ex1()

def ex2():

    nums = [2,10,90,100,3]
    sum = 0
    
    for idx in range(len(nums)):
        sum = sum + nums[idx]
     
    print("Media de la lista: ", sum/len(nums))

#ex2()


def ex3():

    diccionario = dict()

    num = int(input("Dame un número: "))

    for idx in range(1, num + 1):
        diccionario[idx] = idx**2

    print(diccionario)

#ex3()

def ex4():

    dicc = {'Euro':'€', 'Dollar':'$', 'Yen':'¥'}
    correcto = False

    while correcto == False:
        try :
            dato = str(input("Dame nombre de la divisa: "))
            print(dicc[dato])
            correcto = True
        except :
            print("La divisa no está en el diccionario")

#ex4()

def ex5():

    dicc = {'Pera':1.2, 'Manzana':1.4, 'Banano':1.1, 'Fresa':2.1, 'Sandia':2.2}
    correcto = False

    while correcto == False:
        try :
            fruta = str(input('Dame nombre de la fruta: '))
            dicc[fruta]
            try :
                cantidad = int(input('Dame los kilos vendidos: '))
                print("La cantidad ganada con la venta de la/el {frutaN} es de".format(frutaN = fruta), dicc[fruta] * cantidad)
            except:
                print('Debes dar un valor en kilos')
        except:
            print('No tenemos esa fruta')
        
        bucle = str(input('Quieres revisar otra fruta (S/N): '))
        if(bucle.lower() != 's'):
            correcto = True
 
#ex5()

def Persona(nombre, edad, direccion, telefono) :

    persona = {
        "nombre" : nombre,
        "edad" : edad,
        "direccion" : direccion,
        "telefono" : telefono
    }

    return persona['nombre'] + " tiene " + str(persona["edad"]) + " años, vive en " + persona['direccion'] + " y su número de teléfono es " + str(persona['telefono']) 
#Persona()

def ex6():

    p = None

    try :
        nombre = str(input('Dame el nombre de la persona: '))
        edad = int(input('Dame la edad de la persona: '))
        direccion = str(input('Dame la dirección de la persona: '))
        numero = int(input('Dame el número de la persona: '))
        p = Persona(nombre, edad, direccion, numero)
    except:
        print("Valor no válido")
    
    print(p)

#ex6()

def ex7():
    menu = ["Introducir nombre", "Introducir apellido", "Introducir edad", "Introducir telefono", "Mostrar persona", "Salir"]
    persona = {'nombre' : '', 'apellido': '', 'edad': 0, 'telefono': 0}

    while(True):
        for idx in range(len(menu)):
            print(idx, ".",menu[idx])
        
        opcion = int(input("Dame opción: "))

        if opcion == 0 :
            persona['nombre'] = str(input('Dame nombre de la persona: '))
            print(persona)
        elif opcion == 1 :
            persona['apellido'] = str(input('Dame apellido de la persona: '))
            print(persona)
        elif opcion == 2 :
            succes = False
            while succes != True :
                try:
                    persona['edad'] = int(input('Dame edad de la persona: '))
                    print(persona)
                    succes = True
                except:
                    print("Valor equivocado, introduce un número porfavor")
        elif opcion == 3 :
            succes = False
            while succes != True :
                try:
                    persona['telefono'] = int(input('Dame telefono de la persona: '))
                    print(persona)
                    succes = True
                except:
                    print("Valor equivocado, introduce un número porfavor")
        elif opcion == 4 :
            print(persona['nombre'], persona['apellido'], 'tiene', str(persona['edad']), "años y su telefono es", str(persona['telefono']))
        elif opcion == 5 :
            break
        else :
            print('Opción erronea')
#ex7()

def ex8():

    diccionario= {}
    dicc = str(input('Escribe el diccionario: ')).split(",")

    for idx in range(len(dicc)):
        if(dicc[idx].__contains__(':')):
            palabras = dicc[idx].split(':')
            diccionario.__setitem__(palabras[0], palabras[1])
    print(diccionario)

    # #frase = str(input('Introduce una frase en español: '))
    
    # palabras = frase.split(" ")

    # for idx in range(len(palabras)):
    #     print(dicc)
    #     if palabras[idx] in dicc :
    #         print('Test Complete')

    


    #print("Frase traducida: " , frase)

ex8()

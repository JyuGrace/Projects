from calendar import c
from os import system
system("cls")

def recorrer_Matriz_x_valor(matriz):
    for fila in matriz:
        print()
        for valor in fila:
            print(valor, end = " ")
    print()
def leerArchivo():
    with open("data.csv", 'r') as datafile:
        linea= datafile.readline()
        encabezado= linea.rstrip('\n').split(',')

        # Iniciar una matriz nula para la informacion de los pacientes
        matriz= []
        #
        # Inicia un vector con un espacio en blanco para guardar la concatenacion de Ciudad y Departamento por ej.: Leticia Amazonas
        sucursales= [' ']*32
        #
        linea = datafile.readline()
        while linea:
            fila = linea.rstrip('\n').split(',')

            # Concatena city_name y department_name en indice id_branch-1, ten en cuenta el inicie de cada atributo
            sucursales[int(fila[5])-1]= fila[3]+ " " + fila[4]
            #
            # Adiciona una fila a la matriz de pacientes
            matriz.append(fila)
            #
            # Lee la siguiente linea del archivo CSV
            linea = datafile.readline()
    return matriz, sucursales, encabezado        

#suc = recorrer_Matriz_x_valor(sucursales)
''' print(sucursales)
print(len(sucursales))
contar = 0
for i in range(len(sucursales)):
    print(sucursales[i])
    contar += 1
print(contar)  '''

#mat = recorrer_Matriz_x_valor(matriz)   

def main():
    # Arreglos de datos que se obtienen de la funcion
    pacientes, centrales, columnas= leerArchivo()

    # Obtiene los indices de las columnas utilizadas en el proceso
    i_gender = columnas.index('gender')
    i_branch = columnas.index('id_branch')
    i_ps = columnas.index('systolic_pressure')
    i_pd = columnas.index('diastolic_pressure')
    i_medq = columnas.index('medicine_quantity')
    hombres = 0
    mujeres = 0
    len_pacientes = len(pacientes)
    cant_med = 0

    # Capturar la central ingresada como Entrada
    input_central= int(input("ingrese la id de la sucursal a consultar: "))
    #
    for i in range(len_pacientes):
        if int(pacientes[i][i_branch])== input_central:
            entrega= False
            sis, dia = int(pacientes[i][i_ps]), int(pacientes[i][i_pd])
            if sis < 91 and dia < 63:
                entrega= True
            elif 162 <= sis < 188 and 105 <= dia < 119:
                entrega= True
            elif 188 <= sis < 201 and 119 <= dia < 126:
                entrega= True
            elif 201 <= sis < 2014 and 126 <= dia < 146:
                entrega= True
            elif sis >= 214 and dia >= 146:
                entrega= True
            elif sis >= 152 and dia < 77:
                entrega= True
            else:
                entrega= False

            if entrega:
                if pacientes[i][i_gender]== 'm':
                    hombres += 1
                else :
                    mujeres += 1

                # Acumula Cantidad Total de Medicamentos solicitados por el Cliente
                cant_med += int(pacientes[i][i_medq])

    # Salidas esperadas
    print(f"{input_central} {centrales[input_central-1]}")
    print("scheduled patients")
    print(f'male {hombres}')
    print(f'female {mujeres}')
    print(f'total {hombres + mujeres}')
    print('scheduled medicine quantity')
    print('mean {:.2f}'.format(cant_med/(hombres + mujeres)))
    print(f"total {cant_med}")
    
main()    
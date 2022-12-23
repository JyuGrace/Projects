from os import system
system("cls")

#solicitar el numero desucursales y pacientes
suc = []
pac = []
med_inicial = [] #almacena las existencias de medicmaentos por sucursal (inicial)
matriz_med_inicial = [] #almacena todos los medicmaentos por tipos y sucursales (inicial)
matriz_data_pac_inicial = [] #almacena toda la info de los pacientes ingresada, sucursal, tipo demed, num de meds y presiones
data_pac_inicial = [] #almacena info por paciente para ingresarla a matriz_data_pac_inicial
tipos_med = [] #almacena el tipo de medicamentos 1, 2 , 3
matriz_med_entregar = [] #almacena los medicamentos por sucursal y tipo a entregar
matriz_suc_pac = [] #pacientes atendidos en cadas ucursal

#inicializar  el ciclo
num_sucursales = 0
num_pacientes = 0
num_tipos_medicamentos = 0

#solicita el num de sucursales y pacientes
while (num_sucursales <= 0) and (num_tipos_medicamentos <= 0):
    num_suc_med_pac_str = ((input("ingrese #de sucs #tipos de meds y # pacs: ").split(" ")))
    num_suc_med_pac = [int(num_suc_med_pac_str[0]) , int(num_suc_med_pac_str[1]) , int(num_suc_med_pac_str[2])]
    if (num_suc_med_pac[0] >= 1) and (num_suc_med_pac[1] >= 1):
        for i in range (1, num_suc_med_pac[0]+1):
            suc.append(i) # vector de sucursales
        for k in range (1, num_suc_med_pac[1]+1):
            tipos_med.append(k) # vector con tipo de medicamento
        for j in range (1, num_suc_med_pac[2]+1):
            pac.append(j)    #vector de pacientes
        num_sucursales = num_suc_med_pac[0] #para salirse del while
        num_tipos_medicamentos = num_suc_med_pac[1]
        num_pacientes = num_suc_med_pac[2] #para salirse del while         
    else:
        num_sucursales = 0 #para que entre al ciclo y pida valores validos
        num_tipos_medicamentos = 0
        num_pacientes = 0

#crea la matriz que almacena las existencias iniciales de medicamentos por sucursal y tipo de medicamento       
for i in range (num_sucursales):
    med_inicial_str = ((input(f"ingrese la existencia de medicamentos por tipos, para la sucursal {i+1}: ").split(" ")))
    for j in range(num_tipos_medicamentos):
        med_inicial.append(int(med_inicial_str[j]))
    matriz_med_inicial.append(med_inicial)
    med_inicial = []

#crea la matriz que almacena la sucursal tipo y num de medicamento + datos de presion del paciente      
for i in range (num_pacientes):
    data_pac_inicial_str = ((input(f"ingrese la suc, tipo de med, # de med p. sis y p. dis, para el paciente {i+1}: ").split(" ")))
    for j in range (5):
        data_pac_inicial.append(int(data_pac_inicial_str[j]))
    matriz_data_pac_inicial.append(data_pac_inicial)
    data_pac_inicial = [] 
    
  
matriz_data_pac_corregida = []
vector_data_pac_corregida = []

#se crea el vector # de pacientes por cada sucursal
pac_suc = []
cont_pac = 0
for i in suc:
    for j in range(len(matriz_data_pac_inicial)):
            if i == matriz_data_pac_inicial[j][0]:
                cont_pac += 1
    pac_suc.append(cont_pac)
    cont_pac = 0

       
test_mat = []
vec_test = []
matriz_data_pac_inicial_clon = matriz_data_pac_inicial

for i in range (len(matriz_data_pac_inicial_clon)):
    for j in range (len(matriz_data_pac_inicial_clon[0])):
        if (matriz_data_pac_inicial_clon[i][0] >= 1) and (matriz_data_pac_inicial_clon[i][0] <= num_sucursales):
            if (matriz_data_pac_inicial_clon[i][1] >= 1) and (matriz_data_pac_inicial_clon[i][1] <= num_tipos_medicamentos):
                if (matriz_data_pac_inicial_clon[i][2] >= 0):
                    if (matriz_data_pac_inicial_clon[i][3] < 80) and (matriz_data_pac_inicial_clon[i][4] < 60):
                        vec_test.append(matriz_data_pac_inicial_clon[i][j])
                        
                    elif (matriz_data_pac_inicial_clon[i][3] >= 80 and (matriz_data_pac_inicial_clon[i][3] < 120)) and (matriz_data_pac_inicial_clon[i][4] >= 60 and (matriz_data_pac_inicial_clon[i][4] < 80)): #aqui no se entrega
                        matriz_data_pac_inicial_clon[i][2] = 0
                        vec_test.append(matriz_data_pac_inicial_clon[i][j])
                        
                    elif (matriz_data_pac_inicial_clon[i][3] >= 120 and (matriz_data_pac_inicial_clon[i][3] < 130)) and (matriz_data_pac_inicial_clon[i][4] >= 80 and (matriz_data_pac_inicial_clon[i][4] < 85)):#aqui no se entrega
                        matriz_data_pac_inicial_clon[i][2] = 0
                        vec_test.append(matriz_data_pac_inicial_clon[i][j])
                        
                    elif (matriz_data_pac_inicial_clon[i][3] >= 130 and (matriz_data_pac_inicial_clon[i][3] < 140)) and (matriz_data_pac_inicial_clon[i][4] >= 85 and (matriz_data_pac_inicial_clon[i][4] < 90)):
                        vec_test.append(matriz_data_pac_inicial_clon[i][j])
                        
                    elif (matriz_data_pac_inicial_clon[i][3] >= 140 and (matriz_data_pac_inicial_clon[i][3] < 160)) and (matriz_data_pac_inicial_clon[i][4] >= 90 and (matriz_data_pac_inicial_clon[i][4] < 100)):
                        vec_test.append(matriz_data_pac_inicial_clon[i][j])
                        
                    elif (matriz_data_pac_inicial_clon[i][3] >= 160 and (matriz_data_pac_inicial_clon[i][3] < 180)) and (matriz_data_pac_inicial_clon[i][4] >= 100 and (matriz_data_pac_inicial_clon[i][4] < 110)):
                        vec_test.append(matriz_data_pac_inicial_clon[i][j])
                        
                    elif (matriz_data_pac_inicial_clon[i][3] >= 180) and (matriz_data_pac_inicial_clon[i][4] >= 110):
                        vec_test.append(matriz_data_pac_inicial_clon[i][j])
                        
                    elif (matriz_data_pac_inicial_clon[i][3] >= 140) and (matriz_data_pac_inicial_clon[i][4] < 90):
                        vec_test.append(matriz_data_pac_inicial_clon[i][j])
                         
                    else :
                        matriz_data_pac_inicial_clon[i][2] = 0
                        vec_test.append(matriz_data_pac_inicial_clon[i][j])
                        
                else :
                        matriz_data_pac_inicial_clon[i][2] = 0
                        vec_test.append(matriz_data_pac_inicial_clon[i][j])
                        
            else :
                        matriz_data_pac_inicial_clon[i][2] = 0
                        vec_test.append(matriz_data_pac_inicial_clon[i][j])
                        
        else :
                        matriz_data_pac_inicial_clon[i][2] = 0
                        vec_test.append(matriz_data_pac_inicial_clon[i][j])
                                                                         
    test_mat.append(vec_test) # matriz con la data LIMPIA!
    vec_test = []     
                                 
pac_suc = []
cont_pac = 0

for i in suc:
    for j in range(len(matriz_data_pac_inicial)):
            if i == matriz_data_pac_inicial[j][0]:
                cont_pac += 1
    pac_suc.append(cont_pac)
    cont_pac = 0                   

# crea la matriz con los medicamentos a entregar por sucursal y tipo
contador = 0
fila_med_entregar = []
matriz_med_entregar = []

for i in range(len(suc)):
    for j in range(len(tipos_med)):
        for k in range(len(matriz_data_pac_inicial)):
            for c in range(1):
                if (matriz_data_pac_inicial[k][0] == suc[i]) and (matriz_data_pac_inicial[k][1] == tipos_med[j]):
                    contador += matriz_data_pac_inicial[k][2]
        fila_med_entregar.append(contador)
        contador = 0
        
    matriz_med_entregar.append(fila_med_entregar)
    fila_med_entregar = [] 
    contador = 0 

#crea matriz con restantes de existencias de medicamentos por sucursal
fila_resta = []
matriz_med_restantes = []

for i in range(len(suc)):
    for j in range(len(tipos_med))  :
        resta = matriz_med_inicial[i][j] - matriz_med_entregar[i][j]
        fila_resta.append(resta)
       
    matriz_med_restantes.append(fila_resta)
    fila_resta = []
 
#crea matriz que suma las cantidades de medicamento entregados por sucursal 
suma_med = [] 
suma = 0 
for i in range(len(suc)):
    for j in range(len(tipos_med)):
        suma += matriz_med_entregar[i][j]
    suma_med.append(suma)
    suma = 0    

#resultados
for i in range(len(suc)):
    print(suc[i])
    a = matriz_med_restantes[i] #extrae la fila de medicamentos por tipo para cada sucursal
    mini = min(a) #calcula el valor minimo de medicamento que sobra en cada sucursal
    maxi = max(a) #calcula el valor maximo de medicamento que sobra en cada sucursal
    promedio = suma_med[i]/len(tipos_med) #calcula el promedio de medicamenos entregados por sucursal
    print(f"{a.index(mini)+1} {mini}")
    print(f"{a.index(maxi)+1} {maxi}")
    print(f"{min(matriz_med_entregar[i]) :.2f} {promedio :.2f} {max(matriz_med_entregar[i]) :.2f}")
    if pac_suc[i] == 0:
        d = 0 #si el numero de pacientes es cero en la sucursal, el promedio de medicamentos por paciente es cero
        print(f"{d :.2f}")
    else:
        d = suma_med[i]/pac_suc[i] #si el numero de pacientes no es cero en la sucursal, calcula el promedio de medicamentos por paciente
        print(f"{d :.2f}")
    
#calcula una lista que almacena la entrega de medicamento tipo 1 por sucursal
lista_suc_med1 = []
for i in range(len(matriz_med_entregar)):
    lista_suc_med1.append(matriz_med_entregar[i][0])
    
print(f"{lista_suc_med1.index(min(lista_suc_med1))+1} {min(lista_suc_med1)}") #imprime la sucursal con la menor entrega de medicamento tipo 1
print(f"{lista_suc_med1.index(max(lista_suc_med1))+1} {max(lista_suc_med1)}") #imprime la sucursal con la mayor entrega de medicamento tipo 1
        
 

suc = []
pac = []
med_inicial = []
data_pac = []

#inicializar  el ciclo
num_sucursales = 0
num_pacientes = 0

#solicita el num de sucursales y pacientes
while (num_sucursales <= 0) and (num_pacientes <= 0):
    num_suc_pac_str = ((input().split(" ")))
    num_suc_pac = [int(num_suc_pac_str[0]) , int(num_suc_pac_str[1])]
    if (num_suc_pac[0] >= 1) and (num_suc_pac[1] >= 1):
        for i in range (1, num_suc_pac[0]+1):
            suc.append(i) # vestor de sucursales
        for j in range (1, num_suc_pac[1]+1):
            pac.append(j)    #vector de pacientes
        num_sucursales = num_suc_pac[0] #para salirse del while
        num_pacientes = num_suc_pac[1] #para salirse del while         
    else:
        num_sucursales = 0 #para que entre al ciclo y pida valores validos
        num_pacientes = 0
        

#solicita el numero de farmacos por sucursal         
for i in range(1, len(suc) + 1):
    med_suc=int(input())
    if med_suc >=1:
        med_inicial.append(med_suc)
    else:
        while med_suc <= 0:
            med_suc=int(input())
            if med_suc >= 1:
                med_inicial.append(med_suc) #med por sucursal

#print(med_inicial) 

info_paciente = []  
pacientes = []
#solicita donde se atendera cada paciente y calculara cuatos medicamentos se llevara               
for i in range (1,len(pac)+1) :
    data_pac_pre_str = input().split(" ")
    data_pac_pre = [int(data_pac_pre_str[0]) , int(data_pac_pre_str[1]), int(data_pac_pre_str[2])]
   
    
    if (data_pac_pre[0] >= 1) and (data_pac_pre[0] <= num_suc_pac[0]) :
        if (data_pac_pre[1] < 80) and (data_pac_pre[2] < 60) :
                num_dosis = 5
                pacientes.append(data_pac_pre[0])
        elif ((data_pac_pre[1] >= 80 ) and (data_pac_pre[1] <120)) and ((data_pac_pre[2] >= 60) and (data_pac_pre[2] < 80))  :
                num_dosis = 0
                pacientes.append(data_pac_pre[0])
        elif ((data_pac_pre[1] >= 120 ) and (data_pac_pre[1] <130)) and ((data_pac_pre[2] >= 80) and (data_pac_pre[2] < 85)) :
                num_dosis = 0
                pacientes.append(data_pac_pre[0])
        elif ((data_pac_pre[1] >= 130 ) and (data_pac_pre[1] <140)) and ((data_pac_pre[2] >= 85) and (data_pac_pre[2] < 90))  :
                num_dosis = 2
                pacientes.append(data_pac_pre[0])
        elif ((data_pac_pre[1] >= 140 ) and (data_pac_pre[1] <160)) and ((data_pac_pre[2] >= 90) and (data_pac_pre[2] < 100)) :
                num_dosis = 5  
                pacientes.append(data_pac_pre[0])
        elif ((data_pac_pre[1] >= 160 ) and (data_pac_pre[1] <180)) and ((data_pac_pre[2] >= 100) and (data_pac_pre[2] < 110)) :
                num_dosis = 10  
                pacientes.append(data_pac_pre[0])
        elif ((data_pac_pre[1] >= 180) and (data_pac_pre[2] >= 110)) :
                num_dosis = 30  
                pacientes.append(data_pac_pre[0])  
        elif ((data_pac_pre[1] >= 140) and (data_pac_pre[2] < 90))  :
                num_dosis = 20
                pacientes.append(data_pac_pre[0])
        else : #tentativo
                num_dosis = 0  
                pacientes.append(data_pac_pre[0])
                
        pacientes.append(num_dosis)
        info_paciente.append(pacientes) #matriz con sucursal y num de medicamento de cada paciente, en orden ascendente         
                
    else :
        continue          
                 
        #pacientes.append(num_dosis)
        #info_paciente.append(pacientes) #matriz con sucursal y num de medicamento de cada paciente, en orden ascendente
    pacientes = []                          

#print(info_paciente) 

suc_med_restantes = []
me_restantes = []


contador_pacientes = 0
#crea la matriz suc_med_restantes dodne estan las sucursales con los meds restantes despues de haber sido entregados
for i in range(len(suc)):
    me_restantes.append(i+1)
    for j in range(len(info_paciente)):
        if (i+1) == info_paciente[j][0]:
            contador_pacientes += info_paciente[j][1]
    l = med_inicial[i]-contador_pacientes
    me_restantes.append(l)
    suc_med_restantes.append(me_restantes)
    contador_pacientes = 0
    me_restantes = [] 


#lets see
suc_menor_med = min(suc_med_restantes)
suc_mayor_med = max(suc_med_restantes) 



test_mayor = max(suc_med_restantes, key = lambda item: item [1]) 
test_menor = min(suc_med_restantes, key = lambda item: item [1]) 
print(test_menor[0], test_menor[1]) 
print(test_mayor[0], test_mayor[1])

       

#calcula el numero de medicamentos entregados por sucursal 
med_entregados = [] 
for i in range (len(med_inicial)):
    med_entregados.append(med_inicial[i]-suc_med_restantes[i][1])

med_porcentual = []
for k in range (len(med_inicial)):
    porcentajes = 100*(med_entregados[k] / med_inicial[k])
    med_porcentual.append(porcentajes)
#print(med_porcentual) 

#crea la matriz final
resultados = []
result_intermedio = []
for x in range (len(suc)):
    result_intermedio.append(suc[x])
    result_intermedio.append(med_porcentual[x])
    resultados.append(result_intermedio)
    result_intermedio = []
#print(resultados) 

#imprime el resultado
for i in range (len(resultados)):
    print(f"{resultados[i][0]} {resultados[i][1] :.2f}%")         
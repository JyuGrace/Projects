from os import system
system("cls")

import math

num_areas = int(input("ingrese el numero de zonas a contemplar: "))

area_ant_old = 18400
area_a = 35600
area_b = 6800
area_c = 59300
area_d = 24200
area_e = 7400

num_ant_new_a = 0
num_ant_new_b = 0
num_ant_new_c = 0
num_ant_new_d = 0
num_ant_new_e = 0

por_ant_a = 0
por_ant_b = 0
por_ant_c = 0
por_ant_d = 0
por_ant_e = 0

acum_a = 0
acum_b = 0
acum_c = 0
acum_d = 0
acum_e = 0

if num_areas > 0: 

    for i in range(1,num_areas+1):
        area = float(input(f"ingrese el area de la zona {i}: "))
        num_ant_old = int(input(f"ingrese el numero de antenas viejas instaladas en la zona {i}: "))
        tipo_ant = input(f"ingrese el tipo de antena nueva a instalar en la zona {i}: ")
        if num_ant_old >= 0 :
            if tipo_ant == "a" :
                num_ant_new_a = math.ceil((area-area_ant_old*num_ant_old)/area_a)
                if num_ant_new_a < 0 :
                    num_ant_new_a = 0
                acum_a += num_ant_new_a        
            elif tipo_ant == "b" :
                num_ant_new_b = math.ceil((area-area_ant_old*num_ant_old)/area_b)
                if num_ant_new_b < 0 :
                    num_ant_new_b = 0
                acum_b += num_ant_new_b     
            elif tipo_ant == "c" :
                num_ant_new_c = math.ceil((area-area_ant_old*num_ant_old)/area_c)
                if num_ant_new_c < 0 :
                    num_ant_new_c = 0
                acum_c += num_ant_new_c     
            elif tipo_ant == "d" :
                num_ant_new_d = math.ceil((area-area_ant_old*num_ant_old)/area_d)
                if num_ant_new_d < 0 :
                    num_ant_new_d = 0
                acum_d += num_ant_new_d     
            elif tipo_ant == "e" :
                num_ant_new_e = math.ceil((area-area_ant_old*num_ant_old)/area_e)
                if num_ant_new_e < 0 :
                    num_ant_new_e = 0
                acum_e += num_ant_new_e     
        else :
            if tipo_ant == "a" :         
                num_ant_new_a = 0
            elif tipo_ant == "b" :
                num_ant_new_b = 0
            elif tipo_ant == "c" :
                num_ant_new_c = 0
            elif tipo_ant == "d" :
                num_ant_new_d = 0
            elif tipo_ant == "e" :
                num_ant_new_e = 0
                
    total_ant_new = acum_a + acum_b + acum_c + acum_d + acum_e
    if total_ant_new == 0 :            
        por_ant_a = 0
        por_ant_b = 0
        por_ant_c = 0
        por_ant_d = 0
        por_ant_e = 0
        
        print(f"el numero total de antenas a instarla es: {total_ant_new}")
        print(f"a {por_ant_a :.2f}%")
        print(f"b {por_ant_b :.2f}%")
        print(f"c {por_ant_c :.2f}%")
        print(f"d {por_ant_d :.2f}%")
        print(f"e {por_ant_e :.2f}%")
    else: 
        por_ant_a = (acum_a / total_ant_new) *100
        por_ant_b = (acum_b / total_ant_new) *100
        por_ant_c = (acum_c / total_ant_new) *100
        por_ant_d = (acum_d / total_ant_new) *100
        por_ant_e = (acum_e / total_ant_new) *100
        
        print(f"el numero total de antenas a instarla es: {total_ant_new}")
        print(f"a {por_ant_a :.2f}%")
        print(f"b {por_ant_b :.2f}%")
        print(f"c {por_ant_c :.2f}%")
        print(f"d {por_ant_d :.2f}%")
        print(f"e {por_ant_e :.2f}%")
            
else:
    print(f"el numero total de antenas a instalar es: {num_ant_new_a + num_ant_new_b + num_ant_new_c + num_ant_new_d + num_ant_new_e}")
    print(f"a {por_ant_a :.2f}%")
    print(f"b {por_ant_b :.2f}%")
    print(f"c {por_ant_c :.2f}%")
    print(f"d {por_ant_d :.2f}%")
    print(f"e {por_ant_e :.2f}%")
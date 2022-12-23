import math

area = float(input())
num_ant_old = int(input())
tipo_ant = input()
area_ant_old = 18400
area_a = 35600
area_b = 6800
area_c = 59300
area_d = 24200
area_e = 7400 

if num_ant_old >= 0 :
    if tipo_ant == "a" :
        num_ant_new = math.ceil((area-area_ant_old*num_ant_old)/area_a)
        if num_ant_new < 0 :
            print(0)
        else:
            print(num_ant_new)             
    elif tipo_ant == "b" :
        num_ant_new = math.ceil((area-area_ant_old*num_ant_old)/area_b)
        if num_ant_new < 0 :
            print(0)
        else:
            print(num_ant_new) 
    elif tipo_ant == "c" :
        num_ant_new = math.ceil((area-area_ant_old*num_ant_old)/area_c)
        if num_ant_new < 0 :
            print(0)
        else:
            print(num_ant_new) 
    elif tipo_ant == "d" :
        num_ant_new = math.ceil((area-area_ant_old*num_ant_old)/area_d)
        if num_ant_new < 0 :
            print(0)
        else:
            print(num_ant_new) 
    elif tipo_ant == "e" :
        num_ant_new = math.ceil((area-area_ant_old*num_ant_old)/area_e)
        if num_ant_new < 0 :
            print(0)
        else:
            print(num_ant_new) 
    else:
        print("error en los datos")                    
else :
    print("error en los datos")     
package Ejercicio7;


class Solution {
public String[] findRelativeRanks(int[] nums) {
    int[] sorted=nums.clone();
    Arrays.sort(sorted);
    int i=0,j=nums.length-1;
    while(i<j){int temp=sorted[i];sorted[i]=sorted[j];sorted[j]=temp;i++;j--;}
    HashMap<Integer,String> map=new HashMap();
    for(int k=0;k<nums.length;k++)map.put(sorted[k],String.valueOf(k+1));
    String[] output=new String[nums.length];
    int k=0;
    for(int a:nums){
        if(map.get(a).equals("1"))output[k]="Gold Medal";
        else if(map.get(a).equals("2"))output[k]="Silver Medal";
        else if(map.get(a).equals("3"))output[k]="Bronze Medal";
        else output[k]=map.get(a);k++;
    }
    return output;
  }
}    

/*
_____________________________________________ANALISIS DE EL ALGORITMO________________________________________
 Se le da una matriz scorede números enteros de tamaño n, donde score[i]es el puntaje del atleta en una competencia. Se garantiza que todas las puntuaciones son únicas .ith

Los atletas se colocan en función de sus puntajes, donde el atleta del lugar tiene el puntaje más alto, el atleta del lugar tiene el puntaje más alto, y así sucesivamente. La ubicación de cada atleta determina su rango:1st2nd2nd

El lugar donde se encuentra el rango del atleta .1st"Gold Medal"
El lugar donde se encuentra el rango del atleta .2nd"Silver Medal"
El lugar donde se encuentra el rango del atleta .3rd"Bronze Medal"
Para el puesto del atleta del puesto, su rango es su número de puesto (es decir, el puesto del atleta del puesto es ).4thnthxth"x"
Devuelve una matriz answerde tamaño ndonde answer[i]está el rango del atleta.ith

___________________________________________ANALISIS DE COMPLEJIDAD_____________________________________________________________
El analisis de complejidad del algoritmo es O(n2)

 */
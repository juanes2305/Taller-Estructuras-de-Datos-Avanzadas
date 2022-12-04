package Ejercicio8;


#include<functional>
#include<stdio.h>
#include<string.h>
#include<queue>
using namespace std;
typedef struct
{
	char stu[20];
	int x;
}carry;
carry str[1000005],str1[1000005];
int  main()
{
	int n,m,j=0;
	priority_queue<int, vector<int>,greater<int> >k;
	scanf("%d",&n);
	for(int i=1;i<=n;i++)
	{
		scanf(" %s",str[i].stu);
		if(strcmp(str[i].stu,"removeMin")!=0)
			scanf("%d",&str[i].x);
		if(strcmp(str[i].stu,"insert")==0)
		{
			k.push(str[i].x);
			str1[j++]=str[i];
		}
		else if(strcmp(str[i].stu,"removeMin")==0)
		{
			if(k.empty())
			{
				k.push(1);
				strcpy(str1[j].stu,"insert");
				str1[j++].x=1;
			}
			k.pop();
			str1[j++]=str[i];
		}
		else if(strcmp(str[i].stu,"getMin")==0)
		{
            if(k.empty())
			{
				strcpy(str1[j].stu,"insert");
				str1[j++].x=str[i].x;
				k.push(str[i].x);
				strcpy(str1[j].stu,"getMin");
				str1[j++].x=str[i].x;
			}
			else
			{
				while(k.top()<str[i].x)
				{
					strcpy(str1[j++].stu,"removeMin");
					k.pop();
					if(k.empty())
					{
						strcpy(str1[j].stu,"insert");
						str1[j++].x=str[i].x;
						k.push(str[i].x);
					}
				}
				if(k.top()>str[i].x)
				{
					strcpy(str1[j].stu,"insert");
					str1[j++].x=str[i].x;
					k.push(str[i].x);
				}
				if(k.top()==str[i].x)
				{
					strcpy(str1[j].stu,"getMin");
					str1[j++].x=str[i].x;
				}
			}
		}
	}
	printf("%d\n",j);
	for(int i=0;i<j;i++)
	{
		if(strcmp(str1[i].stu,"removeMin")==0)
			printf("%s\n",str1[i].stu);
		else
			printf("%s %d\n",str1[i].stu,str1[i].x);
	}
}


/* _________________________________________ANALISIS DE EL ALGORITMO__________________________________________-
 * 
 *   En primer lugar, esta pregunta utiliza una cola de prioridad, que es la base para resolver esta pregunta.
  ¿Qué es una cola de prioridad?
   Archivo de encabezado de llamada:
  #include<queue>
  usando el espacio de nombres std; (la plantilla de la cola necesita definir el tipo de contenedor)
       uso detallado (parte): 
  Priority_queue<Type> k; ------ Defina una cola ordenada (el elemento superior es el más grande El uno)
  priority_queue<(el tipo de datos de los elementos en la cola), (el tipo del contenedor subyacente utilizado para almacenar y acceder a los elementos de la cola), (reglas de comparación) > k ------ ( forma estándar) define una cola ordenada
  Por ejemplo: cola_prioridad<int, vector<int>, mayor<int> > k; (nota: debe haber un espacio después de la regla de comparación)
define una cola ordenada, y la regla de clasificación es de grande a pequeño (el elemento superior es el más pequeño El que está en la parte superior del mayor) (el más pequeño en la parte superior de mayor, el más grande en la parte superior de menor)


  k.empty() ------ Verifique si es un ejemplo vacío, en caso afirmativo, devuelve 1, no devuelve 0
  k.push(i) ------ Desde Agregar elemento i después del elemento existente (el tamaño del equipo no está predeterminado)
  k.pop() - ----- Borrar el elemento superior (por supuesto, después de ordenar, lo mismo a continuación)
  k.top() ---- -- Mostrar el elemento superior
  k.size() ------ Mostrar el número de elementos existentes
 
Luego mira la solución específica de la pregunta:
  En primer lugar, hay insert, getmin, removemin, tres formas.
insert y removemin no se detallarán aquí;
Concéntrese en discutir la situación de getmin. Realmente llevó demasiado tiempo depurar en ese momento.
(1) Cuando la cola está vacía, inserte directamente + getmin;
(2) Cuando el valor mínimo actual de la cola es menor que el valor mínimo en getmin, es necesario eliminar continuamente el valor mínimo en la cola hasta que sea mayor o igual a
Valor mínimo en getmin
(3) Cuando el valor mínimo actual en la cola es mayor que getmin, inserte directamente;
(4) Cuando se elimina el valor mínimo en la cola, la cola está vacía y se inserta directamente;
-----------------------------------ANALISIS DE COMPLEJIDAD_____________________________________________________________________________
El algoritmo tiene una complejidad de O(N)

   */
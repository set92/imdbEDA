
Proyecto2 1er cuatri EDA 2015/2016
=================================

 Things To Do
-------------
** Junit


 Dudas
------------
**duda 1** - hay que evaluar lista vacia si la pre dice no vacia?
**duda 2** - informe?hay que hacer o para esta practica no?
**duda 3** - en los  remove te quedas con la info del elemento que has borrado, para que? para dejarselo al GC?y porque no hacerlo nosotros?
                    y luego terminas teniendo en 2 posiciones el mismo objeto... para que? porque first = first.next; tienes nodo 1 y 2 con lo mismo
                    si hicieras eso no tendrias que estar moviendo todos los elementos una a la izquierda?
          
**duda 4** - que si en los casos de prueba se pueden poner las tablas que hacemos en clase o hay que tener los junit y sus clases?                    
**duda 5** - //no me gusta crear nodo, no deberia estar ya creado? en metodo addafter, clase unorderedlist
**duda 6** - al hacer la ordered tienes qe poder comparar pasa saber donde ponerlo pero con elementos T asi que dificil comparar con < y >,
              como lo haces?usas compareTo y vas mirando si 0,1 o 2? entonces le hacemos el .implements compareTo? o mejor 
                añadirselo como nos enseñaste con un metodo qe haga lo mismo?
**duda 7** - Y que comparas? porque si son de tipo T es para no saber lo qe tienen dentro, y comparas usando el compareTo lo ordenas por el valor del objeto
                pero en el caso del proyecto1 lo tenemos que ordenar por el nombre del titulo y en otros casos sera distinto.
                
**Respuesta 1 ** - no estas obligado pero esta mejor porque es mas seguro, y añadir siempre casos posible
**Respuesta 2 ** - Si hay que hacer informe pero los algoritmos y todos los metodos esta muy entreladazo, asi que unir esos 2 apartados
**Respuesta 3 ** - No estas mirando los objetos sino las referencias, y si terminas teniendo la referencia duplicada pero una de ellas es de un objeto que ya no se usa.
                       Dejar el objeto, el return por el improbable caso de que se vaya a usar o se quiera saber cual es el elemento borrado.
**Respuesta 4 ** - da lo mismo 
**Respuesta 5 ** - Hay que buscar cual es el metodo target antes de crear el nodo
**Respuesta 6 ** - se hace con el compareTo y luego creo que es ir compareTo comparando con 0 1, cuando es < y > respectivamente.
**Respuesta 7 ** - que se override el metodo CompareTo de cada T y se especifica que se busca o respecto a que criterio buscar 
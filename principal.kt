package Menu

import cuentas
import movimitos

val Cuenta1 = cuentas ("01-5847-9","Alberto","Palma",5000.00)

fun main ()
{
    // Menu y opcion para elegir
    println(Cuenta1)
    println("""************Menu***********
                1-Depositar
                2-Retirar
                0-Salir
                
                Ingrese 1 o 2 para elegir una opcion
    """.trimMargin())



// menu de opciones
    val opcion = when(readLine())
    {
        "1" -> movimitos.DEPOSITO
        "2" -> movimitos.RETIRO

        else ->
        {
            println("gracias vuevla pronto")
            return main()
        }

    }
// menu de opciones
   println("ingrese el monto que desea")

    var valor = readLine()?.toDouble()

    if (valor == null || valor <= 0 ) {
        println("ingres un valor valdio")
        return main()
    }

    var resultado = if (opcion == movimitos.DEPOSITO) {
        Cuenta1.Depositar(valor)
    } else {
        Cuenta1.retirar(valor)
    }







    println(
        """
        -------------- Recibo --------------

      

        Acción: $opcion
        Monto: $$valor
        Saldo anterior: $${Cuenta1.Saldoenlacuenta}
        Nuevo Saldo: $${Cuenta1.Saldo}

         -----------------------------------
    """.trimIndent()
    )

    main()


}

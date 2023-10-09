package com.example.garbageapp.model



class Orders {
    class OrderItem() {
        var material: String = ""
            private set
        var quantity: String = ""
            private set
        var status: String = ""
            private set
        var date: String = ""
            private set
        var value: Double = 0.0
            private set

        constructor(material : String, quantity : String, status : String, date: String, value : Double) : this() {
            this.material = material
            this.quantity = quantity
            this.status = status
            this.date = date
            this.value = value
        }
    }

    val orders = listOf<OrderItem>(
        OrderItem("Plástico", "3kg", "em leilão", "2021 - 03 - 30",5.0),
        OrderItem("Papel", "1kg", "esperado entregador", "2021 - 03 - 30", 2.0),
        OrderItem("Vidro", "4kg", "vendido", "2021 - 03 - 30", 12.0)
    )
}
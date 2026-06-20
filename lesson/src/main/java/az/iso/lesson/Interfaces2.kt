package az.iso.lesson

interface Alive{
    fun eat()

    fun takeBreak()
}

interface MachineV2{
    fun fillFuel()
}

interface Worker {
    fun work()
    fun takeBreak(){}
}

class Employer() : Alive , Worker{
    override fun work() {
        TODO("Not yet implemented")
    }

    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun takeBreak() {
        super.takeBreak()
    }
    fun test(){
    }
}

class AI () : MachineV2 , Worker{
    override fun work() {
        TODO("Not yet implemented")
    }
    override fun fillFuel() {
        TODO("Not yet implemented")
    }
}


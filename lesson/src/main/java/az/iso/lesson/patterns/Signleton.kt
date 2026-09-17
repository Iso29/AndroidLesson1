package az.iso.lesson.patterns

class NetworkAdapter private constructor(
    val fallbackTime : Long = 5000
){
    companion object{
        private var networkAdapter : NetworkAdapter? = null
        fun getNetworkAdapter(
            fallbackTime : Long = 5000
        ) : NetworkAdapter{
            if(networkAdapter==null){
                networkAdapter = NetworkAdapter(fallbackTime)
            }
            return networkAdapter!!
        }
    }
}

object NetworkAdapterV2{
    val fallbackTime : Long = 5000
}

fun main() {
    val netAdapter1 = NetworkAdapter.getNetworkAdapter()
    val netAdapter2 = NetworkAdapter.getNetworkAdapter()

    val netAdapterV2_1 = NetworkAdapterV2

    val netAdapterV2_2 = NetworkAdapterV2

    println(netAdapterV2_1 == netAdapterV2_2)
}
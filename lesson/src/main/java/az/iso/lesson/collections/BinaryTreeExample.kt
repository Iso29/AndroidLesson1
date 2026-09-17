package az.iso.lesson.collections

data class TreeNode<T : Comparable<T>>(
    var value: T,
    var left: TreeNode<T>? = null,  // Sol budaq (Kiçiklər üçün)
    var right: TreeNode<T>? = null // Sağ budaq (Böyüklər üçün)
)

class Box(
    val elementCount: Int
) : Comparable<Box> {
    override fun compareTo(other: Box): Int {
        return this.elementCount.compareTo(other.elementCount)
    }
}

class MyBinarySearchTree<T : Comparable<T>> {

    private var root: TreeNode<T>? = null // Ağacın kökü (Başlanğıc nöqtəsi)

    fun insert(value: T) {
        root = insertRecursive(root, value)
    }

    private fun insertRecursive(current: TreeNode<T>?, value: T): TreeNode<T> {
        if (current == null) {
            println("🌱 Ağaca yeni düyün yerləşdirildi: $value")
            return TreeNode(value)
        }

        if (value < current.value) {
            println("⬅️ $value < ${current.value} olduğundan sola doğru gedilir...")
            current.left = insertRecursive(current.left, value)
        } else {
            println("➡️ $value >= ${current.value} olduğundan sağa doğru gedilir...")
            current.right = insertRecursive(current.right, value)
        }

        return current
    }

    fun contains(value: T): Boolean {
        return containsRecursive(root, value)
    }

    private fun containsRecursive(current: TreeNode<T>?, value: T): Boolean {
        if (current == null) return false
        if (value == current.value) return true

        return if (value < current.value) {
            containsRecursive(current.left, value) // Sola bax
        } else {
            containsRecursive(current.right, value) // Sağa bax
        }
    }

    fun printInOrder() {
        print("Ağacın Sıralı Forması: ")
        inOrderRecursive(root)
        println()
    }

    private fun inOrderRecursive(node: TreeNode<T>?) {
        if (node != null) {
            inOrderRecursive(node.left)   // Əvvəl tam solları çap et
            print("${node.value} ")        // Sonra özünü
            inOrderRecursive(node.right)  // Sonra sağları
        }
    }
}

// Yoxlamaq üçün Main funksiyası
fun main() {
    val reqemAgaci = MyBinarySearchTree<Int>()

    /* Ağacın vizual forması belə qurulacaq:
                  50
                /    \
              30      70
             /  \
            20  40
    */

    reqemAgaci.insert(50)
    reqemAgaci.insert(30)
    reqemAgaci.insert(70)
    reqemAgaci.insert(20)
    reqemAgaci.insert(40)

    //< > ==
    println("\n--- Axtarış Testi ---")
    println("Ağacda 40 var mı?: ${reqemAgaci.contains(40)}") // true
    println("Ağacda 90 var mı?: ${reqemAgaci.contains(90)}") // false

    println("\n--- Sıralama Testi ---")
    reqemAgaci.printInOrder() // Çıxış: 20 30 40 50 70

//    val box1 = Box(23)
//    val box2 = Box(12)
//    println(box1 > box2)
}
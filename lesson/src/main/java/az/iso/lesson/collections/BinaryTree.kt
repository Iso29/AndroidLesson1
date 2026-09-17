package az.iso.lesson.collections

class BinaryTreeNode<T>(
    var value: T,
    var left: BinaryTreeNode<T>? = null,
    var right: BinaryTreeNode<T>? = null
)

class BinaryTree<T> : Iterable<T> {

    private var root: BinaryTreeNode<T>? = null

    fun setRoot(value: T): BinaryTreeNode<T> {
        val node = BinaryTreeNode(value)
        root = node
        return node
    }

    fun root(): BinaryTreeNode<T>? = root

    fun preOrder(action: (T) -> Unit) {
        preOrder(root, action)
    }

    private fun preOrder(
        node: BinaryTreeNode<T>?,
        action: (T) -> Unit
    ) {
        if (node == null) return

        action(node.value)
        preOrder(node.left, action)
        preOrder(node.right, action)
    }

    fun inOrder(action: (T) -> Unit) {
        inOrder(root, action)
    }

    private fun inOrder(
        node: BinaryTreeNode<T>?,
        action: (T) -> Unit
    ) {
        if (node == null) return

        inOrder(node.left, action)
        action(node.value)
        inOrder(node.right, action)
    }

    fun postOrder(action: (T) -> Unit) {
        postOrder(root, action)
    }

    private fun postOrder(
        node: BinaryTreeNode<T>?,
        action: (T) -> Unit
    ) {
        if (node == null) return

        postOrder(node.left, action)
        postOrder(node.right, action)
        action(node.value)
    }

    override fun iterator(): Iterator<T> {

        val values = mutableListOf<T>()

        inOrder {
            values += it
        }

        return values.iterator()
    }
}
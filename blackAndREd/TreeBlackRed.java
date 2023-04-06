
public class TreeBlackRed {
    private Node root;

    private boolean add(int value) {
        if (root != null) {
            boolean res = addNod(root, value);
            root = rebalance(root);
            root.color = Color.BLACK;
            return res;
        } else {
            root = new Node();
            root.color = Color.BLACK;
            root.value = value;
            return true;
        }
    }


    private boolean addNod(Node node, int value) {

        if (node.value == value) {
            return false;
        } else {
            if (node.value > value) {
                if (node.left != null) {
                    boolean res = addNod(node.left, value);
                    node.left = rebalance(node.left);
                    return res;
                } else {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
                }
            }else {
                if (node.right != null){
                    boolean res = addNod(node.right,value);
                    node.right = rebalance(node.right);
                    return  res;
                }
                else {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return  true;
                }
            }

        }
    }

    private Node rebalance(Node node) {

        Node res = node;
        boolean needReb;
        do {
          //  если правая нода красная(и не равна null) и левая нода черная(или равна null) - левосторонний поворот
        needReb = false;
        if (res.right != null && root.right.color == Color.RED && (res.left == null || res.left.color == Color.BLACK)) {
            needReb = true;
            res = rightTurn(res);
        }
 //           если левая нода красная (и не равна null) и левая нода левой ноды красная(или равна null) - правосторонний поворот
        if (res.left != null && root.left.color == Color.RED && (res.left.left == null || res.left.left.color == Color.RED)){
            needReb = true;
            res = leftTurn(res);
        }
//            если левая нода красная(и не равна null) и правосторонняя нода красная (и не равна null)- замена цвета
        if (res.left != null && root.left.color == Color.RED && res.right != null && res.right.color == Color.RED){
            needReb =true;
            colorReplacement(res);
        }
    }
        while (needReb); //делаем пока false
        return res;


    }

    private void colorReplacement(Node node) {

        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }


    private Node leftTurn(Node node) {
        Node leftChildren = node.left;
        Node beetween = leftChildren.left;
        leftChildren.right = node;
        node.left = beetween;
        leftChildren.color = node.color;
        node.color = Color.RED;
        return  leftChildren;

    }

    private Node rightTurn(Node node) {
        Node rightChildren = node.right;
        Node beetwen = rightChildren.left;
        rightChildren.left = node;
        node.right = beetwen;
        rightChildren.color = node.color;
        node.color = Color.RED;
        return rightChildren;
    }


    private class Node {
        private int value;
        private Color color;
        private Node left;
        private Node right;
    }
    private enum Color {
        RED, BLACK;
    }
}



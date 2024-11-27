public class BinaryTree{
    
    Node root;
    Node current;
    
    public BinaryTree(){
        root = null;
        current = null;
    }
    
    public void add(int value)
    {
        Node temp = new Node(value);
        
        if(root==null){root = temp; current = root; return;}
        
        current = root;
        
        boolean isAdded = false;
        
        while(!isAdded)
        {
            if(temp.value<current.value && current.left == null)
            {
                current.left = temp;
                isAdded = true;
            }
            
            else if(temp.value<current.value)
            {
                current = current.left;
            }
            
            else if(temp.value>current.value && current.right == null)
            {
                current.right = temp;
                isAdded = true;
            }
            
            else if(temp.value>current.value)
            {
                current = current.right;
            }
        }
        
        current = root;
        
    }
    
    public void inOrderTraversal()
    {
        if (current == null) {
            return;
        }
        
        inOrderTraversal(current.left);
        //System.out.print(current.value + " ");
        inOrderTraversal(current.right);
    }
    
    private void inOrderTraversal(Node node)
    {
        if (node == null) {
            return;
        }
        
        inOrderTraversal(node.left);
        //System.out.print(node.value + " ");
        inOrderTraversal(node.right);
    }
}
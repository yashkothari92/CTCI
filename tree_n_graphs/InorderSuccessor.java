package tree_n_graphs;

public class InorderSuccessor {
	public static void main(String[] args) {
		TreeNode root = null;
		InorderSuccessor tree = new InorderSuccessor();
		/*		
		root = insertNode(root, 10);
		root = insertNode(root, 6);
		root = insertNode(root, 16);
		root = insertNode(root, 3);
		root = insertNode(root, 8);
		root = insertNode(root, 12);
		root = insertNode(root, 21);
		root = insertNode(root, 5);
		root = insertNode(root, 11);
		root = insertNode(root, 1);
		*/
		
		root = tree.insertNode(root, 20); 
        root = tree.insertNode(root, 8); 
        root = tree.insertNode(root, 22); 
        root = tree.insertNode(root, 4); 
        root = tree.insertNode(root, 12); 
        root = tree.insertNode(root, 10); 
        root = tree.insertNode(root, 14); 
        
        TreeNode temp = root.left.right.right;  
		//TreeNode temp = root.right.right;
				
		TreeNode successor = findInorderSucc(temp);
		
		if(successor != null)
			System.out.println("Ancestor of node "+temp.data+" is: "+successor.data);
		else
			System.out.println("No Ancestor found for node "+ temp.data);
	}
	
	private TreeNode insertNode(TreeNode node, int data) {
		if(node == null) {
			return new TreeNode(data);
		} else {
			TreeNode temp = null;
			if(data <= node.data) {
				temp = insertNode(node.left, data);
				node.left = temp;
			} else {
				temp = insertNode(node.right, data);
				node.right = temp;
			}
			temp.parent = node;
			
			return node;
		}
		
	}

	private static TreeNode findInorderSucc(TreeNode node) {
		/*If right subtree of given node is non-empty, 
		 * 		find minimum element from right sub-tree
		 * else
		 * 		go up using parent ptr until node is left child of its parent found
		 * 		return that parent
		 * */
		
		if(node.right != null) {
			return findMin(node.right);
		} else {
			TreeNode parent = node.parent;
			// check if node is left child of its parent (Left of parent i.e. bigger than parent)
			while(parent != null && node.data > parent.data) {
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}

	private static TreeNode findMin(TreeNode node) {
		if(node.left != null)
			return findMin(node.left);
		
		return node;
	}
}
